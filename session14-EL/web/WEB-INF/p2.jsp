<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Arrays"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Using Collections</h1>
        <hr/>
        <h3>Using Arrays</h3>
        <% 
            String names[] = {"Nam", "Hai"};
            pageContext.setAttribute("names", names);
        %>
        ${names[0]}<br/>
        ${names[1]}<br/>
        
        <h3>Using List</h3>
        <% 
            List<String> list = Arrays.asList("Nam", "Hai");
            pageContext.setAttribute("list", list);
        %>
        ${list[0]}<br/>
        ${list[1]}<br/>
        
        <h3>Using Maps</h3>
        <% 
            Map<String, Double> map = new HashMap<>();
            map.put("Nam", 9.5);
            map.put("Hai", 8.5);
            session.setAttribute("map", map);
        %>
        Nam: ${map["Nam"]}<br/>
        Hai: ${map["Hai"]}<br/>
    </body>
</html>