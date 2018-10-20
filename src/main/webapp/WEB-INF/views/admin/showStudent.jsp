<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dane studenta</title>
</head>
<body>
	<table border="2">
		<th>ID</th>
		<th>NAME</th>
		<th>SURANME</th>
		<th>PESEL</th>
		<th>KLASA</th>
		<th>ID PARENTS</th>
		
		<c:forEach items="${showStudent.jsp}" var="studentDto">
		
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