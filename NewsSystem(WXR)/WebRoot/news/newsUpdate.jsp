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
            body{
                text-align: center;
            }
            .div{
                margin-left: 40%;
                margin-top: 50px;
                text-align: left;
            }
            .abutton{
            	text-decoration: none;
            	font-size: 23px; 
            	font-weight: bold;
            	background-color: #4A708B;
            	color:#FCFCFC;
            	width:100px;
            }
    </style>
  </head>
  <s:bean name="com.news.action.CategoryAction" var="category" id="category"></s:bean>
  <body>
    <h2 align="left">修改新闻具体信息：</h2>
    <br>
    <s:form action="updatedNews" namespace="/news">
    	<table border="3" bordercolor="lightblue">
			<tr>
				<s:hidden name="news.nid" value="%{news.nid}"/>
				<s:textfield name="news.title" label="标题" />
			</tr>
			<tr>
				<s:select label="类型" name="news.category.id" list="#category.findCategory" listKey="id" 
		listValue="categoryName" headerKey="0" required="true">
		</s:select>
			</tr>
			<tr>
				<s:textarea rows="20" cols="50" label="内容" name="news.content" />
			</tr>
			<tr>
				<s:textfield label="来源" name="news.source" />
			</tr>
			<s:hidden name="news.issueTime">
				<s:param name="value">
					<fmt:formatDate value="<%=new Date()%>" type="date"/>
				</s:param>
			</s:hidden>
			<tr>
				<s:submit value="修改新闻信息" class="abutton"/>
			</tr>
		</table>

    </s:form>
  </body>
</html>
