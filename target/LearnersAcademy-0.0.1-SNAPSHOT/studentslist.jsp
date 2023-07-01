<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Student" %>
<%@ page import="mypackage.dao.StudentDao" %>
<%@ page import="mypackage.daoimpl.StudentDaoImpl" %>
<head>
<style>
  table {
    border-collapse: collapse;
    width: 50%;	
    margin: auto;
  }
  th, td {
	border: 2px #01257D solid;    
    text-align: center;
  }
  th {
    color: #333;
    font-weight: bold;
  }
  .head1 {
  	color: #01257D;
  	padding-top: 10px;
  	padding-bottom: 10px;
  	text-align: center;
  }
</style>

<meta charset="UTF-8">
<title>Students List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		StudentDao studentDao = new StudentDaoImpl();
		List<Student> students = studentDao.getAll(); 
		request.setAttribute("students", students); 
	%>
	<div class="head1">
		<h1> Students List </h1>	
	</div>
		<table>
			<tr>
				<th> Student ID </th>
				<th> Student Name </th>
				<th> Student Address </th>
				<th> Assigned Class </th>				
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Student student : students) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= student.getStudent_name() %></td>
				<td><%= student.getAddress() %></td>			
				<td><%= student.getClazzName() %></td>					
				<td>
					<form action="studentslist.jsp" method="POST">
						<input type="hidden" name="sid" value="<%= student.getStudent_id() %>">
						<button type="submit" name="action" value="delete">Delete</button>
					</form>
				</td>
			</tr>
			<% sequence++; %>
	<%
		}
	%>	
			<tr>
				<td colspan="5">
					<form action="addstudent.jsp" method="GET">
						<button type="submit">Add Student</button>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int sid = Integer.parseInt(request.getParameter("sid"));
			studentDao.delete(sid);
			response.sendRedirect("studentslist.jsp");
		}
	%>	
</body>
</html>