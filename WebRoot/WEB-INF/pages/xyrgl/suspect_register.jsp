<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>嫌疑人资料</title>
<link rel="stylesheet" href="static/plugins/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="static/css/jcjgl/suspect_register.css" />
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
					嫌疑人基本信息
				</h3>
			</div>
			<div class="panel-body">
				<div class="table-responsive">
					<form id="dataForm" action="dataRegister" method="post">
						<table class="table">
						    <tbody>
						    	<tr>
						    		<td class="info">姓名</td>
						    		<td><input name="xm" type="text" class="form-control" required/></td>
						    		<td class="info">身份证号</td>
						    		<td><input name="sfzh" type="text" class="form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">年龄</td>
						    		<td><input name="nl" type="text" class="form-control"/></td>
						    		<td class="info">入狱时间</td>
						    		<td><input name="rysj" type="text" readonly class="form_datetime form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">性别</td>
						    		<td><select name="xb" class="selectpicker show-tick"  data-width="65%">
						    				<option value="男">男</option>
						    				<option value="女">女</option>
						    			</select>
						    		</td>
						    		
						    		<td class="info">入狱原因</td>
						    		<td><input name="ryyy" type="text" class="form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">刑期</td>
						    		<td><input name="xq" type="text" class="form-control"/></td>
						    		<td class="info">籍贯</td>
						    		<td><input name="jg" type="text" class="form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">附件</td>
						    		<td><input name="file" type="file" class="form-control"/></td>
						    	</tr>
						    </tbody>
					</table>
				</div>
				<div class="row">
					<div class="col-md-4 col-md-offset-4 center">
						<input type="button" class="btn btn-info" onclick="addInfo(this)" value="提交"/>
						<input type="reset" class="btn btn-warning" value="重置"/>
					</div>
				</div>
				</form>		
			</div> 
		</div>
	</div>
	<script src="static/plugins/jquery/jquery-1.11.3.js"></script>
	<script src="static/plugins/bootstrap/bootstrap.js"></script>
	<script src="static/plugins/select-plugin/bootstrap-select.js"></script>
	<script src="static/js/suspect/suspect_add.js"></script>
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