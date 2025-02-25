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
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">

        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script>
    </head>
    <body>
        <div class = "container">
            <div class = "row">
                <div class = "col-em-12">
                    <%--header --%>
                    <h1 style="color :red ">Layout Demo</h1>
                    <hr/>
                </div>

            </div>

            <div class = "row">
                <div class = "col-em-12">
                    <%-- content --%>
                    <jsp:include page = "/WEB-INF/${controller}/${action}.jsp"/>
                </div>

            </div>

            <div class = "row">
                <div class = "col-em-12">
                    <hr/>
                    Copyrights &Copy, by FPT Students
                </div>

            </div>

        </div>


        <%-- footer --%>

    </body>
</html>
