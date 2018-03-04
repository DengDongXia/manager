/*添加注销功能*/
$('#logout').click(function(event) {
	$.ajax({
			// url: 'http://localhost:8080/manager/user/logout',
			type: 'POST',
			dataType: 'json',
			contentType:'application/json',
		})
	.done(function(data) {
		//后端跳转页面
	})
	.fail(function() {
		alert('请求出错');
	})
	.always(function() {
		// console.log("complete");
	});
});