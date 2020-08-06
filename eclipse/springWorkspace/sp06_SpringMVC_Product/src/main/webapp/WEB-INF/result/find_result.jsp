<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>+++++++ 검색 결과 +++++++</h2>
	<table border="1">
		<tr>
			<th>ID</th>
			<th>NAME</th>
			<th>MAKER</th>
			<th>PRICE</th>
		</tr>
		<c:forEach items="${list}" var="product">
		<tr>
			<td>${product.id}</td>
			<td>${product.name}</td>
			<td>${product.maker}</td>
			<td>${product.price}</td>
		</tr>
		</c:forEach>
	</table>
	
	<a href="productRegister.jsp">메인페이지 이동</a>
</body>
</html>