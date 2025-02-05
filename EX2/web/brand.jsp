<%-- 
    Document   : brand
    Created on : Jan 26, 2025, 1:04:26 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value = "en_US" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Brand CRUD</title>
    </head>
    <body>
        <h1>Brand CRUD</h1>
        <table border="1" cellspacing = "0" cellpadding = "4">
             <a href ="brand?action=create">Create New</a> <br/>
            <tr>
                <th>Id</th>
                <th>Name</th>
                
            </tr>
            
            <c:forEach var="brand" items="${list}">
                <tr>
                    <td>${brand.id}</td>
                    <td>${brand.name}</td>
                    
                    
                    <td>
               
                        <a href="brand?action=edit&id=${brand.id}">Edit</a>
                        <a href="brand?action=delete&id=${brand.id}">Delete</a>
                    </td>

                </tr>
            </c:forEach>
    </body>
</html>
