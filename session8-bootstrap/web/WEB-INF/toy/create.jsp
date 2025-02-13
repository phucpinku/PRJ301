<%-- 
    Document   : create
    Created on : Jan 16, 2025, 9:57:45 AM
    Author     : PHT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Create Toy</h1>
<hr/>
<div class="row">
    <div class="col-sm-6">
        <!--<form action="/session4-jdbc/toy/create_handler.do">-->
        <!--<form action="${pageContext.request.contextPath}/toy/create_handler.do">-->
        <form action="<c:url value="/toy/create_handler.do" />">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="text" value="${param.id}" class="form-control" id="id" placeholder="Enter id" name="id">
            </div>

            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Name:</label>
                <input type="text" value="${param.name}" class="form-control" id="name" placeholder="Enter name" name="name">
            </div>

            <div class="mb-3 mt-3">
                <label for="price" class="form-label">Price:</label>
                <input type="text" value="${param.price}" class="form-control" id="price" placeholder="Enter price" name="price">
            </div>

            <div class="mb-3 mt-3">
                <label for="expDate" class="form-label">Expired date:</label>
                <input type="date" value="${param.expDate}" class="form-control" id="expDate" placeholder="Enter expired date" name="expDate">
            </div>

            <div class="mb-3 mt-3">
                <label for="brand" class="form-label">Brand:</label>
                <select name="brand" class="form-control">
                    <c:forEach var="brand" items="${list}">
                        <option value="${brand.id}" ${param.brand==brand.id?"selected":""}>${brand.name}</option>
                    </c:forEach>
                </select>
            </div>

            <button type="submit" class="btn btn-outline-primary" value="create" name="op"><i class="bi bi-check-lg"></i> Create</button>
            <button type="submit" class="btn btn-outline-danger" value="cancel" name="op"><i class="bi bi-x-lg"></i> Cancel</button>
        </form>
        <i style="color:red;">${message}</i>
    </div>

    <div class="col-sm-6">
        <img src="<c:url value="/images/raiden.png"/>" width="100%" />
    </div>    
</div>

