<%-- 
    Document   : edit
    Created on : Jan 27, 2025, 2:16:07 PM
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
        <h1>Edit brand</h1>
        <form action="brand">
            Id: <br/>
            <input type="text" disabled = "true"  value = "${brand.id}"/> <br/>
            <input type="hidden"  name="id" value = "${brand.id}"/> <br/>
            Name: <br/>
            <input type="text" name="name" value = "${param.name != null?param.id:brand.name}"/> <br/>
            
            <input type="hidden" name="action" value="edit_handler" />
            <button type="submit" name="op" value="update" >Update</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style = "color:red">${message}</i>
    </body>
</html>
