package net.satityr.aop.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
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
  
}
