<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
<script src="<c:url value='/css/javascript.js'/>"></script>
<fmt:setLocale value="vi_VN"/>

<div class="container">

    <div class="row" >

        <div class="col-sm-4 brand">
            <form action="<c:url value='/shoes/brand.do'/>" method="get">
                <select name="brand" onchange="this.form.submit()" style="width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ddd;">
                    <option value="" disabled selected>Brands</option>
                    <option value="Adidas" <c:if test="${param.brand == 'Adidas'}">selected</c:if>>Adidas</option>
                    <option value="Nike" <c:if test="${param.brand == 'Nike'}">selected</c:if>>Nike</option>
                    <option value="Jordan" <c:if test="${param.brand == 'Jordan'}">selected</c:if>>Jordan</option>
                    <option value="Asics" <c:if test="${param.brand == 'Asics'}">selected</c:if>>Asics</option>
                    <option value="Sandal and Slide" <c:if test="${param.brand == 'Sandal and Slide'}">selected</c:if>>Sandal and Slide</option>
                    </select>
                </form>
            </div>

            <div class="col-sm-4 price">

                <form action="<c:url value='/shoes/price.do'/>" method="get" id="priceForm">
                <div class="form-group">
                    <select id="priceRange" name="type" style="width: 100%; padding: 10px; border-radius: 5px; border: 1px solid #ddd;" required>
                        <option value="" disabled selected>Price Range</option>
                        <option value="preset1">Below 1m</option>
                        <option value="preset2">1m - 1m3</option>
                        <option value="preset3">1m3 - 1m7</option>
                        <option value="preset4">Above 1m7</option>
                        <option value="custom">Custom Range</option>
                    </select>
                </div>

                <div id="customRange" style="display: none;">
                    <div class="form-group">
                        <label for="minPrice">Min Price:</label>
                        <input type="number" id="minPrice" min="0" name="min_price"/>
                    </div>
                    <div class="form-group">
                        <label for="maxPrice">Max Price:</label>
                        <input type="number" id="maxPrice" min="0" name="max_price"/>
                    </div>
                </div>

                <div class="form-group">
                    <label>Order By:</label><br>
                    <input type="radio" id="DESC" name="orderBy" value="DESC" <c:if test="${orderBy==null || orderBy.equals('DESC')}">checked</c:if>>
                        <label for="DESC">DESC <i class="bi bi-arrow-down-right"></i></label><br>
                        <input type="radio" id="ASC" name="orderBy" value="ASC" <c:if test="${orderBy.equals('ASC')}">checked</c:if>>
                        <label for="ASC">ASC <i class="bi bi-arrow-up-right"></i></label>
                    </div>

                    <button type="submit" name="op" value="submit" class="btn btn-sm btn-primary">Go <i class="bi bi-search"></i></button>
                </form>

                <script>
                    document.getElementById('priceRange').addEventListener('change', function () {
                        if (this.value === 'custom') {
                            document.getElementById('customRange').style.display = 'block';
                        } else {
                            document.getElementById('customRange').style.display = 'none';
                        }

                        if (this.value === 'preset1') {
                            document.getElementById('minPrice').value = 0;
                            document.getElementById('maxPrice').value = 1000000;
                        }
                        if (this.value === 'preset2') {
                            document.getElementById('minPrice').value = 1000001;
                            document.getElementById('maxPrice').value = 1300000;
                        }
                        if (this.value === 'preset3') {
                            document.getElementById('minPrice').value = 1300001;
                            document.getElementById('maxPrice').value = 1700000;
                        }
                        if (this.value === 'preset4') {
                            document.getElementById('minPrice').value = 1700001;
                            document.getElementById('maxPrice').value = 10000000;
                        }
                    });

                </script>

            </div>

            <div class="col-sm-4 search">
                <form action="<c:url value="/shoes/search.do" />" method="get">
                <input type="text" name="keyword" placeholder="Search ..." required>
                <button type="submit">Search <i class="bi bi-search"></i></button>
            </form>
        </div>

    </div>

</div>
