/*注册部分*/	
	/*异步获取邮箱验证码*/
	//注册Ajax异步请求发送验证码,向后台传输手机号或者邮箱
	$('#getPicVerification').click(function(){
		getIdentifyCode();
	});

	// 发起请求，获取后台数据，发送邮箱验证码
	function getIdentifyCode() {
		$.ajax({
			// url: "data/sendemail.json",
			url: "http://localhost:8080/manager/email/emailIdentifyCode",
			type:  "POST",
			contentType:"application/json",
			dataType: 'json',
			async: true,
			data: JSON.stringify({email : $('#email').val()})
		})
		.done(function(data) {
			setData(data);
		})
	}

	// 处理data的函数
	function setData(da) {
		
		if(da.getIdentifyCodeResult == true){
			 	setTip(1);   //传入1表示发送成功
		}else{
			 	setTip(0);   //传入0表示发送失败
		}
	}

	//设置插入的文本的函数
	function setTip(num) {
		$("#tag").find(".error").remove();	
	    var text = "<div class='error'>&nbsp;" ;
		switch(num){
			case 0 :
				text += "<span>邮箱获取验证码失败，请检查邮箱格式是否正确</span></div>";
				$("#tag").append(text);
				break;
			case 1 :
				countDown($("#getPicVerification"));
				break;
		}
		
	}

	// 倒计时函数封装
	//当后台异步返回邮箱发送成功时，调用该函数
	function countDown(obj) {
		var sec = 60;              //倒计时60s
			obj.text(sec+'s后重新发送');
			obj.addClass("sended");           //添加类名sended
			obj.attr("disabled",true);        //按钮不可用
			timer = setInterval(function(){
				sec--;                            //秒数自减1
				$("#getPicVerification").attr('value',sec+'s后重新发送');  //设置按钮文本
				if(sec == 0){                     //如果倒计时结束
					clearInterval(timer);         //清除定时器
					$("#getPicVerification").attr("disabled",false);      //恢复可用
					$("#getPicVerification").attr('value','重新发送');  //设置按钮文本
				}
			},1000);
	}

  //提交，最终验证。
   $('#ok').click(function(){
    $('.main').find('.check').trigger('blur');    //含有类名为check的文本框都触发验证事件
    var numError = $('.main .error').length;
    if(numError){
     return false;
    } 
    // 异步提交表单数据
    $.ajax({
    	// url: 'data/register.json',
    	url: 'http://localhost:8080/manager/user/register',
    	type: 'POST',
    	dataType: 'json',
    	contentType:'application/json',
    	data: JSON.stringify({
    		email: $("#email").val(),
			password: $("#password").val(),
			repeatePassword: $("#rePassword").val(),
			validateCode: $("#verification").val()
		}),
    })
    .done(function(data) {
    	if(data.validateCodeResult == true && data.emailExist == true && data.passwordResult == true){
				alert("注册成功！");
				// location.href = "http://localhost:8080/team/login.jsp";   //当后端注册成功后,返回true,跳转到登录界面
				location.href = "http://localhost:8080/manager/login.jsp";   //当后端注册成功后,返回true,跳转到登录界面
			}else{
				if(data.emailExist == false){
					$("#tag").find(".error").remove();	
				    var text = "<div class='error form-group'><span>邮箱已存在</span></div>" ;
					$("#tag").append(text);
				}
				else if(data.passwordResult == false){
					$("#tag").find(".error").remove();	
				    var text = "<div class='error form-group'><span>请确认密码的一致性</span></div>" ;
					$("#tag").append(text);
				}
				else if(data.validateCodeResult == false){
					$("#tag").find(".error").remove();	
				    var text = "<div class='error form-group'><span>验证码错误</span></div>" ;
					$("#tag").append(text);
				}
			}
    })
    .fail(function() {
    	// console.log("error");
    })
    .always(function() {
    	// console.log("complete");
    });
});
