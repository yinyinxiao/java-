<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'index.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<script type="text/javascript">
		function check(form){
			with(form){
				if(name.value==""){
					alert("姓名不能为空！");
					return false;
				}
				if(add.value==''){
					alert("家庭住址不能为空！")
					return false;
				}
			}
		}
	</script>
  </head>
  
  <body>
    <form action="AddressServlet" method="post" onsubmit="return check(this)">
    <h2>添加人员信息</h2>
    <ul>
    	<li>姓名：<input type="text" name="name"/></li>
    	<li>性别：<input type="radio" name="sex" value="男 " checked="checked" />男<input type="radio" name="sex" value="男女" checked="checked" />女</li>
    	<li>家庭住址：<textarea row="5" cols="30" name="add" ></textarea></li>
    	<li><input type="submit" value="submit"/></li>
    </form>
  </body>
</html>
