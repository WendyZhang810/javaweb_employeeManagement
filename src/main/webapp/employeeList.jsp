<%--
  Created by IntelliJ IDEA.
  User: naiqianzhang
  Date: 30/11/2021
  Time: 13:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

<h4>Welcome back, ${cookie.username.value}!</h4>

<table>
    <tr>
        <th>id</th>
        <th>name</th>
        <th>department</th>
        <th>salary</th>
        <th>operate</th>
    </tr>
    <c:forEach items="${employeeList}" var="employee">
        <tr>
            <td>${employee.id}</td>
            <td>${employee.name}</td>
            <td>${employee.department}</td>
            <td>${employee.salary}</td>
            <td>
                <a href="${pageContext.request.contextPath}/del?id=${employee.id}">delete</a>
                <a href="${pageContext.request.contextPath}/findById?id=${employee.id}">alter</a>
            </td>
        </tr>
    </c:forEach>
</table>
<h4>add new worker</h4>
<form action="/add" method="post">
    name <input type="text" name="name">
    department <input type="text" name="department">
    salary <input type="text" name="salary">
    <input type="submit" value="submit">
</form>

</body>
</html>
