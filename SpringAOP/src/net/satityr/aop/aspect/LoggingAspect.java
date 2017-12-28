package net.satityr.aop.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggingAspect {

  // logging before the call of addAcount
  @Before("execution(public void net.satityr.aop.dao.AccountDao.addAccount())")
  public void beforeAddAccount() {

    System.out.println(" : LOGGING addAccount!!!!!!!");

  }

  // logging before the call of any public add method
  @Before("execution(public void add*())")
  public void beforePublicAdd() {

    System.out.println(" : before Public Add methode : !!!!!!!");

  }

  // logging before the call of any add method (we don't need * because it's
  // optional, but you can do it if you like
  @Before("execution(void add*())")
  public void beforeAnyAdd() {

    System.out.println(" : before Any Add methode : !!!!!!!");

  }

  // logging before the call of any add method with a boolean return type
  @Before("execution(boolean add*())")
  public void beforeBooleanAdd() {

    System.out.println(" : before boolean Add methode : !!!!!!!");

  }

  // logging before the call of any add method with a parameter of type Account
  @Before("execution(* add*(net.satityr.aop.dao.Account))")
  public void beforeParamAdd() {

    System.out.println(" : before Add methode with Account param : !!!!!!!");

  }

  // logging before the call of any method inside the package net.satityr.aop.dao whatever it's name, return type or number of parameters are
  @Before("execution(* net.satityr.aop.dao.*.*(..))")
  public void beforeDaoMethode() {

    System.out.println(" : before a net.satityr.aop.dao Method (any one of them) : !!!!!!!");

  }

  // logging before the call of any add method with a parameter of type Account followed by any number of parameter (0 to many)
  @Before("execution(* add*(net.satityr.aop.dao.Account, ..))")
  public void beforeMultiParamAdd() {

    System.out.println(
        " : before Add methode with Account param, and probably more parameters : !!!!!!!");

  }
  
  
  //declaring the point cut expression
  @Pointcut("execution( * net.satityr.aop.dao.MembershipDao.addAccount(..))")
  public void pointcutForMembership() {}
  
  // multiple logging before the call of add method inside membership class using pointcut expression
  @Before("pointcutForMembership()")
  public void beforeMemberAdd1() {

    System.out.println(
        " : before Add methode of membership 1 : !!!!!!!");

  }

  @Before("pointcutForMembership()")
  public void beforeMemberAdd2() {

    System.out.println(
        " : before Add methode of membership 2 : !!!!!!!");

  }

  @Before("pointcutForMembership()")
  public void beforeMemberAdd3() {

    System.out.println(
        " : before Add methode of membership 3 : !!!!!!!");

  }
  
  // point cut for package
  @Pointcut("execution(* net.satityr.aop.dao.*.*(..))")
  private void forDaoPackage() {}
  
  // point cut for getters
  @Pointcut("execution(* net.satityr.aop.dao.*.get*())")
  private void getter() {}
  
  // point cut for package
  @Pointcut("execution(* net.satityr.aop.dao.*.set*(..))")
  private void setter() {}
  
  // combine the point cuts include package exclude getters setters
  @Pointcut("forDaoPackage() && !(getter() || setter())")
  private void forDaoPackageExceptGetAndSet() {}
  
  @After("forDaoPackageExceptGetAndSet()")
  public void anAfter() {
    System.out.println("*******After executing a Dao methode, Except getters and setters!*******\n\n");
  }
  
  
}
