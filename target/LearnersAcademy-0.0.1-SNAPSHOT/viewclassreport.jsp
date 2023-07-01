<%@page import="org.hibernate.internal.build.AllowSysOut"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<%@ page import="java.util.List"%>
<%@ page import="mypackage.entities.Student"%>
<%@ page import="mypackage.entities.Subject"%>
<%@ page import="mypackage.entities.Clazz"%>
<%@ page import="mypackage.entities.Teacher"%>
<%@ page import="mypackage.dao.ClazzDao"%>
<%@ page import="mypackage.daoimpl.ClazzDaoImpl"%>
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
	color: #01257D;
	font-weight: bold;
}
td {
	color : #fff;
}

.head1 {
	color: #01257D;
	padding-top: 10px;
	padding-bottom: 10px;
	text-align: center;
}
</style>
<meta charset="UTF-8">
<title>Class Report</title>
</head>
<body>
	<%@ include file="header.jsp"%>

	<%
    ClazzDao clazzDao = new ClazzDaoImpl();
    List<Clazz> clazzes = clazzDao.getAll();
    request.setAttribute("clazzes", clazzes);
%>
	<div class="head1">
		<h1>Class Report</h1>
	</div>
	<table>
		<tr>
			<th>Student ID</th>
			<th>Student Name</th>
			<th>Assigned Subject</th>
			<th>Assigned Class</th>
			<th>Assigned Teacher</th>
		</tr>
		<%
        int sequence = 1;
        %>
		<%
        for (Clazz clazz : clazzes) {
    %>
		<tr>
			<td><%= sequence %></td>
			<td>
				<%
                    for (Student student : clazz.getStudents()) {
                        out.println(student.getStudent_name() + "<br>");
                    }
                %>
			</td>
			<td>
				<%
                    for (Subject subject : clazz.getSubjects()) {
                        out.println(subject.getSubject_name() + " " + subject.getSubject_level()+ "<br>");
                    }
                %>
			</td>
			<td><%= clazz.getClazz_name() %></td>
			<td>
				<%
                    for (Teacher teacher : clazz.getTeachers()) {
                    	out.println(teacher.getTeacher_name() + "<br>");
                    }
                %>
			</td>
		</tr>
		<%
        sequence++;
    %>
		<%
        }
    %>
	</table>
</body>
</html>
