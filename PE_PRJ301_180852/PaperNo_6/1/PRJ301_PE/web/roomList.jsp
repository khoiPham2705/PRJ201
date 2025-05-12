<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Room List</title>
</head>
<body>
    <h1>Room List</h1>
    
    <form action="MainController">
        <input type="hidden" name="action" value="logout">
        <button type="submit">Logout</button>
</form>
    
    <!-- Form tìm kiếm phòng -->
    <form action="MainController" method="get">
        <input type="hidden" name="action" value="search">
        Search Room: 
        <input type="text" name="searchValue" value="${param.searchValue}" />
        <button type="submit">Search</button>
    </form>
    <br>
    
    <!-- Hiển thị kết quả tìm kiếm nếu có -->
    <c:choose>
        <c:when test="${not empty roomList}">
            <table border="1" cellpadding="5" cellspacing="0">
                <tr>
                    <th>No</th>
                    <th>ID</th>
                    <th>Name</th>
                    <th>Description</th>
                    <th>Price</th>
                    <th>Area</th>
                    <th>Action</th>
                </tr>
                <c:forEach var="room" items="${roomList}" varStatus="status">
                    <tr>
                        <td>${status.index + 1}</td>
                        <td>${room.id}</td>
                        <td>${room.name}</td>
                        <td>${room.description}</td>
                        <td>${room.price}</td>
                        <td>${room.area}</td>
                        <td>
                            <!-- Nút Update: chuyển sang trang updateRoom.jsp -->
                            <form action="MainController" method="get" style="margin:0">
                                <input type="hidden" name="action" value="updateForm">
                                <input type="hidden" name="id" value="${room.id}">
                                <button type="submit">Update</button>
                            </form>
                        </td>
                    </tr>
                </c:forEach>
            </table>
        </c:when>
        <c:otherwise>
            <c:if test="${not empty param.searchValue}">
                <p>No room found.</p>
            </c:if>
        </c:otherwise>
    </c:choose>
    
</body>
</html>
