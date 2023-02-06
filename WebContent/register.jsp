<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h2>Registracija</h2>
	<form action="LoginController" method="post">
		Ime:<br>
		<input type="text" name="ime" value="${param.ime }"><br>
		Prezime:<br>
		<input type="text" name="prezime" value="${param.prezime }"><br>
		Godiste:<br>
		<input type="text" name="godiste" value="${param.godiste }"><br>
		Username:<br>
		<input type="text" name="username" value="${param.username }"><br>
		Password:<br>
		<input type="password" name="password"><br>
		Ponovite password:<br>
		<input type="password" name="password2"><br>
		<input type="submit" name="action" value="Register"><br>
	</form>
	${requestScope.msg }
	<p>Ako ste vec registrovani mozete se ulogvati <a href="index.jsp">OVDE</a></p>
</body>
</html>