<%-- 
    Document   : p1
    Created on : Mar 6, 2025, 9:45:30 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="user" class="beans.User" scope="request" />
<jsp:setProperty name="user" property="email" value="john@gmail.com" />
<jsp:setProperty name="user" property="fullName" value="John Smith" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Use Beans</h1>
        <hr/>
        Email: <jsp:getProperty name="user" property="email" /><br/>
        Full Name: <jsp:getProperty name="user" property="fullName" /><br/>
        <hr/>
        <!--c1-->
        Email: ${user.email} <br/>
        Full Name: ${user.fullName}<br/>
<!--        c2
        Email: ${user["email"]} <br/>
        Full Name: ${user["fullName"]}<br/>-->
    </body>
</html>
