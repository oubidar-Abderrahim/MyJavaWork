<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>

<html>

<head>
<title>List of Orders </title>

<!-- reference our style sheet -->

<link type="text/css" rel="stylesheet"
    href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>

<body>

    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">

        <div id="content">

            <!-- new button: add order -->

            <input type="button" value="Add Order"
                onclick="window.location.href='showFormForAddOrder'; return false;" 
                class="add-button"/>
            
            <!--  add our html table here -->

            <table>
                <tr>
                    <th>First Name</th>
                    <th>Last Name</th>
                    <th>Email</th>
                    <th>Description</th>
                    <th>Date of Purchase</th>
                    <th>Action</th>
                </tr>

                <!-- loop over and print our customers -->
                <c:forEach var="tempOrderBusiness" items="${orderBusiness}">
                
                    <!-- construct an "update" link with oredr id -->
                    <c:url var="updateLink" value="/customer/showFormForUpdateOrder">
                        <c:param name="orderId" value="${tempOrderBusiness.id}" />
                    </c:url>
                    
                    <!-- construct an "delete" link with customer id -->
                    <c:url var="deleteLink" value="/customer/deleteOrder">
                        <c:param name="orderId" value="${tempOrderBusiness.id}" />
                    </c:url>

                    <tr>
                        <td>${tempOrderBusiness.customer.firstName}</td>
                        <td>${tempOrderBusiness.customer.lastName}</td>
                        <td>${tempOrderBusiness.customer.email}</td>
                        <td>${tempOrderBusiness.description}</td>
                        <td>${tempOrderBusiness.dateOfPurchase}</td>
                        <td>
                          <a href="${updateLink}">Update</a> 
                          | 
                          <a href="${deleteLink}" onclick="if (!(confirm('Are you sure you want to delete this customer?'))) return false" >Delete</a>
                        </td>
                    </tr>

                </c:forEach>

            </table>

        </div>

    </div>


</body>

</html>









