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
	<div><font color="red">${msg }</font></div>
	<form action="login" method="post">
		用户名:<input type="text" name="username"><br><br>
		密&nbsp;&nbsp;码:<input type="password" name="passwd"><br><br>
		<input type="submit" value="提交">
	</form>
</center>
</body>
</html>