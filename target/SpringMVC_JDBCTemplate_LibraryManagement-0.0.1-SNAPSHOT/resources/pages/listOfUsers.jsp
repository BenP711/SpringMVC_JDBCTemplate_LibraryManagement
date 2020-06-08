<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="spring" uri="/spring"%>
<%@ taglib prefix="form" uri="/spring-form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>List of Users</title>
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
			<th>User Name</th>
			<!-- <th>Email Id</th>
			<th>Phone</th> -->
		</tr>
		<c:if test="${not empty userList}">
			<c:forEach items="${userList}" var="userList">
				<tr>
					<td><a href="${userList.userName}Details${userList.userId}.do">${userList.userName}</a></td>
					<%-- <td>${userList.emailId}</td>
					<td>${userList.phone}</td> --%>
				</tr>
			</c:forEach>
		</c:if>
	</table>
</body>
</html>