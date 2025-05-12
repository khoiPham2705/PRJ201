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

        <form action ="MainController" method ="get">
            <input type="hidden" name="action" value="search">
            Employee Name:
            <input type="text" name="searchValue" value="${param.searchValue}" />
            <button type="submit">Search</button>
        </form>
        <br/>
        <c:choose>
            <c:when test="${not empty employeeList}">
                <table border="1" cellpadding="5" cellspacing="0">
                    <tr>
                        <th>No</th>
                        <th>ID</th>
                        <th>full Name</th>
                        <th>Date Of Birth</th>
                        <th>Salary</th>

                    </tr>
                    <c:forEach var="employee1" items="${employeeList}" varStatus="status">
                        <tr>
                            <td>${status.index + 1}</td>
                            <td>${employee1.id}</td>
                            <td>${employee1.fullName}</td>
                            <td>${employee1.dob}</td>
                            <td>${employee1.salary}</td>
                        </tr>
                    </c:forEach>
                </table>
            </c:when>
            <c:otherwise>
                <c:if test="${not empty param.searchValue}">
                    <p>No user found.</p>
                </c:if>
            </c:otherwise>
        </c:choose>


        <br>

        <table border="1" cellspacing="0" cellpadding="2">
            <tr>
                <th>Id</th>
                <th>Full Name</th>
                <th>Date of Birth</th>
                <th>Salary</th>
                    <c:if test="${account.roleId eq 'AM'}">   
                    <th>Operation</th>
                    </c:if> 
            </tr>
            <c:forEach var="em" items="${list}">
                <tr>
                    <td>${em.id}</td>
                    <td>${em.fullName}</td>
                    <td><fmt:formatDate value="${em.dob}" pattern="yyyy-MM-dd"/>
                    </td>
                    <td>${em.salary}</td>
                    <c:if test="${account.roleId eq 'AM'}">   
                        <td>
                            <a href="MainController?action=remove&id=${em.id}">Remove</a>
                        </td>
                        </c:if> 
                </tr>
            </c:forEach>
        </table>

    </body>
</html>
