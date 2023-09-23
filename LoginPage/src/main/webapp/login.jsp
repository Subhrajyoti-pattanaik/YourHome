<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login here</title>
</head>
<body>
	<div align="center">
		<h2>Login here</h2>
	</div>
	
	<form action=LoginServlet method=post>
	<div align="center">
		<table>
			<tr><td>User id</td><td><input type=text name=ip></td></tr>			
			<tr><td>password</td><td><input type=password name=pw></td></tr>
			<tr><td><input type=submit value=login></td><td><input type=reset value=reset></td></tr>
		</table>
		</div>
	</form>
</body>
</html>