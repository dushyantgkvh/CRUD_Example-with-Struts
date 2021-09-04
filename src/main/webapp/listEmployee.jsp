<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
table {
	border-collapse: collapse;
	width: 100%;
}

th, td {
	text-align: left;
	padding: 8px;
}

tr:nth-child(even) {
	background-color: #f2f2f2
}

th {
	background-color: #04AA6D;
	color: white;
}
</style>
<body>

	<a href="/StrutsExam/newEmployee.jsp"><h2>NEW REGISTER</h2></a>
	<h1 align="center">List of Employees</h1>
	<table border="1" style="width: 50%" align="center">
		<tr>
			<th>Id</th>
			<th>Name</th>
			<th>Company</th>
			<th>Edit</th>
			<th>Delete</th>
		</tr>

		<c:forEach items="${employees}" var="emp">
			<tr>
				<td>${emp.id}</td>
				<td>${emp.name}</td>
				<td>${emp.company}</td>
				<td><a
					href="editEmployee.jsp?id=${emp.id}&name=${emp.name}&company=${emp.company}">Edit</a></td>
				<td><a href="deleteEmployee.do?id=${emp.id}">Delete</a></td>
			</tr>
		</c:forEach>

	</table>
</body>
</html>