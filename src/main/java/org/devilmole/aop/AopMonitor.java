package org.devilmole.aop;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

/**
 * Created by Administrator on 2016/9/27 0027.
 */
@Aspect
@Component
public class AopMonitor {

    private Logger logger = LogManager.getLogger(AopMonitor.class);

    @Before("execution(* org.devilmole.service.DemoService.*(..))")
    public void beforeExecu(JoinPoint joinPoint) {
        logger.error("log@@@@@beforeExecu: " + joinPoint + "@@@@@");
    }

    @After("execution(* org.devilmole.service.DemoService.*(..))")
    public void afterExecu(JoinPoint joinPoint) {
        logger.error("log@@@@@afterExecu: " + joinPoint + "@@@@@");
    }

    @AfterReturning("execution(* org.devilmole.service.DemoService.*(..))")
    public void afterReturningAdvisor(JoinPoint joinPoint) {
        logger.error("log@@@@@afterReturningAdvisor: " + joinPoint + "@@@@@");
    }
}
