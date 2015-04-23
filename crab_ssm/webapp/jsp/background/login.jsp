<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>  
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<script type="text/javascript">
	$(document).ready(function(){
		//添加页面按键事件
		$("body").keypress(function(event){
			event = event?event:window.event;
			if(event.keyCode==13)
			{
				$("#loginForm").submit();
			}
		});
		//添加按钮提交事件
		$("#submit").click(function(event){
			
			$("#loginForm").submit();
		});
	});
	</script>
</head>
<body>
	<c:url value="/login" var="loginUrl"/>
	<c:if test="${param.error != null}">
		<p>
			Invalid username and password.
		</p>
	</c:if>
	<c:if test="${param.logout != null}">
		<p>
			You have been logged out.
		</p>
	</c:if>

	<form id="loginForm" action="${loginUrl}" method="post">
	<div class="easyui-panel" title="login" class="center" style="width:400px;padding:30px 60px">
		<div style="margin-bottom:20px">
			<div style="margin: 5px 0">用户名:</div>
			<input name="username" class="easyui-textbox" data-options="prompt:'Enter a username...'" style="width:100%;height:32px">
		</div>
		<div style="margin-bottom:20px">
			<div style="margin: 5px 0">密码:</div>
			<input name="password" class="easyui-textbox" data-options="prompt:'Enter a passowrd...'" style="width:100%;height:32px">
		</div>
		<div style="text-align:right">
			<input type="hidden"  name="${_csrf.parameterName}"  value="${_csrf.token}"/>
			<a href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:30%;height:32px">注册用户</a>
			<a id="submit" href="#" class="easyui-linkbutton" iconCls="icon-ok" style="width:30%;height:32px">登录</a>
		</div>
	</div>
	</form>
</body>
</html>