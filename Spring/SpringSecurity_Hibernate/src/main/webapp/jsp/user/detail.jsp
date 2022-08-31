<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 31-Aug-22
  Time: 02:14 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
  <tiles:insertDefinition name="template">
    <tiles:putAttribute name="body">
      <h1>User</h1>
      <p>Tài khoản: ${user.username}</p>
      <p>Mật khẩu: ${user.password}</p>
      <p>Email: ${user.email}</p>
      <p>Tuổi: ${user.age}</p>
      <p>Nhóm: ${user.group}</p>
    </tiles:putAttribute>
  </tiles:insertDefinition>
</body>
</html>
