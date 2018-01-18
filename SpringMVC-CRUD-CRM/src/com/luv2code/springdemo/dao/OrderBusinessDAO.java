package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.OrderBusiness;

public interface OrderBusinessDAO {

  List<OrderBusiness> getOrderBusinesses();

  void saveOrderBusiness(OrderBusiness theOrderBusiness);

  OrderBusiness getOrderBusiness(int theId);

  void deleteOrderBusiness(int theId);

}

