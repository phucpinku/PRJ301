<%-- 
    Document   : toy
    Created on : Jan 13, 2025, 10:45:03 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Toy CRUD</h1>
        <hr/>
        <table border="1">
            <c:forEach var="toy" items="${list}">
                <tr>
                    <td>${toy.id}</td>
                    <td>${toy.name}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
