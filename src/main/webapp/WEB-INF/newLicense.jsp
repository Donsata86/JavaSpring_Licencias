<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>New License!</title>
</head>
<body>
	<h2>New License</h2>

	<form:form action="/licenses/new" method="post" modelAttribute="license">

		<form:label path="person">Name</form:label>
		<form:select path="person">
			<c:forEach items="${persons}" var="person">
				<form:option value="${ person.id }">
					<c:out value=" ${ person.firstName }  ${ person.lastName } " />
				</form:option>
			</c:forEach>
		</form:select><br><br>

		<form:label path="state">State</form:label>
		<form:input path="state" /> <br><br>
		
		
		<form:label path="expirationDate">Expiration Date</form:label>
		<form:errors path="expirationDate"/>
		<form:input type="date" path="expirationDate"/><br><br>


		<input type="submit" value="Create"/>

	</form:form>


</body>
</html>