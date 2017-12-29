package net.satityr.aop.aspect;


import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import net.satityr.aop.dao.Account;

@Aspect
@Component
@Order(-1)
public class FirstAdvise {
  
  // Advises:
 
  
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void abefore(JoinPoint theJoinPoint) {
    System.out.println("*******before executing a Dao methode, FIRST Advise: keep it clean!*******\n");
    
    // Display method signature
    MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
    System.out.println("Method Signature : " + methodSignature);
    
    // Display method Arguments
    Object[] args = theJoinPoint.getArgs();
    
    if(args == null) {
      System.out.println("There is no arguments for this method : NULL");
    }
    else if(args.length == 0) {
      System.out.println("There is no arguments for this method : Zero");
    }
    else {
      for( Object temp : args) {
        System.out.print(temp);    
        if(temp instanceof Account) {
          Account account = (Account) temp;
          System.out.println(" | Account name: " + account.getName() + "; AccountNumber: " + account.getAccountNumber());
        }
        else {
          System.out.println();
        }      
      }
    }
    
    
  }
  
}
