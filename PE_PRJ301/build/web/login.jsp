<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    <body>
        <h1>Login</h1>
        <hr/>
        <!--your code here-->
        <form action="MainController">
            Email: <br/>
            <input type="email" name="email" value="${param.email}" /><br/>
            Password: <br/>
            <input type="password" name="password" value="${param.password}" /><br/>
            <input type="hidden" name="action" value="login" />
            <button type="submit" name="op" value="login" >Login</button>
        </form>
            <i style="color: red">${message}</i>
    </body>
</html>
