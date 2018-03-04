<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>登录——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/registerLogin.css">
</head>
<body>
	<div class='main'>
		<p class='title'><span>登录</span></p>
		<p><input type='text' class='input check' id='email' placeholder='请输入用户id或邮箱' /></p>
		<p><input type='password' class='input check' id='password' placeholder='请输入用户密码' /></p>
		<div class='verBg'><div class='VerificationBg'><input type='text' class='VerificationBg input check' id='verification' placeholder='请输入验证码' /></div><div class='VerificationBg imgBg'><img src='' alt='图片验证码' id='getPicVerification' class='img'></div></div>
		<p><input type='button' class='' id='ok' value='登录' /></p>
		<p class='other'><a href="register.jsp">注册管理账号</a></p>
	</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/registerLogin.js"></script>
<script src="js/login.js"></script>
</body>
</html>