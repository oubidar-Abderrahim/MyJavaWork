package com.oubidar.springdemo.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;

import java.util.logging.Logger;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  
  // setup a loggger
  private Logger logger = Logger.getLogger(getClass().getName());
  
  
  // set up pointcut declaration
  @Pointcut("execution(* com.oubidar.springdemo.controller.*.*(..))")
  private void controllerPointCut() {}
  
  @Pointcut("execution(* com.oubidar.springdemo.service.*.*(..))")
  private void servicePointCut() {}
  
  @Pointcut("execution(* com.oubidar.springdemo.dao.*.*(..))")
  private void daoPointCut() {}
  
  @Pointcut("controllerPointCut() || servicePointCut() || daoPointCut()")
  private void combinedPointCut() {}
  
  
  // add before advise
  @Before("combinedPointCut()")
  public void before(JoinPoint joinPoint) {
    
    String method = joinPoint.getSignature().toShortString();
    logger.info("#### Calling method : " + method);
  }
  
  
  // add after advise
  @AfterReturning(pointcut="combinedPointCut()", returning="result")
  public void afterReturning(JoinPoint joinPoint, Object result) {
    
    logger.info("#### The result is : " + result);
  }
  
}
