<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<html>
<head>
    <title>Spring Boot Application</title>
</head>
<body>
    <table border="1" align="center" cellpadding="2" cellspacing="2">
        <tr>
            <td>Welcome to Java Spring Clazz</td>>
        </tr>
        <tr>
            <td>
                <a href="/">Trang chủ</a>
                <sec:authorize access="!hasAnyRole('ROLE_USER')">
                <a href="/dang-nhap" style="margin-left: 30px">Đăng nhập</a>
                </sec:authorize>
                <sec:authorize access="hasAnyRole('ROLE_USER')">
                    <a href="/nguoi-dung" style="margin-left: 30px">Cá nhân</a>
                    <a href="/logout" style="margin-left: 30px">Logout</a>
                </sec:authorize>
            </td>
        </tr>
        <tr>
            <td>
                <h2>Hello Java Clazz</h2>
            </td>
        </tr>
    </table>
</body>
</html>