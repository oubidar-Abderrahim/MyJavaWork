package net.satityr.aop.dao;


import org.springframework.stereotype.Component;

@Component
public class MembershipDao {

  
  public void addAccount() {
    
    System.out.println(getClass() + " : adding Membership shit!");
    System.out.println("");
  }
}
