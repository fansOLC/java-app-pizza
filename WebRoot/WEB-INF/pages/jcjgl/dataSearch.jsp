<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="java.net.URLDecoder"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>接处警查询</title>
<link rel="stylesheet" href="static/plugins/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" />
<link rel="stylesheet" href="static/css/jcjgl/datasearch.css" />
<link rel="stylesheet" href="static/plugins/sidebar/font-awesome.min.css"/>
<link rel="stylesheet" href="static/plugins/laypage/page.css" />
</head>
<script>
	var basePath="<%=request.getContextPath()%>";
</script>
<body>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					接处警查询
				</h3>
			</div>
			<div class="panel-body">
				<form id="searchForm" action="">
					<table class="table">
						<tbody>
							<tr>
								<td class="info">接警单编号</td>
								<td><input name="jjdbh" type="text" value="" class="form-control"/></td>
								<td class="info">报警电话</td>
								<td><input name="bjdh" type="text" class="form-control"/></td>
								<td class="info">报警人姓名</td>
								<td><input name="bjrxm" type="text" class="form-control"/></td>
								<td class="info">接警员</td>
								<td><input name="jjy" type="text" class="form-control"/></td>
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
					接处警查询列表
				</h3>
			</div>
			<div class="panel-body">
				<table id="searchData" class="table table-bordered">
					<thead>
						<tr>
							<th>接警单编号</th>
							<th>报警时间</th>
							<th>关键字</th>
							<th>案发地址</th>
							<th>作案方式</th>
							<!-- <th>作案手段分类</th>
							<th>作案手段大类</th>
							<th>作案手段小类</th>
							<th>接警员</th> -->
							<th>报警人姓名</th>
							<th>报警人性别</th>
							<th>报警电话</th>
							<th>报警内容</th>
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
	<script src="static/js/jcjgl/datasearch.js"></script>
	<script src="static/plugins/laypage/laypage.js"></script>
	<script src="static/plugins/laypage/page.js"></script>
	<script src="static/plugins/layer/layer.js"></script>
</body>
</html>