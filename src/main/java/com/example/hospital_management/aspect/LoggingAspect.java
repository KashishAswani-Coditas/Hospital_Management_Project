package com.example.hospital_management.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Slf4j
public class LoggingAspect {

    @Pointcut("execution(* com.example.hospital_management.controller..*(..))")
    public void controllerLayer(){}

    @Around("controllerLayer()")
    public Object logRequestAndTime(ProceedingJoinPoint joinPoint) throws Throwable {

        long startTime = System.currentTimeMillis();

        String methodName = joinPoint.getSignature().toShortString();

        log.info("Incoming Request: {}", methodName);

        try {
            Object result = joinPoint.proceed();

            long timeTaken = System.currentTimeMillis() - startTime;

            log.info("Completed: {} in {} ms", methodName, timeTaken);

            return result;

        } catch (Exception ex) {

            log.error("Exception in {} : {}", methodName, ex.getMessage());

            throw ex;
        }
    }
}