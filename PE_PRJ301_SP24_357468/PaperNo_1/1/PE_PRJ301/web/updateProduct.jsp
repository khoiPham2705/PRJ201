<%-- 
    Document   : updateProduct
    Created on : Mar 20, 2025, 11:41:56 PM
    Author     : LAPTOP
--%>

<%@page import="pe.product.ProductDTO"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Hello World!</h1>
        
        <%
        ProductDTO product = (ProductDTO) request.getAttribute("product");
        if(product == null) {
    %>
    <p>Product not found.</p>
    <% } else { %>
    <form action="MainController" method="post">
        <input type="hidden" name="action" value="updateAction" />
        <input type="hidden" name="id" value="<%= product.getId() %>" />
        
        <p>ID: <b><%= product.getId() %></b></p>
        
        <p>
            Name: <input type="text" name="name" value="<%= product.getName() %>" />
        </p>
        <p>
            Description: <input type="text" name="description" value="<%= product.getDescription() %>" />
        </p>
        <p>
            Price: <input type="text" name="price" value="<%= product.getPrice() %>" />
        </p>
        <p>
            Size: <input type="text" name="size" value="<%= product.getSize() %>" />
        </p>
        <button type="submit">Update</button>
    </form>
    <% } %>
    </body>
</html>
