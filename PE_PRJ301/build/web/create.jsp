<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Creating Employee</title>
    </head>
    <body>
        <h1>Creating Employee</h1>
        <hr/>
        <!--your code here-->
        <hr/>

            <form action="MainController">
                
           

            FullName: <br/>
            <input type="text" name="fullName" value = "${param.fullName}"/> <br/>
            
            Dob: <br/>
            <input type="date" name="dob" value = "${param.dob}"/> <br/>
            
            Salary: <br/>
            <input type="text" name="salary" value = "${param.salary}"/> <br/>
            
            <br/>
            
            <input type="hidden" name="action" value="create_handler" />
            
            <button type="submit" name="op" value="create" >Create</button>
            <button type="submit" name="op" value="cancel" >Cancel</button>
        </form>
        <i style = "color:red">${message}</i>
        
    </body>
</html>
