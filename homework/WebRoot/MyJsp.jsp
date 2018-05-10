<%@ page language="java" import="java.util.*" pageEncoding="GBK"%>
<html>
<head>
<title>Simple AjaxExample </title>
<script type="text/javascript">
var xmlHttp;
   var name;
   var password;
   var password1;
function createXMLHttpRequest(){
   if(window.ActiveXObject) {
     xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");//创建XMLHttpRequet对象
   }
  else if (window.XMLHttpRequest) {
     xmlHttp=new XMLHttpRequest();//创建XMLHttpRequet对象
     }
 }
function startRequest() {
 createXMLHttpRequest();
   
 xmlHttp.onreadystatechange=handleStateChange;
 xmlHttp.open("POST", "index.jsp", true);
 var str="name="+name;
  xmlHttp.setRequestHeader("Content-Type","application/x-www-form-urlencoded");
 xmlHttp.send(str);
 }
function handleStateChange() {
  if(xmlHttp.readyState==4) {
 if(xmlHttp.status==200) {
  if( xmlHttp.responseText==1)
  document.getElementById("nameInfo").innerHTML="<font color='red'>该昵称已存在</font>";
  else
  alert("恭喜你，注册成功！");
     }
  }
}
function check(){
if(name==""){
document.getElementById("nameInfo").innerHTML="<font color='red'>昵称不能为空！</font>";
return false;
}
else if(password==""){
document.getElementById("passwordInfo").innerHTML="<font color='red'>密码不能为空！</font>";
return false;
}
else if(password1==""){
document.getElementById("password1Info").innerHTML="<font color='red'>密码不能为空！</font>";
return false;
}
else if(password!=password1){
document.getElementById("password1Info").innerHTML="<font color='red'>两次输入的密码不一致！</font>";
return false;
}
else {
clear();
return true;
}
}
function exec(){
clear();
name=document.getElementById("userName").value;
password=document.getElementById("passWord").value;
password1=document.getElementById("passWord1").value;
if(check()==true){
startRequest();
}
}
function clear(){
document.getElementById("nameInfo").innerHTML="";
document.getElementById("passwordInfo").innerHTML="";
document.getElementById("password1Info").innerHTML="";
}
</script>
</head>
<body>
  <form action="#">
  <div align="center">
  <table border="1" >
<tr><td align="center" valign="center"> 昵称： <input id="userName"/><div id="nameInfo"></div><br/></td></tr>
 <tr><td>请输入密码： <input type="password" id="passWord"/><div id="passwordInfo"></div><br/></td></tr>
 <tr><td> 请再次输入密码： <input type="password" id="passWord1"/><div id="password1Info"></div><br/><tr/><td/>
 <tr><td><input type="button" value="注册"  onclick="exec(); "/></td></tr>
  </table>
  </div>
</form>
</body>
</html>
