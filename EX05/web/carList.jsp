<%-- 
    Document   : HoaDNT
    Created on : NOVEMBER 1, 2022, 9:09:09 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
    </head>
    <body>
        <!--your code here-->
        Welcome ${user.fullName} | 
        <a href="MainController?action=logout">Logout</a> |
        <a href="MainController?action=create">Create</a>

        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Full Name</th>
                <th>Description</th>
                <th>Price</th>
                 <th>Speed</th>
                  <th>Status</th>
            </tr>
            <c:forEach var="car" items="${list}">
                <tr>
                    <td>${car.id}</td>
                    <td>${car.name}</td>
                    <td>${car.description}</td>
                    <td>${car.price}</td>
                    <td>${car.speed}</td>
                    <td>${car.status}</td>
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
