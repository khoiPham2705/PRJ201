<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<h1>Delete Shoes</h1>
<hr/>
<form action="<c:url value="/shoes/delete_handler.do"/>">
    Are you sure to delete this toy with id=${param.id};
    <input type="hidden" name="id" value="${param.id}"/><br/>         
    <button type="submit" value="yes" name="op">Yes</button>
    <button type="submit" value="no" name="op">No</button>
</form>
