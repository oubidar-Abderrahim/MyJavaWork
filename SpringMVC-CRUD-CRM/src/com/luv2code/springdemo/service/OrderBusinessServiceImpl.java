package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.OrderBusinessDAO;
import com.luv2code.springdemo.entity.OrderBusiness;


@Service
public class OrderBusinessServiceImpl implements OrderBusinessService {
  
  
  @Autowired
  private OrderBusinessDAO orderBusinessDAO;

  @Override
  @Transactional
  public List<OrderBusiness> getOrderBusinesses() {
    
    return orderBusinessDAO.getOrderBusinesses();
  }

  @Override
  @Transactional
  public void saveOrderBusiness(OrderBusiness theOrderBusiness) {

    orderBusinessDAO.saveOrderBusiness(theOrderBusiness);
    
  }

  @Override
  @Transactional
  public OrderBusiness getOrderBusiness(int theId) {
    
    return orderBusinessDAO.getOrderBusiness(theId) ;
  }

  @Override
  @Transactional
  public void deleteOrderBusiness(int theId) {
    
    orderBusinessDAO.deleteOrderBusiness(theId);
  }

}
