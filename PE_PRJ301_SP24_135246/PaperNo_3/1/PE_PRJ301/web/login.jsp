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
         <h1>Login information</h1>
        <form action="MainController">
            Username: <br/>
            <input type ="text" name ="username" value ="${param.username}"/><br/>
            Password: <br/>
            <input type ="password" name ="password" value ="${param.password}" /> <br/>
            <input type ="hidden" name ="action" value ="login"/> 
           <button type="submit" name="op" value="login" >Login</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
    
</html>

