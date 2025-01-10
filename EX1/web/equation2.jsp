<%-- 
    Document   : bac2
    Created on : Jan 10, 2025, 1:53:08 PM
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
        <h1>Equation ax<sup>2</sup> + bx + c = 0</h1>


        <hr/>
        
        <form action = "equa2Controller">
    
            Factor a:<br/>
            <input type="text" name="a"  value = "${param.a}"/> <br/>
            Factor b:<br/>
            <input type="text" name="b"  value = "${param.b}"/> <br/>
            Factor c:<br/>
            <input type="text" name="c"  value = "${param.c}"/> <br/>
            
            <input type="submit" name="op" value ="Giai" /> 
            
            
            <input type="reset" name="reset" /> <br/>
        </form>
       <p>Equation: ${model.a}x<sup>2</sup> + ${model.b}x + ${model.c} = 0</p>
       Result: ${result}
    </body>
</html>
