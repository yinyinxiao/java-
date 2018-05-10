<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%
		response.setCharacterEncoding("UTF-8");
		String user=new String(request.getParameter("password").getBytes("ISO-8859-1"),"utf-8");
		if(user.equals("123456")){
			out.print("ok");
		}else{
			out.print("password is fault");
		}	
%>
