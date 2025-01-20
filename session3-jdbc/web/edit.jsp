<%-- 
    Document   : create
    Created on : Jan 16, 2025, 9:57:48 AM
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
        <h1>Edit Toy</h1>
        <hr/>
        <form action="toy">
            Id:<br/>
            <input type="text" disabled="" value="${toy.id}"/><br/>
            <input type="hidden" name="id" value="${toy.id}" />
            Name<br/>
            <input type="text" name="name" value="${param.name!=null?param.name:toy.name}"/><br/>
            Price:<br/>
            <input type="text" name="price" value="${param.price!=null?param.price:toy.price}"/><br/>
            Expired date:<br/>
            <input type="date" name="expDate" value="${param.expDate!=null?param.expDate:toy.expDate}"/><br/>
            Brand:<br/>
            <input type="text" name="brand" value="${param.brand!=null?param.brand:toy.brand}"/><br/>
            <input type="hidden" name="action" value="edit_handler"/>
            <button type="summit" value="update" name="op">Update</button>
            <button type="summit" value="cancel" name="op">Cancel</button>
        </form>
        <i style="color:red;">${message}</i>
    </body>
</html>
