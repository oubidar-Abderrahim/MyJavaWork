package com.oubidar.springdemo.dao;

import java.util.List;

import com.oubidar.springdemo.entity.OrderBusiness;

public interface OrderBusinessDAO {

  List<OrderBusiness> getOrderBusinesses();

  void saveOrderBusiness(OrderBusiness theOrderBusiness);

  OrderBusiness getOrderBusiness(int theId);

  void deleteOrderBusiness(int theId);

}

