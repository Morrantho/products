<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Join Page</title>
</head>
<body>
	<form action="/join" method="POST">
		<select name="categoryId" >
			<c:forEach items="${ categories }" var="category" >
				<option value="${category.id}">${category.name}</option>
			</c:forEach>
		</select>

		<select name="productId" >
			<c:forEach items="${ products }" var="product" >
				<option value="${product.id}">${product.name}</option>
			</c:forEach>			
		</select>

		<input type="submit" value="Join" />
	</form>
</body>
</html>