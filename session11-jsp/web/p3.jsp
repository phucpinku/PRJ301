<%-- 
    Document   : p3
    Created on : Mar 3, 2025, 10:33:12 AM
    Author     : ACER
--%>

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
        <h1>Calculator</h1>
        <hr/>
        <form>
            Number 1:<br/>
            <input type="number" name="num1" value="${param.num1}" /><br/>
            Number 2:<br/>
            <input type="number" name="num2" value="${param.num2}" /><br/>
            <button type="submit" name="op" value="add">Add</button>
            <button type="submit" name="op" value="sub">Sub</button>
            <button type="submit" name="op" value="mul">Mul</button>
            <button type="submit" name="op" value="div">Div</button>

        </form>
        Result:
        <c:choose>
            <c:when test="${param.op=='add'}">
                ${param.num1 + param.num2}
            </c:when>

            <c:when test="${param.op=='sub'}">
                ${param.num1 - param.num2}
            </c:when>

            <c:when test="${param.op=='mul'}">
                ${param.num1 * param.num2}
            </c:when>

            <c:when test="${param.op=='div'}">
                <c:if test="${param.num2 == 0}">
                    Can't divide by zero
                </c:if> 

                <c:if test="${param.num2 != 0}">
                    ${param.num1 / param.num2}
                </c:if>    

            </c:when>
        </c:choose>
    </body>
</html>
