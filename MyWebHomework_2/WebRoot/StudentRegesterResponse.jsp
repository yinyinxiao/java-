<%@ page language="java" import="java.util.*,java.sql.*" pageEncoding="utf-8"%>
<%@page contentType="text/html;charset='utf-8'"%>
<%
	try{
	Class.forName("com.mysql.jdbc.Driver");
	String url="jdbc:mysql://localhost:3006/test";
	String username="root";
	String password="liuyin520";
	Connection conn=DriverManager.getConnection(url,username,password);
	
	if(conn!=null){
		out.println("链接成功");
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
<!DOCTYPE html>
<html>
	<head>
		<meta charset="UTF-8">
		<title></title>
		<style type="text/css">
			#form_1{
			width: 800px;
			border: 1px solid gainsboro;
			margin: 0 auto;
			margin-top: 50px;
			height: 500px;
		}
		#form_1 ul li{
			list-style: none;
			list-style: none;
width: 800px;
height: 40px;

margin-top: 2px;
display: inline-block;
		}
		.span_1{
			    display: inline-block;
    width: 100px;
    text-align: right;
    padding-top: 7px;
		}
		#form_1 ul li input{
			height: 30px;
    border: 1px solid #8B8B83;
    width: 300px;
		}
		#form_1 ul li #sub_1{
			margin-left: 120px;
			width: 90px;
		}
		#form_1 ul li #sub_2{
			width: 100px;
    margin-left: 50px;
		}
				#form_1 ul li #a_1{
			
			display: inline-block;
    color: #8B3626;
    height: 30px;
    text-align: center;
    width: 130px;
		}
		</style>
		<script type="text/javascript" src="js/jquery-1.8.3.min.js" ></script>
	<script type="text/javascript">
		$(function(){
			var ok1 = false;
			var ok2 = false;
			var ok3 = false;
			var reg1=/^[0-9]{7}[0-9]$/;//ID
			var reg2=/^[\u4e00-\u9fa5]{1,18}[\u4e00-\u9fa5]$/;//
			var reg3=/^[a-z0-9_-]{6,18}$/;// 
			//éªè¯IDå·
			$('.ID').focus(function(){
				$(this).next().text("IDå·å¿é¡»ä¸º8ä½æ°å­");
			}).blur(function(){
				if(reg1.test($(this).val())){
					$(this).next().text(" ");
					ok3=true;
				}else{
					$(this).next().text("å¯ç ä¸ç¬¦åè¦æ±");
				}
			})
		//éªè¯å¯ç 
		$('input[name="password"]').focus(function(){ 
			$(this).next().text('å¯ç åºè¯¥ä¸º6-20ä½ä¹é´');
		}).blur(function(){
			if(reg3.test($(this).val())){
				$(this).next().text('');
				ok2=true;
				}else{
					$(this).next().text('å¯ç ä¸ç¬¦åè§è');
				}
			}); 
			//æäº¤æé®,ææéªè¯éè¿æ¹å¯æäº¤ 
			$('.sub_1').click(function(){ 
					if(ok2 && ok3){
						$('form').submit();
					}else{ return false;
					
					}
					});
		});
	</script>
	</head>
	<body>
		<form id="form_1" action="false">
                	<ul>
                		<li><span class="span_1">ID:</span><input type="text" name="name" class="ID"/><span></span></li>
                		<li><span class="span_1">å¯ç :</span><input type="password" name="password" /><span></span></li>
                		<li ><input id="sub_1" type="submit" name="S_submit" value="å­¦çç»é"class="sub_1"/><input class="sub_1" id="sub_2" type="submit" name="T_submit"value="æå¸ç»é" /><a href="reg.html" id="a_1">è¿æªæ³¨å,æ³¨å</a></li>
                	</ul>
                	
                	
                	
                </form>
	</body>
</html>
