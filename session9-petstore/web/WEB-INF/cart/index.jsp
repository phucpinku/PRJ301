<%-- 
    Document   : index
    Created on : Feb 24, 2025, 10:08:09 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-striped">
    <tr>
        <th>No.</th>
        <th>Image</th>
        <th>Id</th>
        <th>Description</th>
        <th style="text-align: right">Old Price</th>
        <th style="text-align: right">New Price</th>
        <th style="text-align: right">Quantity</th>
        <th style="text-align: right">Cost</th>
        <th>Operations</th>

    </tr>
    <c:forEach var="item" items="${cart.items}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><img src="<c:url value="/products/${item.id}.jpg"/>" height="60px"></td>
            <td>${item.id}</td>
            <td>${item.product.description}</td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.product.price}" type="currency" />
            </td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.product.newPrice}" type="currency" />
            </td>
            <td style="text-align: right">
                <input type="number" min="0" name="quantity" value="${item.quantity}" style="width:60px" />

            </td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.cost}" type="currency" />
            </td>
            <td>
                <a href="#" class="update" data-id="${item.id}">Update</a> | 
                <a href="<c:url value="/cart/remove.do?id=${item.id}" />">Remove</a>

            </td>
        </tr>
    </c:forEach>
    <tr>
        <th style="text-align: right" colspan="7">Total</th>
        <th style="text-align: right">
            <fmt:formatNumber value="${cart.total}" type="currency" />
        </th>
        <th><a href="<c:url value="/cart/empty.do" />">Empty Cart</a></th>
    </tr>

</table>
    <a href="<c:url value="/cart/checkout.do" />">Check out</a>
    
    
<script>
    $(".update").click(function () {
        //lay id va quantity
        var id = $(this).data("id");
        var quantity = $(this).closest("tr").find("input[name='quantity']").val();
        //tao url
        var url = `<c:url value="/cart/update.do?id=\${id}&quantity=\${quantity}" />`;
        
        window.location = url;
    });
</script>
