<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%
    	if(request.getSession().getAttribute("user") != null){
    %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<h1>Zasticeno logovanjem</h1>
	<h1>Ulogovan: ${sessionScope.user.ime }</h1>
	
	<a href="LoginController?action=Logout">Logout</a>
</body>
</html>
<%
    	}else{
    		response.sendRedirect("index.jsp");
    	}
%>