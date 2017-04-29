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
    
    <title>My JSP 'Show.jsp' starting page</title>
    
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
<a href="insert.jsp">插入用户</a><br>
<table border="1" width="90%" cellpadding="0" cellspacing="0">
	<tr align="center">  
		<td>编号</td>
		<td>用户名</td>
		<td>年龄</td>
		<td>操作</td>
	</tr>
	 <c:forEach items="${list}" var="stu">
	 	<tr align="center">
			<td>${stu.stuId }</td>
			<td>${stu.stuName }</td>
			<td>${stu.stuAge }</td>
			<td>
				<a href="getStuServlet?id=${stu.stuId }">编辑</a>
				&nbsp&nbsp
				<a href="deleteStuServlet?id=${stu.stuId }">删除</a>
			</td>
		</tr>
	 </c:forEach>
</table>
    
</center>    
  </body>
</html>
