<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
 <head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
    <title>Add an Order</title>
    <link type="text/css" rel="stylesheet" 
          href="${pageContext.request.contextPath}/resources/css/style.css" />
    <link type="text/css" rel="stylesheet" 
          href="${pageContext.request.contextPath}/resources/css/add-customer-style.css" />
 </head>
 <body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>
    
    <div id="container">
        <h3>Save Order</h3>
        
        <form:form action="saveOrder" modelAttribute="orderBusiness" methode="POST">
        
            <!-- associate data with order & customer id -->
            <form:hidden path="id" />
            <form:hidden path="customer.id" />
            
            <table>
                <tbody>
                    <tr>
                        <td><label>First name</label></td>
                        <td><form:input path="customer.firstName" /></td>
                    </tr>
                    <tr>
                        <td><label>Last name</label></td>
                        <td><form:input path="customer.lastName" /></td>
                    </tr>
                    <tr>
                        <td><label>Email</label></td>
                        <td><form:input path="customer.email" /></td>
                    </tr>
                    <tr>
                        <td><label>Description</label></td>
                        <td><form:input path="description" /></td>
                    </tr>
                    <tr>
                        <td><label>Date of purchase</label></td>
                        <td><form:input path="dateOfPurchase" /></td>
                    </tr>
                    <tr>
                        <td><label></label></td>
                        <td><input type="submit" value="Save" Class="save" /></td>
                    </tr>
                </tbody>
            </table>
        </form:form>
        
        <div style="clear; both;" ></div>
        <p><a href="${pageContext.request.contextPath}/customer/orderlist">Back to Order list</a></p>
    </div>
 </body>
</html>