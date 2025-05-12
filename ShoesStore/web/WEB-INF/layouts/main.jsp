<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<fmt:setLocale value="vi_VN" scope="session" />
<!DOCTYPE html>
<html data-bs-theme="dark">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Group 3 Shoes Shop</title>
        <!-- Latest compiled and minified CSS -->
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet">
        <!-- Latest compiled JavaScript -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/js/bootstrap.bundle.min.js"></script> 
        <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.11.3/font/bootstrap-icons.min.css">
        <link href="<c:url value="/css/style.css"/>" rel="stylesheet"/>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.7.1/jquery.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/chart.js@4.4.8/dist/chart.umd.min.js"></script>
    </head>
    <body>
        <div class="container">
            <div class="row">
                <div class="col-md-12 header">
                    <%--header--%>
                    <h1 class="title" style="color: blue">
                        <a href="<c:url value="/" />" style="text-decoration: none">
                            <img src="<c:url value="/pictures/logo.png"/>" width="10%"/>
                        </a>                       
                    </h1>

                    <p class="float-end">
                        <c:choose>
                            <c:when test="${empty sessionScope.account}">
                                <!-- Hien thi nút Login và Register -->
                                <a href="" class="btn" data-bs-toggle="modal" data-bs-target="#registerModal">Register</a> |
                                <a href="" class="btn" data-bs-toggle="modal" data-bs-target="#loginModal">Login</a>
                            </c:when>
                            <c:otherwise>
                                <!-- Hien thi thông tin nguoi dùng và nút Logout -->
                                <span class="btn">Welcome ${account.fullname}</span> |
                                <a href="<c:url value="/account/logout.do" />" class="btn">Logout</a>
                            </c:otherwise>
                        </c:choose>


                        <a href="<c:url value="/cart/index.do" />" class="btn">
                            <c:if test="${cart.total == 0}">
                                <i class="bi bi-cart2"></i>
                            </c:if>
                            <c:if test="${cart.total != 0}">
                                <i class="bi bi-cart-fill"></i>
                            </c:if>
                            <fmt:formatNumber type="currency" value="${cart.total}"/>
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
                    Copyright &COPY; by Group03
                </div>
            </div>
        </div>
    </body>
</html>

<!-- The Modal -->
<div class="modal" id="loginModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="<c:url value="/account/login.do" />" method="POST">
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


<div class="modal" id="registerModal">
    <div class="modal-dialog">
        <div class="modal-content">
            <form action="<c:url value='/account/register.do' />" method="POST">

                <!-- Modal Header -->
                <div class="modal-header">
                    <h4 class="modal-title">Register</h4>
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
                    <div class="mb-3">
                        <label for="fullName" class="form-label">FullName:</label>
                        <input type="text" class="form-control" id="fullName" placeholder="Enter full name" name="fullName">
                    </div>

                </div>

                <!-- Modal footer -->
                <div class="modal-footer">
                    <button type="submit" class="btn btn-primary">Register</button>
                    <button type="button" class="btn btn-danger" data-bs-dismiss="modal">Cancel</button>
                </div>
            </form>
        </div>
    </div>
</div>

<c:if test="${not empty message}">
    <div class="toast-container position-fixed top-0 end-0 p-3">
        <div id="liveToast" class="toast" role="alert" aria-live="assertive" aria-atomic="true" data-bs-delay="3000">
            <div class="toast-header">
                <strong class="me-auto">Notification</strong>
                <small>Just now</small>
                <button type="button" class="btn-close" data-bs-dismiss="toast" aria-label="Close"></button>
            </div>
            <div class="toast-body">
                ${message}
            </div>
        </div>
    </div>
    <script type="text/javascript">
        document.addEventListener('DOMContentLoaded', function () {
            var toastEl = document.getElementById('liveToast');
            var toast = new bootstrap.Toast(toastEl);
            toast.show();
        });
    </script>
</c:if>






