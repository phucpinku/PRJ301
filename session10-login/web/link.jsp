<%-- 
    Document   : link
    Created on : Feb 17, 2025, 11:20:44 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<span style="float:right;">
    <a href="<c:url value="/"/>">Home</a> |
    <c:if test="${account==null}">
        <a href="<c:url value="/login.jsp"/>">Login</a>
    </c:if>
    <c:if test="${account!=null}">
        Welcome ${account.fullName} | 
        <a href="<c:url value="/user/logout.do"/>">Logout</a> </span>
    </c:if>

