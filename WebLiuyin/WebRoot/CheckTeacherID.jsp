<%@page import="liuyin.Teacher"%>
<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="Teacher" class="liuyin.Teacher"></jsp:useBean>
<jsp:setProperty property="*" name="Teacher"/>
<%
response.setCharacterEncoding("UTF-8");
try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String username="root";
		
		String password="******";
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement statement=conn.createStatement();
		String user=new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8");
		//String user=new String("12345678".getBytes("ISO-8859-1"),"UTF-8");
		String sql="select* from teachers";
		List<Teacher> list=new ArrayList<Teacher>();
		ResultSet rs= statement.executeQuery(sql);
		while(rs.next()){
			
			Teacher teacher =new Teacher();
			teacher.setID(rs.getString("Teacher_id"));
			teacher.setUsername(rs.getString("Teacher_name"));
			teacher.setPassword(rs.getString("Teacher_pwd"));
			list.add(teacher);
		}
		String testString=new String();
		for(Teacher teacher:list){
			String tString=teacher.getID();
			if(tString.equals(user)){
			testString=teacher.getID();
			}
		}
		if(testString.equals(user)){
			out.print("you can regester");
		}else{
			out.print("The id not existed");
		}
		rs.close();
		statement.close();
		conn.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
	
%>
