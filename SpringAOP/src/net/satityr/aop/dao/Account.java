package net.satityr.aop.dao;

import org.springframework.stereotype.Component;

@Component
public class Account {

  
  public String name;
  public String accountNumber ;
  
  public Account() {
    // TODO Auto-generated constructor stub
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
  
  
}
