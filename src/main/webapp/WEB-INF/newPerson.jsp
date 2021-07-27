<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New Person</title>
</head>
<body>
<h2>New Person</h2>
<form:form  action="/persons/new" method="post" modelAttribute="person">

		<tr >
			<td><form:label path="firstName">First Name</form:label></td>
			<td><form:errors path="firstName" /></td>
			<td><form:input path="firstName" /></td>
		</tr><br><br>
		<tr>
			<td><form:label path="lastName">Last Name</form:label></td>
			<td><form:errors path="lastName" /></td>
			<td><form:input path="lastName" /></td>
		</tr><br><br>
		
		<input type="submit" value="Create" />

	</form:form>

</body>
</html>