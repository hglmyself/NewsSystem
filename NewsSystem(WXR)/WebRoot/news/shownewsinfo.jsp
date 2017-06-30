<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
request.setCharacterEncoding("utf-8");
response.setCharacterEncoding("utf-8");
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'addnews.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/adminNeed/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/adminNeed/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adminNeed/lib/font-awesome/css/font-awesome.css">

    <script src="${pageContext.request.contextPath}/adminNeed/lib/jquery-1.7.2.min.js" type="text/javascript"></script>
	
     <style type="text/css">
        #line-chart {
            height:300px;
            width:800px;
            margin: 0px auto;
            margin-top: 1em;
        }
        .brand { font-family: georgia, serif; }
        .brand .first {
            color: #ccc;
            font-style: italic;
        }
        .brand .second {
            color: #fff;
            font-weight: bold;
        }
         .title{
            	width: 100%;
            	text-align: center;	
            	color:#4fc08d;
           }
         
    </style>
    
  </head>
  
  <body>
  <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">欢迎您 </a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i>
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                           
                            <li class="divider"></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="#" onClick="javascript:history.back(-1);">返回</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="#"> <span class="second"></span></a>
        </div>
    </div>  
   <div>
	<s:iterator value="news" var="news" status="stu">
		<div class="title"><h3 class="center"><s:property value="#news.title"/></h3>
			<p>来源:<s:property value="#news.source"/>&nbsp;
			发布时间:<s:date name="#news.issueTime" format="yyyy/MM/dd EE" nice="false"/></p>
			<hr>
		</div>
		<p style="text-align: left; padding-left: 10%;padding-right: 10%; color:#4fc08d;"><s:property value="#news.content"/></p>
    </s:iterator>
  </div>
  </body>
</html>
