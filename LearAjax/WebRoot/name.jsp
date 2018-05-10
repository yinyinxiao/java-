<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'name.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
	window.onload=function(){
	var p1=document.getElementById("p1");
				document.getElementById("a1").onclick=function(){
					var request= new XMLHttpRequest();

					var url=this.href;
					var method="GET";
					
					request.open(method,url);
					
					request.send(null);
					
					request.onreadystatechange=function(){
						if(request.readyState==4){
							if(request.status==200||request.status==304){
							document.getElementById("p1").innerHTML=request.responseText;
								
							}		
						}
					}
					return false;
				}
	}
</script>
  </head>
  <body>
  	<a href="liuyin.html" id="a1" >刘银</a>
    <p id="p1"></p>
  </body>
</html>
