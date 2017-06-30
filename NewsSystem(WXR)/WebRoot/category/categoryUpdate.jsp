<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"  isELIgnored="true" %>
<%@ taglib prefix="s" uri="/struts-tags" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>UpdateCategory.jsp</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
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
            	font-size: 18px; 
            	font-weight: bold;
            	background-color: #4fc08d;
            	color:#FCFCFC;
            	-webkit-border-radius: 5px;
            	width:200px;
            }
            .inputCateory{
            	font-size: 18px; 
            	font-weight: bold;
            	width:200px;
            	height:30px
            }
    </style>
  </head>
  
  <body>
    <h2 style="text-align: center;padding-top: 15px;">修改新闻类别</h2>
    <div class="div">
    <s:form action="categoryUpdated" namespace="/category">
    	<s:hidden name="category.id" value="%{category.id}"/>
    	<s:textfield name="category.categoryName" label="类别名" class="inputCateory"/>
    	<s:submit value="确认修改" class="abutton"/>
    </s:form>
    </div>
  </body>
</html>
