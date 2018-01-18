package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.OrderBusiness;

@Repository
public class OrderBusinessDAOImpl implements OrderBusinessDAO {

  
  
  // need to inject the session factory
  @Autowired
  private SessionFactory sessionFactory;
  
  
  @Override
  public List<OrderBusiness> getOrderBusinesses() {
 
    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
        
    // create a query 
    Query<OrderBusiness> theQuery = 
        currentSession.createQuery("from OrderBusiness",
            OrderBusiness.class);
    
    // execute query and get result list
    List<OrderBusiness> orderBusinesses = theQuery.getResultList();
        
    // return the results   
    return orderBusinesses;
  }

  @Override
  public void saveOrderBusiness(OrderBusiness theOrderBusiness) {


    // get current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    // save/upate the orderBusiness 
    currentSession.saveOrUpdate(theOrderBusiness);

  }

  @Override
  public OrderBusiness getOrderBusiness(int theId) {


    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    // now retrieve/read from database using the primary key
    OrderBusiness theOrderBusiness = currentSession.get(OrderBusiness.class, theId);
    
    return theOrderBusiness;
  }

  @Override
  public void deleteOrderBusiness(int theId) {

    // get the current hibernate session
    Session currentSession = sessionFactory.getCurrentSession();
    
    // delete object with primary key
    OrderBusiness orderBusiness = currentSession.get(OrderBusiness.class, theId);
    
    if( orderBusiness != null ) {
      currentSession.delete(orderBusiness);
    }
      
  }

}
