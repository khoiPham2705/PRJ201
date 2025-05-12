<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<jsp:forward page="/paint/index.do" />

<%--
index.jsp --> FrontController --> ProductController
          --> layouts/main.jsp --> include /paint/index.jsp
--%>