<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2017/10/19 0019
  Time: 下午 7:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册</title>
</head>
<body>
    <form action="doRegister.html"  method="post"/>
        用户名：
        <input type="text" name="userName">
        <br>
        密 码：
        <input type="password" name="password">
        <br>
        性别：
        <input type="radio" value="1" name="sex">男 <input type="radio" value="2" name="sex">女
        <br>
        邮箱：
        <input type="email" name="emailAddress">

        <input type="submit" value="注册" />
        <input type="reset" value="重置" />
        ${error}
    </form>
</body>
</html>
