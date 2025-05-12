<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<c:if test="${account.role=='ADMIN'}">
    <a href="<c:url value="/shoes/create.do"/>" style="text-decoration: none; color: white;" class="btn">New Shoes</a>  |  
</c:if>

<c:if test="${account.role=='ADMIN'}">
    <a href="<c:url value="/revenue/index.do"/>" style="text-decoration: none; color: white;" class="btn">Get Revenue</a>  |  
</c:if>

<c:if test="${not empty account}" >
    <a href="<c:url value="/order/index.do"/>" style="text-decoration: none; color: white;" class="btn">Order Status</a>
</c:if>
