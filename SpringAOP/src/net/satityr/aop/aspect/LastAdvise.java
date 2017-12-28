package net.satityr.aop.aspect;


import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(99)
public class LastAdvise {

  
  // Advises 
  
  
  // logging before the call of any method inside the package net.satityr.aop.dao whatever it's name, return type or number of parameters are
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void beforeDaoMethode() {

    System.out.println("*******Before a net.satityr.aop.dao Method LAST Advise : Keep it Simple & Stupid*******\n");

  }
  
  
}
