<html>
<jsp:include page="../includes.jsp" />
<head>
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>
</head>
<body>
<h3><b><font size="3" color="Green">LOGIN FORM</font></b></h3>
<div id="errorBlockId"></div>
 <form action="../login/home.htm" method="POST">
 	<table border="1">
	 	<tr>
			<td>Email</td>
			<td><input id="emailId" type="text" name="emailId" placeholder="Enter your EmailId" /></td>
		</tr>
		<tr>
			<td>Password</td>
			<td><input id="password" type="password" name="password" placeholder="Enter your Password"/></td>
		</tr>
		<tr>
			<!-- <td><input type="submit" value="Login" onclick="handleClick()"/></td> -->
			<td><input type="submit" value="Login"/></td>
		</tr>
	</table>
</form>

<script type="text/javascript">
  function handleClick()
  {
	  var eId, pass;
	  eId = $('#emailId').val();
	  pass = $('#password').val();
	  var pattern = /^\b[A-Z0-9._%-]+@[A-Z0-9.-]+\.[A-Z]{2,4}\b$/i;
	  if(eId == ' ' ){
		  var errName = $("#errorBlockId"); //Element selector
		   errName.html("Please enter valid Email");
		 	document.getElementById('errorBlockId').innerHTML = '<p>Please enter valid Email</p>';
		  
	  }
	  
	  return false;
	  
     
  }
</script>
</html>
</body>