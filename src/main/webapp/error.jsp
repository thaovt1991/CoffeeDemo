<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Error Error 404 !</title>
</head>
<body>
<h1>Error 404! </h1>
<c:if test="${message != null }">
    <h1>
            ${message}
    </h1>
    <br>
    <a href="${pageContext.request.contextPath}/login?action=home">Quay lai trang chu</a>
</c:if>
<c:if test="${messageLoginError != null }">
    <h1>
            ${messageLoginError}
    </h1>
    <br>
    <a href="${pageContext.request.contextPath}/">Login again !</a>
</c:if>
</body>
</html>
