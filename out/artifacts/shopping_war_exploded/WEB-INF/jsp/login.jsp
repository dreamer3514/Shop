<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <title>登陆</title>
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
                     <h1>用户登录</h1>
                     <form action="/loginCheck.html" method="post">


                        <ul>

                         <li><input type="text" name="userName" value="" placeholder="请输入用户名" /></li>
                         <li><input type="text" name="password" value="" placeholder="请输入密码" /></li>


                         </ul>
                        ${error}
                        <%--<span><a href="#">忘记密码</a></span>--%>
                         <br>
                        <input id="sub_btn" type="submit" value="登录"/>
                     </form>
                 </div>
             </div>
             <div class="am-hide-sm am-hide-md am-u-lg-5">
                 <div class="user-right">
                     <p>还没有帐号</p>
                     <button><a href="/toRegister.html">立即注册</a></button>
                 </div>
             </div>
         </div>
     </div>
</body>
</html>

<style>
    #sub_btn{
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
<%--<script>--%>
    <%--function login() {--%>
        <%--userName=$("#username").val()--%>
        <%--password=$("#password").val()--%>
        <%--var xhr = new XMLHttpRequest();--%>
        <%--xhr.open('POST',"/loginCheck.html",true);--%>
        <%--xhr.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');--%>
        <%--xhr.send('userName='+userName+'&'+'password='+password);--%>
        <%--}--%>
<%--</script>--%>
