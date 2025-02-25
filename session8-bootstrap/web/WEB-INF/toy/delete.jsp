<%-- 
    Document   : delete
    Created on : Jan 16, 2025, 11:35:39 AM
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
        <h1>Delete Toy</h1>
        <hr/>
        <form action="<c:url value = "/toy/delete_handler.do"/>">
            Are you sure to delete this toy with id = ${param.id}?
            <input type="hidden" name="id" value="${param.id}" />
       
            <button type="submit" name="op" value="yes" >Yes</button>
            <button type="submit" name="op" value="no" >No</button>
            
        </form>
    </body>
</html>
