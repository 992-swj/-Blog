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
<script src="js/jquery.min.js"></script>
<link rel="shortcut icon" href="images/1111.jpg">
<link rel="stylesheet" href="css/list-style.css">
<link rel="shortcut icon" href="images/建筑-北极星.png">
</head>
<script type="text/javascript">
	function doPage(num){
		frm.pageIndex.value=num;
		frm.submit();
	}
	$(document).ready(function(){
		$(".contentcuts").each(function(index,item) {
			var s=$(this).html();
			console.log(s);
			if(s.length>=20){
				$(this).html(s.substring(0, 20)+".......");
			}
		});
	});
	
</script>

<body>
	<!--strat container-->
	<div id="container">
		<!--strat header-->
		<%@ include file="header.jsp"%>
		<!--end header-->
		<div id="middle">
			<!--strat middle_left-->
			<div id="middle_left">
				<strong>全部文章</strong>
				<hr>
				<form
					action="userlistarticle.action"
					name="frm" method="post">
					<input type="hidden" value="<s:property value="userid"/>" name="userid">
					<input type="hidden" value="" name="pageIndex">
					<div style="line-height: 30px">
						<s:iterator value="list" var="a">
							<strong><s:property value="#a.title" /></strong>
							<p>
								<s:date name="#a.pubdate" format="yyyy-MM-dd" />
							</p>
							<div>
								<span class="contentcuts"><s:property
										value="#a.articlecontent" /></span>
							</div>
							<a
								href="concat.action?articleid=<s:property value="#a.articleid" />">》》阅读全文</a>
							<div class="clicksorcomments" style="display: flex;justify-content: flex-end;">
								点击量：
								<s:property value="#a.clicks" />
								评论：
								<s:property value="#a.comments" />
								
							</div>
							<hr>
						</s:iterator>
					</div>
					<div id="paging">
						<!--分页-->
						<span>第<s:property value="pageIndex" />页/共<s:property
								value="map.SumIndex" />页，转到
						</span> <a href="javascript:doPage(<s:property value="map.prev"/>)">上一页</a>
						<a href="javascript:doPage(<s:property value="map.next"/>)">下一页</a>
						<input type="text" name="Specify" style="width: 30px;"><input type="submit" value="GO" />
					</div>
				</form>
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
	<script src="js/snowflakes.min.js"></script>
    <script src="js/index.js"></script>
</body>
</html>
