<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 30-Aug-22
  Time: 04:52 PM
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
            <h1>Group List</h1>
            <table style="width: 100%" border="1">
                <tr>
                    <td>Name</td>
                    <td>#</td>
                </tr>
                <tr>
                    <td colspan="2">
                        <form method="get" action="/nhom/danh-sach">
                            <input type="text" name="q">
                        </form>
                    </td>
                </tr>
                <c:forEach items="${groups}" var="item" varStatus="loop">
                    <tr>
                        <td><a href="/tai-khoan/danh-sach?group=${item.id}">${item.name}</a>
                            <ul>
                                <c:forEach items="${item.users}" var="user" varStatus="loop">
                                    <li>${user.username} - ${user.age}</li>
                                </c:forEach>
                            </ul>
                        </td>
                        <td><a href="/nhom/xoa/${item.id}">Delete</a></td>
                        <td><a href="/nhom/sua?id=${item.id}">Update</a></td>
                    </tr>
                </c:forEach>
            </table>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
