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
     xmlHttp= new ActiveXObject("Microsoft.XMLHTTP");//����XMLHttpRequet����
   }
  else if (window.XMLHttpRequest) {
     xmlHttp=new XMLHttpRequest();//����XMLHttpRequet����
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
  document.getElementById("nameInfo").innerHTML="<font color='red'>���ǳ��Ѵ���</font>";
  else
  alert("��ϲ�㣬ע��ɹ���");
     }
  }
}
function check(){
if(name==""){
document.getElementById("nameInfo").innerHTML="<font color='red'>�ǳƲ���Ϊ�գ�</font>";
return false;
}
else if(password==""){
document.getElementById("passwordInfo").innerHTML="<font color='red'>���벻��Ϊ�գ�</font>";
return false;
}
else if(password1==""){
document.getElementById("password1Info").innerHTML="<font color='red'>���벻��Ϊ�գ�</font>";
return false;
}
else if(password!=password1){
document.getElementById("password1Info").innerHTML="<font color='red'>������������벻һ�£�</font>";
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
<tr><td align="center" valign="center"> �ǳƣ� <input id="userName"/><div id="nameInfo"></div><br/></td></tr>
 <tr><td>���������룺 <input type="password" id="passWord"/><div id="passwordInfo"></div><br/></td></tr>
 <tr><td> ���ٴ��������룺 <input type="password" id="passWord1"/><div id="password1Info"></div><br/><tr/><td/>
 <tr><td><input type="button" value="ע��"  onclick="exec(); "/></td></tr>
  </table>
  </div>
</form>
</body>
</html>
