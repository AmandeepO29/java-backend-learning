package in.strikes.aopDemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

public class ApplicationPointcuts {
    @Pointcut("within(in.strikes.aopDemo.controller..*)")
    public void controllerLayer(){

    }

    @Pointcut("within(in.strikes.aopDemo.service..*)")
    public void serviceLayer(){

    }

    @Pointcut("execution(public * *(..))")
    public void publicMethod(){

    }

    @Pointcut("serviceLayer()&&publicMethod()")
    public void publicServiceMethod(){

    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethod(){

    }

}
