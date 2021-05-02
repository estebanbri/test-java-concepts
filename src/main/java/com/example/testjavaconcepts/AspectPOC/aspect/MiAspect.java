package com.example.testjavaconcepts.AspectPOC.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class MiAspect {

    @Around("@annotation(com.example.testjavaconcepts.AspectPOC.annotation.Loggeable)")
    public Object log(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        System.out.println("Antes de ejecutar el metodo");
        Object result = proceedingJoinPoint.proceed();
        System.out.println("Luego de ejecutar el metodo");
        return Arrays.asList("Chau", result);
    }
}
