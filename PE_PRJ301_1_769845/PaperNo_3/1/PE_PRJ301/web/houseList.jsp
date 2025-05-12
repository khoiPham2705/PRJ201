<%-- 
    Document   : admin
    Created on : Mar 1, 2022, 8:29:12 PM
    Author     : hd
--%>


<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:if test="${empty user}">
    <c:redirect url="login.jsp"/>
</c:if>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>House List</title>
    </head>
    <body>
        Welcome, ${user.name}! |
        <a href="MainController?action=logout">Logout</a>
        <hr/>

        <form action="MainController">
            Search: <input type="text" name="keyword" value="${param.keyword==null?" ":param.keyword}">
            <button type="submit" name="action" value="search">Search</button>


            <table border="1" cellspacing="0" cellpadding="2">
                <tr>
                    <th>no.</th>
                    <th>Id</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>price</th>
                    <th>size</th>
                    <th>status</th>
                    <th>Operation</th>
                </tr>
                <c:forEach var="house" items="${list}" varStatus="loop">
                    <tr>
                        <td>${loop.count}</td>
                        <td>${house.id}</td>
                        <td>${house.name}</td>
                        <td>${house.description}</td>
                        <td>${house.price}</td>
                        <td>${house.size}</td>
                        <td>${house.status}</td>
                        <td>
                            <a href="MainController?action=delete&id=${house.id}&keyword=${param.keyword==null?" ":param.keyword}">Delete</a>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </form>

    </body>
</html>
