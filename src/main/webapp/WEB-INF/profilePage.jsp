<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<div>
		<h2>
			<c:out value="${person.firstName}" />
			<c:out value="${person.lastName}" />
		</h2>
		<div>
			<p>
				License number:
				<c:out value="${person.license.number}" />
			</p>
			<p>
				State:
				<c:out value="${person.license.state}" />
			</p>
			<p>
				Expiration date:
				<c:out value="${person.license.expirationDate}" />
			</p>
		</div>
	</div>
</body>
</html>