<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page contentType="text/html;charset=utf-8"%>
<%
try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String username="root";
		String password="******";
		Connection conn=DriverManager.getConnection(url,username,password);

		String id=new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8");
		String name=new String(request.getParameter("username").getBytes("ISO-8859-1"),"utf-8");
		String sql1 = "update teachers set Teacher_name=? where Teacher_id=?";
		
		String sql2="select* from teachers";
		
		PreparedStatement ps=conn.prepareStatement(sql1);
		ps.setString(1,name);
		ps.setString(2, id);
		ps.executeUpdate();		
		ps.close();
		conn.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	response.setHeader("refresh","0.1;URL=http://localhost:8080/WebLiuyin/School/Enter.html");
	
%>
