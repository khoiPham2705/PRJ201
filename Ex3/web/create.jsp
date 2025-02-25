<%-- 
    Document   : create
    Created on : Jan 31, 2025, 4:51:28 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create product</title>
    </head>
    <body>
        <h1>Create</h1>
        
        </hr>
        <form action ="<c:url value = "/product/create_handler.do"/>">
            
            Name: <br/>
            <input type ="text" name="name" value = "${param.name}"/> <br/>
            Price: <br/>
            <input type ="text" name="price" value = "${param.price}"/> <br/>
            ExpDate: <br/>
            <input type ="date" name="expDate" value = "${param.expDate}"/> <br/>
          
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
            
        </form>
            <i style = "color:red">${message}</i>
    </body>
</html>
