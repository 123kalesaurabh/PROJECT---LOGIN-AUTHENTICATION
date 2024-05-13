<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">


<title>Home Page</title>
<style type="text/css">
body{
    background-color:darkgrey;
}
 h1{
    text-align: center;
    margin-top: 5%;
}
div{
    text-align: center;
}
    
</style>
</head>
<body>
<%
String check = (String)session.getAttribute("check");
if(check!=null)
{
	

%>
<h1>In home page</h1>

<div>
<a href="logout">Logout</a>
</div>
<% } 
else
{
	response.sendRedirect("login.html");
}
%>
</body>
</html>