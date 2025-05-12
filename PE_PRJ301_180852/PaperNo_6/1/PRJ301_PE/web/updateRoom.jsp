<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="sample.room.RoomDTO" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Update Room</title>
</head>
<body>
    <h1>Update Room</h1>
    <%
        RoomDTO room = (RoomDTO) request.getAttribute("room");
        if(room == null) {
    %>
    <p>Room not found.</p>
    <% } else { %>
    <form action="MainController" method="post">
        <input type="hidden" name="action" value="updateAction" />
        <input type="hidden" name="id" value="<%= room.getId() %>" />
        
        <p>ID: <b><%= room.getId() %></b></p>
        
        <p>
            Name: <input type="text" name="name" value="<%= room.getName() %>" />
        </p>
        <p>
            Description: <input type="text" name="description" value="<%= room.getDescription() %>" />
        </p>
        <p>
            Price: <input type="text" name="price" value="<%= room.getPrice() %>" />
        </p>
        <p>
            Area: <input type="text" name="area" value="<%= room.getArea() %>" />
        </p>
        <button type="submit">Update</button>
    </form>
    <% } %>
</body>
</html>
