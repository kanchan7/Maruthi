<html>
<jsp:include page="../includes.jsp" />
<body>
<h3><b><font size="3" color="Green">REGISTRATION FORM</font></b></h3>
<form action="../login/welcome.htm">
	<table border="1">
	 	<tr>
			<td>FirstName</td>
			<td><input id="firstName" type="text" name="firstName" placeholder="firstName"/></td>
		</tr>
		<tr>
			<td>LastName</td>
			<td><input id="lastName" type="text" name="lastName" placeholder="lastName"/></td>
		</tr>
		<tr>
			<td>UserName</td>
			<td><input id="UserName" type="text" name="UserName" placeholder="UserName"/></td>
		</tr>
		<tr>
			<td>EmailId</td>
			<td><input id="emailId" type="text" name="emailId" placeholder="EmailId" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input id="password" type="password" name="password" placeholder="Password"/></td>
		</tr>
		<tr>
			<td><input type="submit" value="Register" onclick="handleClick()"/></td>
		</tr>
	</table>
</form>

<script type="text/javascript">
  function handleClick()
  {
     alert("abc");
     alert('2');
  }
</script>
</body>
</html>