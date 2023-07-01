<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Teacher" %>
<%@ page import="mypackage.dao.TeacherDao" %>
<%@ page import="mypackage.daoimpl.TeacherDaoImpl" %>
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
<title>Teachers List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		TeacherDao teacherDao = new TeacherDaoImpl();
		List<Teacher> teachers = teacherDao.getAll(); 
		request.setAttribute("teachers", teachers); 
	%>
	<div class="head1">
		<h1> Teachers List </h1>	
	</div>
		<table>
			<tr>
				<th> Teacher ID </th>
				<th> Teacher Name </th>
				<th> Teacher Qualification </th>
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Teacher teacher : teachers) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= teacher.getTeacher_name() %></td>
				<td><%= teacher.getTeacher_qual() %></td>
				<td>
					<form action="teacherslist.jsp" method="POST">
						<input type="hidden" name="tid" value="<%= teacher.getTeacher_id() %>">
						<button type="submit" name="action" value="delete">Delete</button>
					</form>
				</td>
			</tr>
			<% sequence++; %>
	<%
		}
	%>	
			<tr>
				<td colspan="4">
					<form action="addteacher.jsp" method="GET">
						<button type="submit">Add Teacher</button>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int tid = Integer.parseInt(request.getParameter("tid"));
			teacherDao.delete(tid);
			response.sendRedirect("teacherslist.jsp");
		}
	%>	
</body>
</html>