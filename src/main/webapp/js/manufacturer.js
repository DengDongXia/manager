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
		if(data.userId == 0 || data.type != 5){
			alert('你没有访问该页面的权利');
			window.location.href="http://localhost:8080/manager/login.jsp";
		}else{
			userId = data.userId;    //保存id
			$('#imgBg').append("<img src="+data.pictureURL+">");  //添加头像
			$('#adminName').append(data.name);   //添加用户名称
			$('#adminQuote').append(data.quote);  //添加个性签名
			getUserNumber(1);     //获取下级代理账号
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

/*对两个功能按钮进行监听*/
$('#fun').find('span').click(function(event) {
	$('#fun').find('span').removeClass('choose');  //移除选中类
	$(this).addClass('choose');   //当前点击对象添加选中类
	if($(this).is('#checkUser')){
		getUserNumber(1);  //获取账号
	}else{
		getsales();  //获取整个团队代理销售情况
	}
});
/*对两个功能按钮进行监听*/


/*查看下级代理账号*/
//获取下级代理账号
var sumPage; //记录总的页号数
function getUserNumber(page) {
	$.ajax({
			// url: 'data/showProxyUserMessage.json',
			url: 'http://localhost:8080/manager/user/showProxyUserMessage',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"pageIndex":page,
				"showLimit":5
			}),
		})
	.done(function(data) {
		sumPage = data.pageNumber;
		dealUserNumber(data);  //处理返回的下级代理账号信息
		addButton();    //为返回的信息添加分页按钮
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

//处理返回的下级代理账号信息
function dealUserNumber(data) {
	$('#info').children().remove();   //移除原有的信息
	// 插入ul
	$('#info').append("<ul class='liBg' id='liBg'><ul>");
	// 插入标题
	var title = "<span class='number'>编号</span><span class='name'>用户名称</span><span class='head'>头像</span><span class='email'>邮箱</span>";
		title += "<span class='power'>代理添加权限</span><span class='status'>账号状况</span><span class='opera'>操作</span>";
	$('#liBg').append("<p>"+title+"</p>");
	// 插入全部li
	$.each(data.content, function(index, val) {
		 var text = "<span class='number'>"+val.userId+"</span><span class='name'>"+val.name+"</span>";
		 	 text += "<span class='head'><span class='imgBg'><img src='"+val.pictureURL+"'></span></span>";
		 	 text += "<span class='email'>"+val.email+"</span>";
		 	 // 判断是否有代理
		 	 if(val.proxyState == true){
		 	 	text += "<span class='power'><label class='choosePemit' value='1'>允许</label><label class='unChoosePemit' value='0'>不允许</label></span>";
		 	 }else{
		 	 	text += "<span class='power'><label class='choosePemit' value='0'>不允许</label><label class='unChoosePemit' value='1'>允许</label></span>";
		 	 }
		 	 // 判断账号是否正常
		 	 if(val.locked == true){
		 	 	text += "<span class='status'><label class='chooseStatus' value='0'>冻结</label><label class='unChangeStatus' value='1'>正常</label></span>";
		 	 }else{
		 	 	text += "<span class='status'><label class='chooseStatus' value='1'>正常</label><label class='unChangeStatus' value='0'>冻结</label></span>";
		 	 }
		 	 // text += "<span class='quote'>"+val.quote+"</span>";
		 	 text += "<span class='opera allotGoods' id='allotGoods'>分配商品</span>";
		 $('#liBg').append("<li>"+text+"</li>");
	});
	// 为是否有代理权限绑定事件
	$('.unChoosePemit').click(function(event) {
		var proxyState;  //是否有代理权
		if($(this).attr('value') == 1){
			proxyState = true;
		}else{
			proxyState = false;
		}
		var lockedObj = $(this).parents('li').find('.chooseStatus').attr('value');
		var locked;    //账号是否被冻结
		if(lockedObj == 1){
				locked = true;
		}else{
			locked = false;
		}
		// 获取当前代理用户的id
		var agentIdChange = $(this).parents('li').find('.number').text();
		// 改变权限
		changePowerStatus(agentIdChange,proxyState,locked);
	});
	// 为账号是否冻结绑定事件
	$('.unChangeStatus').click(function(event) {
		var locked;    //账号是否被冻结
		if($(this).attr('value') == 1){
			locked = true;
		}else{
			locked = false;
		}
		var proxyStateObj = $(this).parents('li').find('.choosePemit').attr('value');  
		var proxyState;  //是否有代理权
		if(proxyStateObj == 1){
			proxyState = true;
		}else{
			proxyState = false;
		}
		// 获取当前代理用户的id
		var agentIdChange = $(this).parents('li').find('.number').text();
		// 改变账号状况
		changePowerStatus(agentIdChange,proxyState,locked);
	});
	// changestatus(val.proxyState,val.locked);
	// 分配商品
	$('.allotGoods').click(function(event) {
		$('#allotBg').show();    //显示遮罩层
	});
	// 为分配按钮绑定事件
	allotGood();

}

// 改变代理权限或账号状态
function changePowerStatus(agentIdChange,proxyState,locked) {
	$.ajax({
			// url: 'data/updateAgentState.json',
			url: 'http://localhost:8080/manager/user/updateAgentState',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"agentId":agentIdChange,
				"proxyState":proxyState,
				"locked":locked
			}),
		})
	.done(function(data) {
		if(data.updateResult == true){
			alert('修改成功');
			getUserNumber(1);     //获取下级代理账号
		}else{
			alert('修改出错');
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

// 对返回的信息进行分页处理
var nowPage = 1; //记录当前页号 
function addButton() {
	var button = "<span id='first'>首页</span><span id='last'>上一页</span>";
		button += "<span id='next'>下一页</span><span id='end'>尾页</span>共"+sumPage+"页";
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
			if(nowPage != sumPage){
				nowPage = nowPage + 1;
			}else{
				nowPage = sumPage;
			}
		}
		else{
			nowPage = sumPage;
		}
		getUserNumber(nowPage);
	});
}
/*查看下级代理账号*/

/*查看整个团队代理销售情况*/
//获取整个团队代理销售情况
function getsales() {
	$.ajax({
			// url: 'data/getAgentGoodsMessage.json',
			url: 'http://localhost:8080/manager/data/getAgentGoodsMessage',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId
			}),
		})
	.done(function(data) {
		dealsales(data);  //处理返回的整个团队代理销售情况信息
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

//处理返回的整个团队代理销售情况信息
function dealsales(data) {
	$('#info').children().remove();   //移除原有的信息
	// 插入ul
	$('#info').append("<ul class='liBg sell' id='libg'><ul>");
	// 插入标题
	var title = "<span class='number'>编号</span><span class='name'>用户名称</span><span class='head'>头像</span>";
		title += "<span class='sumProfit'>其利润总额</span><span class='sumCount'>商品销售总量</span>";
	$('#libg').append("<p>"+title+"</p>");
	// 插入全部li
	$.each(data.content, function(index, val) {
		 var text = "<span class='number'>"+val.agentUserId+"</span><span class='name'>"+val.agentUserName+"</span>";
		 	 text += "<span class='head'><span class='imgBg'><img src='"+val.agentUserPictureURL+"'></span></span>";
		 	 text += "<span class='sumProfit'>"+val.account+"元</span><span class='sumCount'>"+val.goodsNumber+"件</span>";
		 $('#libg').append("<li>"+text+"</li>");
	});

}
/*查看整个团队代理销售情况*/

/*公共部分：对新增按钮进行监听，显示遮罩层*/
// 新增一级代理
$('#addAgent').click(function(event) {
	$('#adduserBg').show();    //显示遮罩层
});
// 新增商品信息
$('#addgoods').click(function(event) {
	$('#addgoodsBg').show();    //显示遮罩层
});

$('.addBg').click(function(event) {
	$('.addBg').hide();    //隐藏遮罩层
});

$('.addForm').click(function(event) {
	event.stopPropagation();  //阻止冒泡事件
});

/*公共部分：对新增按钮进行监听，显示遮罩层*/

/*新增代理*/
$('#addUserButton').click(function(event) {
	// 判断表单是否填写完整
	if($('#name').val() == '' || $('#email').val() == '' || $('#password').val() == '' || $('#quote').val() == '' || $('#pic').val() == ''){
		alert("请将表单填写完整");
	}else{
		var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;  //邮箱匹配的正则表达式
		if (!emailReg.test($('#email').val())) {
			alert('请输入正确的邮箱号');
		}else{
			// 上传图片
			submitPic();  //上传图片
		}
	}
});

// 上传图片
function submitPic() {
	$.ajaxFileUpload({
			// url: 'data/picture.json',
			url: 'http://localhost:8080/manager/picture/submit', //用于文件上传的服务器端请求地址
			secureuri: false, //是否需要安全协议，一般设置为false
			fileElementId: 'pic', //文件上传域的ID
			dataType: 'json', //返回值类型 一般设置为json
			contentType:'application/json',
			data: JSON.stringify({
				"picture": $('#pic').attr('name'),
			}),
			success: function (data, status)  //服务器成功响应处理函数
			{
				sendForm(data.pictureURL);  //上传表单
			},
			error: function (data, status, e)//服务器响应失败处理函数
			{
				alert("图片上传失败");
			}
		});
}

// 提交添加代理的表单
function sendForm(pic) {
	$.ajax({
			url: 'http://localhost:8080/manager/user/add',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"email":$('#email').val(),
				"name":$('#name').val(),
				"password":$('#password').val(),
				"quote":$('#quote').val(),
				"pictureURL":pic,
				"proxyState":$('#check').is(':checked')
			}),
		})
	.done(function(data) {
		if(data.addResult == true){
			alert('新增成功');
			alert('请记下新用户账号为：'+data.id+" 新用户密码为："+data.password);
			window.location.href="http://localhost:8080/manager/manufacturer.jsp";
		}else{
			alert('新增出错');
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}
/*新增代理*/

/*新增商品信息*/
$('#addGoodsButton').click(function(event) {
	// 判断表单是否填写完整
	if($('#goodsName').val() == '' || $('#goodsPrice').val() == '' || $('#goodsCount').val() == ''){
		alert("请将表单填写完整");
	}else{
		sendGoodsform();  //提交添加商品的表单
	}
});

//提交添加商品的表单
function sendGoodsform() {
	$.ajax({
			// url: 'data/addCompanyGoodsMessage.json',
			url: 'http://localhost:8080/manager/user/addCompanyGoodsMessage',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"name":$('#goodsName').val(),
				"price":$('#goodsPrice').val(),
				"account":$('#goodsCount').val()
			}),
		})
	.done(function(data) {
		if(data.addResult == true){
			alert('录入商品信息成功');
			window.location.href="http://localhost:8080/manager/manufacturer.jsp";
		}else{
			alert('录入商品信息出错');
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}
/*新增商品信息*/

/*分配商品信息给下级代理 */
function allotGood(argument) {
	var agentId;
	$('.allotGoods').click(function(event) {
		$('#userNumber').text('');
		$('#userNumber').append("厂商编号："+userId);
		agentId = $(this).parents('li').find('.number').text();   //获取代理的id值
		$('#agentNumber').text('');
		$('#agentNumber').append("一级代理编号："+agentId);
	});
	// 点击分配按钮时触发事件
	$('#allotButton').click(function(event) {
			// 判断表单是否填写完整
			if($('#allotGoodsId').val() == '' || $('#allotPrice').val() == '' || $('#allotaccount').val() == ''){
				alert("请将表单填写完整");
			}else{
				allotGoodsform(agentId);  //提交分配商品的表单
			}
	});
}

//提交分配商品的表单
function allotGoodsform(agentId) {
	$.ajax({
			// url: 'data/addGoodsAgent.json',
			url: 'http://localhost:8080/manager/user/addGoodsAgent',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				"userId":userId,
				"agentUserId":agentId,
				"goodsId":$('#allotGoodsId').val(),
				"price":$('#allotPrice').val(),
				"account":$('#allotaccount').val()
			}),
		})
	.done(function(data) {
		if(data.goodsAgentResult == true){
			alert('分配商品成功');
			window.location.href="http://localhost:8080/manager/manufacturer.jsp";
		}else{
			alert('分配商品信息出错');
		}
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}
/*分配商品信息给下级代理 */