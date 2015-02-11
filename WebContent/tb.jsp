<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="java.sql.Date"%>
<%@page import="java.util.*,com.gzctksxt.dao.*,com.gzctksxt.bean.*"%>
<%@page import="com.gzctksxt.daoImp.*"%>
<%@page import="java.text.SimpleDateFormat"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>互联网渠道业务展示平台</title>
<link href="http://v3.bootcss.com/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link
	href="http://v3.bootcss.com/examples/starter-template/starter-template.css"
	rel="stylesheet">
<script
	src="./Starter Template for Bootstrap_files/ie-emulation-modes-warning.js"></script>
<style type="text/css">
html, body {
	margin: 0px;
	padding: 0px;
	width: 100%;
	height: 100%;
	background-color: yellow;
}

img {
	
}

li {
	list-style: none;
	display: block;
	height: 800px;
	max-height: 800px;
}

#wrapper {
	position: absolute;
	z-index: 1;
	top: 50px;
	bottom: 0px;
	left: 0;
	width: 100%;
	background: #ccc;
	overflow: hidden;
}

#scroller {
	position: absolute;
	z-index: 1;
	width: 100%;
	/*height: 100%;*/
	-webkit-tap-highlight-color: rgba(0, 0, 0, 0);
	-webkit-transform: translateZ(0);
	transform: translateZ(0);
	-webkit-touch-callout: none;
	-webkit-user-select: none;
	user-select: none;
	-webkit-text-size-adjust: none;
	text-size-adjust: none;
	background: #D2BF9F;
}
</style>
</head>
<body onload="loaded()">
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
				<a class="navbar-brand" href="">各项目销量通报</a>
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
	<%
    BaseBeanDao bd=new BaseBeanImp();
     BaseNameDao bnd=new BaseNameImp();

 
     
     
   List<BaseBean> list_yd=bd.selectAll("yd");
   List<BaseNameBean> list_ydn=bnd.selectLastOne("ydn");
		

	   List<BaseBean> list_kd=bd.selectAll("kd");
	   List<BaseNameBean> list_kdn=bnd.selectLastOne("kdn");
			BaseBean bb_kd=(BaseBean)list_kd.get(0);
			BaseBean bb_yd=(BaseBean)list_yd.get(0);
			BaseNameBean bnb_ydn=(BaseNameBean)list_ydn.get(0);
			BaseNameBean bnb_kdn=(BaseNameBean)list_kdn.get(0);
	
    %>


	<div id="wrapper">
		<div id="scroller">
			<ul style="-webkit-padding-start: 0px;">

				<li style="position: relative;"><img src="img/1.jpg"
					style="position: absolute; z-index: -5; width: 100%; top: 0%; left: 0%;">

					<table cellpadding="0" cellspacing="0"
						style="position: relative; font-size: 4.8vw; font-weight: bold;left:4%;">
						<tr style="height: 50px;"></tr>
						<tr>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL1() %>&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL2() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL3() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL4() %>&nbsp;&nbsp;&nbsp;</td>
						</tr>
						<%
                   for(int i=0;(i<list_yd.size()-1)&&i<8;i++)
                   {
                	 bb_yd=(BaseBean)list_yd.get(i);
                	   
                   %>

						<tr style="height: 20px;"></tr>
						<tr>
							<td style="width: 4vw;"></td>
							<td><%=bb_yd.getL1() %></td>
							<td style="width: 4vw;"></td>
							<td><%=bb_yd.getL2() %></td>
							<td style="width: 4vw;"></td>
							<td><%=bb_yd.getL3() %></td>
							<td style="width: 4vw;"></td>
							<td><%=bb_yd.getL4() %></td>
						</tr>

						<%} %>
					</table> 
					<div
						style="position: relative; z-index: 5; left: 10%; width: 80%; text-align: center; font-size: 5vw;">
						<%=bnb_ydn.getL10() %>
					</div></li>
				<%--第二页 --%>


				<li style="position: relative;"><img src="img/2.jpg"
					style="position: absolute; z-index: -5; width: 100%; top: 0%; left: 0%;">
					<table cellpadding="0" cellspacing="0"
						style="position: relative; font-size: 4.7vw; font-weight: bold;left:4%;">
						<tr style="height: 50px;"></tr>
						<tr>
							<td style="width: 4vw;"></td>
							<td style="white-space: nowrap;"><%=bnb_ydn.getL1() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL6() %>&nbsp;&nbsp;</td>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL7() %>&nbsp;&nbsp;</td>
							<td style="width: 4vw;"></td>
							<td><%=bnb_ydn.getL8() %>&nbsp;&nbsp;</td>
						</tr>
						<%
                   for(int i=0;(i<list_yd.size()-1)&&i<8;i++)
                   {
                	 bb_yd=(BaseBean)list_yd.get(i);
                	    
                   %>

						<tr style="height: 20px;"></tr>
						<tr>
							<td style="width: 4vw;"></td>
							<td style="white-space: nowrap;"><%=bb_yd.getL1() %></td>
							<td style="width: 4vw;"></td>
							<td><%=bb_yd.getL6() %></td>
							<td style="width: 4vw; white-space: nowrap"></td>
							<td><%=bb_yd.getL7() %></td>
							<td style="width: 4vw; white-space: nowrap"></td>
							<td><%=bb_yd.getL8()  %></td>
						</tr>

						<%} %>
					</table>
					<div
						style="position: relative; z-index: 5; left: 10%; width: 80%; text-align: center; font-size: 5vw;">
						<%=bnb_ydn.getL10() %>
					</div>

					</li>
<%--第三页 --%>
				<li style="position: relative;"><img src="img/2.jpg"
					style="position: absolute; z-index: -5; width: 100%; top: 0%; left: 0%;">
						<table cellpadding="0" cellspacing="0"
						style="position: relative; font-size: 5vw; font-weight: bold;left:4%;">
						
						<tr style="height: 20px;"></tr>
						
						
						
<tr>
<td colspan="10" style="font-size:6vw;">
<%=bnb_kdn.getL0() %>
</td>

</tr>
						
							<tr style="height: 15px;"></tr>
						<tr>
						<td style="width: 3vw;"></td>
						    <td>科室&nbsp;&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 3vw;"></td>
							<td><%=bnb_kdn.getL2() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 3vw;"></td>
							<td><%=bnb_kdn.getL3() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 3vw;"></td>
							<td><%=bnb_kdn.getL4() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 3vw;"></td>
							<td><%=bnb_kdn.getL5() %>&nbsp;&nbsp;&nbsp;</td>
						</tr>
					
					
						
					<%
                   for(int i=0;(i<list_kd.size()-1)&&i<3;i++)
                   {
                	 bb_kd=(BaseBean)list_kd.get(i);
                	    
                   %>

						<tr style="height: 15px;"></tr>
						<tr>
							<td style="width: 3vw;"></td>
							<td style="white-space: nowrap;"><%=bb_kd.getL0() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 3vw;"></td>
							<td><%=bb_kd.getL1() %></td>
							<td style="width: 3vw; white-space: nowrap"></td>
							<td><%=bb_kd.getL2() %></td>
							<td style="width: 3vw; white-space: nowrap"></td>
							<td><%=bb_kd.getL3()  %></td>
							<td style="width: 3vw; white-space: nowrap"></td>
							<td><%=bb_kd.getL4()  %></td>
						</tr>

						<%} %>
						
						
						
						
					<tr style="height: 15px;"></tr>
	
						<tr>

<td colspan="10" style="font-size:6vw;">
<%=bnb_kdn.getL1() %>
</td>

</tr>
			
							<%
                   for(int i=0;(i<list_kd.size()-1)&&i<3;i++)
                   {
                	 bb_kd=(BaseBean)list_kd.get(i);
                	    
                   %>

						<tr style="height: 15px;"></tr>
						<tr>
							<td style="width: 3vw;"></td>
							<td style="white-space: nowrap;"><%=bb_kd.getL0() %>&nbsp;&nbsp;&nbsp;</td>
							<td style="width: 3vw;"></td>
							<td><%=bb_kd.getL5() %></td>
							<td style="width:3vw; white-space: nowrap"></td>
							<td><%=bb_kd.getL6() %></td>
							<td style="width: 3vw; white-space: nowrap"></td>
							<td><%=bb_kd.getL7()  %></td>
							<td style="width: 3vw; white-space: nowrap"></td>
							<td><%=bb_kd.getL8()  %></td>
						</tr>

						<%} %>
						
						
						
					</table>
					 <br />
				<br />
					<div
						style="position: relative; z-index: 5; left: 10%; width: 80%; text-align: center; font-size: 5vw;">
						<%=bnb_ydn.getL10() %>
					</div>
					</li>

			</ul>
		</div>
	</div>


	<script src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/iscroll.js"></script>
	<script src="./Starter Template for Bootstrap_files/bootstrap.min.js"></script>

	<script type="text/javascript">
     var myh = $(window).height();
     var myh2 = $(window).height()-50;
     $("img").height(myh);
 
    var myScroll;

    function loaded() {
        myScroll = new IScroll('#wrapper', {
            snap: "li",
            // snap: true,
            scrollX: false,
            scrollY: true,
        });
    }
    document.addEventListener('touchmove', function(e) {
        e.preventDefault();
    }, false);
    </script>
	<script
		src="./Starter Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


</body>
</html>
