package net.satityr.aop.aspect;

import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class SecondAdvise {
  
  // create logger
  private Logger secondLogger = Logger.getLogger(getClass().getName());
  
  
  
  
  // Advises 

  // logging before the call of any method inside the package net.satityr.aop.dao whatever it's name, return type or number of parameters are
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void beforeDaoSMethode() {

    secondLogger.info("*******Before a net.satityr.aop.dao Method SECOND Advise: Verify before submetting *******\n");

  }
  
  //logging after the call of any method inside the package net.satityr.aop.dao except getters and setters
  @After("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void anAfter() {
    secondLogger.info("*******After executing a Dao methode, Except getters and setters SECOND Advise: Re-Verify Once more!*******\n\n");
  }
  
  
  //logging after the call of any method inside the package net.satityr.aop.dao except getters and setters
  @AfterReturning(pointcut="execution( String net.satityr.aop.dao.AccountDao.addAccount(..))", returning="result")
  public void anAfterReturning(JoinPoint joinPoint, String result) {
    secondLogger.info("*******After getting the results *******\n\n");
    secondLogger.info("** Result : " + result + " ***");
    
    // let's make it Upper-case we can do any modification and it will modify the output objects
    result = result.toUpperCase();
    secondLogger.info("** Result : " + result + " ***");
    
  }
  
  
}
