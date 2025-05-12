<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<h1>Create Shoes</h1>
<hr/>
<form action="<c:url value="/shoes/create_handler.do"/>" method="post" enctype="multipart/form-data">
    Id: <br/>
    <input type="text" disabled=""/> <br/>
    Name: <br/>
    <input type="text" name="name" value="${param.name}"/> <br/>
    Brand: <br/>
    <input type="text" name="brand" value="${param.brand}"/> <br/>
    Category: <br/>
    <input type="text" name="category" value="${param.category}"/> <br/>
    Size(ghi them dau phay cho nhieu size khac nhau): <br/>
    <input type="text" name="size" value="${param.size}"/> <br/>
    Price: <br/>
    <input type="number" name="price" min="1" value="${param.price}"/> <br/>
    Discount(%): <br/>
    <input type="number" name="discount" min="1" max="99" value="${param.discount}"/> <br/>
    Picture: <br/>
    <input type="file" name="picture" accept="image/*" /> <br/>
    <br/><br/>
    <button type="submit" name="op" value="create" >create</button>
    <button type="submit" name="op" value="cancel" >Cancel</button>
</form>
<i style="color: red">${message}</i>
