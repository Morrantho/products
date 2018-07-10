<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Show Product</title>
</head>
<body>
	<form:form action="/products/${product.id}/update" method="POST" modelAttribute="product" >
		<form:label path="name" >Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label>
		<form:label path="cost" >Cost:
			<form:errors path="cost"></form:errors>
			<form:input path="cost"></form:input>
		</form:label>
		
		<input type="submit" value="Update" />
	</form:form>

</body>
</html>