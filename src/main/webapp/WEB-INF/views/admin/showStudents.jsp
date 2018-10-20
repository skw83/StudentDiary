<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dane studentów</title>
</head>
<body>
	<h1>Lista studentów</h1>
	
	<table border="2">
		<th>ID</th>
		<th>NAME</th>
		<th>SURANME</th>
		<th>PESEL</th>
		<th>KLASA</th>
		<th>ID PARENTS</th>
		
		<c:forEach items="${listsStudentDto}" var="StudentDto">
		
			<tr>
				<td>${studentDto.id}</td>
				<td>${studentDto.name}</td>
				<td>${studentDto.surname}</td>
				<td>${studentDto.pesel}</td>
				<td>${studentDto.idSchoolGroup.id}</td>
				<td>${studentDto.parentsDto.id}</td>
			</tr>
		
		</c:forEach>
		
	</table>
</body>
</html>