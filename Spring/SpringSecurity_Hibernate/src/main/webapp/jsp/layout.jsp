<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 30-Aug-22
  Time: 09:37 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>Welcome to Spring Jazz</h1>
    <p><a href="/">Trang chủ</a></p>
    <sec:authorize access="!hasAnyRole('ROLE_USER')">
        <a href="/dang-nhap" style="margin-left: 30px">Đăng nhập</a>
    </sec:authorize>
    <sec:authorize access="hasAnyRole('ROLE_USER')">
        <a href="/nguoi-dung" style="margin-left: 30px">Người dùng</a>
        <a href="javascript:document.getElementById('logout').submit();" style="margin-left: 30px">Đăng xuất</a>
    </sec:authorize>
    <form action="/j_spring_security_logout" id="logout" method="post">
        <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
    </form>
    <tiles:insertAttribute name="body"/>
</body>
</html>
