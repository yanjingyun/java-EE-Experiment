<%@ page language="java" pageEncoding="UTF-8"%>
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
	<br>
	<br>
	<div>登录界面</div>
	<div><font color="red">${msg }</font></div>
	<form action="user_login.action" method="post">
		用户名:<input type="text" name="user.username"><br><br>
		密&nbsp;&nbsp;码:<input type="password" name="user.passwd"><br><br>
		<input type="submit" value="提交">
	</form>
	<br>
	<br>
	<a href="user_listUI.action">得到全部用户</a>
</center>
</body>
</html>