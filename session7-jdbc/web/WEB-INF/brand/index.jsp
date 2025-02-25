<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" />
<h1>Brand List</h1>
<hr/>
<a href="<c:url value="/brand/create.do"/>">Create New</a><br/>
<table border="1" cellspacing="0" cellpadding="2">
    <tr>
        <th>Id</th>
        <th>Name</th>
        <th>Operation</th>
    </tr>
    <c:forEach var="brand" items="${list}">
        <tr>
            <td>${brand.id}</td>
            <td>${brand.name}</td>
            <td>
                <a href="<c:url value="/brand/edit.do?id=${brand.id}"/>">Edit</a> | 
                <a href="<c:url value="/brand/delete.do?id=${brand.id}"/>">Delete</a>
            </td>
        </tr>
    </c:forEach>
</table>