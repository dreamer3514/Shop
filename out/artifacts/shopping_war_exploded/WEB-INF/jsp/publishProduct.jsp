<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2018/1/18 0018
  Time: 下午 7:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form method="post" action="/addNewProduct.html">
        商品名称：<input type="text" name="productName"><br>
        商品价格：<input type="text" name="price"><br>
        描述：<input type="text" name="description"><br>
        类型：<select name="typeId">
                <option value="1">手机</option>
                <option value="2">零食</option>
                <option value="3">服饰</option>
                <option value="4">运动</option>
                <option value="5">图书</option>
                <option value="6">手表</option>
              </select>

        图片地址：<input type="url" name="imgUrl">

    </form>
</body>
</html>
