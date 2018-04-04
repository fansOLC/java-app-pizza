<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>详情页</title>
<link rel="stylesheet" href="static/plugins/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="static/css/jcjgl/dataRegister.css" />
<link rel="stylesheet" href="static/plugins/select-plugin/bootstrap-select.css" />
<link rel="stylesheet" href="static/plugins/bootstrap-datetimepicker/bootstrap-datetimepicker.min.css" />
</head>
<script type="text/javascript">
	var basePath='<%=request.getContextPath()%>';
	
</script>
<body>
	<div class="container-fluid">
		<div class="panel panel-default">
			<div class="panel-heading">
				<h3 class="panel-title">
					警情基本信息
				</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<form id="dataForm" action="dataRegister" method="post">
						<table class="table">
						    <tbody>
						    	<tr>
						    		<td class="info">接警单编号</td>
						    		<td><p class="jjdbh"></p></td>
						    		<td class="info">被骗总金额</td>
						    		<td><p class="bpzje"></p></td>
						    	</tr>
						    	<tr>
						    		<td class="info">作案方式</td>
						    		<td>
						    			<p class="zafs"></p>
						    		</td>
						    		<td class="info">作案手段分类</td>
						    		<td>
										<p class="zasdfl"></p>
									</td>
						    	</tr>
						    	<tr>
						    		<td class="info">作案手段大类</td>
						    		<td>
						    			<p class="zasddl"></p>
						    		</td>
						    		<td class="info">作案手段小类</td>
						    		<td>
										<p class="zasdxl"></p>
									</td>
						    	</tr>
						    	<tr>
						    		<td class="info">关键字</td>
						    		<td><p class="gjz"></p></td>
						    		<td class="info">报警时间</td>
						    		<td><p class="bjsj"></p></td>
						    	</tr>
						    	<tr>
						    		<td class="info">接警员</td>
						    		<td><p class="jjy"></p></td>
						    		<td class="info">报警电话</td>
						    		<td><p class="bjdh"></p></td>
						    	</tr>
						    	<tr>
						    		<td class="info">报警人姓名</td>
						    		<td><p class="bjrxm"></p></td>
						    		<td class="info">报警人性别</td>
						    		<td><p class="bjrxb"></p></td>
						    	</tr>
						    	<tr>
						    		<td class="info">单位</td>
						    		<td><p class="dw"></p></td>
						    		<td class="info">案发地址</td>
						    		<td><p class="afdz"></p></td>
						    	</tr>
						    	<tr style="border-bottom:1px solid #eee;">
						    		<td class="info">报警内容</td>
						    		<td colspan="3"><p class="bjnr"></p></td>
						    	</tr>
						    </tbody>
					</table>
				</div>
				</form>		
			</div> 
		</div>
	</div>
	<script src="static/plugins/jquery/jquery-1.11.3.js"></script>
	<script src="static/js/jcjgl/dataDetail.js"></script>
	<script>
		var id=${infoId};
		
	</script>
</body>
</html>