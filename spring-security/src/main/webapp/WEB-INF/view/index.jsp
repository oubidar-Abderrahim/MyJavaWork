<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <title>Satityr Company Home Page</title>
</head>

<body>
	<h2>Satityr Company Home Page</h2>
	<hr>
    <p>
		Welcome to the Satityr company home page! <br /><br />
		Do you know that CSRF protection is enabled by default in Spring Security, Spring uses the synchronized token pattern, where each
		request includes a session cookies and randomly generated token. <br />Spring security filters verify this token before processing any request.
		<br /><br />The token is add by default if you use "form:from" tag. In case you used a normal "form" tag, you have to add it manually or you will get an 
		HTTP Status 403 - Forbidden (Invalid CSRF Token 'null' was found on the request parameter '_csrf' or header 'X-CSRF-TOKEN'. The server understood the request but 
		refuses to authorize it.)
		<br />Best practice : <b>Use "form:form" tag</b>
    </p>
    <hr />
    <p>employee's portal : <a href="${pageContext.request.contextPath}/services" >Services</a></p>
	<security:authorize access="hasRole('MANAGER')" >
	   <p>Manager's portal : <a href="${pageContext.request.contextPath}/management" >Management Program</a></p>
	</security:authorize>
	<security:authorize access="hasRole('ADMIN')" >
	   <p>Admin's portal : <a href="${pageContext.request.contextPath}/control" >Control Unit</a></p>
	</security:authorize>
    
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