<%@page import="mypackage.serviceimpl.ClazzServiceImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Clazz"%>
<%@ page import="mypackage.dao.ClazzDao"%>
<%@ page import="mypackage.daoimpl.ClazzDaoImpl"%>
<head>
<style>
form {
	padding-top: 50px;
}

fieldset {
	text-align: center;
	border: 2px #01257D solid;
	overflow: auto;
}

legend {
	text-align: center;
	color: #01257D;
	font-size: 20px;
	font-weight: 700;
}

label {
	display: inline-block;
	width: 120px;
	text-align: right;
	font-weight: 600;
	color: #01257D;
	margin-right: 5px;
}

input[type="text"], select {
	width: 167px;
}
select option[disabled] {
	text-align: center;
	padding: 0;
}
</style>
<meta charset="UTF-8">
<title>Add Subject</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<% 
		ClazzDao clazzDao = new ClazzDaoImpl();
		List<Clazz> clazzes = clazzDao.getAll(); 
		request.setAttribute("clazzes", clazzes);  
	%>
	<form action="subjectcontroller" method="post"
		style="width: 400px; margin: 0px auto;">
		<fieldset>
			<legend>Add Subject form</legend>
			<br> <label>Name: </label><input type="text" name="subjectname"
				required>
			<p>
				<label>Level: </label> <select name="subjectlevel" id="subjectlevel"
					required>
					<option disabled selected value>-- select level --</option>
					<option value="Level I">Level I</option>
					<option value="Level II">Level II</option>
				</select>
			</p>
			<p> 
			<label> Assign Class : </label> <select name="clazzname" id="clazzname"
				required>
				<option disabled selected value>-- select class --</option>
				<% for (Clazz clazz : clazzes) { %>
				<option value="<%= clazz.getClazz_id() %>"><%= clazz.getClazz_name() %></option>
				<% } %>
			</select>
			</p>
			
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>