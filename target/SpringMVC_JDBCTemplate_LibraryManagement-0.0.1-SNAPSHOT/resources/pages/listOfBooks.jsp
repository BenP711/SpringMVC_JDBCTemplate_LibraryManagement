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
	top: 300px;
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
			<th>Book Name</th>
			<th>Author</th>
			<th>ISBN</th>
			<c:if test="${login == 'admin'}">
				<th>No of Copies</th>
				<c:if test="${bookListType == 'allBooks'}">
					<th>Update</th>
					<th>Delete</th>
				</c:if>
			</c:if>
		</tr>
		<c:if test="${not empty bookList}">
			<c:forEach items="${bookList}" var="book">
				<tr>
					<td>${book.bookName}</td>
					<td>${book.author}</td>
					<td>${book.isbn}</td>
					<c:if test="${login == 'admin'}">
						<td>${book.numberOfCopies}</td>
						<c:if test="${bookListType == 'allBooks'}">
							<td align="center"><a href="updateBook${book.bookId}.do">Update</a></td>
							<td align="center"><a href="deleteBook${book.bookId}.do">Delete</a></td>
						</c:if>
					</c:if>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>