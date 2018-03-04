$().ready(function() {
	getUserData();  //获取用户信息，并对用户进行判断是否登录
});

//获取用户信息，并对用户进行判断是否登录
var userId;  //保存用户id
function getUserData() {
	$.ajax({
			// url: 'data/getUserMessage.json',
			url: 'http://localhost:8080/manager/user/getUserMessage',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
			}),
		})
	.done(function(data) {
		if(data.userId == 0){
			alert('请先登录');
			window.location.href="http://localhost:8080/manager/login.jsp";
		}else{
			userId = data.userId;    //保存id
			// 判断是哪一级代理
			if(data.type = 2){
				$('#personalLink').attr('href', 'agent.jsp');
			}else if(data.type = 3){
				$('#personalLink').attr('href', 'nextAgent.jsp');
			}else{
				window.location.href="http://localhost:8080/manager/login.jsp";
			}
			getAddForm();  //获取新增订单表单
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

/*对三个功能按钮进行监听*/
$('.navInfo').find('p').click(function(event) {
	$('.navInfo').find('p').removeClass('chooseNav');  //移除选中类
	$(this).addClass('chooseNav');   //当前点击对象添加选中类
	if($(this).is('#chooseAddOrder')){
		getAddForm();  //获取新增订单表单
	}else if($(this).is('#chooseSaleOrder')){
		getSearchBg();   //获取搜索框
	}else{
		getMyAgent();   //我的代理订单的情况统计
	}
});
/*对两个功能按钮进行监听*/

/*新增订单部分*/
function getAddForm() {
	$('#contentInfo').children().hide();   //移除原有信息
	$('#orderForm').show();
	addOrder();  //新增订单
}

//新增订单
function addOrder() {
	$('#submit').click(function(event) {
	// 判断表单是否填写完整
	if($('#customerName').val() == '' || $('#customerPhone').val() == '' || $('#customerEmail').val() == '' || $('#goodsId').val() == '' 
		|| $('#address').val() == '' || $('#price').val() == '' || $('#deliveryId').val() == '' || $('#deliveryCompany').val() == ''){
		alert("请将表单填写完整");
	}else{
		var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;  //邮箱匹配的正则表达式
		var phoneReg = /^1[3|4|5|7|8][0-9]{9}$/;  //手机匹配的正则表达式
		if(!phoneReg.test($('#customerPhone').val())){
			alert('请输入正确的手机号');
		}
		else if (!emailReg.test($('#customerEmail').val())) {
			alert('请输入正确的邮箱号');
		}else{
			submitform();  
		}
	}
	});
}

//提交订单
function submitform() {
	$.ajax({
			// url: 'data/addGoodsAgent.json',
			url: 'http://localhost:8080/manager/user/addGoodsOrder',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"customerName":$('#customerName').val(),
				"customerPhone":$('#customerPhone').val(),
				"customerEmail":$('#customerEmail').val(),
				"goodsId":$('#goodsId').val(),
				"address":$('#address').val(),
				"price":$('#price').val(),
				"deliveryId":$('#deliveryId').val(),
				"deliveryCompany":$('#deliveryCompany').val(),
				"state":$('#state').is(':checked')
			}),
		})
	.done(function(data) {
		if(data.addGoodsOrderResult == true){
			alert('新增订单成功');
			window.location.href="http://localhost:8080/manager/goodsOrder.jsp";
		}else{
			alert('新增订单出错');
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}
/*新增订单部分*/



/*查看销售订单*/
//通过搜索查看销售订单
// 获取搜索框
function getSearchBg() {
	$('#contentInfo').children().hide();   //移除原有信息
	$('#checkOrder').show();
	$('#check').click(function(event) {
		if($('#filter').val() == ''){
			alert("请先输入搜索条件");
		}else{
			submitFilter(1);
		}
	});
}

var sumSalePage; //记录总的页号数
function submitFilter(page) {
	$.ajax({
		// url: 'data/searchGoodsOrder.json',
		url: 'http://localhost:8080/manager/user/searchGoodsOrder',
		type: 'POST',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userId":userId,
			"pageIndex":page,
			"showLimit":5,
			"type":$("input[name='searchType']:checked").attr('value'),
			"condition":$('#filter').val()
		}),
		})
	.done(function(data) {
		sumSalePage = data.pageNumber;
		dealOrderData(data);  //处理返回的订单信息
		addButton();    //为返回的信息添加分页按钮
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

//处理返回的订单信息
function dealOrderData(data) {
	$('#liBg').children().remove();  //移除li
	$.each(data.content, function(index, val) {
		var liText = "<div class='goodsInfo'><p class='goodsInfoTitle'>订单编号:<span class='getOrderid'>"+val.Id+"</span></p>";
			liText += "<p><span>商品名称："+val.goodsName+"</span></p><p><span>发货地址："+val.address+"</span></p>";
			liText += "<p><span>快递公司：<label class='Company'>"+val.dliveryCompany+"</label></span></p>";
			if(val.state == true){
				liText += "<p><span>收货状态：已收货</span></p>";
			}else{
				liText += "<p><span>收货状态：未收货</span></p>";
			}
			liText += "<p class='otherInfo'><span>快递单号：<label class='getdliveryId'>"+val.dliveryId+"</label></span><span>出单时间："+val.time+"</span>";
			liText += "<span>商品价格："+val.price+"元</span></p></div>";
			liText += "<div class='customerInfo'><p class='userInfoTitle'>客户信息</p><p><span>客户名称："+val.customerName+"</span></p>";
			liText += "<p><span>电话号码："+val.customerPhone+"</span></p><p><span>客户邮箱："+val.customerEmail+"</span></p>";
			liText += "<p class='editBg'><span>编辑</span></p></div>";
		$('#liBg').append("<li class='order'>"+liText+"</li>");
	});
	// 给编辑订单信息按钮绑定事件
	$('.editBg').click(function(event) {
		$('#allotBg').show();
		$('#changeOrderId').text("订单号："+$(this).parents('li').find('.getOrderid').text());
		$('#changeDeliveryCompany').val($(this).parents('li').find('.Company').text());
		$('#changeDeliveryId').val($(this).parents('li').find('.getdliveryId').text());
	});
	// 更改订单数据
	changeOrderData();
	
}

// 更改订单数据
function changeOrderData() {
	$('#changeOrderData').click(function(event) {
		if($('#changeDeliveryCompany').val() == '' || $('#changeDeliveryId').val() == ''){
		alert("请将表单填写完整");
		}else{
			$.ajax({
				// url: 'data/addGoodsAgent.json',
				url: 'http://localhost:8080/manager/user/updateGoodsOrder',
				type: 'POST',
				dataType: 'json',
				contentType:'application/json',
				data: JSON.stringify({
					"userId":userId,
					"orderId":$('#changeOrderId').text(),
					"deliveryCompany":$('#changeDeliveryCompany').val(),
					"deliveryId":$('#changeDeliveryId').val(),
					"state":$('#chageState').is(':checked')
				}),
			})
			.done(function(data) {
				if(data.updateResult == true){
					alert('修改订单成功');
					window.location.href="http://localhost:8080/manager/goodsOrder.jsp";
				}else{
					alert('修改订单出错');
				}
			})
			.fail(function() {
				alert('请求出错');
			})
			.always(function() {
				// console.log("complete");
			});
		}
	});
}

/*遮罩层显示*/
$('.addBg').click(function(event) {
	$('.addBg').hide();    //隐藏遮罩层
});

$('.addForm').click(function(event) {
	event.stopPropagation();  //阻止冒泡事件
});
/*遮罩层显示*/

// 对返回的信息进行分页处理
var nowPage = 1; //记录当前页号 
function addButton() {
	var button = "<span id='first'>首页</span><span id='last'>上一页</span>";
		button += "<span id='next'>下一页</span><span id='end'>尾页</span>共"+sumSalePage+"页";
	$('#liBg').append("<p class='switchPage'>"+button+"</p>");
	// 给按钮绑定事件
	$('.switchPage').find('span').click(function(event) {
		if($(this).is('#first')){
			nowPage = 1;
		}
		else if($(this).is('#last')){
			if(nowPage != 1){
				nowPage = nowPage - 1;
			}else{
				nowPage = 1;
			}
		}
		else if($(this).is('#next')){
			if(nowPage != sumSalePage){
				nowPage = nowPage + 1;
			}else{
				nowPage = sumSalePage;
			}
		}
		else{
			nowPage = sumSalePage;
		}
		submitFilter(nowPage);
	});
}
/*查看销售订单*/

/*我的代理*/
//我的代理订单的情况统计
function getMyAgent() {
	$('#contentInfo').children().hide();   //移除原有信息
	$('#myAgentBg').show();
	getMyAgentData(1);   //获取用户代理的信息
}

var sumAgentPage; //记录总的页号数
function getMyAgentData(page) {
	$.ajax({
		// url: 'data/goodsOrderMessage.json',
		url: 'http://localhost:8080/manager/data/goodsOrderMessage',
		type: 'POST',
		dataType: 'json',
		contentType:'application/json',
		data: JSON.stringify({
			"userId":userId,
			"pageIndex":page,
			"showLimit":5,
		}),
		})
	.done(function(data) {
		sumAgentPage = data.pageNumber;
		dealAgentData(data);  //处理返回的订单信息
		addAgentButton();    //为返回的信息添加分页按钮
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

//处理返回的订单信息
function dealAgentData(data) {
	$('#myAgent').children().remove();  //移除li
	$.each(data.sendGoods, function(index, val) {
		var liText = "<span class='goodsId'>"+val.goodsId+"</span><span class='goodsName'>"+val.goodsName+"</span>";
			liText += "<span class='sendGoods'>"+val.sendGoods+"件</span><span class='saveGoods'>"+val.saveGoods+"件</span>";
			liText += "<span class='cost'>"+val.cost+"元</span><span class='account'>"+val.account+"元</span>";
		$('#myAgent').append("<li>"+liText+"</li>");
	});
	
}

// 对返回的信息进行分页处理
var nowPage = 1; //记录当前页号 
function addAgentButton() {
	var button = "<span id='first'>首页</span><span id='last'>上一页</span>";
		button += "<span id='next'>下一页</span><span id='end'>尾页</span>共"+sumAgentPage+"页";
	$('#myAgent').append("<p class='switchPage'>"+button+"</p>");
	// 给按钮绑定事件
	$('.switchPage').find('span').click(function(event) {
		if($(this).is('#first')){
			nowPage = 1;
		}
		else if($(this).is('#last')){
			if(nowPage != 1){
				nowPage = nowPage - 1;
			}else{
				nowPage = 1;
			}
		}
		else if($(this).is('#next')){
			if(nowPage != sumAgentPage){
				nowPage = nowPage + 1;
			}else{
				nowPage = sumAgentPage;
			}
		}
		else{
			nowPage = sumAgentPage;
		}
		submitFilter(nowPage);
	});
}
/*我的代理*/
