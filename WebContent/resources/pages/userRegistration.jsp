<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign Up</title>
<link href="<c:url value="/resources/css/userDetails.css" />"
	rel="stylesheet">
</head>
<body><form:form method="post" modelAttribute="user"
			action="/SpringMVC_JDBCTemplate_LibraryManagement/loginPage">
	<table>
		
			<tr>
				<td><label for="userName">User Name:</label></td>
				<td><form:input path="userName" /></td>
			</tr>
			<tr>
				<td><label for="password">Password:</label></td>
				<td><form:input path="password" /></td>
			</tr>
			<tr>
				<td><label for="emailId">Email Id:</label></td>
				<td><form:input path="emailId" /></td>
			</tr>
			<tr>
				<td><label for="phone">Phone:</label></td>
				<td><form:input path="phone" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" id="btnCreateAccount" name="signUp"
					value="Create Account" /></td>
			</tr>
		
	</table></form:form>
</body>
</html>