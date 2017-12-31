<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2017/10/17 0017
  Time: 下午 8:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录</title>
</head>
<body>

<form action="loginCheck.html"  method="post"/>
    用户名：
    <input type="text" name="userName">
    <br>
    密 码：
    <input type="password" name="password">
    <br>
    <input type="submit" value="登录" />
    <input type="reset" value="重置" />
    ${error}
</form>
</body>
</html>
