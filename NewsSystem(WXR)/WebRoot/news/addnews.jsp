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
	<style type="text/css">
			.errorMessage{
			 color:red;
	         text-align: left;
			}
            body{
                text-align: center;
            }
            .abutton{
            	text-decoration: none;
            	font-size: 18px; 
            	font-weight: bold;
            	background-color: #4fc08d;
            	color:#FCFCFC;
            	-webkit-border-radius: 5px;
            	width:200px;
            }
            .input{
            	font-size: 18px; 
            	font-weight: bold;
            	height:30px
            }
    </style>
  </head>
  <s:bean name="com.news.action.CategoryAction" var="category" id="category"></s:bean>
  <body>
    <h2 align="left">发布新闻：</h2>
    <br>
    <s:form action="/news/addNews.action" namespace="/news" method="post" enctype="multipart/form-data">
    	<table border="1" bordercolor="#4fc08d" width="600px" class="input">
			<tr bordercolor="#4fc08d">
				<s:textfield name="news.title" label="标题" placeholder="News Title "/>
			</tr>
			<tr bordercolor="#4fc08d">
				<s:select label="类型" name="news.category.id" list="#category.findCategory" listKey="id" 
		listValue="categoryName" headerKey="0"  headerValue="--请选择新闻类型--" required="true">
		</s:select>
			</tr>
			<tr bordercolor="#4fc08d">
				<s:textarea rows="20" cols="50" label="内容" name="news.content" placeholder="News Content " />
			</tr>
			<tr bordercolor="#4fc08d">
				<s:file name="news.upload" label="请选择文件" class="abutton"></s:file>
			</tr>
			<tr bordercolor="#4fc08d">
				<s:textfield label="来源" name="news.source" placeholder="From Where "/>
			</tr>
			<s:hidden name="news.issueTime">
				<s:param name="value">
					<fmt:formatDate value="<%=new Date()%>" type="date"/>
				</s:param>
			</s:hidden>
			<tr >
				<s:submit value="添加" class="abutton" />
			</tr>
		</table>

    </s:form>
  </body>
</html>
