<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <title>Satityr Company Services Page</title>
</head>

<body>
    <h2>Satityr Company Services Page</h2>
    <hr>
    <p>
        You are in the services page for all Employees.<br /><br />
        <a href="${pageContext.request.contextPath}/" >Home Page</a>
    </p>
    
    <!-- add logout button -->
    <form:form action="${pageContext.request.contextPath}/logout" method="POST">
        <input type="submit" value="Logout" />
    </form:form>
    <br />
    <h4>
        You are <security:authentication property="principal.username" />
        <br />
        Your role is <security:authentication property="principal.authorities" />
    </h4>
</body>

</html>