<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Categories</title>
</head>
<body>
	<h1>Categories</h1>
	
	<form:form action="/categories" method="POST" modelAttribute="category">
		<form:label path="name" >Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label>
				
		<input type="submit" value="Create Category" />		
	</form:form>
	
	<table>
		<tr>
			<th>Name:</th>
		</tr>
	
		<c:forEach items="${categories}" var="i" >
			<tr>
				<td>
					<a href="/categories/${i.id}">${i.name}</a>
				</td>
			</tr>
		</c:forEach>
	</table>
</body>
</html>