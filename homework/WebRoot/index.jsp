<%@ page language="java" import="java.util.*" pageEncoding="utf-8" import="java.sql.*"%>
<%
	try{
	Class.forName("com.mysql.jdbc.Driver");
	
	String url="jdbc:mysql://localhost:3306/test";
	String username="root";
	String password="liuyin520";
	Connection conn=DriverManager.getConnection(url,username,password);
	
	if(conn!=null){
	out.println("数据库链接成功！");
	conn.close();
	}else{
	out.println("链接失败");
	}
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
	
 %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  </head>
  
  <body>
    
  </body>
</html>
