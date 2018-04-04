<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>警情基本信息</title>
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
						    		<td><input name="jjdbh" type="text" class="form-control" required/></td>
						    		<td class="info">被骗总金额</td>
						    		<td><input name="bpzje" type="text" class="form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">作案方式</td>
						    		<td>
						    			<select id="zafs" name="zafs" class="selectpicker show-tick"  data-width="65%">
										</select>
						    		</td>
						    		<td class="info">作案手段分类</td>
						    		<td>
										<select id="zpsdfl" name="zasdfl" class="selectpicker show-tick" data-size="10" data-live-search="true"  data-width="65%">
										</select>
									</td>
						    	</tr>
						    	<tr>
						    		<td class="info">作案手段大类</td>
						    		<td>
						    			<select id="zpsddl" name="zasddl" class="selectpicker show-tick"  data-width="65%">
										</select>
						    		</td>
						    		<td class="info">作案手段小类</td>
						    		<td>
										<select id="zpsdxl" name="zasdxl" class="selectpicker show-tick"  data-width="65%">
										</select>
									</td>
						    	</tr>
						    	<tr>
						    		<td class="info">关键字</td>
						    		<td><input name="gjz" type="text" class="form-control"/></td>
						    		<td class="info">报警时间</td>
						    		<td><input name="bjsj" type="text" readonly class="form_datetime form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">接警员</td>
						    		<td><input name="jjy" type="text" class="form-control"/></td>
						    		<td class="info">报警电话</td>
						    		<td><input name="bjdh" type="text" class="form-control"/></td>
						    	</tr>
						    	<tr>
						    		<td class="info">报警人姓名</td>
						    		<td><input name="bjrxm" type="text" class="form-control"/></td>
						    		<td class="info">报警人性别</td>
						    		<td><select name="bjrxb" class="selectpicker show-tick"  data-width="65%">
						    				<option value="男">男</option>
						    				<option value="女">女</option>
						    			</select>
						    		</td>
						    	</tr>
						    	<tr>
						    		<td class="info">单位</td>
						    		<td><input name="dw" type="text" class="form-control"/></td>
						    		<td class="info">案发地址</td>
						    		<td><input name="afdz" type="text" class="form-control"/></td>
						    	</tr>
						    	<tr style="border-bottom:1px solid #eee;">
						    		<td class="info">报警内容</td>
						    		<td colspan="3"><textarea name="bjnr" style="resize:none" class="form-control" rows="3"></textarea></td>
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
	<script src="static/js/jcjgl/dataRegister.js"></script>
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