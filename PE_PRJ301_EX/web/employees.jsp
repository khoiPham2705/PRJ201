<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Employee List</title>
    </head>
    <body>
        <h1>Employee List</h1>
        <hr/>
        <!--your code here-->
        Welcome ${account.fullName} | 
        <a href="MainController?action=logout">Logout</a> |
        <a href="MainController?action=create">Create</a>

        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Full Name</th>
                <th>Date of Birth</th>
                <th>Salary</th>
            </tr>
            <c:forEach var="em" items="${list}">
                <tr>
                    <td>${em.id}</td>
                    <td>${em.fullName}</td>
                    <td><fmt:formatDate value="${em.dob}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>${em.salary}</td>
                </tr>
            </c:forEach>
        </table>
        
    </body>
</html>
