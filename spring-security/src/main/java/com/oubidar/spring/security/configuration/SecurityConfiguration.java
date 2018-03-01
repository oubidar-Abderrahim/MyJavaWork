package com.oubidar.spring.security.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.User.UserBuilder;


@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
    
    // add users for (in memory) authentication (( in Spring Security 5.0.2 , They deprecated this method ))
    UserBuilder users = User.withDefaultPasswordEncoder();
    
    auth.inMemoryAuthentication().withUser(users.username("Atem").password("test123").roles("ADMIN","EMPLOYEE","MANAGER"))
                                 .withUser(users.username("Madara").password("test123").roles("MANAGER","EMPLOYEE"))
                                 .withUser(users.username("Aizen").password("test123").roles("MANAGER","EMPLOYEE"))
                                 .withUser(users.username("Zamasu").password("test123").roles("EMPLOYEE"))
                                 .withUser(users.username("Acknologia").password("test123").roles("EMPLOYEE"));
    
  }

  @Override
  protected void configure(HttpSecurity http) throws Exception {


    http.authorizeRequests()                            // What requests should be authorized ?
//        .anyRequest()                                 // All of them, and who should access it ?
//          .authenticated()                            // anyone authenticated... WAIT what?!, not every user should have full access! we need to restrict more!
          .antMatchers("/","/services/**")              // for Home page, services page and its sub-pages
            .hasRole("EMPLOYEE")                        // any EMPLOYEE should be able to access it
          .antMatchers("/management/**")                // for management page and its sub-pages
            .hasRole("MANAGER")                         // any MANAGER should be able to access it
          .antMatchers("/control/**")                   // for control page and its sub-pages
            .hasRole("ADMIN")                           // any ADMIN should be able to access it
        .and()                                          // and
        .formLogin()                                    // show our custom form login instead of Spring default one
          .loginPage("/loginPageForCampany")            // login form's url http://localhost:8080/spring-security/loginPageForCampany
          .loginProcessingUrl("/authenticateUser")      // when hitting submit, send data to http://localhost:8080/spring-security/authenticateUser
          .permitAll()                                  // allow acess to this page for all users, it's done by default but just to make sure
        .and()                                          // and
        .logout()                                       // add log out support
          .permitAll()                                  // allow log out for all users
        .and()                                          // and
          .exceptionHandling()                          // when an exception occures (unauthorized person tries to access a page)
            .accessDeniedPage("/denied");               // show our custom page at url http://localhost:8080/spring-security/denied, instead of Error 403 message.
  }

  
  
}
