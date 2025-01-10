<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>
        <title>TODO supply a title</title>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
    </head>
    <body>
        <h1>Calculation</h1>
        <hr/>
        
        <form action = "Cal2">
            <!-- calculator la url pattern cua servlet se xu ly form -->
            Number 1:<br/>
            <input type="text" name="num1"  value = "${param.num1}"/> <br/>
            Number 2:<br/>
            <input type="text" name="num2"  value = "${param.num2}"/> <br/>
            <input type="submit" name="op" value ="Add" /> 
            <input type="submit" name="op" value ="Sub" /> 
            <input type="submit" name="op" value ="Mul" /> 
            <input type="submit" name="op" value ="Div" /> 
            
            <input type="reset" name="reset" /> <br/>
        </form>
       Result: ${result}
    </body>
</html>
