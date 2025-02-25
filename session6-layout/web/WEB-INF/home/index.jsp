<%-- 
    Document   : index
    Created on : Feb 10, 2025, 11:02:55 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>

<h1>Front Controller demo</h1>
        <hr/>
        <h3> User </h3>
        <a href = "<c:url value = "/user/register.do"/>"> Register </a> <br/>
        <a href = "<c:url value = "/user/login.do"/>"> Log in </a> <br/>
        <a href = "<c:url value = "/user/logout.do"/>"> Log out </a> <br/>
        <hr/>
        
        <h3> Product </h3>
        <a href = "<c:url value = "/product/create.do"/>"> Create </a> <br/>
        <a href = "<c:url value = "/product/edit.do"/>"> Edit </a> <br/>
        <a href = "<c:url value = "/product/delete.do"/>"> Delete </a> <br/>
