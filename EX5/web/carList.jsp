<%-- 
    Document   : HoaDNT
    Created on : NOVEMBER 1, 2022, 9:09:09 PM
    Author     : hd
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Car List Page</title>
    </head>
    <body>
        <!--your code here-->
         <h1>Car List</h1>
        <hr/>
        Welcome ${user.fullName} | 
        <a href="MainController?action=logout">Logout</a> |

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
        
        <%-- Kiểm tra quyền của người dùng, chỉ ADMIN mới thấy form --%>
<c:if test="${user.roleId eq 'AD'}">
    <h2>Create New Car</h2>
    <form action="MainController">
        Car ID: <br/>
        <input type="text" name="id" value="${param.id}" /> <br/>

        Name: <br/>
        <input type="text" name="name" value="${param.name}" /> <br/>

        Description: <br/>
        <input type="text" name="description" value="${param.description}"/> <br/>

        Price: <br/>
        <input type="number" name="price" value="${param.price}" min="0" /> <br/>

        Speed: <br/>
        <input type="number" name="speed" value="${param.speed}" min="0" /> <br/>

        <br/>
        <input type="hidden" name="action" value="create_handler" />

        <button type="submit" name="op" value="create">Create</button>
    </form>

    <i style="color:red">${message}</i>
</c:if>

        
        

    </body>
</html>
