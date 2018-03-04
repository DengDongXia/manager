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
		if(data.userId == 0 || data.type != 1){
			alert('你没有访问该页面的权利');
			window.location.href="http://localhost:8080/manager/login.jsp";
		}else{
			userId = data.userId;    //保存id
			$('#imgBg').append("<img src="+data.pictureURL+">");  //添加头像
			$('#adminName').append(data.name);   //添加用户名称
			$('#adminQuote').append(data.quote);  //添加个性签名
			getUserNumber(1);     //获取厂商账号
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
		getUserNumber(1);  //获取厂商账号
	}else{
		getsales();  //获取整个团队代理销售情况
	}
});
/*对两个功能按钮进行监听*/


/*查看厂商账号*/
//获取厂商账号
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
		dealUserNumber(data);  //处理返回的厂商账号信息
		addButton();    //为返回的信息添加分页按钮
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
}

//处理返回的厂商账号信息
function dealUserNumber(data) {
	$('#info').children().remove();   //移除原有的信息
	// 插入标题
	var title = "<p class='title'><span class='num'>编号</span><span>头像</span><span class='name'>昵称</span><span class='addAgent'>代理添加情况</span>";
		title += "<span class='status'>账号情况</span><span class='quote'>个性签名</span></p>";
	$('#info').append(title);
	// 插入ul
	$('#info').append("<ul id='libg'><ul>");
	// 插入全部li
	$.each(data.content, function(index, val) {
		 var text = "<span class='num'>"+val.userId+"</span><span class='url'><img src='"+val.pictureURL+"'></span><span class='name'>"+val.name+"</span>";
		 	 // 判断是否有代理
		 	 if(val.proxyState == true){
		 	 	text += "<span class='addAgent'>允许</span>";
		 	 }else{
		 	 	text += "<span class='addAgent'>不允许</span>";
		 	 }
		 	 // 判断账号是否正常
		 	 if(val.locked == true){
		 	 	text += "<span class='status'>冻结</span>";
		 	 }else{
		 	 	text += "<span class='status'>正常</span>";
		 	 }
		 	 text += "<span class='quote'>"+val.quote+"</span>";
		 $('#libg').append("<li>"+text+"</li>");
	});

}

// 对返回的信息进行分页处理
var nowPage = 1; //记录当前页号 
function addButton() {
	var button = "<span id='first'>首页</span><span id='last'>上一页</span>";
		button += "<span id='next'>下一页</span><span id='end'>尾页</span>共"+sumPage+"页";
	$('#libg').append("<p class='switchPage'>"+button+"</p>");
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
/*查看厂商账号*/

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
	// 插入标题
	var title = "<span class='num'>编号</span><span>头像</span><span class='name'>代理用户名称</span>";
		title += "<span class='profit'>其利润总额</span><span class='count'>其商品销售总量</span>";
	$('#info').append("<p class='title'>"+title+"</p>");
	// 插入ul
	$('#info').append("<ul id='libg'><ul>");
	// 插入全部li
	$.each(data.content, function(index, val) {
		 var text = "<span class='num'>"+val.agentUserId+"</span><span class='url'><img src='"+val.agentUserPictureURL+"'></span>";
		 	 text += "<span class='name'>"+val.agentUserName+"</span><span class='profit'>"+val.account+"元</span><span class='count'>"+val.goodsNumber+"件</span>";
		 $('#libg').append("<li>"+text+"</li>");
	});

}
/*查看整个团队代理销售情况*/

/*对新增厂商按钮进行监听*/
$('#add').click(function(event) {
	$('.addBg').show();    //显示遮罩层
});

$('.addBg').click(function(event) {
	$('.addBg').hide();    //隐藏遮罩层
});

$('.addForm').click(function(event) {
	event.stopPropagation();  //阻止冒泡事件
});

// 提交表单
$('#submitForm').click(function(event) {
	// 判断表单是否填写完整
	if($('#name').val() == '' || $('#email').val() == '' || $('#password').val() == '' ||$('#quote').val() == ''){
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

// 提交表单信息
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
			window.location.href="http://localhost:8080/manager/damin.jsp";
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
/*对新增厂商按钮进行监听*/
