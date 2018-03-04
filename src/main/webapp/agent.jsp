<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>一级代理管理——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/agent.css">
</head>
<body>
	<div class='main'>
		<div class="shortcut"><span class='logo'>Manager</span><a href="agent.jsp"><span id='personal'>个人中心</span></a><span id='logout'>注销</span></div>
		<div class="content">
			<div class="userInfo">
				<div class="userPic">
					<p class='headImgbg'><span class='imgBg' id='imgBg'><!-- <img src="images/head.jpg"> --></span></p>
					<p><span class='identify'>一级代理</span></p>
				</div>
				<div class="userText">
					<p><label>昵称：</label><span class='userName' id='adminName'><!-- 撒飒飒 --></span></p>
					<p class='quoteBg'><label>个性签名：</label><span id='adminQuote'><!-- 撒反反复复飒飒 --></span></p>
					<p class='add'><span id='addAgent'>新增二级代理</span><a href="report.jsp"><span id='addgoods'>查看报表</span></a></p>
				</div>
				<div class='goodOrder'><a href="goodsOrder.jsp" target='_blank'><p class='orderLogo'></p><p><span>商品销售信息	</span></p></a></div>
			</div>
			<div class="funInfo">
				<p id='fun'><span class='choose' id='checkUser'>查看下级代理用户</span><span>下级代理的商品销售情况</span></p>
				<div class="info" id='info'>
				</div>
			</div>
		</div>
		<div class="footer">脚部信息</div>

		<!-- 遮罩层新增二级代理 -->
		<div class="addBg" id='adduserBg'>
			<div class="addForm">
				<p class='addTitle'>新增二级代理</p>
				<p><input type="text" name="" id='name' placeholder="请输入新增的二级代理名称"></p>
				<p><input type="eamil" name="" id='email' placeholder="请输入新增的二级代理邮箱"></p>
				<p><input type="password" name="" id='password' placeholder="请输入密码"></p>
				<p><input type="text" name="" id='quote' placeholder="请输入新增的二级代理的个性签名"></p>
				<p><input type="file" name="" id='pic'></p>
				<p class='checkBg'><label><input type="checkbox" id='check' name="power" checked>允许代理</label></p>
				<p><input type="button" name="" value='新增二级代理' class='submitForm' id='addUserButton'></p>
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
<script src="js/agent.js"></script>
</body>
</html>