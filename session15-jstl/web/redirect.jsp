<%-- 
    Document   : redirect
    Created on : Mar 6, 2025, 11:06:37 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:set var="name" value="John Smith" scope="request" />
<c:redirect url="welcome.jsp" />
