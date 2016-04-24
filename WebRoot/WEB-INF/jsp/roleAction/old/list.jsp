<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>  
    <title>全部岗位</title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
		<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
  <body>
    <s:iterator value="roleList">
    	<s:property value="id"/>
    	<s:property value="name"/>
    	<s:property value="description"/>
    	<s:a action="role_editUI?id=%{id}">修改</s:a> 
    	<s:a action="role_delete?id=%{id}" onclick="return confirm('确定要删除？')">删除</s:a> 
    	<br/>
    </s:iterator>
    <s:a action="role_addUI">添加</s:a>
  </body>
</html>
