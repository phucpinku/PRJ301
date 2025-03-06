<%-- 
    Document   : p4
    Created on : Mar 6, 2025, 10:46:00 AM
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
        <h1>Forward & Redirect</h1>
        <hr/>
        <form action="controller">
            <button type="submit" name="op" value="forward">Forward</button>
            <button type="submit" name="op" value="redirect">Redirect</button>
        </form>
    </body>
</html>
