<%--
  Created by IntelliJ IDEA.
  User: DO TAT HOA
  Date: 26-Aug-22
  Time: 10:59 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <h1>List of Students</h1>
    <form method="GET" action="/hello/list">
    <table border="1">
        <tr>
            <td colspan="4"><input type="text" name="q" size="30"/></td>
            <td><input type="submit" value="Submit"/></td>
        </tr>
        <tr>
            <td>Id</td>
            <td>Name</td>
            <td>Age</td>
            <td></td>
            <td></td>
            <td></td>
        </tr>
        <c:forEach items="${students}" var="student">
            <tr>
                <td>${student.id}</td>
                <td>${student.name}</td>
                <td>${student.age}</td>
                <td>
                    <a href="delete/${student.id}">delete</a>
                </td>
                <td>
                    <a href="edit/${student.id}">edit</a>
                </td>
                <td>
                    <a href="javascript:view(${student.id})">Log Json</a>
                </td>
            </tr>
        </c:forEach>
    </table>
    </form>
    <dialog id="viewStudent" style="width: 50%;border:1px dotted black;">
        <div id = "content"></div>
        <button id="hide">Close</button>
    </dialog>
<script>
    function view(id){
        const xmlHttp = new XMLHttpRequest();
        xmlHttp.open("GET", "json/" + id, true);
        xmlHttp.onload = function (){
            if (this.status != 200) return;
            console.log(this.responseText);
            var student = JSON.parse(this.responseText);
            document.getElementById('content').innerHTML = 'Name: ' + student.name + '<img src="/hello/avatar/' + student.id + '" width="200px"/>';
            var dialog = document.getElementById('viewStudent');

            dialog.show();
        };
        xmlHttp.send();
    };

    const dialog = document.getElementById('viewStudent');
    document.getElementById('hide').onclick = function (){
        dialog.close();
    }
</script>
</body>
</html>
