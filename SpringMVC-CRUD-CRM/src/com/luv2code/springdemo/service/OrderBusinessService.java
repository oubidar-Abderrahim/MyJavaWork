package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.OrderBusiness;

public interface OrderBusinessService {

  public List<OrderBusiness> getOrderBusinesses() ;

  public void saveOrderBusiness(OrderBusiness theOrderBusiness);

  public OrderBusiness getOrderBusiness(int theId);

  public void deleteOrderBusiness(int theId);
}

