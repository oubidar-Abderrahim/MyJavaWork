package net.satityr.aop.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(99)
public class LastAdvise {

  
  // create logger
  private Logger lastLogger = Logger.getLogger(getClass().getName());
  
  
  
  // Advises :
  // logging before the call of any method inside the package net.satityr.aop.dao whatever it's name, return type or number of parameters are
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void beforeDaoMethode() {

    lastLogger.info("*******Before a net.satityr.aop.dao Method LAST Advise : Keep it Simple & Stupid*******\n");

  }
  
  // after throwing an exception
  @AfterThrowing(pointcut="execution(* *.addException(boolean))", throwing="theExeption")
  public void afterTheException(JoinPoint joinPoint, Throwable theExeption) {
    
    // log the exception : 
    lastLogger.info("####### the Exeption :: " + theExeption + " #######");
  }
  
  
  // calculate the time of execution with around
  @Around("execution(String *.hideException(..))")
  public Object hideException(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    
    // executing method
    Object result = null ;
    
    try {
      result = proceedingJoinPoint.proceed();
    } catch (Exception e) {
      
      lastLogger.warning(e.getMessage());
      
      // we won't throw the exception but we will change the result
      result = "Something bad happend but you don't need to worry about it";
      
      // in case we want to throw it : throw e;
    }

    
    return result;
  }
  
  
}
