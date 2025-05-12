<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<fmt:setLocale value="vi_VN" />
<body style="font-family: Arial, sans-serif;
      color: #f5f5f5;">
    <div class="container" style="width: 60%;
         margin: auto;
         padding: 20px;
         background-color: #1e1e1e;
         border-radius: 10px;
         box-shadow: 0 0 10px rgba(255, 255, 255, 0.2);
         text-align: center;">
        <h2>Detail</h2>

        <!-- Hiển thị ảnh -->
        <img src="<c:url value="/pictures/${shoes.id}.jpg"/>" alt="Shoe Image" style="width: 300px;
             height: auto;
             border-radius: 10px;"/>
        
        <c:if test="${account.role == 'ADMIN'}">
            <p><strong>Id:</strong> ${shoes.id}</p>
        </c:if>

        <p><strong>Name:</strong> ${shoes.name}</p>
        <p><strong>Brand:</strong> ${shoes.brand}</p>
        <p><strong>Category:</strong> ${shoes.category}</p>

        <!-- Giá gốc -->
        <p><strong>Original Price:</strong> 
            <span class="price-original" style="text-decoration: line-through;
                  color: gray;">
                <fmt:formatNumber value="${shoes.price}" type="currency" currencySymbol="₫"/>
            </span>
        </p>

        <!-- Giá sau khi giảm -->
        <p><strong>Discounted Price:</strong> 
            <span class="price-discount" style="color: red;
                  font-weight: bold;">
                <fmt:formatNumber value="${shoes.price * (1 - shoes.discount)}" type="currency" currencySymbol="₫"/>
            </span>
        </p>

        <form action="<c:url value='/cart/add.do'/>" method="post">
            <input type="hidden" name="id" value="${shoes.id}"/>

            <h3>Pick a shoe size</h3>
            <select name="shoe_size" required>
                <c:forEach var="size" items="${sizeList}">
                    <option value="${size}">${size}</option>
                </c:forEach>
            </select>

            <br/><br/>

            <button type="submit" class="btn btn-primary">
                <i class="bi bi-cart-plus"></i> Add to Cart
            </button>

        </form>
        <br/>
        <c:if test="${account.role == 'ADMIN'}">
            <!-- Nút chỉnh sửa -->
            <a href="<c:url value='/shoes/edit.do?id=${shoes.id}'/>" 
               style="text-decoration: none; font-weight: bold;">
                <i class="bi bi-pencil"></i> Update
            </a> |
            <!-- Nút xóa -->
            <a href="<c:url value='/shoes/delete.do?id=${shoes.id}'/>" 
               style="color: red; text-decoration: none; font-weight: bold;">
                <i class="bi bi-trash"></i> Delete
            </a>            
        </c:if>
        <!-- Nút quay lại -->
        <p>
            <a href="<c:url value="/shoes/index.do" />" style="color: cyan; text-decoration: none;">
                <div>
                    <i class="bi bi-arrow-left"></i> Return to list
                </div>
            </a>
        </p>
    </div>
</body>