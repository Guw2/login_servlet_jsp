<%@page import="com.dao.LoginAndLogoutDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body style="font-family: arial; zoom: 2; text-align: center;">
	
	<h1>Log-in Page</h1>
	
	<hr style="margin-bottom: 20px;">
	
	<form action="Login" method="post">
		
		USERNAME : <input type="text" name="username"><br>
		PASSWORD : <input type="password" name="password" style="margin-top: 5px;"><br>
		
		<input type="submit" value="login" style="margin-top: 15px;">
	</form>
</body>
</html>