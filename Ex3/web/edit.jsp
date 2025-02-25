<%-- 
    Document   : update
    Created on : Feb 2, 2025, 10:07:12 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update Product</title>
    </head>
    <body>
        <h1>Update Product</h1>
        <hr/>
        <form action="<c:url value = "/product/edit_handler.do"/>">
            Id: <br/>
            <input type="text" disabled = "true"  value = "${product.id}"/> <br/>
            <input type="hidden"  name="id" value = "${product.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value = "${param.name != null?param.id:product.name}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value = "${param.price != null?param.id:product.price}"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate" value = "${param.expDate != null?param.id:product.expDate}"/> <br/>
            

            <button type="submit" name="op" value="update" >Update</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style = "color:red">${message}</i>
    </body>
</html>
