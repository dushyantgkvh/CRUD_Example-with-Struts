<%@ taglib uri="http://struts.apache.org/tags-html" prefix="h"%>

<h:form action="/login">
	Username : <h:text property="username" />
	<br>
	<br>
	Password : <h:text property="password" />
	<br>
	<br>
	<h:submit />

	<hr>
	<h:errors />
</h:form>