<%@page import="liuyin.Student"%>
<%@ page language="java" import="java.util.*,java.sql.*,java.lang.String.*" pageEncoding="ISO-8859-1"%>
<jsp:useBean id="Student" class="liuyin.Student"></jsp:useBean>
<jsp:setProperty property="*" name="Student"/>
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
		String sql="select* from students";
		List<Student> list=new ArrayList<Student>();
		ResultSet rs= statement.executeQuery(sql);
		while(rs.next()){
			Student student =new Student();
			student.setId(rs.getString("Student_id"));
			student.setName(rs.getString("Student_name"));
			student.setPassword(rs.getString("Student_pwd"));
			student.setClassId(rs.getString("Class_id"));
			list.add(student);
		}
 		String testString=new String();
		for(Student student:list){
			if(user.equals(student.getId())){
			testString=student.getId();
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
