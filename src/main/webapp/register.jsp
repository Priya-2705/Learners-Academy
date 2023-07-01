<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
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
</style>
<meta charset="UTF-8">
<title>Register</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<form action="registercontroller" method="post" style = "width: 400px; margin:  0px auto;">
		<fieldset>
			<legend>Registration form</legend><br>
			Username : <input type="text" name="username" required><br><br>
			Password : <input type="password" name="password" required><br><br>
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>