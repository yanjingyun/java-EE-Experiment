<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core_rt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'listUI.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
<body>
<center>
<br><br>
<a href="addUser.jsp">新增用户</a>
<table border="1" width="90%" cellpadding="0" cellspacing="0">
	<tr><th>编号</th><th>用户名</th><th>密码</th><th>操作</th></tr>
	<c:forEach var="user" items="${list }">
		<tr align="center">
			<td>${user.id }</td>
			<td>${user.username }</td>
			<td>${user.passwd }</td>
			<td>
				<a href="editUI.action?user.id=${user.id }" >编辑</a>
				<a href="delete.action?user.id=${user.id }" >删除</a>
			</td>
		</tr>
	</c:forEach>
</table>
</center>
</body>
</html>
