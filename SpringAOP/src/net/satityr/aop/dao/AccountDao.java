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
  
  public void addAccount(Account account) {
    
    System.out.println(getClass() + " : Doing DB work whatever!");
    System.out.println("");
  }
}
