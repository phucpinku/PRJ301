<%-- 
    Document   : login
    Created on : Feb 17, 2025, 9:41:27 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr/>
        <form action="<c:url value="/user/login.do" />" method="post">
        Email:<br/>
        <input type="email" name="email" value="${param.email}" /><br/>
        Password:<br/>
        <input type="password" name="password" value="${param.password}" /><br/>
        <button type="submit" name="op" value="login">login</button>
        <button type="submit" name="op" value="Cancel">Cancel</button>
        </form>
        <i style="color:red;">${message}</i>
    </body>
</html>
