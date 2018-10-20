<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Login : STUDENT</title>
</head>
<body>

	<div>
		<h2>
			Menu
		</h2>
			<h4><a href="/student/logout">Logout</a></h4>
	</div>	
	<div>
		<h1 align="center">Dane logowania ucznia</h1>
	</div>
	<div>
		<form:form method="post" modelAttribute="studentDto" action="login">
			<div>
				<label>PESEL:</label>
				<form:input path="pesel"/>
				
			</div>
			<div>
				<label>PASSWORD:</label>
				<form:input path="password"/>
				
			</div>
			<div>
				<form:hidden path="id"/>
				<input type="submit" value="send">
			</div>
		</form:form>
	</div>

</body>
</html>