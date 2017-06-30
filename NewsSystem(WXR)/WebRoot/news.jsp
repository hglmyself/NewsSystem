<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>新闻系统</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="adminNeed/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="adminNeed/stylesheets/theme.css">
    <link rel="stylesheet" href="adminNeed/lib/font-awesome/css/font-awesome.css">

    <script src="adminNeed/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

    <!-- Demo page code -->

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
    </style>
  </head>
   <s:bean name="com.news.action.CategoryAction" var="category" id="category"></s:bean>
  <body> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <a class="brand" href="#"> <span class="second">Campus Hep </span></a>
        </div>
    </div>   
    <div class="sidebar-nav">
        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase">
        </i>新闻类型<span class="label label-info"><s:property value="#category.findCategory.size()"/></span></a>
        
        <ul id="accounts-menu" class="nav nav-list collapse in" align="left">
        	<s:iterator value="#category.findCategory" var="category" status="stu">
            <li>
            	<s:a href="news/NewsByCategory.action?categoryName=%{#category.id}" target="RightFrame">
            		<s:property value="#category.categoryName"/>
           		</s:a>
           	</li>
           	</s:iterator>
        </ul>
    </div>
    <script src="adminNeed/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
    
  </body>
</html>
