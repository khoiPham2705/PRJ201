<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login Page</title>
    </head>
    <body>
        Login information:
        <!--your code here-->
  
        <form action="MainController">
            User ID: <br/>
            <input type ="text" name ="userId" value ="${param.userId}"/><br/>
            Password: <br/>
            <input type ="password" name ="password" value ="${param.password}" /> <br/>
            <input type ="hidden" name ="action" value ="login"/> 
           <button type="submit" name="op" value="login" >Login</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
    
</html>

