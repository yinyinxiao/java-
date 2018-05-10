<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
	String[] userList={"刘银","张宁"};
	String user=new String(request.getParameter("username").getBytes("ISO-8859"),"utf-8");
		Arrays.sort(userList);
		int result=Arrays.binarySearch(userList,user);
		if(result>-1){
			out.print("已经被注册");
			
		}else{
			out.println("注册成功");
		}
 %>