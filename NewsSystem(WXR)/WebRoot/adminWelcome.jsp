<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'adminindex.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  <style>
		.center{ 
		width:950px; 
		height:570px; 
		border:5px solid #4fc08d; 
		-webkit-border-radius: 20px;
		text-align:center;
		 line-height:700px;
		 }
	</style>
  </head>
  
  <body style="background: #F8F8FF;">
   <div class="center"><center><h1>新闻管理系统  欢迎您<br>
    Dear Administrator ${username}</h1></center>
  </div>
  </body>
</html>
