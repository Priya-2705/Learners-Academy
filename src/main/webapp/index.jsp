<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<style>
.welcome {
	text-align: center;
	padding-bottom: 20px;
}
fieldset {
	text-align: center;
	border: 2px #01257D solid;
}
legend {
	text-align: center;
	color: #01257D;
	font-size: 20px;
	font-weight: 700;
}
.option {
	font-size: 12px;
	padding-top: 8px;
}
</style>

<meta charset="UTF-8">
<title>Login Page</title>
</head>
<body>

	<%@ include file="header.jsp"%>
	
	<div class="welcome">
		<h1>Learner's Academy</h1>
	</div>
	<form action="./logincontroller" method="post" style = "width: 400px; margin:  0px auto;">
		<fieldset>
			<legend>Admin Login</legend><br>
			Username : <input type="text" id="username" name="username" required><br><br>
			Password : <input type="password" id="password" name="password" required><br><br>
			<input type="submit" value="Submit">
			
			<div class="option">
				Not a registered user?<a href="register.jsp">Click here</a>
			</div>
		</fieldset>
	</form>
	
</body>
</html>

