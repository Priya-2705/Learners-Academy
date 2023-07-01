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

label {
	display: inline-block;
	width: 80px;
	text-align: right;
	font-weight: 600;
	color: #01257D;
	margin-right: 5px;	
}
input[type="text"] {
	width: 167px; 
}
</style>
<meta charset="UTF-8">
<title>Add Clazz</title>
</head>
<body>
	<%@ include file="header.jsp"%>
	
	<form action="clazzcontroller" method="post" style="width: 400px; margin: 0px auto;">
		<fieldset>
			<legend>Add Clazz form</legend><br>
			<label>Name : </label><input type="text" name="clazzname" required><br><br>
		
			<input type="submit" value="Submit">
		</fieldset>
	</form>
</body>
</html>