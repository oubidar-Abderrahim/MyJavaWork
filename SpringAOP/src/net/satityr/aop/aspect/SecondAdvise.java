package net.satityr.aop.aspect;

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
  
  // Advises 
  
  
  // logging before the call of any method inside the package net.satityr.aop.dao whatever it's name, return type or number of parameters are
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void beforeDaoSMethode() {

    System.out.println("*******Before a net.satityr.aop.dao Method SECOND Advise: Verify before submetting *******\n");

  }
  
  //logging after the call of any method inside the package net.satityr.aop.dao except getters and setters
  @After("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void anAfter() {
    System.out.println("*******After executing a Dao methode, Except getters and setters SECOND Advise: Re-Verify Once more!*******\n\n");
  }
  
  
  //logging after the call of any method inside the package net.satityr.aop.dao except getters and setters
  @AfterReturning(pointcut="* String net.satityr.aop.dao.AccountDao.addAccount(..)", returning="result")
  public void anAfterReturning(JoinPoint joinPoint, String result) {
    System.out.println("*******After executing a Dao methode, Except getters and setters SECOND Advise: Re-Verify Once more!*******\n\n");
  }
  
  
}
