<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	body {
	    background: url("http://i.imgur.com/Eor57Ae.jpg") no-repeat fixed center center;
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
	    margin-bottom: 20px;
	    font-size: 14px;
	    font-family: Montserrat;
	    padding: 0 20px 0 10px;
	    outline: none;
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
	.error{
		color: red;
		margin-bottom: 10px;
	}
	.login{
		text-align: right;
		margin-bottom: 10px;
		
	}
</style>
</head>
<body>
	<h1 class="logo">SEARCH IMAGE</h1>
	<form action="XuLyRegister" method="post" class="login-block"  >
	    <h1>Register</h1>
	    <input type="text" placeholder="Email" id="email" name="email" />
	    <div class="error">
	    	<% String email_mess = (String) request.getParameter("email_error"); 
	    		if(email_mess != null){%>
					<%= email_mess %>
				<%}%>
		</div>
		<div class="error">
			<% String email_exist = (String) request.getParameter("email_exist"); 
	    		if(email_exist != null){%>
					<%= email_exist %>
				<%}%>
		</div>
		
	    <input type="text" placeholder="Username" id="username" name="username" />
	    <div class="error">
	    	<% String user_mess = (String) request.getParameter("user_error"); 
	    		if(user_mess != null){%>
					<%= user_mess %>
				<%}%>
		</div>
		
	    <input type="password" placeholder="Password" id="password" name="password" />
	    <div class="error">
	    	<% String pass_mess = (String) request.getParameter("password_error"); 
	    		if(pass_mess != null){%>
					<%= pass_mess %>
				<%}%>
		</div>
		
	    <input type="password" placeholder="Confirm Password" id="password_confirm" name="password_confirm" />
	    <div class="error">
	    	<% String pass_conf_mess = (String) request.getParameter("password_confirm_error"); 
	    		if(pass_conf_mess != null){%>
					<%= pass_conf_mess %>
				<%}%>
		</div>
		<div class="error">
			<% String check = (String) request.getParameter("check"); 
	    		if(check != null){%>
					<%= check %>
				<%}%>
		</div>
		<div class="login"><a href="index.jsp" style="text-decoration:none;color: black">Login ?</a></div>
	    <button>Register</button>
	</form>
</body>
</html>