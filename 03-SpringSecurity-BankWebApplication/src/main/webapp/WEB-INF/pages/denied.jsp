<%@page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME TO DENIED PAGE</h1>
Authentication failed for:<%=SecurityContextHolder.getContext().getAuthentication().getName() %><br/>
<a href="./">HOME</a>
</body>
</html>