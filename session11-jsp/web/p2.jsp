<%-- 
    Document   : p2
    Created on : Mar 3, 2025, 10:26:34 AM
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
        <h1>Hello World!</h1>
        <form>
            Enter your name:
            <input type="text" name="fullname" value="${param.fullname}" />
            <button type="submit">Submit</button>
        </form>
        Hello ${param.fullname}
    </body>
</html>
