<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 25-Aug-22
  Time: 04:13 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h2>Please Input Student Information</h2>
    <form:form method="POST" action="/hello/save">
        <form:hidden path="id"/>
      <table>
        <tr>
          <td>Name:</td>
          <td>
              <form:input path="name" type="text" />
              <form:errors path="name" />
          </td>
        </tr>
        <tr>
          <td>Age: </td>
          <td>
              <form:input path="age" type="text" />
              <form:errors path="age"/>
          </td>
        </tr>
        <tr>
          <td colspan="2">
            <input type="submit" value="Submit" />
          </td>
        </tr>
      </table>
    </form:form>
    <c:if test="${id != null}">
        <h1>Please Upload a Image</h1>
        <form method="post" action="/hello/avatar/save/${id}" enctype="multipart/form-data">
            <input type="hidden" name="id" value="${id}"/>
            <input type="file" name="file"/>
            <input type="submit" value="Upload">
        </form>
    </c:if>
</body>
</html>
