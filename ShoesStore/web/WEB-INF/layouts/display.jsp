<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN"/>

<div class="row">

    <c:forEach var="shoes" items="${list2}">
        <div class="col-sm-4 mt-3 mb-3">

            <a href="<c:url value='/shoes/detail.do?id=${shoes.id}'/>" style="text-decoration: none; color: white">

                <div>
                    <img src="<c:url value='/pictures/${shoes.id}.jpg'/>" width="100%"/>

                    <br/>

                    ${shoes.name} <br/>


                    <!-- Giá gốc (Gạch ngang) -->
                    <span style="text-decoration: line-through; color: gray;">
                        <fmt:formatNumber value="${shoes.price}" type="currency" currencySymbol="₫"/>
                    </span>

                    <!-- Giá sau khi giảm (Màu đỏ) -->
                    <span style="color: red; font-weight: bold;">
                        <fmt:formatNumber value="${shoes.price * (1 - shoes.discount)}" type="currency" currencySymbol="₫"/>
                    </span>

                    <br/>
                    Discount: <fmt:formatNumber value="-${shoes.discount}" type="percent"/> <br/>
                </div>


            </a>
        </div>
    </c:forEach>

</div>

