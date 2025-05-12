<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${param.language == 'en'}">
    <fmt:setLocale value="en_US" scope="session"/>
</c:if>

<c:if test="${param.language == 'vi'}">
    <fmt:setLocale value="vi_VN" scope="session"/>
</c:if>
<fmt:setBundle basename="resources.messages" scope="session" />

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div style="float:right;">
            <a href="<c:url value="/?language=en" /> "><fmt:message key="english"/></a> |
            <a href="<c:url value="/?language=vi" /> "><fmt:message key="vietnamese"/></a>
        </div>
        <h1><fmt:message key="home.welcome"/></h1>
        <fmt:message key="home.flag" var="flag" />
        <img src="images/${flag}" /> 
        
        <br/><br/>
        <a href="info.jsp"><fmt:message key="home.info"/></a>
    </body>
</html>