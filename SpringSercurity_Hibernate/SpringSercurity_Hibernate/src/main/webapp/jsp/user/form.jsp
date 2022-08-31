<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 31-Aug-22
  Time: 09:28 AM
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
           <h1>Add User</h1>
           <form:form method="post" action="/tai-khoan/luu">
               <p>
                   Name: <form:input type="text" path="username" name="username" />
               </p>
               <p>
                   Password: <form:input path="password" type="password" name="password"/>
               </p>
               <p>
                   Email: <form:input path="email" type="email" name="password"/>
               </p>
               <p>
                   Age: <form:input path="age" type="number" name="password"/>
               </p>
               <p>
                   Group:
                   <form:select path="groupId" name="group" id="group">
                       <form:options items="${groups}"></form:options>
                   </form:select>
               </p>
               <p class="submit">
                   <input type="submit" name="add" value="Add">
               </p>
           </form:form>
       </tiles:putAttribute>
   </tiles:insertDefinition>
</body>
</html>
