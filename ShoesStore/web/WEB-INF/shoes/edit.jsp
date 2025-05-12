<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Edit Shoes</h1>
<hr/>
<form action="<c:url value="/shoes/edit_handler.do"/>">
    Id: <br/>
    <input type="text" value="${shoes.id}" disabled=""/> <br/>
    <input type="hidden" name="id" value="${shoes.id}"/> 
    Name: <br/>
    <input type="text" name="name" value="${shoes.name}"/> <br/>
    Brand: <br/>
    <input type="text" name="brand" value="${shoes.brand}"/> <br/>
    Category: <br/>
    <input type="text" name="category" value="${shoes.category}"/> <br/>
    Size(ghi them dau phay cho nhieu size khac nhau): <br/>
    <input type="text" name="size" value="${shoes.size}"/> <br/>
    Price: <br/>
    <input type="number" name="price" min="1" value="${shoes.price}"/> <br/>
    Discount(%): <br/>
    <input type="number" name="discount" min="1" max="99" value="${shoes.discount * 100}"/>
    <br/><br/>
    <button type="submit" name="op" value="update" >Update</button>
    <button type="submit" name="op" value="cancel" >Cancel</button>
</form>
<i style="color: red">${message}</i>

