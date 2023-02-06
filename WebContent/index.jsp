<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Logovanje</h2>
	<form action="LoginController" method="post">
		Username:<br>
		<input type="text" name="username" value="${param.username }"><br>
		Password:<br>
		<input type="password" name="password" value="${param.password }"><br>
		<input type="submit" name="action" value="Login"><br>
	</form>
	${requestScope.msg }
	<p>Ako se niste registovali mozete to uraditi <a href="register.jsp">OVDE</a></p>
</body>
</html>