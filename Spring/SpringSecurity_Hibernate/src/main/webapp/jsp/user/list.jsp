<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 31-Aug-22
  Time: 10:06 AM
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
            <h1>User List</h1>
            <table style="width: 100%" border="1">
                <tr>
                    <td>Name</td>
                    <td>password</td>
                    <td>email</td>
                    <td>age</td>
                    <td>group</td>
                    <td>#</td>
                </tr>
                <c:forEach items="${users}" var="item" varStatus="loop">
                    <tr>
                        <td><a href="/tai-khoan/chi-tiet/${item.username}">${item.username}</a> </td>
                        <td>${item.password}</td>
                        <td>${item.email}</td>
                        <td>${item.age}</td>
                        <td>${item.group}</td>
                    </tr>
                </c:forEach>
            </table>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
