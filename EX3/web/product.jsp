<%-- 
    Document   : product
    Created on : Jan 31, 2025, 4:42:17 PM
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
        <title>Product Crud</title>
    </head>
    <body>
        <h1>Product Crud</h1>
        <a href ="<c:url value = "/product/create.do"/>">Create New</a> <br/>
       
        <hr/>
        <table border="1" cellspacing = "0" cellpadding = "4">
            
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th style="text-align: right">Price</th>
                <th>Expired Date</th>
               
            </tr>
            
            <c:forEach var="product" items="${list}">
                <tr>
                    <td>${product.id}</td>
                    <td>${product.name}</td>
                    <td style="text-align: right">
                        <fmt:formatNumber value="${product.price}" type="currency" currencySymbol="$"/>
                    </td>
                    <td>
                        <fmt:formatDate value="${product.expDate}" pattern="dd-MM-yyyy"/>
                    </td>
                 
                    <td>
               
                        <a  href="<c:url value = "/product/edit.do?id=${product.id}" />">Edit</a>
                        <a  href="<c:url value = "/product/delete.do?id=${product.id}" />">Delete</a>
                    </td>

                </tr>
            </c:forEach>
        </table>
    </body>
</html>
