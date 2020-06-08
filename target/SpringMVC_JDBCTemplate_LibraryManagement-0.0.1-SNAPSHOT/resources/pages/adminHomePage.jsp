<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Welcome ${user.userName}</title>
<link href="<c:url value="/resources/css/userDetails.css" />"
	rel="stylesheet">

</head>
<body>
	<form:form method="post" commandName="user"
		action="/SpringMVC_JDBCTemplate_LibraryManagement/adminAccess" cssStyle="border:none">
		<table style="background: transparent;">
			<tr>
				<td><input type="Submit" id="btnListOfUsers" name="listOfUsers"
					value="View Users" /></td>
			</tr>
			<tr>
				<td><input type="Submit" id="btnAddNewBook" name="addNewBook"
					value="Add New Book" /></td>
			</tr>
			<tr>
				<td><input type="Submit" id="btnAvailableBooks"
					name="availableBooks" value="View Available Books" /></td>
			</tr>
			<tr>
				<td><input type="Submit" id="btnListAllBooks"
					name="listAllBooks" value="View All Books" /></td>
			</tr>
			<tr>
				<td><input type="Submit" id="btnIssuedBooks" name="issuedBooks"
					value="View Issued Books" /></td>
			</tr>
			<tr>
				<td><input type="Submit" id="btnLogOut" name="logOut"
					value="Sign Out" /></td>
			</tr>
		</table>
	</form:form>
</body>
</html>