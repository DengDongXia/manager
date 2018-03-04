<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>厂商管理——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/manufacturer.css">
</head>
<body>
	<div class='main'>
		<div class="shortcut"><span class='logo'>Manager</span><span id='logout'>注销</span></div>
		<div class="content">
			<div class="userInfo">
				<div class="userPic">
					<p class='headImgbg'><span class='imgBg' id='imgBg'><!-- <img src="images/head.jpg"> --></span></p>
					<p><span class='identify'>厂商</span></p>
				</div>
				<div class="userText">
					<p><label>昵称：</label><span class='userName' id='adminName'><!-- 撒飒飒 --></span></p>
					<p class='quoteBg'><label>个性签名：</label><span id='adminQuote'><!-- 撒反反复复飒飒 --></span></p>
					<p class='add'><span id='addAgent'>新增一级代理</span><span id='addgoods'>录入商品信息</span></p>
				</div>
			</div>
			<div class="funInfo">
				<p id='fun'><span class='choose' id='checkUser'>查看下级代理用户</span><span>下级代理的商品销售情况</span></p>
				<div class="info" id='info'>
					<!-- 查看下级代理账户 -->
					<!-- <ul class='liBg'>
						<p><span class='number'>编号</span><span class='name'>用户名称</span><span class='head'>头像</span><span class='email'>邮箱</span><span class='power'>代理添加权限</span><span class='quote'>个性签名</span><span class='opera'>操作</span></p>
						<li><span class='number'>122222</span><span class='name'>dadas</span><span class='head'><span class='imgBg'><img src='images/head.jpg'></span></span><span class='email'>123@qq.com</span><span class='power'><label class='choosePemit'>允许</label><label>不允许</label></span><span class='quote'>个性签名个性签名个性签名个性签名</span><span class='opera allotGoods' id='allotGoods'>分配商品</span></li>
					</ul> -->
					<!-- 查看下级代理销售情况 -->
					<!-- <ul class='liBg sell'>
						<p><span class='number'>编号</span><span class='name'>用户名称</span><span class='head'>头像</span><span class='sumProfit'>其利润总额</span><span class='sumCount'>商品销售总量</span></p>
						<li><span class='number'>122222</span><span class='name'>dadas</span><span class='head'><span class='imgBg'><img src='images/head.jpg'></span></span><span class='sumProfit'>100000</span><span class='sumCount'>100件</span></li>
					</ul> -->
				</div>
			</div>
		</div>
		<div class="footer">脚部信息</div>

		<!-- 遮罩层新增一级代理 -->
		<div class="addBg" id='adduserBg'>
			<div class="addForm">
				<p class='addTitle'>新增一级代理</p>
				<p><input type="text" name="" id='name' placeholder="请输入新增的一级代理名称"></p>
				<p><input type="eamil" name="" id='email' placeholder="请输入新增的一级代理邮箱"></p>
				<p><input type="password" name="" id='password' placeholder="请输入密码"></p>
				<p><input type="text" name="" id='quote' placeholder="请输入新增的一级代理的个性签名"></p>
				<p><input type="file" name="" id='pic'></p>
				<p class='checkBg'><label><input type="checkbox" id='check' name="power" checked>允许代理</label></p>
				<p><input type="button" name="" value='新增一级代理' class='submitForm' id='addUserButton'></p>
			</div>	
		</div>

		<!-- 遮罩层新增商品信息 -->
		<div class="addBg" id='addgoodsBg'>
			<div class="addForm">
				<p class='addTitle'>录入商品信息</p>
				<p><input type="text" name="" id='goodsName' placeholder="请输入新增的商品名称"></p>
				<p><input type="text" name="" id='goodsPrice' placeholder="请输入新增的商品价格"></p>
				<p><input type="text" name="" id='goodsCount' placeholder="请输入新增的商品数目"></p>
				<p><input type="button" name="" value='新增商品' class='submitForm' id='addGoodsButton'></p>
			</div>	
		</div>

		<!-- 遮罩层分配商品信息给下级代理 -->
		<div class="addBg" id='allotBg'>
			<div class="addForm">
				<p class='addTitle'>分配商品</p>
				<p class='allotUserId'><span id='userNumber'></span></p>
				<p class='allotUserId'><span id='agentNumber'></span></p>
				<p><input type="text" name="" id='allotGoodsId' placeholder="请输入分配的商品编号"></p>
				<p><input type="text" name="" id='allotPrice' placeholder="请输入代理的商品的定价"></p>
				<p><input type="text" name="" id='allotaccount' placeholder="请输入代理的商品的数目"></p>
				<p><input type="button" name="" value='分配' class='submitForm' id='allotButton'></p>
			</div>	
		</div>
	</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/ajaxfileupload.js"></script>
<script src="js/common.js"></script>
<script src="js/manufacturer.js"></script>
</body>
</html>