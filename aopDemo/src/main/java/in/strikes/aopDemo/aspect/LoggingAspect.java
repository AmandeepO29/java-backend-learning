package in.strikes.aopDemo.aspect;

import in.strikes.aopDemo.dto.Student;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    //@Before("execution(String in.strikes.aopDemo.service.StudentService.getStudent(String))")
//    @Before("execution(* in.strikes.aopDemo.service.StudentService.*(*))")
    // student service ke andar koi bhi single method jiska koi bhi return type, method name ho
    // uske liye ye aspect use ho skta h

    // to store a pointcut
    @Pointcut("within(in.strikes.aopDemo.service..*)" +
            "&&" +
            " execution(public * * (..))")
    public void logPublicServiceMethod(){
        //emptylog
    }
    @Before("logPublicServiceMethod()")
    public void logBeforeMethod() {
        System.out.println("Method intercepted");
    }


//    @Around("@annotation(jdk.jfr.Timestamp)")
//    public void evaluateTimeMethod(ProceedingJoinPoint joinPoint){
//        long startTime=System.currentTimeMillis();
//        joinPoint.proceed();
//        long endTime=System.currentTimeMillis();
//        System.out.println(endTime-startTime);
//    }


//    @Before("execution(String in.strikes.aopDemo.service.StudentService.createStudent())")
//    public void logBeforeMethod(JoinPoint joinPoint){
//
//        // this is used to extract all arguments of the target service class
////        Object[] arr=joinPoint.getArgs();
//
//
//        System.out.println("Student is going to be saved");
//
//
//    }
//
//    @AfterReturning(value = "execution(in.strikes.aopDemo.dto" +
//            " in.strikes.aopDemo.service.StudentService" +
//            ".createStudent(in.strikes.aopDemo.dto.Student))",
//            returning="student")
//    public void logAfterReturningMethod(Student student){
//
//        student.setAge(29);
//        student.setName("Rahul");
//
//        System.out.println("createStudent() has been intercepted");
//    }

//    @AfterThrowing(value="execution(* in.strikes.aopDemo.service.StudentService.createStudent(..))",
//    throwing = "exception")
//    public void logAfterThrowingMethod(Throwable exception){
//
//        System.out.println("Exception type-> "+exception.getClass().getName());
//        System.out.println("Exception Message-> "+exception.getMessage());
//
//    }

//    @After(value="execution(* in.strikes.aopDemo.service.StudentService.createStudent(..))")
//    public void logAfterMethod(){
//        System.out.println("logAfter method executed");
//
//    }

//    @Around(value="execution(* in.strikes.aopDemo.service.StudentService.createStudent(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        System.out.println("Starting-->"+joinPoint.getSignature().getName());
//
//        //join.proceed() returns Object type ....
//        try{
//            Object student= joinPoint.proceed();
//            System.out.println("Execution successful");
//            return student;
//        }
//        catch(Exception e){
//            System.out.println("Execution failed: "+e.getMessage());
//            throw e;
//            // if we want to consume exception use return null .....
//        }
//        finally{
//            System.out.println("Execution completed");
//        }
//
//    }

//    @Around(value="execution(* in.strikes.aopDemo.service.StudentService.dummyMethod(..))")
//    public Object logAroundMethod(ProceedingJoinPoint joinPoint) throws Throwable {
//        Object[] arr=joinPoint.getArgs();
//
//        String originalString=(String)arr[0];
//
//        String modifiedString= originalString.toUpperCase();
//
//        Object[] modifiedArr={
//                modifiedString
//        };
//
//        return joinPoint.proceed(modifiedArr);
}
