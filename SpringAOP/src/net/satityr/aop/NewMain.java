package net.satityr.aop;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.satityr.aop.dao.Account;
import net.satityr.aop.dao.AccountDao;
import net.satityr.aop.dao.MembershipDao;

public class NewMain {

  public static void main(String[] args) {


    // read spring configuration class
    
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
    theAccountDao.addAccount(account);
    System.out.println("I called addAccount 3 times \n");
    
    System.out.println("I'm gonna call getName \n");
    account.getName();
    System.out.println("I called getName \n");
    
    // close the context
    
    context.close();


  }

}
