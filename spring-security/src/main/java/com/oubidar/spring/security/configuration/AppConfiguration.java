package com.oubidar.spring.security.configuration;

import java.beans.PropertyVetoException;
import java.util.logging.Logger;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import com.mchange.v2.c3p0.ComboPooledDataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.oubidar.spring.security")
@PropertySource("classpath:persistence-mysql.properties")
public class AppConfiguration {

  // set up a variable to hold properties
  @Autowired
  private Environment environment ;
  
  // set up a logger
  private Logger logger = Logger.getLogger(getClass().getName());
  
  // define a bean for ViewResolver
  @Bean
  public ViewResolver viewResolver() {

    InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();

    viewResolver.setPrefix("/WEB-INF/view/");
    viewResolver.setSuffix(".jsp");

    return viewResolver;
  }
  
  // define bean for datasource
  @Bean
  public DataSource securityDataSource() {
    
    // create connection pool
    ComboPooledDataSource comboPooledDataSource = new ComboPooledDataSource();
    
    // set the jdbc driver class
    try {
      comboPooledDataSource.setDriverClass(environment.getProperty("jdbc.driver"));
    } catch (PropertyVetoException exc) {
      logger.warning(exc.getMessage());
      throw new RuntimeException(exc);
    }
    
    // log the connection props
    logger.info(">>> JDBC URL : "+ environment.getProperty("jdbc.url"));
    logger.info(">>> JDBC user : "+ environment.getProperty("jdbc.user"));
    
    // set database connection props
    comboPooledDataSource.setJdbcUrl(environment.getProperty("jdbc.url"));
    comboPooledDataSource.setUser(environment.getProperty("jdbc.user"));
    comboPooledDataSource.setPassword(environment.getProperty("jdbc.password"));
    
    //set connection pool props
    comboPooledDataSource.setInitialPoolSize(getIntProperty("connection.pool.initialPoolSize"));
    comboPooledDataSource.setMinPoolSize(getIntProperty("connection.pool.minPoolSize"));
    comboPooledDataSource.setMaxPoolSize(getIntProperty("connection.pool.maxPoolSize"));
    comboPooledDataSource.setMaxIdleTime(getIntProperty("connection.pool.maxIdleTime"));
    
    return comboPooledDataSource ;
  }
  
  // helper to get int values from properties
  private int getIntProperty(String property) {
    
    String propertyValue = environment.getProperty(property);
    
    return Integer.parseInt(propertyValue);
  }
}
