<%-- 
    Document   : delete
    Created on : Jan 27, 2025, 1:38:48 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Delete Brand</h1>
         <form action ="brand">
            Are you sure to delete this brand with id = ${param.id}?
            <input type="hidden" name="id" value="${param.id}" />
            <input type="hidden" name="action" value="delete_handler" />
            <button type="submit" name="op" value="yes" >Yes</button>
            <button type="submit" name="op" value="no" >No</button>
            
        </form>
    </body>
</html>
