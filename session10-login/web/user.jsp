<%-- 
    Document   : user
    Created on : Feb 17, 2025, 9:49:06 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${account==null}">
    <jsp:forward page="/login.jsp" />
</c:if> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>User Page</h1>
        <hr/>
        <jsp:include page="/link.jsp" />
    </body>
</html>
