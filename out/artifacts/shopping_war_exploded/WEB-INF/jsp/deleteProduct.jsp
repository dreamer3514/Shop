<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2018/2/21 0021
  Time: 上午 11:41
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link rel="stylesheet" href="css/bootstrap.min.css" />
<script type="text/javascript" src="lib/jquery/jquery.js"></script>
<script>
    function deleteProduct(pid,node)
    {
        var xhr = new XMLHttpRequest();
        xhr.open('POST',"/deleteProduct.html",true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('pid='+pid);
        node.parentNode.removeChild(node);

    }
</script>

<html>
<head>
    <title>删除商品</title>
</head>
<body>
<table class="table table-striped" id="productList">
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
            <td><button type="button" class="btn btn-danger" onclick="deleteProduct(${product.productId},this.parentNode.parentNode)">删除商品</button></td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<ul class="pagination">
    <li><a href="/toDeleteProduct.html?page=1">1</a></li>
    <li><a href="/toDeleteProduct.html?page=2">2</a></li>
    <li><a href="/toDeleteProduct.html?page=3">3</a></li>
    <li><a href="/toDeleteProduct.html?page=4">4</a></li>
    <li><a href="/toDeleteProduct.html?page=5">5</a></li>
</ul>
</body>
</html>
