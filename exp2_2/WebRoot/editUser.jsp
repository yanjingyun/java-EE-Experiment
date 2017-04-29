<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
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
   		<h3>修改用户</h3>
   		<form action="editUser2" method="post">
   			<input type="hidden" name="id" value="${user.id }">
   			用户名:<input type="text" name="username" value="${user.username }"><br><br>
   			密码：<input type="text" name="passwd" value="${user.passwd }"><br><br>
   			<input type="submit" value="提交">
   		</form>
   
   </center>
  </body>
</html>
