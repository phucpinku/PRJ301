<%-- 
    Document   : index
    Created on : Mar 6, 2025, 11:15:57 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<fmt:setBundle basename="resources.messages" scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1><fmt:message key="home.welcome" /></h1>
        <fmt:message key="home.flag" var="flag" />
        <img src="images/${flag}" />
    </body>
</html>
