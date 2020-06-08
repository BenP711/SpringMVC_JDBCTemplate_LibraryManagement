<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>${user.userName}'s profile</title>
<link href="<c:url value="/resources/css/userDetails.css" />"
	rel="stylesheet">
</head>
<body>
	<table>
		<tr>
			<td>
				<div class="name">${user.userName}</div>
			</td>
		</tr>
		<tr>
			<td class="details-td">
				<div class="label">Email Id</div> :
				<div class="phone">${user.emailId}</div> <br>
			<div class="label">Phone</div> :
				<div class="mobile">${user.phone}</div> <br>
			</td>
		</tr>
	</table>
</body>
</html>