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
    <title>发布商品</title>
    <link rel="stylesheet" href="css/bootstrap.min.css" />
    <script type="text/javascript" src="lib/jquery/jquery.js"></script>
</head>
<body>
<div style="padding: 100px 100px 10px;">>
    <form method="post" action="/addNewProduct.html" class="bs-example bs-example-form" role="form" >
        <div class="input-group">
            商品名称：<input type="text" name="productName"><br>
        </div>
        <br>
        <br>

        <div class="input-group" >
            商品价格：
            <input type="number" name="price" >
        </div>
        <br>
        <br>

        <div class="input-group">
            商品描述：
            <input type="text" name="description"><br>
        </div>
        <br>
        <br>
        商品类型：<select name="typeId">
                <option value="1">手机</option>
                <option value="2">零食</option>
                <option value="3">服饰</option>
                <option value="4">运动</option>
                <option value="5">图书</option>
                <option value="6">手表</option>
              </select>
        <br>
        <br>
        <br>
        <div class="input-group">
            图片地址：<input type="url" name="imageUrl">
        </div>
        <br>
        <br>
        <button type="submit" class="btn btn-default">提交</button>
    </form>
</div>
</body>
</html>
