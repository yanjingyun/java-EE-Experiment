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
	<table width="90%" border="1" cellpadding="0" cellspacing="0">
		<tr>
			<th>编号</th>
			<th>用户名</th>
			<th>密码</th>
			<th>操作</th>
		</tr>
		<s:iterator value="listUser">
			<tr align="center">
				<td><s:property value="id"/></td>
				<td><s:property value="username"/></td>
				<td><s:property value="passwd"/></td>
				<td>
					<s:url action="user_editUI" var="editUI" >
						<s:param name="id"><s:property value="id"/></s:param>
					</s:url>
					<a href="<s:property value="#editUI" />" >编辑</a>

					&nbsp;&nbsp;

					<s:url action="user_delete" var="delete" >
    					<s:param name="id"><s:property value="id"/></s:param>
					</s:url>
					<a href="<s:property value="#delete" />" >删除</a>
				</td>
			</tr>
		</s:iterator>
	</table>
</center>
</body>
</html>