<%-- 
    Document   : main
    Created on : Feb 10, 2025, 10:43:27 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%--header --%>
        <h1 style="color :red ">Layout Demo</h1>
        <hr/>
        <%-- content --%>
        <jsp:include page = "/WEB-INF/${controller}/${action}.jsp"/>
        <%-- footer --%>
        <hr/>
        Copyrights &Copy, by FPT Students
    </body>
</html>
