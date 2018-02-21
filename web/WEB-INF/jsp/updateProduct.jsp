<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2018/2/21 0021
  Time: 下午 12:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="lib/jquery/jquery.js"></script>

<html>
<head>
    <title>修改商品</title>
</head>
<body>
<table class="table table-striped">
    <caption>所有商品</caption>
    <thead>
    <tr>
        <th>名称</th>
        <th>描述</th>
        <th>价格</th>
        <th></th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${page.list}" var="product">
        <tr>
            <td>${product.productName}</td>
            <td>${product.description}</td>
            <td>￥${product.price}</td>
            <td><button class="add-btn" onclick="update(${product.productId})">修改商品</button></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
</body>
</html>