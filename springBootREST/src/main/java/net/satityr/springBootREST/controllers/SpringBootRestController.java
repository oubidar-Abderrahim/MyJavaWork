package net.satityr.springBootREST.controllers;


import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.satityr.springBootREST.beans.Greeting;


@RestController
@RequestMapping("/api")
public class SpringBootRestController {

  
  
  @RequestMapping("/")
  public String welcome() {
            
    return "Welcome to RestTemplate Example.";
  }

  
  @RequestMapping("/hello/{name}")
  public Greeting message(@PathVariable String name) {

      Greeting  msg = new Greeting(name, "Hello " + name);
      return msg;
  }

}
