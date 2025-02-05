<%-- 
    Document   : create
    Created on : Jan 26, 2025, 4:53:59 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create Page</title>
    </head>
    <body>
        <h1>Create Brand</h1>
        <form action="brand">
            Id: <br/>
            <input type="text" name="id" value = "${param.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value = "${param.name}"/> <br/>
            
            <input type="hidden" name="action" value="create_handler" />
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style = "color:red">${message}</i>
    </body>
</html>
