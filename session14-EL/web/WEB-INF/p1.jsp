<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<jsp:useBean id="user" class="beans.User" scope="request" />
<jsp:setProperty name="user" property="email" value="john@gmail.com" />
<jsp:setProperty name="user" property="fullName" value="John Smith" />
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Use Beans</h1>
        <hr/>
        Email: <jsp:getProperty name="user" property="email" /><br/>
        Full Name: <jsp:getProperty name="user" property="fullName" /><br/>
        <hr/>
        Email: ${user.email}<br/>
        Full Name: ${user.fullName}<br/>
        <hr/>
<!--        Not recommended-->
        Email: ${user["email"]}<br/>
        Full Name: ${user["fullName"]}<br/>
    </body>
</html>