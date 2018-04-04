<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接处警查询</title>
<link rel="stylesheet" href="static/plugins/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="static/plugins/sidebar/font-awesome.min.css"/>
<link rel="stylesheet" href="static/plugins/laypage/page.css" />
<link rel="stylesheet" href="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" />
<style>
	div.container-fluid,div.row,*{
		margin:0;
		padding:0;
	}
	.table{
		margin-bottom:8px;
	}
	.table>tbody>tr>td.info{
		vertical-align: middle;
		text-align:right;
		width:8%;
		background:#fff;
	}
	.panel{
		margin-bottom:0;
	}
	#searchForm>table.table>tbody>tr>td{
		border:none;
	}
</style>
</head>
<script>
	var basePath="<%=request.getContextPath()%>";
</script>
<body>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					嫌疑人查询
				</h3>
			</div>
			<div class="panel-body">
				<form id="searchForm" action="">
					<table class="table">
						<tbody>
							<tr>
								<td class="info">姓名</td>
								<td><input name="name" type="text" value="" class="form-control"/></td>
								<td class="info">年龄</td>
								<td><input name="age" type="text" class="form-control"/></td>
								<td class="info">入狱时间</td>
								<td><input name="rysj" type="text" class="form_datetime form-control"/></td>
								<td class="info">籍贯</td>
								<td><input name="jg" type="text" class="form-control"/></td>
							</tr>
						</tbody>
					</table>
					<div class="row" style="text-align:center">
						<input type="button" class="btn btn-info" value="查询" onclick="searchData()"/>&nbsp;&nbsp;
						<input type="reset" class="btn btn-info" value="重置"/>
					</div>
				</form>
			</div>
		</div>
		
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					查询列表
				</h3>
			</div>
			<div class="panel-body">
				<table id="searchData" class="table table-bordered">
					<thead>
						<tr>
							<th>序号</th>
							<th>姓名</th>
							<th>身份证号码</th>
							<th>年龄</th>
							<th>入狱时间</th>
							<th>性别</th>
							<th>入狱原因</th>
							<th>刑期</th>
							<th>籍贯</th>
							<th>附件</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
				<!-- 开始封装 -->
		        <div id="page">
		        </div>
			</div>
		</div>
		
	</div>
	<script src="static/plugins/jquery/jquery-1.11.3.js"></script>
	<script src="static/plugins/bootstrap/bootstrap.js"></script>
	<script src="static/js/suspect/suspect_search.js"></script>
	<script src="static/plugins/laypage/laypage.js"></script>
	<script src="static/plugins/laypage/page.js"></script>
	<script src="static/plugins/layer/layer.js"></script>
	<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.js"></script>
	<script src="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.zh-CN.js"></script>
	<script>
		  $(".form_datetime").datetimepicker({
		  	format: 'yyyy-mm-dd hh:ii:ss',
		  	language:"zh-CN",
		  	minuteStep:1,
		  	minView: 0,//日期时间选择器最高能展示的选择范围视图。
		  	todayBtn : true
		  	//pickerPosition:默认值：’bottom-right’  还支持 : ‘bottom-left’，’top-right’，’top-left’
		  	//autoclose:true//选完日期自动关闭
		  });
	</script>
</body>
</html>