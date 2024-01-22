<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page import="java.util.Random"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>WELCOME TO LOAN APPROVE PAGE</h1>
<pre>
<b>U r approved for loan amount:<%=new Random().nextInt(100000)%></b>
<a href="./">HOME</a>
<a href="logout">LOGOUT</a>
</pre>
</body>
</html>