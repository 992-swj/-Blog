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

<title>文章内容</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">

<link rel="stylesheet" href="css/style.css">
<script src="js/jquery.min.js"></script>
<link rel="shortcut icon" href="images/1111.jpg">
<link rel="stylesheet" href="css/article_link.css">
<link rel="shortcut icon" href="images/建筑-北极星.png">
<link rel="stylesheet" href="editor/css/editormd.css">
<link rel="stylesheet" href="util/prism.css">
 <script src="util/prism.js"></script>
<link rel="stylesheet" href="css/editormd.preview.min.css">
</head>
<script type="text/javascript">
	$(document).ready(function(){
		$("form[name=frm]").submit(function(){
			var flog=true;
			var postcomment=$("textarea[name=postcomment]").val();
			var username=$("#username").val();
			if(username=="" && username.length<=0){
				console.log("username："+username);
				$(".uerror").html("用户名不能为空").css({"color":"red"});
				flog=false;
			}else{
				$(".uerror").html("√").css({"color":"#0eb83a"});
			}
			if(postcomment=="" && postcomment.length<=0){
				console.log("postcomment："+postcomment);
				$(".upostcomment").html("评论内容不能为空").css({"color":"red"});
				flog=false;
			}else{
				$(".upostcomment").html("√").css({"color":"#0eb83a"});
			}
			return flog;
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
				<strong>文章内容</strong>
				<hr>
				<!--文章内容-->
                <div id="article">
                    <div style="margin:  15px 0;overflow:hidden;">
                    	<strong id="Quote"><s:property value="articles.title"/></strong>
                    	<hr>
                    	<div id="editormd-view" style="width: 96%;" class="markdown-body editormd-html-preview">
                    		${articles.articlecontent}
                    	</div>
                    </div>
                    <div>
                        <strong id="Quote">访客评论</strong>
                        <hr>
                        <ul>
                        <s:iterator value="comments" var="c">
                            <li>
                                <p><s:property value="#c.commentcontent"/></p>
                                <p>昵称:<s:property value="#c.authorname"/>,<s:date name="#c.pubdate" format="yyyy-MM-dd hh:ss:mm"/></p>
                            </li>
                            </s:iterator>
                        </ul>
                    </div>
                    <div>
                        <strong id="Quote">发表评论</strong>
                        <hr>
                        <form action="article_comment.action" name="frm" method="post">
                        <input type="hidden" name="articleid" value="<s:property value="articleid"/>">
                        <table>
                            <tr>
                                <td>昵称:</td>
                                <td><input type="text" name="username" id="username">
                                	<span class="uerror" style="color:red;"></span>
                                </td>
                            </tr>
                            <tr>
                                <td>评论内容:</td>
                                <td><textarea name="postcomment" id="" cols="60" rows="3"></textarea>
                                	<span class="upostcomment" style="color:red;"></span>
                                </td>
                            </tr>
                            <tr>
                                <td><input type="submit" value="评论" style="width: 60px;">
                                <td><input type="reset"style="width: 60px;"></td>
                            </tr>
                        </table>
                        </form>
                    </div>
                </div>
				
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
	<script src="editor/editormd.min.js"></script>
</body>
</html>
