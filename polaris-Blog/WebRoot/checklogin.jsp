<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<script type="text/javascript">
	var userid = '${session.userid}';
	if (userid == null || userid == "") {
		alert("请登录");
		location.href = 'getuserinfo';
	}
</script>
