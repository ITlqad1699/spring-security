package com.eazybytes.aop;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * The type Notices aspect.
 */
@Aspect
@Configuration
public class NoticesAspect {
    private final Logger logger = LoggerFactory.getLogger(NoticesAspect.class);

    /**
     * Before.
     *
     * @param joinPoint the join point
     */
    @Before("execution(* com.eazybytes.controller.NoticesController.getNotices())")
    public void before(JoinPoint joinPoint) {
        logger.info("Start get notices at: " + joinPoint.getTarget().toString());
    }
}
