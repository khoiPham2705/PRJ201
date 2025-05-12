<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-sm-12">
        <div class="float-end">
            <a href="<c:url value="/?page=1"/>" class="btn btn-sm btn-primary ${page ==1?"disabled":""}" title="First">
                <i class="bi bi-caret-left-fill"></i>
            </a>
            <a href="<c:url value="/?page=${page-1}"/>" class="btn btn-sm btn-primary ${page ==1?"disabled":""}" title="Previous">
                <i class="bi bi-caret-left"></i>
            </a>
            <a href="<c:url value="/?page=${page+1}"/>" class="btn btn-sm btn-primary ${page ==totalPage?"disabled":""}" title="Next">
                <i class="bi bi-caret-right"></i>
            </a>
            <a href="<c:url value="/?page=${totalPage}"/>" class="btn btn-sm btn-primary ${page ==totalPage?"disabled":""}" title="Last">
                <i class="bi bi-caret-right-fill"></i>
            </a>
            Page: ${page} / ${totalPage}
        </div>
    </div>
</div>

<div class="row">
    <c:forEach var="shoes" items="${list}" >
        <div class="col-sm-4 mt-3 mb-3">
            <img src="<c:url value="/pictures/${shoes.id}.jpg"/>" width="100%"/>
            Id: ${shoes.id} <br/>
            Name: ${shoes.name} <br/>
            Brand: ${shoes.brand} <br/>
            Category: ${shoes.category} <br/>
            Price: <fmt:formatNumber value="${shoes.price}" type="currency" currencySymbol="$"/> <br/>
            Discount: <fmt:formatNumber value="${shoes.discount}" type="percent"/> <br/>
           
            <a href="<c:url value="/cart/add.do?id=${shoes.id}"/>" class="btn btn-primary mt-3 mb-3">
                <i class="bi bi-cart-plus"></i> Add to Cart
            </a>
            
        </div>
    </c:forEach>
</div>