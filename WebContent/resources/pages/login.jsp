<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Sign In</title>
<link href="<c:url value="/resources/css/userDetails.css" />"
	rel="stylesheet">

</head>
<body>
	<table>
		<form:form method="post" action="/SpringMVC_JDBCTemplate_LibraryManagement/homePage"
			commandName="user">
			<tr>
				<td>
					<div class="name">Login Form</div>
				</td>
			</tr>
			<tr>
				<td class="login-table-td">
					<div class="label">User Name</div> :
					<div class="login-txtBox">
						<form:input path="userName" />
					</div> <br>
					<div class="label">Password</div> :
					<div class="login-txtBox">
						<form:input path="password" />
					</div> <br>
				</td>
			</tr>
			<tr>
				<td><input type="Submit" id="btnSignIn" name="signIn"
					value="Sign In" /></td>
			</tr>
		</form:form>
		<form:form method="post" action="/SpringMVC_JDBCTemplate_LibraryManagement/signUp"
			commandName="user">
			<tr>
				<td><input type="Submit" id="btnSignUp" name="signUp"
					value="Create an Account" /></td>
			</tr>
		</form:form>
	</table>

</body>
</html>