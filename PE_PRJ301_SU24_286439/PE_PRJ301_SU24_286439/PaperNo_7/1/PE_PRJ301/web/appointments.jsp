<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>List of the appointments </title>
    </head>
    <body>
        <h1>The appointments</h1>
        <hr/>
        <!--your code here-->
        <c:if test="${account.roleDB == 'super'}">
            <h1>Welcome ${account.fullName}</h1> <br/>
        <a href="MainController?Action=logout">Logout</a> |
        <a href="MainController?action=create">Create</a> 
        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <td>idApp </td>
                <td>account </td>
                <td>partnerPhone </td>
                <td>partnerName </td>
                <td>timeToMeet </td>
                <td>place </td>
                <td>expense </td>
                <td>note </td>
            </tr>
            
            <c:forEach var="em" items="${list}">
                <tr>
                    <td>${em.idApp}</td>
                    <td>${em.account}</td>
                    <td>${em.partnerPhone}</td>
                    <td>${em.partnerName}</td>
                    <td><fmt:formatDate value="${em.timeToMeet}" pattern="yyyy-MM-dd" /></td>
                    <td>${em.place}</td>
                    <td>${em.expense}</td>
                    <td>${em.note}</td>
                </tr>
            </c:forEach>
            
        </table>
        </c:if>
        <c:if test="${account.roleDB == 'member'}">
            <h1>Welcome ${account.fullName}</h1> <br/>
        <a href="MainController?Action=logout">Logout</a>
        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <td>idApp </td>
                <td>account </td>
                <td>partnerPhone </td>
                <td>partnerName </td>
                <td>timeToMeet </td>
                <td>place </td>
                <td>expense </td>
                <td>note </td>
            </tr>
            
            <c:forEach var="em" items="${list}">
                <tr>
                    <td>${em.idApp}</td>
                    <td>${em.account}</td>
                    <td>${em.partnerPhone}</td>
                    <td>${em.partnerName}</td>
                    <td><fmt:formatDate value="${em.timeToMeet}" pattern="yyyy-MM-dd" /></td>
                    <td>${em.place}</td>
                    <td>${em.expense}</td>
                    <td>${em.note}</td>
                </tr>
            </c:forEach>
            
        </table>
        </c:if>
    </body>
</html>
