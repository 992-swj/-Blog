<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<div>
	<strong>用户列表|Users Line</strong>
	<hr>
	<ul>
		<!--<s:iterator value="#session.infos" var="a">
			<li><a href="userlistarticle.action?userid=<s:property value="#a.userid" />"><s:property value="#a.loginid" /></a></li>
		</s:iterator>-->
		<s:iterator value="infos" var="a">
			<li><a href="userlistarticle.action?userid=<s:property value="#a.userid" />"><s:property value="#a.loginid" /></a></li>
		</s:iterator>
	</ul>
</div>