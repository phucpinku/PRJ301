<%-- 
    Document   : delete
    Created on : Jan 16, 2025, 11:35:03 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Toy</h1>
        <hr/>
        <form action="toy">
            Are you sure to delete this toy with id = ${param.id}?
            <input type="hidden" name="action" value="delete_handler"/>
            <button type="summit" value="yes" name="op">Yes</button>
            <button type="summit" value="no" name="op">No</button>
        </form>
    </body>
</html>
