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

<title>用户文章列表</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/style.css">
<link rel="shortcut icon" href="images/1111.jpg">
<link rel="stylesheet" href="css/list-style.css">
<link rel="shortcut icon" href="images/建筑-北极星.png">
</head>

<body>
	<!--strat container-->
	<div id="container">
		<!--strat header-->
		<%@ include file="header.jsp"%>
		<!--end header-->
		<div id="middle">
			<!--strat middle_left-->
			<div id="middle_left">
				<table width="90%">
					<thead
						style="color:white;background-color: #4A3C8C;line-height: 35px;">
						<tr>
							<th>编号</th>
							<th>用户名称</th>
							<th>QQ</th>
							<th>邮箱</th>
							<th>操作</th>
						</tr>
					</thead>
					<tbody
						style="background-color: #E7E7FF;line-height: 25px;text-align: center;">
						<s:iterator value="list" var="a">
							<tr>
								<td><s:property value="#a.userid" /></td>
								<td><s:property value="#a.username" /></td>
								<td><s:property value="#a.QQ" /></td>
								<td><s:property value="#a.mail" /></td>
								<td><a
									href="delAllUser?userid=<s:property value="#a.userid"/>"
									onclick="return confirm('是否删除')">删除</a></td>
							</tr>
						</s:iterator>
					</tbody>
				</table>
			</div>
			<!--end middle_left-->

			<!--strat middle_right-->
			<div id="middle_right">
				<%--@ include file="userlist.jsp"--%>
				<s:action name="userall" namespace="/" executeResult="true"></s:action>
				<%@ include file="userlogin.jsp"%></div>
			<!--end middle_right-->
		</div>
		<%@ include file="fotter.jsp"%>
	</div>
	<!--end container-->
	<script src="js/jquery.min.js"></script>
</body>
</html>
