<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>login</title>
	<!-- 新 Bootstrap 核心 CSS 文件 -->
	
	<link rel="stylesheet" href="adminNeed/css/bootstrap.min.css">
	<!--自定义last year-->
	<!-- <link  rel="stylesheet" href="css/style.css"> -->
	<!-- 可选的Bootstrap主题文件（一般不用引入） -->
	<link rel="stylesheet" href="adminNeed/css/bootstrap-theme.min.css">
	<link rel="stylesheet" href="adminNeed/css/mine-define.css">
  	<link rel="stylesheet" type="text/css" href="adminNeed/css/loginandout.css">
</head>
<body>
		<!-- 顶部 start -->
<div class="navbar navbar-fixed-top nav-bg-blue" role="navigation">
      <div class="container bg-blue">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-collapse">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand nav-text" href="#">新闻管理系统     Campus Hep..</a>
        </div>
        <div class="navbar-collapse collapse">
           <div class="collapse navbar-collapse">
         
        </div><!--/.nav-collapse -->
        </div><!--/.navbar-collapse -->
      </div>
    </div><!--顶部 end -->

    <div class="container">
	<div class="login_boldborder col-lg-6 col-xs-offset-7">
            <h3> 用 户 登 录</h3>
              <hr>
                  <s:form  method="post" action="login"  class="form-horizontal" namespace="/">
                    <div class="form-group">
                      <div class="input-group">
                        <s:textfield class="form-control input-lg" id="inputname" placeholder="Your name " name="username"></s:textfield>
                      </div>
                    </div>
                    <div class="form-group">
                      <div class="input-group">
                       <s:password class="form-control input-lg" id="inputPassword" placeholder="Password" name="password"></s:password>
                      </div>
                    </div>
                    <div class="form-group">
                        <s:submit class="btn login_button" value="Login"></s:submit>
                    </div>
              </s:form>
	</div>
</div>
</body>
</html>