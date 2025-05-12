<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN" />

<table class="table table-stripe">
    <tr>
        <td>Order Id</td>
        <td style="text-align: right">Date</td>
        <c:if test="${account.role=='ADMIN'}">
            <td style="text-align: right">Account ID</td>
        </c:if>
        <td style="text-align: right">Current Status</td>
        <c:if test="${account.role=='ADMIN'}">
            <td style="text-align: right">New Status</td>
            <td style="text-align: right">Operation</td>
        </c:if>

    </tr>
    <c:forEach var="order" items="${list}">

        <c:if test="${order.accountId == account.id || account.role == 'ADMIN'}">
            <tr>

                <td>
                    ${order.id}
                </td>

                <td style="text-align: right">
                    <fmt:formatDate value="${order.date}" pattern="dd-MM-yyyy"/>
                </td>

                <c:if test="${account.role=='ADMIN'}">
                    <td style="text-align: right">
                        ${order.accountId}
                    </td>
                </c:if>

                <td style="text-align: right">
                    ${order.status}
                </td>

                <c:if test="${account.role=='ADMIN'}">
                <form action="<c:url value="/order/update_handler.do"/>" method="get">

                    <input type="hidden" value="${order.id}" name="id">
                    <td style="text-align: right">
                        <select name="status" required>
                            <option value="NEW">New</option>
                            <option value="SHIPPING">Shipping</option>
                            <option value="PAID">Paid</option>
                        </select>

                    </td>
                    <td style="text-align: right">
                        <button type="submit" name="op" value="update">Update</button>
                    </td>

                </form>
            </c:if>
        </tr>
    </c:if>
</c:forEach>

</table>
