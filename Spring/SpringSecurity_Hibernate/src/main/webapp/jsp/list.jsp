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
                <c:forEach items="${groups}" var="item" varStatus="loop">
                    <tr>
                        <td>${item.name}</td>
                        <td><a href="/nhom/xoa/${item.id}">Delete</a></td>
                        <td><a href="/nhom/sua?id=${item.id}">Update</a></td>
                    </tr>
                </c:forEach>
            </table>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
