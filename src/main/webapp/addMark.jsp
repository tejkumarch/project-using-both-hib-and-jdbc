<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Adding</title>
</head>
<body>
<h2>Enter the Mark Details</h2>
<form action="msave" method="post">
<table>
		<tr>
				<td>ExamId</td>
				<td><input type="text" name="eid">
				</td>
			</tr>
			<tr>
				<td>StudentId</td>
				<td><input type="text" name="sid">
				</td>
			</tr>
			<tr>
				<td>Mark1</td>
				<td><input type="text" name="mark1">
				</td>
			</tr>
			<tr>
				<td>Mark2</td>
				<td><input type="text" name="mark2">
				</td>
			</tr>
			<tr>
				<td>Mark3</td>
				<td><input type="text" name="mark3">
				</td>
			</tr>

		</table>
		<input type="submit" value="submit">
		 <input type="reset" value="Cancel">
	</form>

</body>
</html>