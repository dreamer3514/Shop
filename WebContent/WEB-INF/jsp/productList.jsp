<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2017/10/21 0021
  Time: 下午 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>商品</title>
</head>
<body>
<script>
    function addToCart(pid,uid) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST',"/addToCart.html",true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('pid='+pid+'&'+'uid='+uid);
    }
</script>

<form action="/toProductList.html">
    页数：
    <input type="text" name="page">
    <br>
    <input type="submit" value="go" />
</form>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>price</th>
        <th>typeID</th>
    </tr>
    <c:forEach items="${page.list}" var="product">
        <tr>
            <td>${product.productId}</td>
            <td>${product.productName}</td>
            <td>${product.price}</td>
            <td>${product.typeId}</td>
            <td><button class="add" onclick="addToCart(${product.productId},${user.userId})">加入</button></td>
        </tr>

    </c:forEach>
</table>
</body>
</html>
