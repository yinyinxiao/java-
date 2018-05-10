<%@ page language="java" import="java.util.*" pageEncoding="ISO-8859-1"%>
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
	<script type="text/javascript">
		window.onload=function(){
		
			//1.获取a节点，并为其添加onclick响应函数
			document.getElementsByTagName("a")[0].onclick=function(){
			//3.创建一个XMLHttpRequest请求
	
			var request=new XMLHttpRequest;
			//4，准备发送请求的数据：url，
			/*
			在某些情况下，有的浏览器会把多个XMLHttpRequest请求的结果缓存在同一个url。如果对每个请求响应不同，就会带来不好结果
			在此将时间戳追加到url的最后，就能确保url的唯一性，从而避免浏览器缓存结果
			url=this.href+'?time='+new data();*/
			var url=this.href;
			var method="GET";
			//5.调用XMLHttpResquest对象的open方法，
			request.open(method, url);
			//6.调用XMLHttpRequest对象的send方法
			request.send(null);
			//7.为XMLHttpRequest秋香添加onreadystatechange相应函数(由服务器触发)
			request.onreadystatechange=function(){
			alert(request.readyState);
			//8.判断响应是否完成：XMLHttpRequest对象的readyState属性值为4的时候
			/*
				readyState表示Ajax请求的当前状态。
				0：代表未初始化。还没有调用open方法
				1:代表正在加载。open方法已被调用，但是send方法还未被调用
				2:表示加载完毕。send已被调用。请求结束
				3：表示交互中。服务器正在发送响应
				4：代表完成。服务器响应完成。
				每次readyState值得改变都会触发readStatechange事件的触发。如果把onreadstatechange时间处理函数给另一个函数，那么每次readystate
				值的改变都会引发该函数执行。
				readystate的值的变化会因浏览器二不同，但是请求结束时，每个浏览器都会吧readystate的值同意设置为4
				
			*/
				if(request.readyState==4){
				//9.再判断响应是否可用：XMLHttpRequest对象status属性值为200
					if(request.status==200||request.status==304){
					//10.打印响应结果：responseText
						alert(request.responseText);
					}
				}
			}
			//2.取a节点的默认行为
				return false;
			}	
		}
	</script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	
	-->
  </head>
  
  <body>
    <a href="hello.txt.txt">hellor Ajax</a>
  </body>
</html>
