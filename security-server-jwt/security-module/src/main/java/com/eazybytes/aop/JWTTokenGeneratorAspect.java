package com.eazybytes.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

@Aspect
@Configuration
public class JWTTokenGeneratorAspect {

    private final Logger logger = LoggerFactory.getLogger(JWTTokenGeneratorAspect.class);

    @Pointcut("execution(* com.eazybytes.config.filter.JWTTokenGeneratorFilter.doFilterInternal())")
    public void doFilterInternalMethod() {
    }

    @AfterReturning("execution(* com.eazybytes.config.filter.JWTTokenGeneratorFilter.doFilterInternal())")
    public void after(JoinPoint joinPoint) {
        logger.info("Generate token success: " + joinPoint.getTarget().toString());
    }
}
