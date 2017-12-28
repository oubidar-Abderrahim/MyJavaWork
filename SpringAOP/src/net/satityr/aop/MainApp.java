package net.satityr.aop;



import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.satityr.aop.dao.Account;
import net.satityr.aop.dao.AccountDao;
import net.satityr.aop.dao.MembershipDao;

public class MainApp {

  public static void main(String[] args) {


    // read spring configuration class
    
    AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(ConfigClass.class);
    
   
    // get bean from spring container
    
    AccountDao theAccountDao = context.getBean("accountDao",AccountDao.class);
    MembershipDao membershipDao = context.getBean("membershipDao",MembershipDao.class);
    Account account = context.getBean("account",Account.class);
    
    // call the business method
    
    account.setName("nameTest");
    System.out.println("I called setName \n");
    theAccountDao.addAccount();
    membershipDao.addAccount();
    theAccountDao.addAccount(account);
    
    
    // close the context
    
    context.close();


  }

}
