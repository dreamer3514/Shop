<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2017/10/23 0023
  Time: 下午 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<link rel="stylesheet" href="css/page.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />

<html>
<head>
    <title>购物车</title>
</head>
<script>
    function delTFromCart(pid,uid,node) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST',"/delFromCart.html",true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('pid='+pid+'&'+'uid='+uid);
        node.parentNode.removeChild(node);
    }
</script>

<body>

    <h2>${user.userName}的购物车</h2>
    <br>

    <table>
        <tbody><tr>
            <th></th>
            <th>商品名称</th>
            <th>描述</th>
            <th>价格</th>
            <th>数量</th>
            <th>总价</th>
            <th></th>
        </tr>
        <c:forEach items="${list}" var="cartItem">
            <tr>
                <td><img src="${cartItem.product.imageUrl}" alt="13"></td>
                <td>${cartItem.product.productName}</td>
                <td>${cartItem.product.description}</td>
                <td><strong>￥${cartItem.product.price}</strong></td>
                <td>数量：${cartItem.count}</td>
                <td><strong>￥${cartItem.total}</strong></td>
                <td><button class="del-btn" onclick="delTFromCart(${cartItem.productId},${user.userId},this.parentNode.parentNode)">删除</button></td>
            </tr>
        </c:forEach>
        </tbody></table>
</body>
</html>
<style>
    .del-btn {
        width: 100px;
        background: #000 none repeat scroll 0 0;
        text-decoration: none;
        color: #fff;
    }
</style>