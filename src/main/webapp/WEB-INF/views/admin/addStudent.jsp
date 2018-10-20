<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dodaj ucznia</title>
</head>
<body>

	<div>
		<h2>
			Menu
		</h2>
	</div>	
	<div>
		<h1 align="center">Dane dodawanego ucznia</h1>
	</div>
	<div>
		<form:form method="post" modelAttribute="studentDto" action="addStudent">
			<div>
				<label>IMIĘ:</label>
				<form:input path="name"/><form:errors path="name" cssClass="color:red"/>
				
			</div>
			<div>
				<label>NAZWIKSO:</label>
				<form:input path="surname"/><form:errors path="surname" cssClass="color:red"/>
				
			</div>
			<div>
				<label>PESEL:</label>
				<form:input path="pesel"/><form:errors path="pesel" cssClass="color:red"/>
				
			</div>
			
			<div>
				<label>Klasa ID:</label>
				<form:input path="idSchoolGroup.id"/><form:errors path="idSchoolGroup.id" cssClass="color:red"/>
				
			</div>
			<div>
				<form:hidden path="id"/>
				<input type="submit" value="send">
			</div>
		</form:form>
	</div>
	

</body>
</html>