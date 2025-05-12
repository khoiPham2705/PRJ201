<%-- 
    Document   : login
    Created on : Mar 11, 2022, 9:02:11 PM
    Author     : hd
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        <!--your code here-->
        <form action="MainController">
            UserID: <br/>
            <input type="text" name="userID"> <br/>
            Password: <br/>
            <input type="password" name="password"> <br/>
            <button type="submit" name="action" value="login">Login</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
    
</html>

