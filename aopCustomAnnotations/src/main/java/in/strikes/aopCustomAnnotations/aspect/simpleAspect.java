package in.strikes.aopCustomAnnotations.aspect;

import in.strikes.aopCustomAnnotations.annotation.TrackExecutionTime;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect

public class simpleAspect {
//    @Before("@annotation(jdk.jfr.Timestamp)")
//    public void logBeforeMethod(){
//        System.out.println("Method intercepted");
//    }

//    @Around("@annotation(in.strikes.aopCustomAnnotations.annotation.TrackExecutionTime)")
    /* OR */
@Around("@annotation(trackExecutionTime)")
    public Object measureExactTime(ProceedingJoinPoint joinPoint,
                                   TrackExecutionTime trackExecutionTime) throws Throwable {
        long startTime=System.currentTimeMillis();
        try{
            return joinPoint.proceed();
        }
        finally {
            long endTime = System.currentTimeMillis();

            long duration=endTime-startTime;

            String operation=trackExecutionTime.operation();
            if(operation.isBlank()){
                operation=joinPoint.getSignature().getName();
            }

            long warningThreshold= trackExecutionTime.warnAfter();
            if(duration>=warningThreshold){
                System.out.println("Slow operation alert!");
            }
            else{
                System.out.println("Time taken by "+operation +" : "+duration);
            }
        }

    }
}
