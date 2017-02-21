<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
	<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
	
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<jsp:include page="../includes.jsp" />
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Product Management</title>
</head>
<body>
	<h2>Products Management</h2>
	<form:form action="/SpringMavenProject/product/product.do" method="POST" commandName="product">
	<table class="table table-condensed" width="60%" >
		<tr>
			<td>Product Id</td>
			<td><form:input path="productId"/></td>
		</tr>
		<tr>
			<td>Product Name</td>
			<td><form:input path="productName"/></td>
		</tr>
		<tr>
			<td>Product Description</td>
			<td><form:input path="description"/></td>
		</tr>
		<tr>
			<td>Product Price</td>
			<td><form:input path="price"/></td>
		</tr>
		<tr>
			<td colspan="2">
				<input type="submit" name="action" value="Add" class="btn btn-success"/>
				<input type="submit" name="action" value="Edit" class="btn btn-primary"/>
				<input type="submit" name="action" value="Delete" class="btn btn-danger"/>
				<input type="submit" name="action" value="Search" class="btn btn-info"/>
			</td>
		</tr>
	</table>
	</form:form>
	<br/>
	<table border="1" class="table table-hover">
		<th>Product Id</th>
		<th>Product Name</th>
		<th>Description</th>
		<th>Price</th>
		<c:forEach items="${productList}" var="product">
			<tr>
				<td>${product.productId }</td>
				<td>${product.productName }</td>
				<td>${product.description }</td>
				<td>${product.price }</td>
			</tr>
		</c:forEach>
	</table>
	
	
</body>
</html>