<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<center>
	<br><br>
	<div>
	<h3>编辑用户</h3>
	<form action="user_edit" method="post">
		<s:hidden  name="user.id"/>
		用户名:<s:textfield id="password" name="user.username"/><br><br>
		密&nbsp;&nbsp;码:<s:textfield id="password" name="user.passwd"/><br><br>
		
		<input type="submit" value="提交">
	</form>
	</div>
</center>
</body>
</html>