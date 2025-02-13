<%-- 
    Document   : index
    Created on : Feb 10, 2025, 11:23:20 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1>Toy List</h1>
<hr/>
<a href="<c:url value="/toy/create.do" />">Create New</a><br/>
<table class="table table-striped">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th style="text-align: right;">Price</th>
        <th>Expired Date</th>
        <th>Brand</th>
        <th>Operations</th>
    </tr>
    <c:forEach var="toy" items="${list}">
        <tr>
            <td>${toy.id}</td>
            <td>${toy.name}</td>
            <td style="text-align: right;">
        <fmt:formatNumber value="${toy.price}" currencySymbol="$" type="currency" />
        </td>
        <td>
        <fmt:formatDate value="${toy.expDate}" pattern="MM-dd-yyyy"/>
        </td>
        <td>${toy.brand}</td>
        <td>
            <a href="<c:url value="/toy/edit.do?id=${toy.id}" />">Edit</a> | 
            <a href="<c:url value="/toy/delete.do?id=${toy.id}" />">Delete</a>
        </td>
        </tr>
    </c:forEach>
</table>
