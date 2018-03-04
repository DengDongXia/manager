/*登录部分*/
	// 登录异步获取图片验证码
	$('#getPicVerification').click(function(){
		getPicCode();
	});

	//异步请求图片验证码
	function getPicCode() {
		var xmlhttp;
		xmlhttp=new XMLHttpRequest();
		xmlhttp.open("GET","http://localhost:8080/manager/code/identifyCode",true);
		xmlhttp.responseType = "application/json";
		xmlhttp.onload = function(){
		    if (this.status == 200) {
		        var blob = this.response;
		        var data = "data:image/jpeg;base64,"+$.parseJSON(blob).image;
    			$('#getPicVerification').attr('src', data);
		    }
		}
		xmlhttp.send();
		
	}

  //提交，最终验证。
   $('#ok').click(function(){
    $('.main').find('.check').trigger('blur');    //含有类名为required的文本框都触发验证事件
    var numError = $('.main .error').length;
    if(numError){
     return false;
    }

    $.ajax({
			// url: 'data/login.json',
			url: 'http://localhost:8080/manager/user/login',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
			data: JSON.stringify({
				email: $("#email").val(),
				password: $("#password").val(),
				validateCode: $("#verification").val()
			}),
		})
	.done(function(data) {
		var text = "<div class='error form-group'>" ;
			if(data.accountResult == false){
				$("#email").find(".error").remove();
				text += "<span>该账号尚未注册</span></div>";
				$("#email").parent().append(text);
			}else{
				if(data.passwordResult == false){
					$("#password").find(".error").remove();
					text += "<span>密码错误</span></div>";
					$("#password").parent().append(text);
				}
				else if(data.validateCodeResult == false){
				    $("#verification").find(".error").remove();
					text += "<span>验证码错误</span></div>";
					$("#verification").parent().append(text);
				}else if(data.accountState == false){
					$("#verification").find(".error").remove();
					text += "<span>该账号尚未通过审核</span></div>";
					$("#verification").parent().append(text);
				}
				else{
					alert("登录成功！");
					if(data.type == 1){  //团队管理员
						// window.location.href="http://localhost:8080/team/admin.jsp";
						window.location.href="http://localhost:8080/manager/admin.jsp";
					}
					else if(data.type == 2){  //一级代理
						// window.location.href="http://localhost:8080/team/agent.jsp";
						window.location.href="http://localhost:8080/manager/agent.jsp";
					}
					else if(data.type == 3){  //2级代理
						window.location.href="http://localhost:8080/manager/nextAgent.jsp";
					}
					else if(data.type == 4){  //零售代理
						window.location.href="http://localhost:8080/manager/retail.jsp";
					}
					else{   //5表示厂商
						// window.location.href="http://localhost:8080/team/manufacturer.jsp";
						window.location.href="http://localhost:8080/manager/manufacturer.jsp";
					}
				}
			}
	})
	.fail(function() {
		console.log("error");
	})
	.always(function() {
		// console.log("complete");
	});
});