<%--
  Created by IntelliJ IDEA.
  User: hangnt169
  Date: 19/11/24
  Time: 14:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title></title>
</head>
<body>
<h1>${erro}</h1>
<form action="/login" method="post">
    UserName: <input type="text" name="u1">
    <br>
    Password: <input type="password" name="p1">
    <br>
    <button type="submit">Login</button>
</form>

</body>
</html>
