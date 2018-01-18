package net.satityr.aop;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.satityr.aop.dao.Account;
import net.satityr.aop.dao.AccountDao;
import net.satityr.aop.dao.MembershipDao;

public class NewMain {

  /*
   *  because Spring use a different logger than System.out.print we have text showing after the context is closed
   *  in order to remove this issue, we're going to make our program use one logger only to synchronize everything
   */
  
  
  
  private static Logger springLogger = Logger.getLogger("org.springframework");
  
  
  public static void main(String[] args) {
    
    // read spring configuration class
    
    springLogger.setLevel(Level.OFF);
    
    
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
    
    
    
   
    // get bean from spring container
    
    AccountDao theAccountDao = context.getBean("accountDao",AccountDao.class);
    MembershipDao membershipDao = context.getBean("membershipDao",MembershipDao.class);
    Account account = context.getBean("account",Account.class);
    

    
    // call the business method
    
    System.out.println("I'm gonna call setName");
    account.setName("nameTest");
    System.out.println("I called setName \n");
    System.out.println("I'm gonna call addAccount 3 times \n");
    theAccountDao.addAccount();
    membershipDao.addAccount();
    System.out.println("result => " + theAccountDao.addAccount(account, true, 7));
    System.out.println("I called addAccount 3 times \n");
    
    System.out.println("I'm gonna call getName \n");
    account.getName();
    System.out.println("I called getName \n");
    
    
    
    try {
      membershipDao.addException(true);
    }catch(Exception e) {
      System.out.println("Ooops! an exeption occured!");
    }
    
    System.out.println(membershipDao.sleepAndSnore());
    
    // we will make the aspect handle the exception this time
    try {
      System.out.println(membershipDao.hideException(true));
    }catch(Exception e) {
      System.out.println("Ooops! an exeption occured!");
    }
    
    
    // close the context
    
    context.close();


  }

}
