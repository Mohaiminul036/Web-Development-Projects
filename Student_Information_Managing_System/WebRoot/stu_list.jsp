<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>Student Management System</title>

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
	<br> <h2 align = "center"> Student List</h2>
	<p align = "center"><a href = "stu_add.jsp">Add Student</a></p>
	
	<table border = "1" width = "700" align = "center">
		<tr align = "center">
			<td>Number</td>
			<td>Name</td>
			<td>Gender</td>
			<td>Age</td>
			<td>Address</td>
			<td>Operation</td>
		</tr>
		
		<c:forEach items = "${list}" var = "stu">
			<tr align = "center">
				<td>${stu.id}</td>
				<td>${stu.name}</td>
				<td>${stu.gender}</td>
				<td>${stu.age}</td>
				<td>${stu.address}</td>
				<td>
					<a href = "">Update</a>
					<a href = "">Delete</a>
				</td>
			</tr>
		</c:forEach>
	</table>

<br><p align="center"> <%=application.getAttribute("myid")%> </p>

</body>
</html>
