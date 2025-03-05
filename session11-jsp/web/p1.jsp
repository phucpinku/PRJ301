<%-- 
    Document   : p1
    Created on : Mar 3, 2025, 10:13:50 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%--<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>--%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Elements</h1>
        <hr/>
        <%--Declaration--%>
        <%!
            String name = "John Smith";

            int add(int a, int b) {
                return a + b;
            }
        %>
        <%--Expression--%>
        <%=name%>
        <br/>
        <%=add(2, 3)%>
        <br/>
        <%--Scriptlet--%>
        <%
            out.println("Hello" + name);

        %>

    </body>
</html>
