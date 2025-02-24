<%-- 
    Document   : index
    Created on : Feb 24, 2025, 10:08:09 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-striped">
    <c:forEach var="item" items="${cart.items}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><img src="<c:url value="/products/${item.id}.jpg"/>" height="60px"></td>
            <td>${item.id}</td>
            <td>${item.product.description}</td>
            <td>${item.product.price}</td>
            <td>${item.product.newPrice}</td>
            <td>${item.quantity}</td>
            <td>${item.cost}</td>
        </tr>
    </c:forEach>
    
</table>
