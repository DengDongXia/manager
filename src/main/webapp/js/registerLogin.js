$(function(){
	tag = true;  //用于记录邮箱是否存在或正确

// 文本框判断部分
  //文本框失去焦点后
  $('.main').find('.check').blur(function(){
    var $parent = $(this).parent();
    $parent.find(".error").remove();
    var element = this.value;  //获取元素的值	
    var text_pic = "<div class='error'>&nbsp;" ;

    //验证邮件
    if( $(this).is('#email') ){
		var emailReg = /^\w+([-+.]\w+)*@\w+([-.]\w+)*\.\w+([-.]\w+)*$/;  //邮箱匹配的正则表达式
		if (element == "" || element == null) {
			tag = false;
			text = text_pic+"<span>账号不能为空！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else if(!emailReg.test(element)){
			tag = false;
			text = text_pic+"<span>请输入正确的邮箱！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else{
			tag = true;			
			$parent.find(".error").remove();    //输入正确后，删除提示语
		}
    }

    //验证密码
    if( $(this).is('#password') ){	
		if (element == "" || element == null) {
			text = text_pic+"<span>密码不能为空！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else if (element.length<6) {
			text = text_pic+"<span>密码长度不能小于6！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else{
			$parent.find(".error").remove();
		}
    }

 	// 再次确定密码
 	if($(this).is('#rePassword')){
 		var password2 = $('#password').val();
 		console.log(password2);
 		if(element != password2){
 			text = text_pic+"<span>两次输入的密码不一致！</span>";
 			$parent.append(text+"</div>");   //插入html语句
 		}else{
 		$parent.find(".error").remove();
	 	}
 	}

    //验证验证码
    if( $(this).is('#verification') ){	
    	$parent.find(".error").remove();    
		if (element == "" || element == null) {
			text = text_pic+"<span>验证码不能为空！</span>";
			$parent.append(text+"</div>");   //插入html语句
		}else{
			$parent.find(".error").remove();
		}
    }


  }).keyup(function(){ 
   $(this).triggerHandler("blur");    //键下内容时触发事件
  }).focus(function(){
    $(this).triggerHandler("blur");   //获得焦点时触发事件
  });//end blur

})

