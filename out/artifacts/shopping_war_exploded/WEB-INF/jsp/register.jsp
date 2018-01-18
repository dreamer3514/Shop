<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <title>注册</title>
    <meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge" />
<meta name="format-detection" content="telephone=no">
<meta name="renderer" content="webkit">
<meta name="viewport" content="width=device-width,initial-scale=1,maximum-scale=1,user-scalable=no">
<meta http-equiv="Cache-Control" content="no-siteapp" />
<link rel="alternate icon" type="image/png" href="images/favicon.png">
<link rel='icon' href='favicon.ico' type='image/x-ico' />
<meta name="description" content="" />
<meta name="keywords" content="" />
<link rel="stylesheet" href="css/default.min.css?t=227" />
<!--[if (gte IE 9)|!(IE)]><!-->
<script type="text/javascript" src="lib/jquery/jquery.min.js"></script>

<script type="text/javascript" src="lib/handlebars/handlebars.min.js"></script>
<script type="text/javascript" src="lib/iscroll/iscroll-probe.js"></script>
<script type="text/javascript" src="lib/amazeui/amazeui.min.js"></script>
<script type="text/javascript" src="lib/raty/jquery.raty.js"></script>
<script type="text/javascript" src="js/main.min.js?t=1"></script>
</head>
<body>
      
     <div class="user">
         <div class="cgs">
             <div class="am-u-sm-12 am-u-md-12 am-u-lg-7">
                 <div class="user-div">
                     <h1>用户注册</h1>
                     <form action="/doRegister.html" method="post">


                     <ul>
                         <li><i>&#xe681;</i><input type="text" name="userName" value="" placeholder="请输入用户名" /></li>
                         <li><i>&#xe680;</i><input type="text" name="password" value="" placeholder="请输入密码" /></li>
                         <li><i>&#xe680;</i><input type="text" name="emailAdress" value="" placeholder="请输入邮箱"/></li>
                     </ul>
                     ${error}
                       <input id="reg_btn" type="submit" value="注册"/>
                     </form>
                 </div>
             </div>
             <div class="am-hide-sm am-hide-md am-u-lg-5">
                 <div class="user-right">
                     <p>已有帐号</p>
                     <button><a href="/toLogin.html">立即登录</a></button>
                 </div>
             </div>
         </div>
     </div>

     <%--<script>--%>
         <%--function register()--%>
         <%--{--%>
             <%--userName=$("#username").val()--%>
             <%--password=$("#password").val()--%>
             <%--email = $("#email").val()--%>
             <%--var xhr = new XMLHttpRequest();--%>
             <%--xhr.open('POST',"/loginCheck.html",true);--%>
             <%--xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');--%>
             <%--xhr.send('userName='+userName+'&'+'password='+password&'email='+email);--%>
         <%--}--%>
     <%--</script>--%>

</body>
</html>

<style>
    #reg_btn{
        width: 100%;
        padding: 0.8rem 0;
        border-radius: 5px;
        display: block;
        background: #0076ca;
        color: #fff;
        border: 0;
        float: left;
        margin-top: 2rem;
    }
</style>