<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="row">
    <div class="col-sm-12">
        <div class="float-end">
            <a href="<c:url value="/?page=1"/>" class="btn btn-sm btn-primary ${page == 1 ? 'disabled' : ''}" title="First">
                <i class="bi bi-caret-left-fill"></i>
            </a>
            <a href="<c:url value="/?page=${page - 1}"/>" class="btn btn-sm btn-primary ${page == 1 ? 'disabled' : ''}" title="Previous">
                <i class="bi bi-caret-left"></i>
            </a>
            <a href="<c:url value="/?page=${page + 1}"/>" class="btn btn-sm btn-primary ${page == totalPage ? 'disabled' : ''}" title="Next">
                <i class="bi bi-caret-right"></i>
            </a>
            <a href="<c:url value="/?page=${totalPage}"/>" class="btn btn-sm btn-primary ${page == totalPage ? 'disabled' : ''}" title="Last">
                <i class="bi bi-caret-right-fill"></i>
            </a>
            Page: ${page} / ${totalPage}
        </div>
    </div>
</div>

<div class="row">
    <c:forEach var="paint" items="${list}">
        <div class="col-sm-4 mt-3 mb-3">
            Id: ${paint.id} <br/>
            Color: ${paint.color} <br/>
            Color Name: ${paint.colorName} <br/>
            Hex Code: <span style="color: ${paint.hexadecimal};">${paint.hexadecimal}</span> <br/>
            RGB: (${paint.red}, ${paint.green}, ${paint.blue}) <br/>
            Price: <fmt:formatNumber value="${paint.price}" type="currency" currencySymbol="$"/> <br/>
            Discount: <fmt:formatNumber value="${paint.discount}" type="percent"/> <br/>
            <a href="<c:url value="/cart/add.do?id=${paint.id}"/>" class="btn btn-primary mt-3 mb-3">
                <i class="bi bi-cart-plus"></i> Add to Cart
            </a>
            <img src="<c:url value="/paints/${paint.id}.jpg"/>" width="100%"/>
        </div>
    </c:forEach>
</div>
