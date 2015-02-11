<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page import="java.util.*,com.gzctksxt.bean.*,com.gzctksxt.dao.*,com.gzctksxt.daoImp.*" %>
<%@page import="java.text.SimpleDateFormat"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta name="viewport" content="width=device-width,initial-scale=1">
<title>业务发展趋势图</title>
<link href="http://v3.bootcss.com/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://v3.bootcss.com/examples/starter-template/starter-template.css"
	rel="stylesheet">
<script src="./dist/zepto.js"></script>
<script src="http://libs.baidu.com/jquery/2.0.0/jquery.min.js" type="text/javascript"></script>
<script src="./dist/highcharts.js"></script>
<style>
	body,html{height:100%;width:100%;margin:0 auto;padding:0;background:#D2BF9F}
</style>
</head>
<body>
<nav class="navbar navbar-inverse navbar-fixed-top" role="navigation">
		<div class="container">
			<div class="navbar-header">
				<button type="button" class="navbar-toggle collapsed"
					data-toggle="collapse" data-target="#navbar" aria-expanded="false"
					aria-controls="navbar">
					<span class="sr-only">Toggle navigation</span> <span
						class="icon-bar"></span> <span class="icon-bar"></span> <span
						class="icon-bar"></span>
				</button>
				<a class="navbar-brand" href="">业务发展趋势</a>
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

	<div id="main" style="position:relative;height:100%;width:100%;margin:50px auto 0px auto;">
	    <div id="qx1" style="height:100%;width:100%;margin:0 auto;background:url('./img/1.jpg');background-size:cover">
	    	<div id="qx1up" style="height:45%;width:90%;margin:0 auto;margin-top:10px"></div>
	    	<div id="qx1bot" style="height:45%;width:90%;margin:0 auto;margin-top:10px"></div>
	    </div>
	    <!-- <div id="qx2" style="height:100%;width:100%;background:url('./img/2.jpg');background-size:cover">
	    	<div id="qx2up" style="height:45%;width:90%;margin:0 auto;margin-top:10px"></div>
	    	<div id="qx2bot" style="height:45%;width:90%;margin:0 auto">
	    	</div>
	    </div> -->
    </div>
   <script src="./dist/dark-blue.js"></script>
   <script>
   jQuery.noConflict();
   jQuery(document).ready(function($){
		 var ydljlist = [];
		 var yd4glist=[];
		 var yddate=[];
		 var zlkdlist=[];
		 var gkdlist=[];
		 var kddate=[];
		<% 
			BaseBeanDao bbd=new BaseBeanImp();
			SimpleDateFormat sf=new SimpleDateFormat("MM-dd");
			response.setContentType("text/html;chartset=UTF-8");
			List<BaseBean> ydlist=new ArrayList<BaseBean>();
			ydlist=bbd.selectByName("yd");
			List<BaseBean> kdlist=new ArrayList<BaseBean>();
			kdlist=bbd.selectByName("kd");
		    for(int i =ydlist.size()-1;i>=0;i--){
			    BaseBean obj1 =(BaseBean)ydlist.get(i);
		 %>
		 ydljlist.push(<%=obj1.getL3()%>);
		 yd4glist.push(<%=obj1.getL7()%>);
		 yddate.push('<%=sf.format(obj1.getRq().getTime()).toString()%>');
		 <%
		    }
		    for(int i =kdlist.size()-1;i>=0;i--){
			    BaseBean obj = (BaseBean)kdlist.get(i);
		 %>
		 zlkdlist.push(<%=obj.getL2()%>);
		 gkdlist.push(<%=obj.getL6()%>);
		 kddate.push('<%=sf.format(obj.getRq().getTime()).toString()%>')
		 <%
		    }
		 %>
	   	 var option={
	          chart: {
	             renderTo:'qx1up',
	             type: 'line',
	          },
	          title: {
	              text:"近一周移动业务发展趋势",
	              align:'center'
	          },
	          subtitle: {
	              text:"",
	              align:'center'
	          },
	          xAxis: {
	              categories:[]
	          },
	          yAxis: {
	              title: {
	                  text:""
	              },
	              plotLines: [{
	                  value: 0,
	                  width: 1,
	                  color: '#808080'
	              }]
	          },
	          credits:{
	          	enabled:false,
	          	},//去掉右下角的标志
	          series: [{
	              name: '',
	              data:[]
	          }, {
	              name: '',
	              data:[] 
	          }]
	       }
		 //创建第二个饼图
		 option.subtitle.text='入网数';
		 option.series[0].name='累计入网数';
	   	 option.series[1].name="4G入网数";
		 chart1=new Highcharts.Chart(option);
	   	 chart1.series[0].setData(ydljlist);
	   	 chart1.series[0].name='123'; 
	   	 chart1.series[1].setData(yd4glist);
	   	 chart1.yAxis[0].setTitle({text:'入网数'});
	   	 chart1.xAxis[0].setCategories(yddate);
		
	   	 
	   	 option.chart.renderTo="qx1bot";
	   	 option.subtitle.text='受理量';
		 option.series[0].name='主流宽带';
	   	 option.series[1].name="光宽带";
		 option.title.text="近一周宽带业务发展趋势" ;
		 chart2 = new Highcharts.Chart(option);
	   	 chart2.series[0].setData(zlkdlist);
	   	 chart2.series[1].setData(gkdlist);
	   	 chart2.yAxis[0].setTitle({text:'受理量'});
	   	 chart2.xAxis[0].setCategories(kddate);
  });
</script>  
<script>
	 $(window).load(function(){
		$("#main").children("div").css("display","none");
		$("#qx1").css("display","block");
		var i=0;
		var j=$("#main").children("div").size();
		$("body").swipeUp(function() {
			if(i<(j-1)){
				$("#main").children("div").eq(i).css("display","none").next().css("display","block");
				i++;
			}else if(i==j-1)
				{
		
				}
		});
		$("body").swipeDown(function(){
			if(i>0){
				$("#main").children("div").eq(i).css("display","none").prev().css("display","block");
				i--;
			}
		});
	});
</script>
 <script src="./Starter Template for Bootstrap_files/bootstrap.min.js"></script>
</body>
</html>