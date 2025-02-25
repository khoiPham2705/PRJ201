<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
        <form action="MainController">
            Id: <br/>
            <input type="text" disabled=""> <br/>
            Full Name: <br/>
            <input type="text" name="fullname" value="${param.fullname}"> <br/>
            Date of Birth: <br/>
            <input type="date" name="dob" value="${param.dob}"> <br/>
            Salary: <br/>
            <input type="text" name="salary" value="${param.salary}"> <br/>
            <input type="hidden" name="action" value="create_handler" />
            <button type="submit" name="op" value="create">Create</button>
            <button type="submit" name="op" value="cancel">Cancel</button>
        </form>
        <i style="color: red">${message}</i>
    </body>
</html>
