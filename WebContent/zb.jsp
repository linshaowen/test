<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.*,com.gzctksxt.dao.*,com.gzctksxt.bean.*"%>
<%@page import="com.gzctksxt.daoImp.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en"><head><meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width,minimum-scale=1.0,maximum-scale=3.0">
    <title>互联网渠道业务展示平台</title>
    <link href="http://v3.bootcss.com/dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="http://v3.bootcss.com/examples/starter-template/starter-template.css" rel="stylesheet">
    <script src="./Starter Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>
     <style type="text/css">
    html,
    body {
        margin: 0px;
        padding: 0px;
        width: 100%;
        height: 100%;
     display:hidden;
    }
#con{
width: 100%;
	}
	img{
		position: absolute;
		left: 0%;
		top: 50%;
		opacity: 0;
		/*-webkit-transform:rotateX(90deg);*/
		
	}

	img.show
	{/*
		-webkit-transition:-webkit-transform ease-out .5s .5s;
        -webkit-transform:rotateX(0deg);*/
       /*-webkit-transform:translateX(-200px);*/
        -webkit-transform:translateY(-100px);
       -webkit-transition:-webkit-transform ease-out 1s .5s,opacity 1s .5s;
       /*加下面这个更好看*/


		opacity: 1;
	}
	img.hide
	{
	/*	-webkit-transition:-webkit-transform ease-out .5s;
		 -webkit-transform:rotateX(90deg);*/
		 -webkit-transform:translateY(100px);
		  -webkit-transition:-webkit-transform ease-out 1s,opacity 1s;
		 opacity: 0;
	}
    </style>
  </head>
  <body onload="loaded()">
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
      <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">业务质量周报（周更新）</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
          <li style="height:20px;margin:0 0 15px 0"><a href="view2.jsp">总体业务</a></li>
          <li style="height:20px;margin:0 0 15px 0"><a href="tb.jsp">各项目销量通报</a>
       
          </li>
           <li style="height:20px;margin:0 0 15px 0"><a href="zb.jsp">业务质量周报(周更新)</a></li>
          <li style="height:20px;margin:0 0 15px 0"><a href="qx.jsp">业务发展趋势</a></li>
          <li style="height:20px;margin:0 0 15px 0"><a href="js.jsp">劳动竞赛</a></li>
</ul>
        </div>
      </div>
    </nav>
   
   
 

   <div id="con">
	<img src="save/1.jpg" style="" class="show" id="a" alt="">
	<img src="save/2.jpg" style=""id="b"alt="">
</div>
   
 
   
   <script src="./dist/zepto.js"></script>
   <script src="js/jquery.min.js"></script>
    <script type="text/javascript" src="js/iscroll.js"></script>
    <script src="./Starter Template for Bootstrap_files/bootstrap.min.js"></script>
   
    <script src="./Starter Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>

</body>
<script>
jQuery.noConflict();
$(window).load(function(){
	var myw = $(window).width();
    $("img").width(myw);
		var i=0;
		$("body").swipeUp(function  () {
			var j=$("img").size();

		
//到集合最后元素停止i++
if (i<j-1) {

$("img").eq(i).addClass("hide").next().addClass("show").removeClass("hide");

i++;

};
	});


	$("body").swipeDown(function  () {

//在集合第一个元素之前停止i--
if (i>0) {

$("img").eq(i).addClass("hide").prev().removeClass("hide");
i--;
};
		});
	}
		)
</script>
</html>
