<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags" %>
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
    
    <title>ShowAllCategory.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<style type="text/css">
            body{
                width: 100%;
                text-align: center;
            }
            .div{
                margin-left: 31%;
                margin-top: 50px;
                text-align: left;
            }
            .abutton{
            	text-decoration: none;
            	margin-bottom:15px;
            	font-size: 18px; 
            	font-weight: bold;
            	background-color: #4fc08d;
            	color:#FCFCFC;
            	-webkit-border-radius: 5px;
            	width:200px;
            }
    </style>

  </head>
  
  <body>
    <h2 style="text-align: center;padding-top: 15px;">所有新闻类别</h2>
    <div class="div">
    <table border="1" cellspacing="0" cellpadding="10" style="text-align: center;border: 1px solid black; width: 500px;">
    	<thead>
    		<tr>
    			<button class="abutton"><a href="category/addCategory.jsp" class="abutton">添加新闻类别</a></button>
    		</tr>
    		<tr style="font-weight: 2px; background-color: #4fc08d; color:#FCFCFC;">
    			<td>类别ID</td>
    			<td>类别名</td>
    			<td>操作</td>
    		</tr>
    	</thead>
    		<tbody>
    		<s:iterator value="categories" var="category" status="stu">
    			<tr align="center">
    				<td width="60"><s:property value="#stu.count "/></td>
    				<td width="120"><s:property value="#category.categoryName"/></td>
    				<td>
    				<s:a href="category/categoryUpdate.action?cid=%{#category.id}">
    				编辑</s:a>&nbsp;
    				<s:a href="category/deleteCategory.action?cid=%{#category.id}">删除</s:a>
    				
    				</td>
    			</tr>
    			</s:iterator>
    		</tbody>
    </table>
    </div>
  </body>
</html>
