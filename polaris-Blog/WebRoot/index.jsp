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
<title>北极星博客|首页</title>
<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<script src="js/wheel.js"></script>
<link rel="stylesheet" href="css/whell.css">
<link rel="shortcut icon" href="images/建筑-北极星.png">

<script type="text/javascript">
	function doPage(num) {
		frm.pageIndex.value = num;
		frm.submit();
	}
	function exit() {
		location.href = 'exit.action';
	}
</script>
</head>

<body>
	<!--strat container-->
	<div id="container">
		<!--strat header-->
		<%@ include file="header.jsp"%>
		<!--轮播-->
		<div style="width: 900px;">
			<!-- 开始轮播 -->
			<div class="banner">
				<div class="img-wrap">
					<ul>
						<s:iterator value="top5" var="t5">
							
							<li class="item" style="display: block">
								<a href="concat.action?articleid=<s:property value="#t5.articleid" />"> 
									<img src="holder.js/900x300?random=yes&text=<s:property value="#t5.title"/> \n 
										<s:date name="#t5.pubdate" format="yyyy-MM-dd HH:mm"/> \n 
										 点击量:<s:property value="#t5.clicks"/>" />
								</a>
							</li>
						</s:iterator>
					</ul>
				</div>
				<div class="lr-tab">
					<div class="left btn"></div>
					<div class="right btn"></div>
				</div>
				<div class="tab-btn">
					<ul>
						<li class="btn"></li>
						<li class="btn"></li>
						<li class="btn"></li>
						<li class="btn"></li>
						<li class="btn"></li>
					</ul>
				</div>
			</div>
			<!-- 结束轮播 -->
		</div>
		<!--end header-->
		<div id="middle">
			<!--strat middle_left-->
			<div id="middle_left">
				<strong>全部文章</strong>
				<hr>
				<form name="frm" action="getuserinfo" method="post">
					<input type="hidden" name="pageIndex">
					<ul>
						<s:iterator value="list" var="a">
							<li><a
								href="concat.action?articleid=<s:property value="#a.articleid" />"><s:property
										value="#a.title" /></a> <span><s:property
										value="#a.userInfo.username" /></span> <span><s:date
										name="#a.pubdate" format="yyyy-MM-dd" /></span></li>
						</s:iterator>
					</ul>

					<div id="paging">
						<!--分页-->
						<a href="javascript:doPage(<s:property value="map.prev"/>)">上一页</a>
						<a href="javascript:doPage(<s:property value="map.next"/>)">下一页</a>
						<span>第<s:property value="pageIndex" />页/共<s:property
								value="map.SumIndex" />页，转到
						</span> <input type="text" name="Specify" style="width: 30px;"> <input
							type="submit" value="GO" />
					</div>
				</form>
			</div>
			<!--end middle_left-->

			<!--strat middle_right-->
			<div id="middle_right">
				<s:action name="userall" namespace="/" executeResult="true"></s:action>
				<%@ include file="userlogin.jsp"%></div>
			<!--end middle_right-->
		</div>
		<%@ include file="fotter.jsp"%>
	</div>
	<!--end container-->
			
	<script src="js/snowflakes.min.js"></script>
    <script src="js/index.js"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/holder/2.9.6/holder.min.js"></script>

</body>
</html>
