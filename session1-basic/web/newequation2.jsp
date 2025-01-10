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
        <h1>Equation ax<sup>2</sup> + bx + c = 0</h1>


        <hr/>
        
        <form action = "equation2">
            <!-- calculator la url pattern cua servlet se xu ly form -->
            Factor a:<br/>
            <input type="text" name="a"  value = "${param.a}"/> <br/>
            Factor b:<br/>
            <input type="text" name="b"  value = "${param.b}"/> <br/>
            Factor c:<br/>
            <input type="text" name="c"  value = "${param.c}"/> <br/>
            
            <input type="submit" name="op" value ="Giai" /> 
            
            
            <input type="reset" name="reset" /> <br/>
        </form>
       Result: ${result}
       l
      
    </body>
</html>
