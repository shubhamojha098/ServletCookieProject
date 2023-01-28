<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
Cookie[] c=request.getCookies();
for (Cookie cookie : c){
	if (cookie.getName().equals("username") || cookie.getName().equals("password")){
		response.sendRedirect("AdminCookie.jsp");
	}
}%>
<h1>Hiii Admin</h1>

</body>
</html>