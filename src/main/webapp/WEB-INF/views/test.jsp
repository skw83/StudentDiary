<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@	taglib	prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@	taglib	uri="http://java.sun.com/jsp/jstl/core"	prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<form:form	method="post" modelAttribute="testKl">
				<form:input	path="name"/>
				<form:input	path="surname"/>
				<form:input	path="pesel"/>
				<input	type="submit"	value="Save">
</form:form>

</body>
</html>