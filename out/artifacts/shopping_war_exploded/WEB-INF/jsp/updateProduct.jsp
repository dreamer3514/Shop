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
<script type="text/javascript" src="js/bootstrap.js"></script>
<%--<link href="//cdn.bootcss.com/tether/1.3.6/css/tether.min.css" rel="stylesheet">--%>
<%--<script src="//cdn.bootcss.com/tether/1.3.6/js/tether.min.js"></script>--%>



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
            <td></td>
        </tr>
    </c:forEach>

    </tbody>
</table>
<button  class="btn btn-primary" data-toggle="modal" data-target="#myModal" >修改商品</button>
<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title" id="myModalLabel">商品修改</h4>
            </div>
            <div class="modal-body">
                <form method="post" action="/updateProduct.html" class="bs-example bs-example-form" role="form" >
                    <div class="input-group">
                        商品名称：<input type="text" name="productName"><br>
                    </div>
                    <div class="input-group" >
                        商品价格：
                        <input type="number" name="price" >
                    </div>
                    <div class="input-group">
                        商品描述：
                        <input type="text" name="description">
                    </div>
                    商品类型：<select name="typeId">
                    <option value="1">手机</option>
                    <option value="2">零食</option>
                    <option value="3">服饰</option>
                    <option value="4">运动</option>
                    <option value="5">图书</option>
                    <option value="6">手表</option>
                </select>
                    <div class="input-group">
                        图片地址：<input type="url" name="imageUrl">
                    </div>
                    <div class="modal-footer">
                        <button type="button" class="btn btn-default" data-dismiss="modal">关闭
                        </button>
                        <button type="submit" class="btn btn-primary">
                            提交更改
                        </button>
                    </div>
                </form>
            </div>
        </div><!-- /.modal-content -->
    </div><!-- /.modal -->
</div>
<ul class="pagination">
    <li><a href="/toUpdateProduct.html?page=1">1</a></li>
    <li><a href="/toUpdateProduct.html?page=2">2</a></li>
    <li><a href="/toUpdateProduct.html?page=3">3</a></li>
    <li><a href="/toUpdateProduct.html?page=4">4</a></li>
    <li><a href="/toUpdateProduct.html?page=5">5</a></li>
</ul>


</body>
</html>