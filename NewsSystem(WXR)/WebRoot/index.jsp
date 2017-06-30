<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻管理系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="adminNeed/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="adminNeed/stylesheets/theme.css">
    <link rel="stylesheet" href="adminNeed/lib/font-awesome/css/font-awesome.css">

    <script src="adminNeed/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

    <frameset rows="0,*" border="1">
    	<frame></frame>
    	<frameset cols="20%,*">
    		<frame  src="news.jsp" name="LeftFrame"></frame>
    		<frame src="Welcome.jsp" name="RightFrame"></frame>
    	</frameset>
    </frameset>
  </head>
  
  <body>
  </body>
</html>
