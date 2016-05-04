package com.akash.spring.crm.advice;

import org.aspectj.lang.ProceedingJoinPoint;

/**
 * Created by Akash Agarwal on 5/4/2016.
 */
public class LoggingAdvice {

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
