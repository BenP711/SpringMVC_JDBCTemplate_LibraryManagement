<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add a Book</title>
<link href="<c:url value="/resources/css/userDetails.css" />"
	rel="stylesheet">
</head>
<body>
	<table>
		<form:form method="post" action="/SpringMVC_JDBCTemplate_LibraryManagement/saveNewBook"
			modelAttribute="addBook">
			<tr>
				<td><label for="bookName">Book Name: </label></td>
				<td><form:input path="bookName" /> <form:hidden path="bookId" /></td>
			</tr>
			<tr>
				<td><label for="author">Author: </label></td>
				<td><form:input path="author" /></td>
			</tr>
			<tr>
				<td><label for="isbn">ISBN: </label></td>
				<td><form:input path="isbn" /></td>
			</tr>
			<tr>
				<td><label for="isbn">Number of Copies: </label></td>
				<td><form:input path="numberOfCopies" /></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${empty addBook.bookName}">
						<input type="Submit" id="btnSaveNewBook" value="Save New Book"
							name="Save" />
					</c:if></td>
			</tr>
			<tr>
				<td colspan="2"><c:if test="${not empty addBook.bookName}">
						<input type="Submit" id="btnUpdateBook" value="Update Book"
							name="Update" />
					</c:if></td>
			</tr>
		</form:form>
	</table>
</body>
</html>