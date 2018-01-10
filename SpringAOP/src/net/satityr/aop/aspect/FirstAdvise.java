package net.satityr.aop.aspect;


import java.util.logging.Logger;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
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
  
  
  // create logger
  private Logger firstLogger = Logger.getLogger(getClass().getName());
  
  
  
  
  // Advises:
 
  
  @Before("net.satityr.aop.aspect.PointCutExpression.forDaoPackageExceptGetAndSet()")
  public void abefore(JoinPoint theJoinPoint) {
    firstLogger.info("*******before executing a Dao methode, FIRST Advise: keep it clean!*******\n");
    
    // Display method signature
    MethodSignature methodSignature = (MethodSignature) theJoinPoint.getSignature();
    firstLogger.info("Method Signature : " + methodSignature);
    
    // Display method Arguments
    Object[] args = theJoinPoint.getArgs();
    
    if(args == null) {
      firstLogger.info("There is no arguments for this method : NULL");
    }
    else if(args.length == 0) {
      firstLogger.info("There is no arguments for this method : Zero");
    }
    else {
      for( Object temp : args) {
        System.out.print(temp);    
        if(temp instanceof Account) {
          Account account = (Account) temp;
          firstLogger.info(" | Account name: " + account.getName() + "; AccountNumber: " + account.getAccountNumber());
        }
        else {
          firstLogger.info("/n");
         
        }      
      }
    }
  }
  
  
  // calculate the time of execution with around
  @Around("execution(String *.sleepAndSnore())")
  public Object calculateTime(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {
    
    // start recording
    long begin = System.currentTimeMillis();
    
    // executing method
    Object result = proceedingJoinPoint.proceed();
    
    // end recording
    long end = System.currentTimeMillis();
    
    // compute duration
    firstLogger.info("==========> Duration of execution of the method : " + proceedingJoinPoint.getSignature().toShortString() + " is " + (end-begin) + " ms");
    
    return result;
  }
  
}
