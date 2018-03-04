<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8" />
	<title>商品销售信息页面管理——微商团队订单管理系统</title>
	<link rel="stylesheet" type="text/css" href="css/common.css">
	<link rel="stylesheet" type="text/css" href="css/report.css">
</head>
<body>
	<div class='main'>
		<div class="shortcut"><span class='logo'>Manager</span><a href=""><span id='personal'>个人中心</span></a><span id='logout'>注销</span></div>
		<div class="content" id='content'>
			<p><span class='label'>商品编号：</span><input type="text" name="" id='searchFilter' placeholder='请输入商品编号'><span id='checkButton'>查询</span></p>
			<p><span class='label'>年份：</span>
				<select id='sel'>
				  <option>2017</option>
				  <option>2016</option>
				  <option>2015</option>
				   <option>2014</option>
				</select></p>
			<p class='typeBg'><span class='label'>类型：</span><label><input type='radio' name='searchType' value='1' checked>按月份</label><label><input type='radio' name='searchType' value='2'>按季度</label><label><input type='radio' name='searchType' value='3'>按年度</label></p>
			<div id='report'></div>
		</div>
		<div class="footer">脚部信息</div>

	</div>
<script type="text/javascript" src="js/jquery-1.11.1.min.js"></script>
<script src="js/common.js"></script>
<script src="js/highcharts.js"></script>
<script src="js/exporting.js"></script>
<script src="js/report.js"></script>
</body>
</html>