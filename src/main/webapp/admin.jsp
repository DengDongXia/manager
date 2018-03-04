<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>管理员管理——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/admin.css">
</head>
<body>
	<div class='main'>
		<div class="shortcut"><span class='logo'>Manager</span><span id='logout'>注销</span></div>
		<div class="content">
			<div class="userInfo">
				<p class='headImgbg'><span class='imgBg' id='imgBg'><!-- <img src="images/head.jpg"> --></span></p>
				<p><span class='identify'>团队管理员</span></p>
				<p><label>昵称：</label><span id='adminName'><!-- 撒飒飒 --></span></p>
				<p><label>个性签名：</label><span id='adminQuote'><!-- 撒反反复复飒飒 --></span></p>
				<p><span id='add'>新增厂商</span></p>
			</div>
			<div class="funInfo">
				<p id='fun'><span class='choose' id='checkUser'>查看厂商账号</span><span id='checkSales'>团队商品销售情况</span></p>
				<div class="info" id='info'>
					<!-- 查看厂商账号 -->
					<!-- <p class='title'><span class='num'>编号</span><span class="">头像</span><span class='name'>昵称</span><span class='addAgent'>代理添加情况</span><span class='status'>账号情况</span><span class='quote'>个性签名</span></p>
					<ul id='libg'>
						<li><span class='num'>11</span><span class="url"><img src="images/head.jpg"></span><span class='name'>昵称</span><span class='addAgent'>已添加</span><span class='status'>正常</span><span class='quote'>啦啦啦是拉是</span></li>
					</ul> -->
					<!-- 整个团队代理销售情况 -->
					<!-- <p class='title'><span class='num'>编号</span><span class="">头像</span><span class='name'>代理用户名称</span><span class='profit'>其利润总额</span><span class='count'>其商品销售总量</span></p>
					<ul id='libg'>
						<li><span class='num'>11</span><span class="url"><img src="images/head.jpg"></span><span class='name'>昵称</span><span class='profit'>100000</span><span class='count'>1000件</span></li>
					</ul> -->
				</div>
			</div>
		</div>
		<div class="footer">脚部信息</div>

		<!-- 遮罩层新增厂商 -->
		<div class="addBg" id='addBg'>
			<div class="addForm" id='addForm'>
				<p class='addTitle'>新增厂商</p>
				<p><input type="text" name="" id='name' placeholder="请输入新增的厂商名称"></p>
				<p><input type="eamil" name="" id='email' placeholder="请输入新增的厂商邮箱"></p>
				<p><input type="password" name="" id='password' placeholder="请输入密码"></p>
				<p><input type="text" name="" id='quote' placeholder="请输入新增的厂商的个性签名"></p>
				<p><input type="file" name="" id='pic'></p>
				<p class='checkBg'><label><input type="checkbox" id='check' name="power" checked>允许代理</label></p>
				<p><input type="button" name="" value='新增厂商' id='submitForm'></p>
			</div>	
		</div>
	</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/ajaxfileupload.js"></script>
<script src="js/common.js"></script>
<script src="js/admin.js"></script>
</body>
</html>