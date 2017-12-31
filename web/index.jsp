
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="zh-cn">
<head>
    <title>电子商城</title>
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
<!--<![endif]-->
<!--[if lte IE 8 ]>
<script src="http://libs.baidu.com/jquery/1.11.3/jquery.min.js"></script>
<script src="http://cdn.staticfile.org/modernizr/2.8.3/modernizr.js"></script>
<script src="lib/amazeui/amazeui.ie8polyfill.min.js"></script>
<![endif]-->
<script type="text/javascript" src="/lib/handlebars/handlebars.min.js"></script>
<script type="text/javascript" src="/lib/iscroll/iscroll-probe.js"></script>
<script type="text/javascript" src="/lib/amazeui/amazeui.min.js"></script>
<script type="text/javascript" src="/lib/raty/jquery.raty.js"></script>
<script type="text/javascript" src="/js/main.min.js?t=1"></script>
</head>
<body>
<header class="hd">
    <div class="hd-top am-hide-md-down">
        <div class="cg">
            <div class="hd-top-left">
                <a href="#">设为首页</a>
                <a href="#">收藏</a>
                <a href="#">RSS订阅</a>
            </div>
            <div class="hd-top-right">
                <a href="/toLogin.html">登录</a>
                <a href="/toRegister.html">注册</a>
            </div>
        </div>
    </div>
    <div class="cg">
        <div class="hd-search">

            <div class="hd-search-right am-hide-md-down">
                <div class="hd-search-right-input">
                    <form action="/findByKeyword.html" method="get">
                        <input type="text" name="key" value="" placeholder="搜索商品" />
                        <input type="submit" id="find" value="搜索">
                    </form>

                    
                </div>
            </div>
            <button class="am-show-md-down font f-btn" id="hd_botton" type="button" data-am-modal="{target: '#my-modal'}">&#xe68b;</button>
        </div>
    </div>


    <div class="hd-bottom">
        <div class="cg">
            <div class="hd-bottom-category am-hide-md-down">
                <h1><a href="javascript:;">商品分类</a><i data-am-collapse="{target: '.banner-collapse'}">&#xe78f;</i></h1>
            </div>
            <div class="hd-bottom-nav" id="my-modal">
              <h1 class="am-show-md-down"><input type="text" name="name" value="" placeholder="请输入关键字" /><em class="font">&#xe6e7;</em><i data-am-modal="{target: '#my-modal'}">&#xe607;</i></h1>
            
            </div>
        </div>
    </div>
</header>
   
    <div class="am-cf"></div>
    <div class="am-slider am-slider-default index-lunbo" data-am-flexslider="{playAfterPaused: 8000}">
            <ul class="am-slides">
                <li><img src="images/index_banner.jpg" /></li>
                <li><img src="images/index_banner.jpg" /></li>
                <li><img src="images/index_banner.jpg" /></li>
            </ul>

        <div class="banner-slide am-hide-md-down">
            <div class="cg">
                <ul class="category">
                    <li><a href="/productType.html?typeId=1&page=1">手机</a></li>
                    <li><a href="/productType.html?typeId=2&page=1">零食</a></li>
                    <li><a href="/productType.html?typeId=3&page=1">服饰</a></li>
                    <li><a href="/productType.html?typeId=4&page=1">运动</a></li>
                    <li><a href="/productType.html?typeId=5&page=1">图书</a></li>
                    <li><a href="/productType.html?typeId=6&page=1">手表</a></li>
                    <li><a href="/productType.html?typeId=7&page=1">箱包</a></li>
                    <li><a href="/productType.html?typeId=8&page=1">母婴</a></li>

                </ul>
            </div>
        </div>
      
    </div>
    

    <script type="text/javascript">
        var noticeimg = document.getElementById("noticeimg");
        var imgslider = document.querySelectorAll(".imgslider");
        var index = 0;
        for (var i = 0; i < imgslider.length; i++) {
            imgslider[i].index = i;
            imgslider[i].onclick = function () {
                index = this.index;
                var herf = imgslider[index].getAttribute('data-clstag');
                var src = imgslider[index].getAttribute('src');
                noticeimg.children[0].setAttribute('href', herf);
                noticeimg.getElementsByTagName("img")[0].setAttribute('src', src);
            }
        }
    </script>



</body>
</html>