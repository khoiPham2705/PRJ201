<%-- 
    Document   : delete
    Created on : Feb 2, 2025, 10:07:19 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Delete Product</title>
    </head>
    <body>
        <h1>Delete Product</h1>
        <hr/>
        <form action ="product">
            Are you sure to delete this product with id = ${param.id}?
            <input type="hidden" name="id" value="${param.id}" />
            <input type="hidden" name="action" value="delete_handler" />
            <button type="submit" name="op" value="yes" >Yes</button>
            <button type="submit" name="op" value="no" >No</button>
            
        </form>
    </body>
</html>
