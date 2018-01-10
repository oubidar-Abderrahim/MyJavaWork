package net.satityr.aop.dao;


import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

  
  public void addAccount() {
    
    System.out.println(getClass() + " : adding Membership shit!");
    System.out.println("");
  }
  
  public void addException(boolean execpt) throws Exception {
    
    if(execpt) throw new RuntimeException("Major Accident");
    
  }
  
  
  public String sleepAndSnore() {
    
    try {
      TimeUnit.SECONDS.sleep(3);
    }catch(InterruptedException e) {
      return e.toString();
    }
    
    return "ZZZZZZZ";
  }
  
  
  
}
