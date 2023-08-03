<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
    <h4 style="color: red"><c:out value="${error_message}" /></h4>
    <form method="POST" action="${pageContext.request.contextPath}/login">
        Login <input type="text" name="login" required> <br>
        Password <input type="password" name="password" required> <br>
        <input type="submit" value="submit">
    </form>
</body>
</html>
