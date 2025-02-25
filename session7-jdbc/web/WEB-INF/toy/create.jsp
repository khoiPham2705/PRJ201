<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Create Toy</h1>
<hr/>
<!--Hardcode a.k.a not good-->
<!--<form action="/Session4-JDBC/toy/create_handler.do">-->

<!--Dynamic but long-->
<!--<form action="${pageContext.request.contextPath}/toy/create_handler.do">-->

<!--Dynamic and short-->
<form action="<c:url value="/toy/create_handler.do"/>">
    Id: <br/>
    <input type="text" name="id" value="${param.id}"/> <br/>
    Name: <br/>
    <input type="text" name="name" value="${param.name}"/> <br/>
    Price: <br/>
    <input type="text" name="price" value="${param.price}"/> <br/>
    Expired Date: <br/>
    <input type="date" name="expDate" value="${param.expDate}"/> <br/>
    Brand: <br/>
    <!--Text box input-->
    <!--<input type="text" name="brand" value="${param.brand}"/>--> 

    <!--Combo box for choosing-->
    <select name="brand" >
        <c:forEach var="brand" items="${list}" >
            <option value="${brand.id}" ${param.brand==brand.id?"selected":""}>${brand.name}</option>
        </c:forEach>
    </select>
    <br/>
    <button type="submit" name="op" value="create" >Create</button>
    <button type="submit" name="op" value="cancel" >Cancel</button>
</form>
<i style="color: red">${message}</i>