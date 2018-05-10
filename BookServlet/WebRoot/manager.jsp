<%@page import="silver.liuyin.UserBean"%>
<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'manager.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->

  </head>
  
  <body>
    <h2 style="width:350px;text-align:center;">用户信息列表</h2>
    <table align="center" border="1" width="400">
    	<tr align="center" style="font-weight:bold;">
    		<td>姓名</td>
    		<td>性别</td>
    		<td>家庭住址</td>
    	</tr>
    	<% ArrayList<UserBean>list=(ArrayList<UserBean>)application.getAttribute("users");
    		if(list!=null){
    			for(UserBean user:list){
    	 %>
    	 <tr align="center">
    	 <td><%=user.getName() %></td>
    	 <td><%=user.getSex() %></td>
    	 <td><%=user.getAddress() %></td>
    	 </tr>
    	 <%
    	 	}
    	 }
    	  %>
    	  <tr>
    	  	<td align="center" colspan="3">
    	  		<a href="index.jsp">继续添加</a>
    	  		</td>
    	  	</tr>
    </table>
  </body>
</html>
