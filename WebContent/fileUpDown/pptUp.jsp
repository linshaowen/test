<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<html>
    <head>
    <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>文件上传</title>
    </head>
    <body>
        <h3>周报ppt图片文件上传</h3>
        <hr/>
        <!--enctype设置为multipart/form-data，该属性用来设置浏览器采用二进制的方式来处理表单数据，上传文件时需要使用该属性-->
        <s:form action="upLoad2.action"  enctype="multipart/form-data" >
          <s:hidden  name="title"  value="3"/>
	    <!--Struts2使用拦截器fileUpload显示国际化信息时，这里不用使用key值，但是在3.1.2中需要使用-->
            <s:file name="upload" label="选择ppt图片1" /><br/>
            <s:file name="upload2" label="选择ppt图片2" /><br/>
            <s:file name="upload3" label="选择ppt图片3" /><br/>
             <s:file name="upload4" label="选择ppt图片4" /><br/>
            <s:submit value="上传"/>
        </s:form>
    </body>
</html>