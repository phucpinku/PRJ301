<%-- 
    Document   : create
    Created on : Jan 16, 2025, 9:57:45 AM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Edit Toy</h1>
        <hr/>
        <form action="<c:url value="/toy/edit_handler.do" />">
            Id:<br/>
            <input type="text" disabled="" value="${toy.id}" /><br/>
            <input type="hidden" name="id" value="${toy.id}" />
            Name:<br/>
            <input type="text" name="name" value="${param.name!=null?param.name:toy.name}"/><br/>
            Price:<br/>
            <input type="text" name="price" value="${param.price!=null?param.price:toy.price}"/><br/>
            Expired date:<br/>
            <input type="date" name="expDate" value="${param.expDate!=null?param.expDate:toy.expDate}"/><br/>
            Brand:<br/>
            <!--<input type="text" name="brand" value="${param.brand!=null?param.brand:toy.brand}"/>-->
            <select name="brand">
                <c:forEach var="brand" items="${list}">
                    <option value="${brand.id}" ${param.brand==brand.id?"selected":""}>${brand.name}</option>
                </c:forEach>
            </select>
            <br/>
            <button type="submit" value="update" name="op">Update</button>
            <button type="submit" value="cancel" name="op">Cancel</button>
        </form>
        <i style="color:red;">${message}</i>