<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN" />
<table class="table table-stripe">
    <tr>
        <td>No.</td>
        <td>Image</td>
        <td>Name</td>
        <td style="text-align: right">Size</td>
        <td style="text-align: right">Old Price</td>
        <td style="text-align: right">New Price</td>
        <td style="text-align: right">Quantity</td>
        <td style="text-align: right">Cost</td>
        <td>Operation</td>
    </tr>
    <c:forEach var="item" items="${cart.items}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><img src="<c:url value="/pictures/${item.id}.jpg"/>" height="60px"/></td>
            <td>${item.shoes.name}</td>

            <td style="text-align: right">
                ${item.size}
            </td>

            <td style="text-align: right">
                <fmt:formatNumber value="${item.shoes.price}" type="currency"/>
            </td>

            <td style="text-align: right">
                <fmt:formatNumber value="${item.shoes.newPrice}" type="currency"/>
            </td>

            <td style="text-align: right">
                <input type="number" min="0" name="quantity" value="${item.quantity}" style="width: 60px" />
            </td>

            <td style="text-align: right">                
                <fmt:formatNumber value="${item.cost}" type="currency" />
            </td>

            <td>
                <a href="#" class="update" data-id="${item.id}" data-size="${item.size}">Update</a> |
                <a href="<c:url value='/cart/remove.do?id=${item.id}&shoe_size=${item.size}' />">Remove</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <th style="text-align: right" colspan="7">Total</th>
        <th style="text-align: right">                
            <fmt:formatNumber value="${cart.total}" type="currency" />
        </th>
        <th><a href="<c:url value="/cart/empty.do" />">Empty Cart</a></th>
    </tr>
</table>

<form <c:if test="${not empty sessionScope.account}">action="<c:url value='/cart/checkout.do' />"</c:if> method="POST">
        Address: <input type="text" required="" name="address"/> <br/>
        Phone Number: <input type="text" required="" name="phone" minlength="8" maxlength="11" pattern="[0-9]{8,11}" title="Phone number"/> <br/>

        <button class="btn btn-primary"
        <c:choose>
            <c:when test="${empty sessionScope.account}">
                type="button" data-bs-toggle="modal" data-bs-target="#loginModal"
            </c:when>
            <c:otherwise> 
                type="submit"
            </c:otherwise>
        </c:choose>>
        Checkout
    </button>
</form>

<script>
    $(document).ready(function () {
        $(".update").click(function () {
            var id = $(this).data("id");
            var size = $(this).data("size"); // Get size from data attribute
            var quantity = $(this).closest("tr").find("input[name='quantity']").val();

            if (quantity <= 0) {
                alert("Quantity must be greater than zero.");
                return;
            }

            console.log("Updating cart:", {id, size, quantity}); // Debugging log

            var url = `<c:url value="/cart/update.do?id=\${id}&size=\${size}&quantity=\${quantity}"/>`;
            window.location = url;
        });
    });
</script>
