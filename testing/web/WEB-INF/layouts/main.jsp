<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="en-US" scope="session" />
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pet Store</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="<c:url value="/css/stylesheet.css"/>" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 header">
                    <%--header--%>
                    <h1 class="title" style="color: blue">
                        <a href="<c:url value="/" />" style="text-decoration: none">Pet Store</a>
                    </h1>

                    <p class="float-end">
                        <c:if test="${account==null}">
                            <a href="" class="btn" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a>
                        </c:if>
                        <c:if test="${account!=null}">
                            <span class="btn">Welcome ${account.fullName}</span> |
                            <a href="<c:url value="/account/logout.do" />" class="btn">Logout</a>
                        </c:if>

                        <a href="<c:url value="/cart/index.do" />" class="btn">
                            <c:if test="${cart.total == 0}">
                                <i class="bi bi-cart2"></i>
                            </c:if>
                            <c:if test="${cart.total != 0}">
                                <i class="bi bi-cart-fill"></i>
                            </c:if>
                            <fmt:formatNumber type="currency" value="${cart.total}" currencySymbol="$"/>
                        </a>
                    </p>
                </div>
            </div>

            <div class="row">
                <div class="col-md-12">
                    <%--content--%>
                    <jsp:include page="/WEB-INF/${controller}/${action}.jsp" />
                </div>
            </div>

            <div class="row">
                <div class="col-md-12 footer">
                    <%--footer--%>
                    Copyright &COPY; by FPT students
                </div>
            </div>
        </div>
    </body>
</html>

<!-- The Modal -->
<div class="modal" id="loginModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="<c:url value="/account/login.do" />">
                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Login</h4>
                    <button type="button" class="btn-close" data-bs-dismiss="modal"></button>
                </div>

                <!-- Modal body -->
                <div class="modal-body">
                    <div class="mb-3 mt-3">
                        <label for="email" class="form-label">Email:</label>
                        <input type="email" class="form-control" id="email" placeholder="Enter email" name="email">
                    </div>
                    <div class="mb-3">
                        <label for="password" class="form-label">Password:</label>
                        <input type="password" class="form-control" id="password" placeholder="Enter password" name="password">
                    </div>
                    <div class="form-check mb-3">
                        <label class="form-check-label">
                            <input class="form-check-input" type="checkbox" name="remember"> Remember me
                        </label>
                    </div>
                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary" data-bs-dismiss="modal">Login</button>
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>