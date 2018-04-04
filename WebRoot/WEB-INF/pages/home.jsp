<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首页</title>
<link rel="stylesheet" href="static/plugins/bootstrap/bootstrap.min.css" />
<link rel="stylesheet" href="static/plugins/sidebar/font-awesome.min.css"/>
<link rel="stylesheet" href="static/plugins/sidebar/sidebar-menu.css"/>
<link rel="stylesheet" href="static/css/home/home.css" />
</head>
<body>
	<!-- 网页顶部  start-->
	<div id="top" class="container-fluid">
		<div class="row">
			<div class="col-md-4"></div>
			<div class="col-md-4 center">Welcome！</div>
			<div class="col-md-4 text-right">
				你好，<span class="username">${userInfo.userName} </span><a class="btn btn-info" href="logout">注销</a>
			</div>
		</div>
	</div>
	<!-- 网页顶部 end -->
	
	<!-- 左侧导航栏 start -->
   <aside class="main-sidebar">
	<section  class="sidebar">
		<ul class="sidebar-menu">
		  <li class="header">主导航</li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-pencil-square-o"></i> <span>接警组</span> <!-- <i class="fa fa-pencil-square-o pull-right"> --></i>
			  <i class="fa fa-angle-right pull-right"></i>	
			</a>
			<ul class="treeview-menu">
			  <li><a href="data_register" target="parentContainer"><i class="fa fa-circle-o"></i>接处警登记</a></li>
			  <li><a href="data_search" target="parentContainer"><i class="fa fa-circle-o"></i>接处警查询</a></li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-files-o"></i>
			  <span>布局选项</span>
			  <span class="label label-primary pull-right">4</span>
			</a>
			<ul class="treeview-menu" style="display: none;">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 顶部导航</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 盒子布局</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 固定布局</a></li>
			  <li class=""><a href="#"><i class="fa fa-circle-o"></i> 折叠侧边栏</a>
			  </li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-pencil-square-o"></i> <span>嫌疑人资料</span>
			  <i class="fa fa-angle-right pull-right"></i>	
			</a>
			<ul class="treeview-menu">
			  <li><a href="suspect_register" target="parentContainer"><i class="fa fa-circle-o"></i>登记</a></li>
			  <li><a href="suspect_search" target="parentContainer"><i class="fa fa-circle-o"></i>查询</a></li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-pie-chart"></i>
			  <span>图表</span>
			  <i class="fa fa-angle-right pull-right"></i>
			</a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> ChartJS</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> Morris</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> Flot</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> Inline charts</a></li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-laptop"></i>
			  <span>UI 元素</span>
			  <i class="fa fa-angle-right pull-right"></i>
			</a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 一般</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> Icons图标</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 按钮</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 滑块</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 时间表</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 模态框</a></li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-edit"></i> <span>表单</span>
			  <i class="fa fa-angle-right pull-right"></i>
			</a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 一般表单</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 高级表单</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 可编辑表单</a></li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-table"></i> <span>表格</span>
			  <i class="fa fa-angle-right pull-right"></i>
			</a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 简单表格</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 时间表格</a></li>
			</ul>
		  </li>
		  <li>
			<a href="#">
			  <i class="fa fa-calendar"></i> <span>日历</span>
			  <small class="label pull-right label-danger">3</small>
			</a>
		  </li>
		  <li>
			<a href="#">
			  <i class="fa fa-envelope"></i> <span>邮箱</span>
			  <small class="label pull-right label-warning">12</small>
			</a>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-folder"></i> <span>实例</span>
			  <i class="fa fa-angle-right pull-right"></i>
			</a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 清单</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 简况</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 登录</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 注册</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 锁频</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 404 错误</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 500 错误</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 空白页面</a></li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 自适应页面</a></li>
			</ul>
		  </li>
		  <li class="treeview">
			<a href="#">
			  <i class="fa fa-share"></i> <span>多级</span>
			  <i class="fa fa-angle-right pull-right"></i>
			</a>
			<ul class="treeview-menu">
			  <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
			  <li>
				<a href="#"><i class="fa fa-circle-o"></i> 一级 <i class="fa fa-angle-right pull-right"></i></a>
				<ul class="treeview-menu">
				  <li><a href="#"><i class="fa fa-circle-o"></i> 二级</a></li>
				  <li>
					<a href="#"><i class="fa fa-circle-o"></i> 二级 <i class="fa fa-angle-right pull-right"></i></a>
					<ul class="treeview-menu">
					  <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
					  <li><a href="#"><i class="fa fa-circle-o"></i> 三级</a></li>
					</ul>
				  </li>
				</ul>
			  </li>
			  <li><a href="#"><i class="fa fa-circle-o"></i> 一级</a></li>
			</ul>
		  </li>
		  <li><a href="getFileUploadPage" target="parentContainer"><i class="fa fa-book"></i> <span>文件管理</span></a></li>
		  <li class="header">标签</li>
		  <li><a href="#"><i class="fa fa-circle-o text-red"></i> <span>重要</span></a></li>
		  <li><a href="#"><i class="fa fa-circle-o text-yellow"></i> <span>警告</span></a></li>
		  <li><a href="#"><i class="fa fa-circle-o text-aqua"></i> <span>通知</span></a></li>
		</ul>
	  </section>
 </aside>
 <div id="right">
 	<iframe name="parentContainer" width="100%" height="100%"></iframe>
 </div>
	<!-- 左侧导航栏 end -->
	
	<script src="static/plugins/jquery/jquery-1.11.3.js"></script>
	<script src="static/plugins/bootstrap/bootstrap.js"></script>
	<script src="static/plugins/sidebar/sidebar-menu.js"></script>
	<script>
		$.sidebarMenu($('.sidebar-menu'));
	</script>
</body>
</html>