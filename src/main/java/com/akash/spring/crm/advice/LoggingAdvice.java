package com.akash.spring.crm.advice;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * Created by Akash Agarwal on 5/4/2016.
 */
@Aspect
@Component
public class LoggingAdvice {

    @Pointcut("execution(* com.akash.spring.crm.services..*.*(..)) ")
    public void allServiceMethods() {
    }

    @Around("allServiceMethods()")
    public Object timeLogger(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
        long start = System.nanoTime();

        try {
            Object result = proceedingJoinPoint.proceed();
            return result;
        } finally {
            long end = System.nanoTime();
            long elapsed = (end - start) / 1000000;
            System.out.println("Method: " + proceedingJoinPoint.getSignature().getName() + " took " + elapsed + "ms to finish");
        }
    }
}
