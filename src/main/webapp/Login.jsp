<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
	<form action="loginvalidate" method="post">
	<table>
			<tr>
				<td>User Name</td>
				<td><input type="text" name="username"></td>
			</tr>
			<tr>
				<td>Password</td>
				<td><input type="password" name="password">
				<td>
			</tr>
		</table>
	<input type="submit" value="Login">
	<input type="reset" value="Cancel">
	</form>
	For new user account "<a href="register.jsp">Register</a>" 
</body>
</html>