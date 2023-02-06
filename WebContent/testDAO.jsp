<%@page import="model.User"%>
<%@page import="model.DAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	DAO dao = new DAO();
	out.print(dao.selectUsers());
	//dao.insertUser(new User("Milan","Milanovic", 2000, "miki", "miki"));
	
	//out.print(dao.selectUsers());
	out.print(dao.selectUsersByUsername("ivan"));
	out.print(dao.selectUsersByUsernameAndPassword("ivan","ivan"));
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>

</body>
</html>