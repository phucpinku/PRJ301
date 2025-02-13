<%-- 
    Document   : main
    Created on : Feb 10, 2025, 10:43:31 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--header--%>
        <h1 style="color:red;">Demo</h1>
        <hr/>
        <%--content--%>
        <jsp:include page="/WEB-INF/${controller}/${action}.jsp" />
        <%--footer--%>
        
        <hr/>
        Copyrights &copy; by FPT Students
    </body>
</html>
