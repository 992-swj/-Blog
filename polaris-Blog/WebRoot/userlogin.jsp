<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<s:if test="#session.jurisdiction != null ">
	
	<div>
		<strong>用户登录|Login</strong>
		<hr>
		欢迎你,
		<s:property value="#session.username" />
		<ul>
			<s:iterator value="#session.jurisdiction" var="a">
				<li><a
					href="<s:property value="#a.urls"/>?userid=<s:property value="#session.userid"/>"><s:property
							value="#a.jname" /></a></li>
			</s:iterator>
		</ul>
		<button onclick="exit()"
			style="background: url(images/exitlogin.jpg) no-repeat;width: 73px;height: 23px;border: none;"></button>
	</div>
	
	<script type="text/javascript">
		function exit() {
			location.href = 'exit.action';
		}
	</script>
</s:if>
<s:else>
	<div>
		<strong>用户登录|Login</strong>
		<hr>
		<form action="login.action" method="POST">
			<table>
				<tr>
					<td><label for="">用户名:</label></td>
					<td><input type="text" name="loginid" id=""><br></td>
				</tr>
				<tr>
					<td><label for="">密码:</label></td>
					<td><input type="password" name="loginpwd" id=""><br></td>
				</tr>
				<tr>
					<td></td>
					<td><input type="submit" value="">
						<a href="register.jsp">
										<img alt="" src="images/222.jpg" style="border: none;height: 17px;">
									</a>
						</td>
					
				</tr>
			</table>
		</form>
	</div>
</s:else>