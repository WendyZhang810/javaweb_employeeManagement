<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>alter</h2>

<form action="/alter" method="post">
<input type="hidden" value="${employee.id}" name="id">
name<input type="text" value="${employee.name}" name="name">
department<input type="text" value="${employee.department}" name="department">
salary<input type="text" value="${employee.salary}" name="salary">
<input type="submit" value="submit">
</form>
</body>
</html>
