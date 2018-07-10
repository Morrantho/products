<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Products</title>
</head>
<body>
	<h1>Products</h1>
	
	<form:form action="/products" method="POST" modelAttribute="product"  >
		<form:label path="name" >Name:
			<form:errors path="name"></form:errors>
			<form:input path="name"></form:input>
		</form:label>
		
		<form:label path="cost" >Name:
			<form:errors path="cost"></form:errors>
			<form:input path="cost"></form:input>
		</form:label>
		
		<input type="submit" value="Create Product" />		
	</form:form>
	
	<table>
		<tr>
			<th>Name:</th>
			<th>Cost:</th>
			<th>Action:</th>
		</tr>
	
		<c:forEach items="${products}" var="i" >
			<tr>
				<td>
					<a href="/products/${i.id}">${i.name}</a>
				</td>
				<td>${ i.cost }</td>
				<td>
					<form method="post" action="/products/${i.id}" >
						<input type="submit" value="Delete ${i.name}"/>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>





















</body>
</html>