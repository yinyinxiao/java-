<%@page import="liuyin.Grades"%>
<%@ page language="java" import="java.util.*,java.sql.*,java.lang.String.*" pageEncoding="utf-8"%>
<jsp:useBean id="Grades" class="liuyin.Grades"></jsp:useBean>
<jsp:setProperty property="*" name="Grades"/>
<%
response.setCharacterEncoding("UTF-8");
List<Grades> list=new ArrayList<Grades>();
String user=new String(request.getParameter("id").getBytes("ISO-8859-1"),"utf-8");
try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/school";
		String username="root";
		String password="******";
		Connection conn=DriverManager.getConnection(url,username,password);
		Statement statement=conn.createStatement();
		
		//String user=new String("15102424".getBytes("ISO-8859-1"),"UTF-8");
		String sql="select* from students";
		String sql1="select* from student_grades where Student_id="+"'"+user+"'";
		
		ResultSet rs= statement.executeQuery(sql1);
		while(rs.next()){
			Grades grades =new Grades();
			grades.setCourseId(rs.getString("Course_id"));
			grades.setGreades(rs.getDouble("Grades"));
			list.add(grades);
		}
		//while(rs2.next()){
		//	Grades grades =new Grades();
		//	grades.setClassId(rs2.getString("Student_id"));
		//	grades.setStudentName(rs2.getString("Student_name"));
		//	list2.add(grades);
		//}
		rs.close();
		statement.close();
		conn.close();
	}catch(ClassNotFoundException e){
		e.printStackTrace();
	}catch(SQLException e){
		e.printStackTrace();
	}
%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8" />
		<title></title>
		<style type="text/css">
			html,body,header,i,div,ul,li,input{
				margin: 0;
				padding: 0;
				border: none;
				font-family: arial;
				font-size:15px ;
			}
			header{
				height: 60px;
				background-color:#EBEBEB;
			}
			header a{
				float: right;
				height: 20px;
				margin-top: 30px;
				margin-right: 100px;
				font-size: 20px;
				color: #cd0000;
			}
			#bg_2{
				width: 1800px;
			}
			#bg_2 div{
				width: 1500px;
				margin: 0 auto;
			}
			#form_2 #form_input_1{
				width: 150px;
    text-align: right;
    font-size: 30px;
    color: #2B2B2B;
    margin-left: 650px;
    margin-bottom: 10px;
    margin-top: 10px;
			}
			#form_2 #form_input_2{
				width: 100PX;
				text-align: center;
				font-size: 30px;
				color: #2B2B2B;
				margin-left: 10px;
			}
			#form_2 #form_span_1{
				font-size: 30px;
margin-left: 4px;
			}
			#form_2 table thead tr th{
				width: 200px;
    height: 30px;
    border: 1px solid gray;
			}
			#form_2 table{
				border-collapse: collapse;
				margin: 0 auto;
			}
			#form_2 #sub_3{
				margin-top: 10px;
				display: inline-block;
				width: 100px;
				height: 30px;
				    margin-left: 700px;
			}
			#form_2 #a_2{
				font-size: 20px;
				color: #8B8B83;
				margin-left: 10px;
				width: 50px;
				height: 25px;
			}
		</style>
	</head>
	<body>
		<header>
			<a href="http://localhost:8080/WebLiuyin/School/AlterStudentPassword.html">修改密码</a><a href="http://localhost:8080/WebLiuyin/School/main.html">注销登陆</a>
		</header>
		<div id="bg_2">
			<div id="area">
				<form id="form_2" action="http://localhost:8080/WebLiuyin/School/main.html">
					<input type="text" value="<%=user%>" id="form_input_1"/>
						<table>
						<thead>
						<tr>
							<th>课程号</th><th>成绩</th>
						</tr>
						
							<%for(Grades grades:list){
							%>
							<%="<tr><td style=\"font-size:15px;text-align:center;border:1px solid black;width:199px;height:29px\">"+grades.getCourseId()+"</td>"+"<td style=\"font-size:15px;text-align:center;border:1px solid black;width:199px;height:29px\">"+grades.getGreades()+"</td></tr>"%>
							<%} %>
						
						</thead>
						<tbody>
						</tbody>				
					</table>
					<input type="submit" value="退出" id="sub_3"/>
				</form>
               
			</div>
		</div>
	</body>
</html>
