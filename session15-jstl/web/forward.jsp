<%-- 
    Document   : forward
    Created on : Mar 6, 2025, 11:02:41 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="name" value="John Smith" scope="request" />
<jsp:forward page="/welcome.jsp" />
