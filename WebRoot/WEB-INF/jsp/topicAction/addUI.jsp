<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<title>发表新主题</title>
		<%@ include file="/WEB-INF/jsp/public/header.jspf"%>
		<%@ include file="/WEB-INF/jsp/public/kindeditor.jspf"%>
		<link type="text/css" rel="stylesheet"
			href="${pageContext.request.contextPath}/style/blue/forum.css" />
	</head>
	<body>

		<!-- 标题显示 -->
		<div id="Title_bar">
			<div id="Title_bar_Head">
				<div id="Title_Head"></div>
				<div id="Title">
					<!--页面标题-->
					<img border="0" width="13" height="13"
						src="${pageContext.request.contextPath}/style/images/title_arrow.gif" />
					发表新主题
				</div>
				<div id="Title_End"></div>
			</div>
		</div>

		<!--显示表单内容-->
		<div id="MainArea">
			<s:form action="topic_add">
				<s:hidden name="forumId"></s:hidden>
				<div id="PageHead"></div>
				<div class="ItemBlock_Title1">
					<div width="100%" style="float: left">
						<font class="MenuPoint"> &gt; </font>
						<s:a action="forum_list">论坛</s:a>
						<font class="MenuPoint"> &gt; </font>
						<a href="javascript:history.go(-1);">${forum.name}</a>
						<font class="MenuPoint"> &gt;&gt; </font> 发表新主题
					</div>
				</div>
				<div class="ItemBlockBorder">
					<table border="0" cellspacing="1" cellpadding="1" width="100%"
						id="InputArea">
						<tr>
							<td class="InputAreaBg" height="30">
								<div class="InputTitle">
									标题
								</div>
							</td>
							<td class="InputAreaBg">
								<div class="InputContent">
									<s:textfield  name="title" cssClass="InputStyle"
										cssStyle="width: 100%" />
								</div>
							</td>
						</tr>
						<tr height="200">
							<td class="InputAreaBg">
								<div class="InputTitle">
									内容
								</div>
							</td>
							<td class="InputAreaBg">
								<div class="InputContent">
									<s:textarea name="content" cols="120" rows="10"></s:textarea>
								</div>
							</td>
						</tr>
						<tr height="30">
							<td class="InputAreaBg" colspan="2" align="center">
								<input type="image" src="${pageContext.request.contextPath}/style/images/save.png"/>
								<a href="javascript:history.go(-1);"><img
										src="${pageContext.request.contextPath}/style/blue/images/button/goBack.png" />
								</a>
							</td>
						</tr>
					</table>
				</div>
			</s:form>
		</div>

		<div class="Description">

		</div>

	</body>
</html>
