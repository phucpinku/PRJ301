<%-- 
    Document   : HoaDNT
    Created on : NOVEMBER 1, 2022, 9:09:09 PM
    Author     : hd
--%>


<%@page import="pe.user.UserDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
    </head>
    <body>
        <!--your code here-->
        Welcome ${user.fullName} | 
        <a href="MainController?action=logout">Logout</a>


        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Description</th>
                <th>Price</th>
                <th>Speed</th>
                <th>Status</th>
            </tr>
            <c:forEach var="em" items="${list}">
                <tr>
                    <td>${em.id}</td>
                    <td>${em.name}</td>
                    <td>${em.description}</td>
                    <td><fmt:formatNumber value="${em.price}" type="currency" /></td> 
                    <td>${em.speed}</td>
                    <td>${em.status}</td> 
                </tr>
            </c:forEach>
        </table>

        <c:if test="${user.roleID == 'AD'}">
            <h1>Creating Car</h1>
            <hr/>
            <!--your code here-->
            <form action="MainController">
                Id: <br/>
                <input type="text" name="id" value="${param.id}" pattern="C-\d{3}" title="Format: C-XXX (X là số)" required> <br/>

                Name: <br/>
                <input type="text" name="name" value="${param.name}" required> <br/>

                Description: <br/>
                <textarea name="description">${param.description}</textarea> <br/>

                Price: <br/>
                <input type="number" name="price" value="${param.price}" step="0.01" required> <br/>

                Speed (km/h): <br/>
                <input type="number" name="speed" value="${param.speed}" required> <br/>

                <input type="hidden" name="status" value="true">

                <input type="hidden" name="action" value="create_handler" />

                <!-- Buttons -->
                <button type="submit" name="op" value="create">Create</button>
                <button type="submit" name="op" value="cancel">Cancel</button>
            </form>

            <!-- Show validation error messages -->
            <i style="color: red">${message}</i>
        </c:if>


    </body>
</html>
