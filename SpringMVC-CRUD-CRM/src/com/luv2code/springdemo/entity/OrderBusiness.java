package com.luv2code.springdemo.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;


@Entity
@Table(name="order_business")
public class OrderBusiness {
  
  
  @Id
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  @Column(name="id")
  private int id;
  
  
  @Column(name="description")
  private String description;
  
  @Column(name="date_of_purchase")
  @Temporal(TemporalType.DATE)
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private Date dateOfPurchase ;
  
  @OneToOne(cascade=CascadeType.ALL)
  @JoinColumn(name="customer_id")
  private Customer customer;

  public OrderBusiness() {
    
  }

  public OrderBusiness(String description, Date dateOfPurchase) {
    this.description = description;
    this.dateOfPurchase = dateOfPurchase;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getDescription() {
    return description;
  }

  public void setDescription(String description) {
    this.description = description;
  }

  public Date getDateOfPurchase() {
    return dateOfPurchase;
  }

  public void setDateOfPurchase(Date dateOfPurchase) {
    this.dateOfPurchase = dateOfPurchase;
  }

  public Customer getCustomer() {
    return customer;
  }

  public void setCustomer(Customer customer) {
    this.customer = customer;
  }

  @Override
  public String toString() {
    return "OrderBusiness [id=" + id + ", description=" + description + ", dateOfPurchase="
        + DateUtils.formatDate(dateOfPurchase) + ", customer=" + customer + "]";
  }
  
  

}
