<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<title>的客圈 | 登录</title>
<!-- Tell the browser to be responsive to screen width -->
<meta
	content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no"
	name="viewport">
<!-- Bootstrap 3.3.5 -->
<link rel="stylesheet" href="/css/bootstrap.min.css">
<!-- Font Awesome -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.5.0/css/font-awesome.min.css">
<!-- Ionicons -->
<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/ionicons/2.0.1/css/ionicons.min.css">
<!-- Theme style -->
<link rel="stylesheet" href="/css/AdminLTE.min.css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
<script type="text/javascript" src="/js/jQuery-2.2.0.min.js"></script>
<script type="text/javascript" src="/js/myAjax.js"></script>
<script type="text/javascript">	
	$(function() {
		alert("hello jquery!")
		$("#login-button").click(function() {
			login();
		});
	});
	
 	//登录测试
	function login(thisObj) {
		var partUrl = "/v1/user/backstage/login";
		var partMethod = "post";
		var partParams = {};
		var partAccount = $("input[name='account']");
		var partPassword = $("input[name='password']");
		console.info("account:" + partAccount.size());
		console.info("password:" + partPassword.size());
		partParams["account"] = partAccount.val();
		partParams["password"] = partPassword.val();
		console.info("params:" + partParams);
		$.login(partUrl, partParams, partMethod);
	}
</script>
  
</head>
<body class="hold-transition login-page">

	<div class="login-box">
		<div class="login-logo">
			<a href="javascript(0);"><b>的客圈</b>DKQ</a>
		</div>
		<!-- /.login-logo -->
		<div class="login-box-body">
			<p class="login-box-msg">用户登录</p>
			<form id="login-form" action="javascript(0);" method="post">
				<div class="form-group has-feedback">
					<input name="account" type="email" class="form-control" placeholder="Email">
					<span class="glyphicon glyphicon-envelope form-control-feedback"></span>
				</div>
				<div class="form-group has-feedback">
					<input name="password" type="password" class="form-control" placeholder="Password">
					<span class="glyphicon glyphicon-lock form-control-feedback"></span>
				</div>
				<div class="row">
					<div class="col-xs-6"></div>
					<!-- /.col -->
					<div class="col-xs-6">
						<button id="login-button" type="button" class="btn btn-primary btn-block btn-flat">Sign
							In</button>
					</div>
					<!-- /.col -->
				</div>
			</form>
		</div>
</body>
</html>