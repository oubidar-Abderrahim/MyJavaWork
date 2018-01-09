package net.satityr.aop;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.annotation.Scope;

import net.satityr.aop.entity.ClientEntity;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan("net.satityr.aop")
public class ConfigClass {

  // creating a session client for authentication 
  @Bean
  @Scope("session")
  public ClientEntity clientEntity() {
    return new ClientEntity();
  }
}
