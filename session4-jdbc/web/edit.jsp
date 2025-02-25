<%-- 
    Document   : create
    Created on : Jan 16, 2025, 9:57:51 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Toy</h1>
        <hr/>
        <form action="<c:url value = "/toy/edit_handler.do"/>">
            Id: <br/>
            <input type="text" disabled = "true"  value = "${toy.id}"/> <br/>
            <input type="hidden"  name="id" value = "${toy.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value = "${param.name != null?param.id:toy.name}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value = "${param.price != null?param.id:toy.price}"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate" value = "${param.expDate != null?param.id:toy.expDate}"/> <br/>
            Brand: <br/>
<!--            <input type="text" name="brand" value = "${param.brand != null?param.id:toy.brand}"/> -->
            <select name="brand" >
                <c:forEach var="brand" items="${list}" >
                    <option value="${brand.id}" ${param.brand==brand.id?"selected":""}>${brand.name}</option>
                </c:forEach>
            </select>
            <br/>
     
            <button type="submit" name="op" value="update" >Update</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style = "color:red">${message}</i>
    </body>
</html>
