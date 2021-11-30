<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
<body>
<h2>login</h2>

<form action="${pageContext.request.contextPath}/login" method="post">
    username<input type="text" name="username">
    password<input type="password" name="password">
    <input type="submit" value="submit">
</form>
${msg}
</body>
</html>
