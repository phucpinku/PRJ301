<%-- 
    Document   : p1
    Created on : Mar 6, 2025, 10:29:59 AM
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
        <h1>Set Variable's Values</h1>
        <hr/>
        <c:set var="name" value="John Smith" scope="session" />
        Name: ${name}
    </body>
</html>
