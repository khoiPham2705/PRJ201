<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<span style="float: right">
    <a href="<c:url value="/"/>">Home</a> |
    <c:if test="${account == null}">
        <a href="<c:url value="/login.jsp"/>">Login</a>
    </c:if>
        
    <c:if test="${account != null}">
        Welcome ${account.fullName} | 
        <a href="<c:url value="/user/logout.do"/>">Logout</a>
    </c:if>
</span>