<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Items Page</title>
    </head>
    <body>
        Welcome ${user.fullName}
        
        <form action="MainController">
            <input type="hidden" name="action" value="logout">
            <button type="submit">Logout</button>
</form>
        
        
            <form action="MainController" method="get">
            <input type="hidden" name="action" value="search">
        Search Item: 
            <input type="text" name="searchValue1" value="${param.searchValue1}" />
            <input type="text" name="searchValue2" value="${param.searchValue2}" />
            <button type="submit">Search</button>
    </form>
    <br>
    
    <c:choose>
        <c:when test="${not empty itemList}">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Price</th>
                    <th>Quantity</th>
                    <th>SubTotal</th>
                    
                </tr>
                <c:forEach var="item" items="${itemList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${item.id}</td>
                        <td>${item.name}</td>
                        <td>${item.price}</td>
                        <td>${item.quantity}</td>
                        <td>${item.price * item.quantity}</td>
                        <td>
                            <a href="MainController?action=remove&id=${item.id}">Remove</a>
                        </td>
                        
                        
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty param.searchValue1 and not empty param.searchValue2}">
                <p>No Item found.</p>
            </c:if>
        </c:otherwise>
    </c:choose>
    </body>
</html>
