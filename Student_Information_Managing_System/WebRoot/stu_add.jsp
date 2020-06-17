<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'login.jsp' starting page</title>
    
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
  
    <h2>Welcome to CQUST Student Management System! </h2><br>
    <form action="addStudent" method = "post">
    
    	Name:<br><input type = "text" name= "name" maxlength = "20" style = "width:150px"/><br><br>
    	
    	Age:<br><input type = "text" name= "age" style = "width:60px"/><br><br>
    
    	Gender:<br><input type = "text" name= "gender" maxlength = "6" style = "width:60px"/><br><br>
    
    	Address:<br><input type = "text" name= "address" maxlength = "30" style = "width:200px"/><br><br>
    
    	<input type = "submit" value = "Add"/>
    
    </form>
    
   
   <br>
   
   
   ${applicationScope.myid}
     
    
  </body>
</html>
