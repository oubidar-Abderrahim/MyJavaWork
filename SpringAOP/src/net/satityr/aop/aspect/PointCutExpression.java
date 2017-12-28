package net.satityr.aop.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;


@Aspect
public class PointCutExpression {

  
  
  // Point Cuts :
  
  // point cut for package
  @Pointcut("execution(* net.satityr.aop.dao.*.*(..))")
  protected void forDaoPackage() {}
  
  // point cut for getters
  @Pointcut("execution(* net.satityr.aop.dao.*.get*())")
  protected void getter() {}
  
  // point cut for package
  @Pointcut("execution(* net.satityr.aop.dao.*.set*(..))")
  protected void setter() {}
  
  // combine the point cuts include package exclude getters setters
  @Pointcut("forDaoPackage() && !(getter() || setter())")
  protected void forDaoPackageExceptGetAndSet() {}
  
  
  
}
