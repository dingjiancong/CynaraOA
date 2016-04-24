<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<script language="JavaScript" src="${pageContext.request.contextPath}/script/menu.js"></script>
<%@ include file="/WEB-INF/jsp/public/header.jspf"%>
<link type="text/css" rel="stylesheet" href="${pageContext.request.contextPath}/style/blue/menu.css" />
</head>
<body style="margin: 0">
<div id="Menu">
 	<%-- 一级 --%>
    <ul id="MenuUl">
    <s:iterator value="#application.topPrivilegeList">
    	<s:if test="#session.user.hasPrivilegeByName(name)">
	        <li class="level1">
	            <div onClick="$(this).next().toggle()" class="level1Style">
	            	<img src="${pageContext.request.contextPath}/style/images/MenuIcon/${id}.gif" class="Icon" />
	            	${name}
	            </div>
	             <%-- 二级 --%>
	            <ul style="display: none;" class="MenuLevel2">
		            <s:iterator value="childs">
		            	<s:if test="#session.user.hasPrivilegeByName(name)">
			                <li class="level2">
			                    <div class="level2Style">
			                    	<img src="${pageContext.request.contextPath}/style/images/MenuIcon/menu_arrow_single.gif" /> 
			                    	<%-- 这里不要使用 s:a标签--%>
									<a href="${pageContext.request.contextPath}${url}.do" target="right">${name}</a> 
								</div>
			                </li>
		                </s:if>
		            </s:iterator>
	           </ul>
	        </li>
        </s:if>
       </s:iterator>
    </ul>
</div>
</body>
</html>
