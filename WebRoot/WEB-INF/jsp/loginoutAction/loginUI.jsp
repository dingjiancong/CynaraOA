<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html lang="en">

<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>登录页面</title>
<link rel="icon" href="${pageContext.request.contextPath}/style/icon.ico"  type="image/x-icon"> 
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/style.css" />
<SCRIPT type="text/javascript">
	if(window.parent != window){
		window.parent.location.href = window.location.href;
	}
	
</SCRIPT>
</head>

<body bgcolor="#CFCFCF">
<br><br><br><br><br><br><br>
<div class="loginform cf">
	<form action="${pageContext.request.contextPath}/loginOut_login.do" method="post">
		<ul>
			<li><label for="loginName">用户名:</label>
			<input type="text" name="loginName" placeholder="UserName" value="test"></li>
			<li><label for="password">密码:</label>
			<input type="password" name="password" placeholder="Password" value="1234"></li>
			<li><input type="submit" value="Login"> </li>
		</ul>
	</form>
</div>
<br><br><br><br><br><br><br>
	<div align="center" ID="CopyRight">&copy;2016 版权所有 Cynara</div>
</body>

</html>