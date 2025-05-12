<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="ml" uri="/WEB-INF/tlds/mylib" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Custom Tags</h1>
        <hr/>
        <ml:cd /><br/>
        <ml:ccd color="red" size="24" /><br/>
        <ml:ts color="blue" size="24px">Hello World</ml:ts><br/>
        <ml:mt2 />

    </body>
</html>
