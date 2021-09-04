<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<style>
th, td {
	padding: 10px;
}
</style>

<body>

	<h3 style="color: red">Enter your details</h3>

	<h:form action="newEmployee.do" method="post">
		<table align="center">

			<tr>
				<th>Name</th>
				<td><input type="text" name="name" value="${employee.name}"></td>
			</tr>
			<tr>
				<th>Company</th>
				<td><input type="text" name="company"
					value="${employee.company}"></td>
			</tr>
			<tr>
				<td><input type="hidden" name="id" value="${employee.id}"></td>
				<td><input type="submit" value="Submit" /></td>
			</tr>

		</table>
	</h:form>


</body>
</html>