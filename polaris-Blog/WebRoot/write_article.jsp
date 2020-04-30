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

<title>北极星博客|写文章|makedown</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
<link rel="stylesheet" href="editor/css/editormd.css">
<link rel="shortcut icon" href="images/建筑-北极星.png">
<script type="text/javascript">
	function doPage(){
		//获取信息
		var concat=$(".editormd-markdown-textarea").val();
		frm.concat.value=concat;
		//var title=$("#title").val();
		//var userid=$("#userid").val();
		//location="save.action?concat="+concat+"&title="+title+"&userid="+userid;
		frm.submit();
	}
</script>
</head>

<body>
	<%@ include file="checklogin.jsp" %>
	<h1>北极星|写文章</h1>
	<form action="save" name="frm" method="get">
		<input type="hidden" name="concat">
		<input type="hidden" name="userid" id="userid"
			value="<s:property value="#session.userid"/>">
		<div style="margin-left: 65px;margin-bottom: 5px">
			文章标题:<input type="text" id="title" name="title" style="width: 280px">
		</div>
		<div id="test-editormd">
			<textarea style="display:none;"></textarea>
		</div>
		<div style="">
			<input type="button" value="发布" onclick="doPage()"
				style="padding: 5px;width: 200px;border: none;background-color: #e9e7ef;display: flex;justify-content: center;">
		</div>
	</form>
	<s:debug></s:debug>
	<script src="js/jquery.min.js"></script>
	<script src="editor/editormd.min.js"></script>
	<script>
		var testEditor;
		$(function() {
			testEditor = editormd("test-editormd", {
				width : "90%",
				height : 640,
				syncScrolling : "single",
				path : "editor/lib/"
			});
		});
	</script>
</body>
</html>
