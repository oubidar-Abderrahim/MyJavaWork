package com.oubidar.spring.security.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

  @GetMapping("/")
  public String showHome() {

    return "index";
  }
  
  @GetMapping("/loginPageForCampany")
  public String loginPageForCampany() {
    
    // return "login";
    
    return "bootstrap-login";
  } 
  
  @GetMapping("/control")
  public String control() {
    
    return "control";
  } 
  
  @GetMapping("/management")
  public String management() {
    
    return "management";
  } 
  
  @GetMapping("/services")
  public String services() {
    
    return "services";
  } 
  
  @GetMapping("/denied")
  public String denied() {
    
    return "denied";
  } 
  
}
