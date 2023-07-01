<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List" %>
<%@ page import="mypackage.entities.Clazz" %>
<%@ page import="mypackage.dao.ClazzDao" %>
<%@ page import="mypackage.daoimpl.ClazzDaoImpl" %>
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
<title>Class List</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	<%	
		ClazzDao clazzDao = new ClazzDaoImpl();
		List<Clazz> clazzes = clazzDao.getAll(); 
		request.setAttribute("clazzes", clazzes); 
	%>
	<div class="head1">
		<h1> Class List </h1>	
	</div>
		<table>
			<tr>
				<th> Class ID </th>
				<th> Class Name </th>
				<th> Actions </th> 
			</tr>
	<% int sequence = 1; %>
	<%
		for(Clazz clazz : clazzes) {
	%>
			<tr>
				<td><%= sequence %></td>
				<td><%= clazz.getClazz_name() %></td>
				<td>
					<form action="clazzlist.jsp" method="POST">
						<input type="hidden" name="cid" value="<%= clazz.getClazz_id() %>">
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
					<form action="addclazz.jsp" method="GET">
						<button type="submit"> Add Class </button>
					</form>
				</td>
			</tr>
		</table>
	<%
		String action = request.getParameter("action");
		if (action != null && action.equals("delete")) {
			int cid = Integer.parseInt(request.getParameter("cid"));
			clazzDao.delete(cid);
			response.sendRedirect("clazzlist.jsp");
		}
	%>	
</body>
</html>