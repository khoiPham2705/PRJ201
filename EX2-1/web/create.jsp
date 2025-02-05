<%-- 
    Document   : create
    Created on : Jan 31, 2025, 4:51:28 PM
    Author     : LAPTOP
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Create product</title>
    </head>
    <body>
        <h1>Create</h1>
        
        </hr>
        <form action ="product">
            
            Name: <br/>
            <input type ="text" name="name" value = "${param.name}"/> <br/>
            Price: <br/>
            <input type ="text" name="price" value = "${param.price}"/> <br/>
            ExpDate: <br/>
            <input type ="date" name="expDate" value = "${param.expDate}"/> <br/>
            <input type ="hidden" name ="action" value ="create_handler"/>
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
            
        </form>
            <i style = "color:red">${message}</i>
    </body>
</html>
