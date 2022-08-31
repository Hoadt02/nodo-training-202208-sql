<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles" %>
<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 30-Aug-22
  Time: 09:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <tiles:insertDefinition name="template">
       <tiles:putAttribute name="body">
           <h2>${message}</h2>
       </tiles:putAttribute>
    </tiles:insertDefinition>
</body>
</html>
