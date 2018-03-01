<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
    <title>Satityr Company Authentication Form</title>
    <style type="text/css">
        .failed{
            color: red;
        }
    </style>
</head>

<body>
  <h3>Authentication Form</h3>
  <form:form action="${pageContext.request.contextPath}/authenticateUser" method="POST">
     <p>
        <c:if test="${param.error != null}">
            <i class="failed">Sorry! invalid name or password</i>
        </c:if>
     </p>
     <p>
        User Name : <input type="text" name="username" />
     </p>
     <p>
        Password  : <input type="password" name="password" />
     </p>
     <input type="submit" value="Login" />
  </form:form>
</body>

</html>