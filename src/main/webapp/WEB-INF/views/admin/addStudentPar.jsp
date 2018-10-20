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
		<form:form method="post" modelAttribute="addStuPar" action="addUserForm">
		
			<div>Dane studenta</div>
			<div>
				<label>IMIĘ:</label>
				<form:input path="nameSt"/><form:errors path="nameSt" cssClass="color:red"/>
				
			</div>
			<div>
				<label>NAZWIKSO:</label>
				<form:input path="surnameSt"/><form:errors path="surnameSt" cssClass="color:red"/>
				
			</div>
			<div>
				<label>HASŁO:</label>
				<form:input path="passwordSt"/>
				
			</div>
			<div>
				<label>PESEL:</label>
				<form:input path="peselSt"/><form:errors path="peselSt" cssClass="color:red"/>
				
			</div>
			
			<div>
				<label>Klasa:</label>
				<form:input path="idSchoolGroup.id"/>
				
			</div>
			
			<div>Dane rodzica</div>
			<div>
				<label>IMIĘ:</label>
				<form:input path="nameP"/><form:errors path="nameP" cssClass="color:red"/>
				
			</div>
			<div>
				<label>NAZWIKSO:</label>
				<form:input path="surnameP"/><form:errors path="surnameP" cssClass="color:red"/>
				
			</div>
			<div>
				<label>EMAIL:</label>
				<form:input path="email"/><form:errors path="email" cssClass="color:red"/>
			</div>	
			
			<div>
				
				<input type="submit" value="send">
			</div>
		</form:form>
	</div>
	

</body>
</html>