<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>


<!DOCTYPE html>

<html>

<head>
<title>CRM Application </title>

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

            <!-- new button: show orders -->

            <input type="button" value="Show by Order"
                onclick="window.location.href='customer/orderlist'; return false;" 
                class="add-button"/>
                
            <!-- new button: show customers -->

            <input type="button" value="Show by Customer"
                onclick="window.location.href='customer/list'; return false;" 
                class="add-button"/>
            
            <!--  add our html table here -->

            

        </div>

    </div>


</body>

</html>










