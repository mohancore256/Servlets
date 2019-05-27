<%@include file="header.jsp"%>
<form action="../register" method="POST">
	<center>
		<h3>Student Registration form</h3>
	</center>
	<table align="center">
		<tr>
			<td>FIRST NAME</td>
			<td><input type="text" size="10" name="firstName" /></td>
		</tr>
		<tr>
			<td>LAST NAME</td>
			<td><input type="text" size="10" name="lastName" /></td>
		</tr>
		<tr>
			<td>EMAIL ID</td>
			<td><input type="text" name="Email_Id" maxlength="100" /></td>
		</tr>
		<tr>
			<td>User Name:</td>
			<td><input type="text" size="5" name="userName" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" size="5" name="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="register" value="register" /></td>

		</tr>
	</table>
</form>
<%@include file="footer.jsp"%>