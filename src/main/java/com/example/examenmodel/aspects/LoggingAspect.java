package com.example.examenmodel.aspects;

import org.springframework.stereotype.Component;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
import lombok.extern.slf4j.Slf4j;


@Component
@Aspect
@Slf4j
public class LoggingAspect {



    @After("execution( void com.example.examenmodel.services.*.assign*(..))")
    public void logMethodExit(JoinPoint joinPoint) {

        String name = joinPoint.getSignature().getName();

        log.info("Out of method :" + name );
    }

}