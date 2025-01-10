<%-- 
    Document   : bac1
    Created on : Jan 10, 2025, 1:52:53 PM
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
        <h1>Equation  ax + b = 0</h1>


        <hr/>
        
        <form action = "equa1Controller">
       
            Factor a:<br/>
            <input type="text" name="a"  value = "${param.a}"/> <br/>
            Factor b:<br/>
            <input type="text" name="b"  value = "${param.b}"/> <br/>
            
            
            <input type="submit" name="op" value ="Giai" /> 
            
            
            <input type="reset" name="reset" /> <br/>
        </form>
       <p>Equation: ${model.a}x + ${model.b} = 0</p>

       Result: ${result}
    </body>
</html>
