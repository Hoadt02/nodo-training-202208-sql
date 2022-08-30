<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 30-Aug-22
  Time: 02:35 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <tiles:insertDefinition name="template">
        <tiles:putAttribute name="body">
            <h1>Add Group</h1>
            <form:form method="post" action="/nhom/luu" modelAttribute="command">
                <input type="hidden" value="${command.id}" name="id"/>
                <p>
                    <form:input type="text" path="name" name="name" value="${command.name}"/>
                </p>
                <p class="submit">
                    <input type="submit" name="add" value="Add"/>
                </p>
            </form:form>
        </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
