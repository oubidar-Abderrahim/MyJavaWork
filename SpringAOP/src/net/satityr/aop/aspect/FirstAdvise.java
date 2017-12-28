package net.satityr.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(-1)
public class FirstAdvise {
  
  // Advises:
 
  
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void abefore() {
    System.out.println("*******before executing a Dao methode, FIRST Advise: keep it clean!*******\n");
  }
  
}
