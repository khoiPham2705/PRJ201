<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<table class="table table-stripe">
    <tr>
        <td>No.</td>
        <td>Image</td>
        <td>Id</td>
        <td>Color</td>
        <td>Color Name</td>
        <td>Hex Code</td>
        <td style="text-align: right">Original Price</td>
        <td style="text-align: right">Discounted Price</td>
        <td style="text-align: right">Quantity</td>
        <td style="text-align: right">Total Cost</td>
        <td>Operation</td>
    </tr>
    <c:forEach var="item" items="${cart.items}" varStatus="loop">
        <tr>
            <td>${loop.count}</td>
            <td><img src="<c:url value="/paints/${item.id}.jpg"/>" height="60px"/></td>
            <td>${item.id}</td>
            <td>${item.paint.color}</td>
            <td>${item.paint.colorName}</td>
            <td style="background-color: ${item.paint.hexadecimal};">${item.paint.hexadecimal}</td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.paint.price}" type="currency" currencySymbol="$"/>
            </td>
            <td style="text-align: right">
                <fmt:formatNumber value="${item.paint.price * (1 - item.paint.discount)}" type="currency" currencySymbol="$"/>
            </td>
            <td style="text-align: right">
                <input type="number" min="0" name="quantity" value="${item.quantity}" style="width: 40px" />
            </td>
            <td style="text-align: right">                
                <fmt:formatNumber value="${item.cost}" type="currency" currencySymbol="$"/>
            </td>
            <td>
                <a href="#" class="update" data-id="${item.id}">Update</a> |
                <a href="<c:url value="/cart/remove.do?item=${item.id}" />">Remove</a>
            </td>
        </tr>
    </c:forEach>
    <tr>
        <th style="text-align: right" colspan="9">Total</th>
        <th style="text-align: right">                
            <fmt:formatNumber value="${cart.total}" type="currency" currencySymbol="$"/>
        </th>
        <th><a href="<c:url value="/cart/empty.do" />">Empty Cart</a></th>
    </tr>
</table>
<script>
    $(".update").click(function() {
        var id = $(this).data("id");
        var quantity = $(this).closest("tr").find("input[name='quantity']").val();
        var url = `<c:url value="/cart/update.do?id=\${id}&quantity=\${quantity}" />`
        window.location = url;
    });
</script>
