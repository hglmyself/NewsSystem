<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
    
    <title>My JSP 'newlist.jsp' starting page</title>
    
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
                margin-top: 50px;
                text-align: left;
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
  <s:bean name="com.news.action.NewsAction" var="news" id="news"></s:bean>
  <body>
     <h2 style="text-align: left;padding-top: 15px;">新闻信息表</h2>
    <div class="div">
    <s:form action="news/SearchNewsByCategory.action" method="post" namespace="/news"
    enctype="multipart/form-data">
    	<table><tr>
	    	<td><s:select label="类型" name="categoryName" list="#category.findCategory" listKey="id" 
			listValue="categoryName" headerKey="0"  headerValue="--请选择新闻类型--" required="true">
			</s:select></td>
	    	<td><s:submit value="搜索" class="abutton"></s:submit>
	    	</td>
	    	</tr>
    	</table>
   	</s:form>
    
    <table border="1" cellspacing="0" cellpadding="10" style="text-align: center;border: 1px solid black;">
    	<thead>
    		<tr style="font-weight: bold; background-color: #4fc08d; color:#FCFCFC;">
    			<td>序号</td>
    			<td width="300">标题</td>
    			<td width="200">发布时间</td>
    			<td>类型</td>
    			<td width="200">操作</td>
    		</tr>	
    	</thead>
    		<tbody>
    			<s:iterator value="newList" var="news" status="stu">
    			<tr align="center">
    				<td><s:property value="#stu.count"/></td>
    				<td>
    				<s:a href="news/showNews.action?nid=%{#news.nid}">
    				<s:property value="#news.title"/></s:a></td>
    				<td>
						<s:date name="#news.issueTime" format="yyyy/MM/dd EE" nice="false"/>
					</td>
    				<td><s:property value="#news.category.categoryName"/></td>
    				<td>
    				<s:a href="news/updateNews.action?nid=%{#news.nid}">
    				编辑</s:a>&nbsp;
    				<s:a href="news/deleteNews.action?nid=%{#news.nid}">删除</s:a>
    				
    				</td>
    			</tr>
    			</s:iterator>
    			</tbody>
    </table>
    </div>
    <s:set var="splitPage" value="#request.splitPage"/>
   		 <s:if test="#splitPage.hasFirst">
				<a href="news/queryByPage.action?pno=1">首页</a>
				</s:if>
			<s:if test="#splitPage.hasPrevious">
				<a href="news/queryByPage.action?pno=
				<s:property value="#splitPage.currentPage-1"/>">上一页</a>
</s:if>
			<s:if test="#splitPage.hasNext">
				<a href="news/queryByPage.action?pno=
				<s:property value="#splitPage.currentPage+1"/>">下一页</a>
</s:if>
			<s:if test="#splitPage.hasLast">
				<a href="news/queryByPage.action?pno=
				<s:property value="#splitPage.totalPage"/>">尾页</a>
	</s:if>
			<br>
			当前第
			<s:property value="#splitPage.currentPage"/>
			页，总共
			<s:property value="#splitPage.totalPage"/>
			页
  </body>
</html>
