
<%@include file="header.jsp"%>

<form action="../login" method="GET">
	<table align="center">
		<tr>
			<td>User Name:</td>
			<td><input type="text" size="5" name="userName" /></td>
		</tr>
		<tr>
			<td>Password:</td>
			<td><input type="password" size="5" name="password" /></td>
		</tr>
		<tr>
			<td><input type="submit" name="login" value="Login" /></td>
			<td><a href="register.jsp">Sign Up</a></td>
		</tr>
	</table>
</form>

<%@include file="footer.jsp"%>