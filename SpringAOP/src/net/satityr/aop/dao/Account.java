package net.satityr.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class Account {

  
  private String name;
  private String accountNumber ;

  public Account() {
    
  }

  public Account(String name, String accountNumber) {
    this.name = name;
    this.accountNumber = accountNumber;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }
  
  @Override
  public String toString() {
    return "Account [name=" + name + ", accountNumber=" + accountNumber + "]";
  }
}
