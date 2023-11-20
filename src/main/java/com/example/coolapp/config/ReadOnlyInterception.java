package com.example.coolapp.config;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class ReadOnlyInterception {

    private static final Logger logger = LoggerFactory.getLogger(ReadOnlyInterception.class);
    @Around("@annotation(com.example.coolapp.config.ReaderDS)")
    public Object aroundMethod(ProceedingJoinPoint joinPoint) throws Throwable{
        try{
            ReadOnlyContext.enter();
            return joinPoint.proceed();
        } finally {
            ReadOnlyContext.exit();
        }
    }
}
