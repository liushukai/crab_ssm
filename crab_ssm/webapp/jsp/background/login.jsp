<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Panel - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="js/easyui/demo.css">
	<script type="text/javascript" src="js/easyui/jquery.min.js"></script>
	<script type="text/javascript" src="js/easyui/jquery.easyui.min.js"></script>
	<style type="text/css">
		body {text-align: center;}   
		#center { margin-right: auto; margain-left: auto; }   
	</style>
</head>
<body>
	<div class="easyui-panel" title="login" class="center" style="width:400px;padding:30px 60px">
		<div style="margin-bottom:20px">
			<div style="margin: 5px 0">用户名:</div>
			<input class="easyui-textbox" data-options="prompt:'Enter a username...'" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<div style="margin: 5px 0">密码:</div>
			<input class="easyui-textbox" data-options="prmpt:'Enter a passowrd'" style="width:100%;height:32px">
		</div>
		<div style="text-align:right">
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:30%;height:32px">注册用户</a>
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:30%;height:32px">登录</a>
		</div>
	</div>
</body>
</html>