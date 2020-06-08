<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Books</title>
<link href="<c:url value="/resources/css/userDetails.css" />"
	rel="stylesheet">
<style>
table, td, th {
	top: 30%;
	border: 1px solid black;
	width: 450px;
	padding: 10px;
}

table {
	border-collapse: collapse;
}
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="6"><form:form method="get"
					action="/SpringMVC_JDBCTemplate_LibraryManagement/homePage">
					<input type="Submit" id="btnGoToAdminHomePage"
						name="goToAdminHomePage" value="Home" />
				</form:form></td>
		</tr>
		<tr>
			<th>User Name</th>
			<th>Book Name</th>
			<th>ISBN</th>
		</tr>
		<c:if test="${not empty bookList}">
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.userName}</td>
					<td>${book.bookName}</td>
					<td>${book.isbn}</td>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>