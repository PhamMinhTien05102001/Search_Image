<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	body {
	    background: url("https://images.unsplash.com/photo-1559825481-12a05cc00344?ixlib=rb-1.2.1&ixid=MnwxMjA3fDB8MHxleHBsb3JlLWZlZWR8M3x8fGVufDB8fHx8&w=1000&q=80") no-repeat fixed center center;
	    background-size: cover;
	    font-family: Montserrat;
	}
	
	.logo {
	    margin: 30px auto;
	    color: #fff;
	    text-align: center
	}
	
	.login-block {
	    width: 320px;
	    padding: 20px;
	    background: #fff;
	    border-radius: 5px;
	    border-top: 5px solid #386ece;
	    margin: 0 auto;
	}
	
	.login-block h1 {
	    text-align: center;
	    color: #000;
	    font-size: 18px;
	    text-transform: uppercase;
	    margin-top: 0;
	    margin-bottom: 20px;
	}
	
	.login-block input {
	    width: 100%;
	    height: 42px;
	    box-sizing: border-box;
	    border-radius: 5px;
	    border: 1px solid #ccc;
	    font-size: 14px;
	    font-family: Montserrat;
	    padding: 0 20px 0 10px;
	    outline: none;
	}
	
	#email{
		margin-bottom: 20px
	}
	
	#password{
		margin-bottom: 10px
	}
	
	.login-block input:active, .login-block input:focus {
	    border: 1px solid #386ece;
	}
	
	.login-block button {
	    width: 100%;
	    height: 40px;
	    background: #386ece;
	    box-sizing: border-box;
	    border-radius: 5px;
	    border: 1px solid #386ece;
	    color: #fff;
	    font-weight: bold;
	    text-transform: uppercase;
	    font-size: 14px;
	    font-family: Montserrat;
	    outline: none;
	    cursor: pointer;
	}
	
	.register{
		text-align: right;
		margin-bottom: 10px;
		
	}
	
	.error{
		color: red;
		text-align: center;
		margin-bottom: 10px;
	}
	.success{
		color: green;
		text-align: center;
		margin-bottom: 10px;
		font-size: 20px;
	}
</style>
</head>
<body>
	<h1 class="logo">SEARCH IMAGE</h1>
	<form action="XuLyLogin" method="post" class="login-block"  >
		<div class="success">
	    	<% String mess_success = (String) request.getParameter("register_success"); 
	    		if(mess_success != null){%>
					<%= mess_success %>
				<%}%>
		</div>
		
	    <h1>Login</h1>
	    <input type="text" placeholder="Email" id="email" name="email" />
	    <input type="password" placeholder="Password" id="password" name="password" />
	    <div class="register"><a href="register.jsp" style="text-decoration:none;color: black">Register ?</a></div>
	    <div class="error">
	    	<% String mess = (String) request.getParameter("error"); 
	    		if(mess != null){%>
					<%= mess %>
				<%}%>
		</div>
		
	    <button>Submit</button>
	</form>
</body>
</html>