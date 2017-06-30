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
    <title>Here We are 新闻云</title>
    <meta content="IE=edge,chrome=1" http-equiv="X-UA-Compatible">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/adminNeed/lib/bootstrap/css/bootstrap.css">
    
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/adminNeed/stylesheets/theme.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/adminNeed/lib/font-awesome/css/font-awesome.css">

    <script src="${pageContext.request.contextPath}/adminNeed/lib/jquery-1.7.2.min.js" type="text/javascript"></script>

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
	<s:bean name="com.news.action.NewsAction" var="news" id="news"></s:bean>
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
                            <li><a tabindex="-1" href="#" onClick="javascript:window.top.location.href='${pageContext.request.contextPath}/adminLogin.action'">登录管理</a></li>
                        </ul>
                    </li>
                    
                </ul>
                <a class="brand" href="#"> <span class="second"></span></a>
        </div>
    </div>  
<div class="block span10" align="center">
        <a href="#tablewidget" class="block-heading" data-toggle="collapse">新闻列表
        <span class="label label-warning"><s:property value="newList.size()"/></span></a>
        <div id="tablewidget" class="block-body collapse in">
            <table class="table" align="center">
              <thead>
                <tr>
                  <th width="10%">序号</th>
    			<th width="30%">新闻标题</th>
    			<th width="25%">发布时间</th>
    			<th width="15%">新闻类型</th>
    			<th width="20%">新闻来源</th>
                </tr>
              </thead>
                <tbody align="center">
					<s:iterator value="newList" var="news" status="stu">
                    <tr align="left">
                        <td><s:property value="#stu.count"/></td>
    				<td>
    				<s:a href="showNews.action?nid=%{#news.nid}">
    				<s:property value="#news.title"/></s:a></td>
    				<td>
						<s:date name="#news.issueTime" format="yyyy/MM/dd EE" nice="false"/>
					</td>
    				<td><s:property value="#news.category.categoryName"/></td>
    				<td><s:property value="#news.source"/></td>
                    </tr> 
                    </s:iterator>    
                </tbody>
            </table>
            <p><a href="#">More...</a></p>
        </div>
 	</div>
 	 <script src="${pageContext.request.contextPath}/adminNeed/lib/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
        $("[rel=tooltip]").tooltip();
        $(function() {
            $('.demo-cancel-click').click(function(){return false;});
        });
    </script>
  </body>
</html>

