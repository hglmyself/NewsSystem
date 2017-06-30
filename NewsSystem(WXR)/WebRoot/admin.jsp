<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <meta charset="utf-8">
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


  <body class=""> 
  <!--<![endif]-->
    
    <div class="navbar">
        <div class="navbar-inner">
                <ul class="nav pull-right">
                    
                    <li><a href="#" class="hidden-phone visible-tablet visible-desktop" role="button">欢迎您 </a></li>
                    <li id="fat-menu" class="dropdown">
                        <a href="#" role="button" class="dropdown-toggle" data-toggle="dropdown">
                            <i class="icon-user"></i> ${username}
                            <i class="icon-caret-down"></i>
                        </a>

                        <ul class="dropdown-menu">
                           
                            <li class="divider"></li>
                            <li class="divider visible-phone"></li>
                            <li><a tabindex="-1" href="#"  onClick="javascript:window.top.location.href='${pageContext.request.contextPath}/logout.action'">注销</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="#"> <span class="second">新闻管理系统</span></a>
        </div>
    </div>   
    <div class="sidebar-nav">
        <a href="#dashboard-menu" class="nav-header" data-toggle="collapse"><i class="icon-dashboard"></i>新闻类型管理</a>
        <ul id="dashboard-menu" class="nav nav-list collapse in">
            <li><a href="category/listCategories.action" target="RightFrame">新闻类型查看</a></li>
            <li ><a href="category/addCategory.jsp" target="RightFrame">发布新闻类型</a></li>
            
        </ul>

        <a href="#accounts-menu" class="nav-header" data-toggle="collapse"><i class="icon-briefcase"></i>新闻管理<span class="label label-info">+2</span></a>
        <ul id="accounts-menu" class="nav nav-list collapse in">
            <li ><a href="news/queryByPage.action" target="RightFrame">新闻查看</a></li>
            <li ><a href="news/addnews.jsp" target="RightFrame">新闻发布</a></li>
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
