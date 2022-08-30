<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title>Giới thiệu Spring MVC</title>
</head>
<body>
<tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
        <h1>Login to Application</h1>
        <c:if test="${not empty error}">
            <p>Sai tên đăng nhập hoặc mật khẩu</p>
        </c:if>
        <form method="post" action="/j_spring_security_check">
            <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            <p><input type="text" name="username" placeholder="Username"/></p>
            <p><input type="password" name="password" placeholder="Password"/></p>
            <p><input type="submit" name="commit" value="Login"/></p>
        </form>
    </tiles:putAttribute>
</tiles:insertDefinition>

</body>
</html>