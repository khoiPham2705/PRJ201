<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<h1>Create Toy</h1>
<hr/>
<!--Hardcode a.k.a not good-->
<!--<form action="/Session4-JDBC/toy/create_handler.do">-->

<!--Dynamic but long-->
<!--<form action="${pageContext.request.contextPath}/toy/create_handler.do">-->

<!--Dynamic and short-->
<form action="<c:url value="/toy/create_handler.do"/>">
    <div class ="row">
        <div class ="col-sm-6 ">
            <div class="mb-3 mt-3">
                <label for="id" class="form-label">Id:</label>
                <input type="id" value="${param.id}" class="form-control" id="id" placeholder="Enter id" name="id">
            </div>

            <div class="mb-3 mt-3">
                <label for="name" class="form-label">Name:</label>
                <input type="name" value="${param.name}" class="form-control" id="name" placeholder="Enter name" name="name">
            </div>
            <div class="mb-3 mt-3">
                <label for="price" class="form-label">Price:</label>
                <input type="price" value="${param.price}"  class="form-control" id="price" placeholder="Enter price" name="price">
            </div>

            <div class="mb-3 mt-3">
                <label for="brand" class="form-label">Brand:</label>
                <select name="brand" class = "form-control">
                    <c:forEach var="brand" items="${list}" >
                        <option value="${brand.id}" ${param.brand==brand.id?"selected":""}>${brand.name}</option>
                    </c:forEach>
                </select>
            </div>


            <br/>
            <button type="submit" class = "btn btn-outline-primary" name="op" value="create" ><i class="bi bi-check"></i> Create</button>
            <button type="submit" class = "btn btn-outline-danger" name="op" value="cancel" ><i class="bi bi-x"></i> Cancel</button>
        </div>
        <div class ="col-sm-6 ">
         
   
            <img src ="<c:url value = "/images/cas.jpg " />" width="100%" style="display:inline-block; ; border:5px solid #000; padding:10px; border-radius:15px; box-shadow:2px 2px 10px rgba(0,0,0,0.3); object-fit:cover;"/>


        </div>
    </div>

</form>
<i style="color: red">${message}</i>