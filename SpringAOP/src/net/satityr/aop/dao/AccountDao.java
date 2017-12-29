package net.satityr.aop.dao;


import org.springframework.stereotype.Component;

@Component
public class AccountDao {

  private String something ;
  
  public String getSomething() {
    return something;
  }

  public void setSomething(String something) {
    this.something = something;
  }

  public void addAccount() {
    
    System.out.println(getClass() + " : Doing DB work whatever!");
    System.out.println("");
  }
  
  public String addAccount(Account account, boolean b, int i) {
    
    System.out.println(getClass() + " : Doing DB work whatever! and return a string");
    System.out.println("");
    
    return account.getName() + " " + i ;
  }
}
