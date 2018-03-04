<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>注册——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/registerLogin.css">
</head>
<body>
	<div class='main'>
		<p class='title'><span>注册</span></p>
		<p><input type='text' class='input check' id='email' placeholder='请输入邮箱号码' /></p>
		<p><input type='password' class='input check' id='password' placeholder='请输入用户密码' /></p>
		<p><input type='password' class='input check' id='rePassword' placeholder='再次输入密码' /></p>
		<p id='tag'><input type='text' class='Vinput check' id='verification' placeholder='请输入邮箱验证码' /><input type='button' value='获取邮箱验证码' class='Vinput' id='getPicVerification'></button></p>
		<p><input type='button' class='' id='ok' value='注册' /></p>
		<p class='other'><a href="login.jsp">立即登录</a></p>
	</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/registerLogin.js"></script>
<script src="js/register.js"></script>
</body>
</html>