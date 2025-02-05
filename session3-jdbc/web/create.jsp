<%-- 
    Document   : create
    Created on : Jan 16, 2025, 9:57:51 AM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Create Toy</h1>
        <hr/>
        <form action="toy">
            Id: <br/>
            <input type="text" name="id" value = "${param.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value = "${param.name}"/> <br/>
            Price: <br/>
            <input type="text" name="price" value = "${param.price}"/> <br/>
            Expired Date: <br/>
            <input type="date" name="expDate" value = "${param.expDate}"/> <br/>
            Brand: <br/>
            <input type="text" name="brand" value = "${param.brand}"/> <br/>
            <input type="hidden" name="action" value="create_handler" />
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style = "color:red">${message}</i>
    </body>
</html>
