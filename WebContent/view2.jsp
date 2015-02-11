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
    <meta name="viewport" content="width=device-width, initial-scale=1">
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
         background-color:yellow;
    }
    img {}
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
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="">总体业务</a>
        </div>
        <div id="navbar" class="collapse navbar-collapse">
          <ul class="nav navbar-nav">
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
     PJBeanDao pd=new PJBeanImp();
     List<PJBean> list_zd=pd.selectAll("zd");
     PJBean pjb=new PJBean();
     
     
   List<BaseBean> list_yd=bd.selectLastOne("yd");
   List<BaseNameBean> list_ydn=bnd.selectLastOne("ydn");
		BaseBean bb_yd=(BaseBean)list_yd.get(0);
		BaseNameBean bnb_yd=(BaseNameBean)list_ydn.get(0);
		

	   List<BaseBean> list_kd=bd.selectLastOne("kd");
	   List<BaseNameBean> list_kdn=bnd.selectLastOne("kdn");
			BaseBean bb_kd=(BaseBean)list_kd.get(0);
			BaseNameBean bnb_kd=(BaseNameBean)list_kdn.get(0);
	
    %>
    
    
      <div id="wrapper">
        <div id="scroller">
           <ul style="-webkit-padding-start: 0px;">

               <li style="position: relative;"><img src="img/1.jpg"
					style="position: absolute; z-index: -5; width: 100%; top: 0%; left: 0%;">
                   <table cellpadding="0" cellspacing="0"
						style="position: relative; font-size:5vw; font-weight: bold;left:4%;">

                        <tbody>
                            <tr style="height:15px;"></tr>
 <tr>
 <td colspan="5" style="font-size:6vw;">移动业务</td>
    
     </tr>
    <tr>
    <td>&nbsp;&nbsp;&nbsp;</td>
     <td><%=bnb_yd.getL2()%>:&nbsp;&nbsp;</td>
     <td><%=bb_yd.getL2()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
     
      <td><%=bnb_yd.getL3()%>:&nbsp;&nbsp;</td>
     <td><%=bb_yd.getL3()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
     <td><%=bnb_yd.getL4()%>:&nbsp;&nbsp;</td>
     <td><%=bb_yd.getL4()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><%=bnb_yd.getL5()%>:&nbsp;&nbsp;</td>
     <td><%=bb_yd.getL5()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
    <tr style="height:10px;"></tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
<td colspan="5" style="">
<%=bnb_yd.getL6()%>
</td>

</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
<td>入网指标:&nbsp;&nbsp;</td>
<td><%=bb_yd.getL6()%></td>
<td><%=bnb_yd.getL7()%>:&nbsp;&nbsp;</td>
<td><%=bb_yd.getL7()%></td>

</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
<td><%=bnb_yd.getL8()%>:&nbsp;&nbsp;</td>
<td><%=bb_yd.getL8()%></td>
<td><%=bnb_yd.getL9()%>:&nbsp;&nbsp;</td>
<td><%=bb_yd.getL9()%></td>

</tr>
   
   
   
   
                             <tr style="height:10px;"></tr>
 <tr>
 <td colspan="5" style="font-size:6vw;">宽带业务</td>
    
     </tr>
     <tr>
     <td>&nbsp;&nbsp;&nbsp;</td>
 <td colspan="5" style=""><%=bnb_kd.getL0()%></td>
    
     </tr>
    <tr>
    <td>&nbsp;&nbsp;&nbsp;</td>
     <td><%=bnb_kd.getL2()%>:&nbsp;&nbsp;</td>
     <td><%=bb_kd.getL1()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><%=bnb_kd.getL3()%>:&nbsp;&nbsp;</td>
     <td><%=bb_kd.getL2()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
     <td><%=bnb_kd.getL4()%>:&nbsp;&nbsp;</td>
     <td><%=bb_kd.getL3()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
      <td><%=bnb_kd.getL5()%>:&nbsp;&nbsp;</td>
     <td><%=bb_kd.getL5()%>&nbsp;&nbsp;&nbsp;&nbsp;</td>
</tr>
    <tr style="height:10px;"></tr>
 <tr>
 <td>&nbsp;&nbsp;&nbsp;</td>
 <td colspan="5" style=""><%=bnb_kd.getL0()%></td>
    
     </tr>
</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
<td><%=bnb_kd.getL6()%>:&nbsp;&nbsp;</td>
<td><%=bb_kd.getL5()%></td>
<td><%=bnb_kd.getL7()%>:&nbsp;&nbsp;</td>
<td><%=bb_kd.getL6()%></td>

</tr>
<tr>
<td>&nbsp;&nbsp;&nbsp;</td>
<td><%=bnb_kd.getL8()%>:&nbsp;&nbsp;</td>
<td><%=bb_kd.getL7()%></td>
<td><%=bnb_kd.getL9()%>:&nbsp;&nbsp;</td>
<td><%=bb_kd.getL8()%></td>

</tr>
   
   
   
  


                        </tbody>
                    </table>
                    <br />
			
					<div
						style="position: relative; z-index: 5; left: 10%; width: 80%; text-align: center; font-size: 5vw;">
						<%=bnb_yd.getL10() %>
					</div>
                </li>
                
                
                
                
              <li style="position: relative;"><img src="img/2.jpg"
					style="position: absolute; z-index: -5; width: 100%; top: 0%; left: 0%;">
                           
                   <table cellpadding="0" cellspacing="0"
						style="position: relative; font-size: 5vw; font-weight: bold;left:4%;">
                        <tbody>
    <tr style="height:15px;"></tr>
                            <tr>
                                <td colspan="5" style="font-size:6vw;">重点项目（专项）</td>
                            </tr>
                     


    <%
    for(int i=0;i<list_zd.size();i++)
	{  
    	pjb=list_zd.get(i);
    %>
   
     <tr style="height:10px;"></tr>
    <tr> 
    <td  colspan="5"><%=pjb.getName()%></td>
</tr>
    
    <tr>
    <td>&nbsp;&nbsp;&nbsp;</td>
     <td>放号指标:&nbsp;&nbsp;</td>
    <td><%=pjb.getZb()%>&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</td>
   <td>累计放号:&nbsp;&nbsp;</td>
   <td><%=pjb.getFhl()%></td>

</tr>
    <tr>
    <td>&nbsp;&nbsp;&nbsp;</td>
      <td>完成进度:&nbsp;&nbsp;</td>
       <td><%=pjb.getWcjd()%></td>
       <td>环比提升:&nbsp;&nbsp;</td>
    <td><%=pjb.getHbts()%></td>

    </tr>
   
     <% 	
	}
    %>
                        </tbody>
                    </table>
                <br />
			
					<div
						style="position: relative; z-index: 5; left: 10%; width: 80%; text-align: center; font-size: 5vw;">
						<%=bnb_yd.getL10() %>
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
    <script src="./Starter Template for Bootstrap_files/ie10-viewport-bug-workaround.js"></script>


</body></html>
