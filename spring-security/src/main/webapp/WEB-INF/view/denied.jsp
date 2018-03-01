<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<!DOCTYPE html>
<html>

<head>
    <title>Satityr Company Error 403 - Access Denied</title>
</head>

<body>
    <h2>Satityr Company Error 403 - Access Denied</h2>
    <hr />
    <p>
        You are trying to access a page with a higher role than yours!
        <br /> 
        If you think this is an error, please contact our support team.
        <br /> 
        <a href="${pageContext.request.contextPath}/" >Home Page</a>
    </p>
    
    <br />
    <h4>
        You are <security:authentication property="principal.username" />
        <br />
        Your role is <security:authentication property="principal.authorities" />
    </h4>
</body>

</html>