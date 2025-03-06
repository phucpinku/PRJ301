<%-- 
    Document   : p2
    Created on : Mar 6, 2025, 10:02:04 AM
    Author     : ACER
--%>

<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Using Collections</h1>
        <hr/>
        <h3>Using Arrays</h3>
        <%
            String names[] = {"Name", "Hai"};
            pageContext.setAttribute("names", names);
            
        %>
        ${names[0]}<br/>
        ${names[1]}<br/>
        
        <h3>Using list</h3>
        <%
            List<String> list =  Arrays.asList("Name", "Hai");
            pageContext.setAttribute("list", list);
            
        %>
        ${list[0]}<br/>
        ${list[1]}<br/>
        
        <h3>Using Maps</h3>
        <%
            Map<String,Double> map =  new HashMap<>();
            map.put("Nam", 9.5);
            map.put("Minh", 8.5);
            session.setAttribute("map", map);
        %>
        Nam: ${map["Nam"]}<br/>
        Minh: ${map["Minh"]}<br/>
    </body>
</html>
