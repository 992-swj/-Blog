<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>用户注册</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/1111.jpg">
<link rel="stylesheet" href="css/list-style.css">
<link rel="shortcut icon" href="images/建筑-北极星.png">

<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	$(document).ready(function() {
		$("form[name=frm]").submit(function() {
			var flog = true;
			var pwd1 = $("#pwd1").val();
			var pwd2 = $("#pwd2").val();
			var username = $("#username").val();
			var name = $("#name").val();
			var QQ = $("#QQ").val();
			var EMIL = $("#EMIL").val();
			if (username == "" && username.length <= 0) {
				$("#uerror").html("用户名不能为空").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#uerror").html("√").css({
					"color" : "#0eb83a"
				});
			}
			if (name == "" && name.length <= 0) {
				$("#uname").html("用户名不能为空").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#uname").html("√").css({
					"color" : "#0eb83a"
				});
			}
			if (pwd1 == "" && pwd1.length <= 0) {
				$("#upwd1").html("密码不能为空").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#upwd1").html("√").css({
					"color" : "#0eb83a"
				});
			}
			if (pwd2 == "" && pwd2.length <= 0) {
				$("#upwd2").html("确认密码不能为空").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#upwd2").html("√").css({
					"color" : "#0eb83a"
				});
			}
			if (pwd2 != pwd1) {
				$("#upwd2").html("两次输入不一致").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#upwd2").html("√").css({
					"color" : "#0eb83a"
				});
			}
			
			
			if (QQ == "" && QQ.length <= 0) {
				$("#uQQ").html("QQ不能为空").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#uQQ").html("√").css({
					"color" : "#0eb83a"
				});
			}
				if (EMIL == "" && EMIL.length <= 0) {
				$("#uEMIL").html("EMIL不能为空").css({
					"color" : "red"
				});
				flog = false;
			} else {
				$("#uEMIL").html("√").css({
					"color" : "#0eb83a"
				});
			}
			
			return flog;
		});

	});
	$(document).ready(function() {
		$("#username").mouseout(function() {
			var username = $("#username").val();
			$.ajax({
				type : "post",
				 async:false,
				url : "DN.action?username=" + username,
				success : function(data) {
					$("#uerror").html("该用户名不可以使用").css({
						"color" : "red"
					});
					return false;
				},
				error : function() {
					$("#uerror").html("该用户名可以使用").css({
						"color" : "#0eb83a"
					});
				}
			});
		});
	});
</script>
</head>
<style>
* {
	font-size: 15px
}

#register {
	text-align: center;
}

table {
	margin: 0 auto;
}
</style>

<body>
	<!--strat container-->
	<div id="container">
		<!--strat header-->
		<%@ include file="header.jsp"%>
		<!--end header-->
		<div id="middle">
			<!--strat middle_left-->
			<div id="middle_left" style="width: 100%;">
				<div id="register">
					<h1>注册</h1>
					<form action="register" name="frm" method="post">
						<table>
							<tr>
								<td>loginid:</td>
								<td><input type="text" name="username" id="username" /> <span
									id="uerror"></span></td>
							</tr>
							<tr>
								<td>姓名:</td>
								<td><input type="text" name="name" id="name" /> <span
									id="uname"></span></td>
							</tr>
							<tr>
								<td>密码:</td>
								<td><input type="password" name="pwd1" id="pwd1" /> <span
									id="upwd1"></span></td>
							</tr>
							<tr>
								<td>确认密码:</td>
								<td><input type="password" name="pwd2" id="pwd2" /> <span
									id="upwd2"></span></td>
							</tr>
							<tr>
								<td>QQ:</td>
								<td>
									<input type="text" name="QQ" id="QQ" />
									<span id="uQQ"></span>
								</td>
							</tr>
							<tr>
								<td>EMIL:</td>
								<td>
									<input type="text" name="EMIL" id="EMIL" />
									<span id="uEMIL"></span>
								</td>
							</tr>
							<tr>
								<td></td>
								<td><input type="submit" value="注册"
									style="border: none;background-color: #1685a9;padding: 2px 12px;" />
									<input type="reset"
									style="border: none;background-color: #1685a9;padding: 2px 12px;" />

								</td>
							</tr>
						</table>

					</form>
				</div>
			</div>
			<!--end middle_left-->

		</div>
		<%@ include file="fotter.jsp"%>
		<!--end container-->
		</div>
</body>
</html>
