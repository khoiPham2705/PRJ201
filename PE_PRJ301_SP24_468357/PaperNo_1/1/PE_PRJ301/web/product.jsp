<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>product Page</title>
    </head>
    <body>
        Welcome ${user.fullName}
        <form action="MainController">
            <input type="hidden" name="action" value="logout">
            <button type="submit">Logout</button>
</form>
        
        <form action="MainController" method="get">
            <input type="hidden" name="action" value="search">
        Search Product: 
            <input type="text" name="searchValue" value="${param.searchValue}" />
            <button type="submit">Search</button>
    </form>
    <br>
    
    <c:choose>
        <c:when test="${not empty productList}">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Size</th>
                    
                </tr>
                <c:forEach var="product" items="${productList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${product.id}</td>
                        <td>${product.name}</td>
                        <td>${product.description}</td>
                        <td>${product.price}</td>
                        <td>${product.size}</td>
                        <td>
                            <a href="MainController?action=remove&id=${product.id}">Remove</a>
                        </td>
                        
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty param.searchValue}">
                <p>No product found.</p>
            </c:if>
        </c:otherwise>
    </c:choose>
            
    </body>
</html>
