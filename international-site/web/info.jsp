<%-- 
    Document   : info
    Created on : Mar 10, 2025, 9:59:33 AM
    Author     : ACER
--%>

<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<h1><fmt:message key="info.title" /></h1>
<hr/>
<fmt:message key="info.fullname" /> John Smith<br/>
<fmt:message key="info.dob" /><fmt:formatDate value="<%=new Date() %>" /><br/>
<fmt:message key="info.salary" /><fmt:formatNumber value="123456789.9876" type="currency" /><br/>
<br/><br/>
<a href="<c:url value="/" />"><fmt:message key="info.homepage" /></a>
