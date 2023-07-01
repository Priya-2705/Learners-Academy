<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="home-styles.css">
<meta charset="UTF-8">
<title>Home Page</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="heading">
		<h2>Welcome to Learner's Academy</h2>
	</div>
	<div class="tiles">
		<div class="column-3 option-1">
			<h2 class="option-text"><a href="subjectslist.jsp">Subjects<br>List</a></h2>
		</div>
		<div class="column-3 option-2">
			<h2 class="option-text"><a href="teacherslist.jsp">Teachers<br>List</a></h2>
		</div>
		<div class="column-3 option-3">
			<h2 class="option-text"><a href="clazzlist.jsp">Classes<br>List</a></h2>
		</div>
		<div class="column-3 option-4">
			<h2 class="option-text"><a href="studentslist.jsp">Students<br>List</a></h2>
		</div>
		<div class="column-3 option-5">
			<h2 class="option-text">Learner's Academy</h2>
		</div>
		<div class="column-3 option-6">
			<h2 class="option-text"><a href="viewclassreport.jsp">View Class<br>Report</a></h2>
		</div>
	</div>
</body>
</html>
