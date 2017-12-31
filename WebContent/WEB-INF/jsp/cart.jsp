<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2017/10/23 0023
  Time: 下午 2:29
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>购物车</title>
</head>
<script>
    function delTFromCart(pid,uid) {
        var xhr = new XMLHttpRequest();
        xhr.open('POST',"/delFromCart.html",true);
        xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
        xhr.send('pid='+pid+'&'+'uid='+uid);

    }
</script>
<body>
    ${user.userName}的购物车
    <br>
    <table border="1">
        <tr>
            <th>productID</th>
            <th>productName</th>
            <th>price</th>
            <th>count</th>
        </tr>
        <c:forEach items="${list}" var="cartItem">
        <tr>
            <td>${cartItem.product.productId}</td>
            <td>${cartItem.product.productName}</td>
            <td>${cartItem.product.price}</td>
            <td>${cartItem.count}</td>
            <td><button class="del" onclick="delTFromCart(${cartItem.productId},${user.userId})">删除</button></td>
        </tr>
        </c:forEach>
    </table>
</body>
</html>
