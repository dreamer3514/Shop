<%--
  Created by IntelliJ IDEA.
  User: mindong
  Date: 2017/10/21 0021
  Time: 下午 3:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<link rel="stylesheet" href="css/page.css" />
<link rel="stylesheet" href="css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style.css" />

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

//    function productType(typeId,page) {
//    var xhr = new XMLHttpRequest();
//    xhr.open('POST',"/productType.html",true);
//    xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');
//    xhr.send('typeId='+typeId+'&'+'page='+page);
//    }
</script>


<%--<table border="1">--%>
    <%--<tr>--%>
        <%--<th></th>--%>
        <%--<th>名称</th>--%>
        <%--<th>价格</th>--%>
        <%--<th>详情</th>--%>
    <%--</tr>--%>
    <%--<c:forEach items="${page.list}" var="product">--%>
        <%--<tr>--%>
            <%--<td><img height="220" width="220" src="${product.imageUrl}"></td>--%>
            <%--<td>${product.productName}</td>--%>
            <%--<td>${product.price}</td>--%>
            <%--<td>${product.description}</td>--%>
            <%--<td><button class="add" onclick="addToCart(${product.productId},${user.userId})">加入</button></td>--%>
        <%--</tr>--%>

    <%--</c:forEach>--%>
<%--</table>--%>

<c:forEach items="${page.list}" var="product">
    <div class="col-xs-12 col-sm-12 col-md-12">
        <!-- .pro-text -->
        <div class="pro-text">
            <div class="col-xs-12 col-sm-5 col-md-5">
                <!-- .pro-img -->
                <div class="pro-img"> <img height="220" width="220" src="${product.imageUrl}" alt="${product.productName}">
                    <sup class="sale-tag">sale!</sup>
                </div>
            </div>
            <div class="col-xs-12 col-sm-7 col-md-7">
                <div class="pro-text-outer list-pro-text">
                    <span>${product.productName}</span>
                    <p class="wk-price">￥${product.price} </p>
                    <p>${product.description}</p>
                    <button class="add-btn" onclick="addToCart(${product.productId},${user.userId})">加入到购物车</button>
                </div>
            </div>
        </div>
    </div>
</c:forEach>

<ul class="pagination">
    <li><a href="/productType.html?typeId=${typeId}&page=1">1</a></li>
    <li><a href="/productType.html?typeId=${typeId}&page=2">2</a></li>
    <li><a href="/productType.html?typeId=${typeId}&page=3">3</a></li>
    <li><a href="/productType.html?typeId=${typeId}&page=4">4</a></li>
</ul>
</body>
</html>
