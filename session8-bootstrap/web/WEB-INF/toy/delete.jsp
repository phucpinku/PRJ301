<%-- 
    Document   : delete
    Created on : Jan 16, 2025, 11:35:01 AM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Delete Toy</h1>
<hr/>
<form action="<c:url value="/toy/delete_handler.do" />">
    Are you sure to delete this toy with id = ${param.id}?
    <br/>
    <input type="hidden" name="id" value="${param.id}" />
    <button type="submit" value="yes" name="op">Yes</button>
    <button type="submit" value="no" name="op">No</button>
</form>
