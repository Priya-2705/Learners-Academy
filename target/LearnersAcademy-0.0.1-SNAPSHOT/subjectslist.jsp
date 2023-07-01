<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Subject" %>
<%@ page import="mypackage.dao.SubjectDao" %>
<%@ page import="mypackage.daoimpl.SubjectDaoImpl" %>
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
<title>Subjects List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		SubjectDao subjectDao = new SubjectDaoImpl();
		List<Subject> subjects = subjectDao.getAll(); 
		request.setAttribute("subjects", subjects); 
	%>
	<div class="head1">
		<h1> Subjects List </h1>	
	</div>
		<table>
			<tr>
				<th> Subject ID </th>
				<th> Subject Name </th>
				<th> Subject Qualification </th>
				<th> Assigned Class </th>
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Subject subject : subjects) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= subject.getSubject_name() %></td>
				<td><%= subject.getSubject_level() %></td>
				<td><%= subject.getClazzName() %></td>
				<td>
					<form action="subjectslist.jsp" method="POST">
						<input type="hidden" name="sid" value="<%= subject.getSubject_id() %>">
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
					<form action="addsubject.jsp" method="GET">
						<button type="submit">Add Subject</button>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int sid = Integer.parseInt(request.getParameter("sid"));
			subjectDao.delete(sid);
			response.sendRedirect("subjectslist.jsp");
		}
	%>	
</body>
</html>