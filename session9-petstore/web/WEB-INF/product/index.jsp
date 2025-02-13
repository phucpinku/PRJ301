<%-- 
    Document   : index
    Created on : Feb 13, 2025, 11:16:58 AM
    Author     : ACER
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <c:forEach var="product" items="${list}">
        <div class="col-sm-4 mt-3 mb-3">
            Id: ${product.id} <br/>
            Description: ${product.description} <br/>
            Price: <fmt:formatNumber value="${product.price}" type="currency" /> <br/>
            Discount: <fmt:formatNumber value="${product.discount}" type="percent" /> <br/>
            Category Id: ${product.categoryId} <br/>
            <img src="<c:url value="/products/${product.id}.jpg"/>" width="100%" />
            
        </div>
        
    </c:forEach>
    
</div>
