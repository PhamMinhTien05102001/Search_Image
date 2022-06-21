<%@page import="model.bean.Account"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

<style>
	body {
	    background: url("https://colorlib.com/etc/cf/ContactFrom_v2/images/bg-01.jpg") no-repeat fixed center center;
	    background-size: cover;
	    font-family: Montserrat;
	}
	
	.logo {
	    margin: 30px auto;
	    color: #386ece;
	    text-align: center
	}
	
	.login-block {
	    width: 320px;
	    padding: 20px;
	    background: #fff;
	    border-radius: 5px;
	    border: 3px solid #386ece;
	    margin: 50px auto;
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
	    margin-top: 10px;
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
	
	label{
	    font-weight: bold;
	    margin-left: 5px
	}
</style>
</head>
<body>
	<% Account acc = (Account) request.getAttribute("account"); %>
	<form action="XuLyProfile" method="post" class="login-block"  >
	    <h1>Profile</h1>
	    
	    <label for="email">Email (No Edit)</label>
	    <input type="text" readonly placeholder="Email" id="email" name="email" value=<%= acc.getEmail() %> />
	    <div class="error">
	    	<% String email_mess = (String) request.getParameter("email_error"); 
	    		if(email_mess != null){%>
					<%= email_mess %>
				<%}%>
			<% String email_exist = (String) request.getParameter("email_exist"); 
	    		if(email_exist != null){%>
					<%= email_exist %>
				<%}%>
		</div>
		
		<label for="username">Username</label>
	    <input type="text" placeholder="Username" id="username" name="username" value="<%= acc.getUsername() %>" />
	    <div class="error">
	    	<% String user_mess = (String) request.getParameter("user_error"); 
	    		if(user_mess != null){%>
					<%= user_mess %>
				<%}%>
		</div>
		
		<label for="password">Password</label>
	    <input type="password" placeholder="Password" id="password" name="password" value=<%= acc.getPassword() %> />
	    <div class="error">
	    	<% String pass_mess = (String) request.getParameter("password_error"); 
	    		if(pass_mess != null){%>
					<%= pass_mess %>
				<%}%>
		</div>
		
		<label for="password_confirm">Confirm Password</label>
	    <input type="password" placeholder="Confirm Password" id="password_confirm" name="password_confirm" value=<%= acc.getPassword() %> />
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
		
	    <button>Change Profile</button>
	</form>
</body>
</html>