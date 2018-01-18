package com.luv2code.springdemo.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.entity.OrderBusiness;
import com.luv2code.springdemo.service.CustomerService;
import com.luv2code.springdemo.service.OrderBusinessService;

@Controller
@RequestMapping("/customer")
public class CustomerController {

  // need to inject our customer service
  @Autowired
  private CustomerService customerService;
  
  @Autowired
  private OrderBusinessService orderBusinessService;
  
  
  // initiation binder to trim any spaces
  @InitBinder
  public void initBinder(WebDataBinder dataBinder) {
    
    StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
    
    dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
  }
  
  // initiation binder to match Date
  @InitBinder
  public void DateinitBinder(WebDataBinder binder) {
      SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
      sdf.setLenient(true);
      binder.registerCustomEditor(Date.class, new CustomDateEditor(sdf, true));
  }
  
  @GetMapping("/list")
  public String listCustomers(Model theModel) {
    
    // get customers from the service
    List<Customer> theCustomers = customerService.getCustomers();
        
    // add the customers to the model
    theModel.addAttribute("customers", theCustomers);
    
    return "list-customers";
  }
  
  
  @GetMapping("/orderlist")
  public String listOrders(Model theModel) {
    
    // get customers from the service
    List<OrderBusiness> theOrderBusiness = orderBusinessService.getOrderBusinesses();
        
    // add the customers to the model
    theModel.addAttribute("orderBusiness", theOrderBusiness);
    
    return "list-orders";
  }
  
  @GetMapping("/showFormForAdd")
  public String showFormForAdd(Model theModel) {
    
    // create model attribute to bind form data
    Customer theCustomer = new Customer();
    
    theModel.addAttribute("customer", theCustomer);
    
    return "customer-form";
  }
  
  @GetMapping("/showFormForAddOrder")
  public String showFormForAddOrder(Model theModel) {
    
    // create model attribute to bind form data
    OrderBusiness theOrderBusiness = new OrderBusiness();
    
    theModel.addAttribute("orderBusiness", theOrderBusiness);
    
    return "order-form";
  }
  
  @PostMapping("/saveCustomer")
  public String saveCustomer(@ModelAttribute("customer") Customer theCustomer) {
    
    // save the customer using our service
    customerService.saveCustomer(theCustomer);  
    
    return "redirect:/customer/list";
  }
  
  @PostMapping("/saveOrder")
  public String saveOrderBusiness(@ModelAttribute("OrderBusiness") OrderBusiness theOrderBusiness) {
    
    // save the OrderBusiness using our service
    orderBusinessService.saveOrderBusiness(theOrderBusiness);  
    
    return "redirect:/customer/orderlist";
  }
  
  @GetMapping("/showFormForUpdate")
  public String showFormForUpdate(@RequestParam("customerId") int theId,
                  Model theModel) {
    
    // get the customer from our service
    Customer theCustomer = customerService.getCustomer(theId);  
    
    // set customer as a model attribute to pre-populate the form
    theModel.addAttribute("customer", theCustomer);
    
    // send over to our form    
    return "customer-form";
  }
  
  
  @GetMapping("/showFormForUpdateOrder")
  public String showFormForUpdateOrder(@RequestParam("orderId") int theId,
                  Model theModel) {
    
    // get the customer from our service
    OrderBusiness theOrderBusiness = orderBusinessService.getOrderBusiness(theId);  
    
    // set customer as a model attribute to pre-populate the form
    theModel.addAttribute("orderBusiness", theOrderBusiness);
    
    // send over to our form    
    return "order-form";
  }
  
  @GetMapping("/delete")
  public String deleteCustomer(@RequestParam("customerId") int theId) {
    
    // delete the customer
    customerService.deleteCustomer(theId);
    
    return "redirect:/customer/list";
  }
  
  @GetMapping("/deleteOrder")
  public String deleteOrderBusiness(@RequestParam("orderId") int theId) {
    
    // delete the customer
    orderBusinessService.deleteOrderBusiness(theId);
    
    return "redirect:/customer/orderlist";
  }
}










