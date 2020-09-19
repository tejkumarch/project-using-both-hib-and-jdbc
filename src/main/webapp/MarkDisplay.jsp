<%@page import="com.dxc.jdbcDAO.MarkJdbcDAO"%>
<%@page import="com.dxc.jdbcDAO.ExamJdbcDAO"%>
<%@page import="com.dxc.beans.Mark"%>
<%@page import="com.dxc.beans.Exam"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Mark_Display</title>
</head>
<body>

  <label for="examid">Choose one:</label>
  <select id="examid" name="examid">
  <option value="examid">examid</option>
  <%
  String examid="";
  List<Exam> exams=new ExamJdbcDAO().findAll();
  for(Exam exam:exams)
  {
  %>
    <option value="examid"><%=exam.getExamid()%></option>
    <%
   examid=exam.getExamid();
  }
    %>
  </select>
  <form action="MarkDisplay.jsp">
  <input type="submit" value="Display">
  </form>
 <table>
	<tr>
	<th>StudentId</th>
	<th>Name</th>
	<th>Maths</th>
	<th>Physics</th>
	<th>Chemistry</th>
	</tr>
	<%
	List<Mark> marks=new MarkJdbcDAO().findAll();
	for(Mark mark : marks)
	{
		%>
		<tr>
		<td><%= mark.getStudentid()%></td>
		<td>name</td>
		<td><%= mark.getMark1()%></td>
		<td><%=mark.getMark2()%></td>
		<td><%=mark.getMark3() %></td>		
		<td><a href='markEdit.jsp?eid=<%=mark.getExamid()%>?sid=<%=mark.getStudentid()%>'>Edit</a>/
			<a href='deletemark?eid=<%=mark.getExamid()%>?sid=<%=mark.getStudentid()%>'>Delete</a></td>
		</tr>
		<%
	}
	%>
	
	</table>
		<br><a href="addMark.jsp">Add New Student</a><br><br>

</body>
</html>