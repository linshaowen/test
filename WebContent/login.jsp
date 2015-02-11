<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登录页面</title>
<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
	<style>
body,html{
	margin: 0;
	padding: 0;
	width: 100%;
	height: 100%;
}

	</style>
</head>
<body>

<img src="img/bg.jpg" alt="" style="height:100%;width:100%;">
	<div style="position:absolute;bottom:0%;height:200px;width:100%;text-align:center;">
		
		<form action="login" method="post">
			<input name ="userName"class="form-control" type="text" placeholder="参赛者" style="display:block; margin:0 auto;width:50%;">
			<br>
			<input name="userPassword" class="form-control" type="text" placeholder="邀请函" style="display:block;margin:0 auto;width:50%;">
			<br>
       
             <input type="image"  style="width:30%;margin:0 auto;"value="确 定" size="12" src="img/enter.png">
		</form>

	</div>
</body>
</html>