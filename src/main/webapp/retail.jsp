<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>零售代理管理——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/retail.css">
	<link rel="stylesheet" type="text/css" href="css/goodsOrder.css">
</head>
<body>
	<div class='main'>
		<div class="shortcut"><span class='logo'>Manager</span><a href="agent.jsp"><span id='personal'>个人中心</span></a><span id='logout'>注销</span></div>
		<!-- 个人信息方面 -->
		<div class="content userContent">
			<div class="userInfo">
			<div class="userPic">
				<p class='headImgbg'><span class='imgBg' id='imgBg'><!-- <img src="images/head.jpg"> --></span></p>
				<p><span class='identify'>零售代理</span></p>
			</div>
			<div class="userText">
				<p><label>昵称：</label><span class='userName' id='adminName'><!-- 撒飒飒 --></span></p>
				<p class='quoteBg'><label>个性签名：</label><span id='adminQuote'><!-- 撒反反复复飒飒 --></span></p>
				<p class='add'><a href="report.jsp"><span id='addgoods'>查看报表</span></a></p>
			</div>
		</div>

		</div>
		<div class="content">
			<!-- 功能部分 -->
			<div class="navInfo"><p class='chooseNav'  id='chooseAddOrder'><span>新增订单</span></p><p id='chooseSaleOrder'><span>销售订单</span></p><p><span>我的代理</span></p></div>
			<div class="contentInfo" id='contentInfo'>
				<!-- 新增销售订单 -->
				<div class='orderForm' id='orderForm'>
					<p class='addOrderTitle'>新增订单</p>
					<p><label>客户名字：</label><input type='text' id='customerName' name='' placeholder='请输入客户名字'></p>
					<p><label>客户手机号：</label><input type='text' id='customerPhone' name='' placeholder='请输入客户手机号'></p>
					<p><label>客户邮箱：</label><input type='email' id='customerEmail' name='' placeholder='请输入客户邮箱'></p>
					<p><label>商品编号：</label><input type='text' id='goodsId' name='' placeholder='请输入商品编号'></p>
					<p><label>客户地址：</label><input type='text' id='address' name='' placeholder='请输入邮寄商品的客户地址'></p>
					<p><label>商品的价格：</label><input type='text' id='price' name='' placeholder='请输入邮寄商品的价格'></p>
					<p><label>快递单号：</label><input type='text' id='deliveryId' name='' placeholder='请输入邮寄商品的快递单号'></p>
					<p><label>快递公司名称：</label><input type='text' id='deliveryCompany' name='' placeholder='请输入邮寄商品的快递公司名称'></p>
					<p class='check'><input type='checkbox' id='state' name=''>已收货</p>
					<p class='submitBg'><input type='button' name='' id='submit' value='提交订单'></p>
				</div>
				<!-- 查看销售订单信息 -->
				<div class='checkOrder' id='checkOrder'>
					<p class='addOrderTitle'>查询销售订单</p>
					<p class='filter'><span>查询条件：</span><input type='text' id='filter' name='' placeholder='请根据选中的查询类型输入查询条件'><span id='check'>查询</span></p>
					<p class='typeBg'><span>查询类型：</span><label><input type='radio' name='searchType' value='1' checked>按订单号</label><label><input type='radio' name='searchType' value='2'>按发货状态</label><label><input type='radio' name='searchType' value='3'>按商品名</label><label><input type='radio' name='searchType' value='4'>按发货地址</label><label><input type='radio' name='searchType' value='5'>按订单客户姓名</label></p>
					<ul id='liBg'>
						<!-- <li class='order'>
							<div class='goodsInfo'><p class='goodsInfoTitle'><span>订单编号:3343524</span></p><p><span>商品名称：颠倒是</span></p><p><span>发货地址：广东金融学院</span></p><p><span>快递公司：撒大声地快递</span></p><p><span>收货状态：未收货</span></p><p class='otherInfo'><span>快递单号：121223</span><span>出单时间：2018.01.30</span><span>商品价格：2000元</span></p></div>
							<div class='customerInfo'><p class='userInfoTitle'>客户信息</p><p><span>客户名称：收发室</span></p><p><span>电话号码：12345678901</span></p><p><span>客户邮箱：1@aa.com</span></p><p class='editBg'><span>编辑</span></p></div>
						</li> -->
					</ul>
				</div>

				<!-- 查看用户代理的商品情况 -->
				<div class='myAgentBg' id='myAgentBg'>
					<p class='addOrderTitle'>查询代理商品情况</p>
					<p><span class='goodsId'>商品编号</span><span class='goodsName'>商品名称</span><span class='sendGoods'>商品销量</span><span class='saveGoods'>商品存货</span><span class='cost'>成本</span><span class='account'>利润</span></p>
					<ul class='myAgent' id='myAgent'>
						<!-- <li><span class='goodsId'>1211</span><span class='goodsName'>小猪</span><span class='sendGoods'>500件</span><span class='saveGoods'>1000件</span><span class='cost'>10000元</span><span class='account'>3000元</span></li> -->

					</ul>
				</div>
			</div>
		</div>
		<div class="footer">脚部信息</div>

		<!--遮罩层 编辑更新信息的表单 -->
		<div class="addBg" id='allotBg'>
			<div class="addForm">
				<p class='addTitle'>编辑订单信息</p>
				<p class='allotUserId'><span id='changeOrderId'></span></p>
				<p><input type="text" name="" id='changeDeliveryCompany' placeholder="请输入快递公司名称"></p>
				<p><input type="text" name="" id='changeDeliveryId' placeholder="请输入快递单号"></p>
				<p class='check'><input type='checkbox' id='chageState' name='' checked>已收货</p>
				<p><input type="button" name="" value='更改' class='submitForm' id='changeOrderData'></p>
			</div>	
		</div>

	</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/common.js"></script>
<script src="js/retail.js"></script>
</body>
</html>