<%@page import="org.json.*"%>
<%@page import="java.util.*"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"

    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<script src="https://cdn.tailwindcss.com"></script>
</head>
<style>
/* resets */
*,
*:before,
*:after {
  	margin: 0;
  	padding:0;
  	box-sizing: border-box;
}

body {

  font-family: 'Open Sans', sans-serif;
  background: url("https://colorlib.com/etc/searchf/colorlib-search-1/images/Search_001.png") no-repeat fixed center center;
  background-repeat: no-repeat;
  background-size: cover;
}
p {
  font-family: 'Muli', sans-serif;
}

h1 {
  font-family: 'Muli', sans-serif;
  text-transform: uppercase;
}

.container {
  width: 50%;
  margin: 0 auto;
  text-align: center;
}

/* ==== 1. animated seachbox ===== */
  #animated input[type=text] {
    width: 300px;
    box-sizing: border-box;
    border: 1px solid #c8c8c8;
    border-radius: 4px;
    font-size: 16px;
    background-color: white;
    padding: 12px 20px 12px 40px;
    -webkit-transition: width 0.5s ease-out;
    transition: width 0.5s ease-out;
}

#animated input[type=text]:focus {
    width: 500px;
}

#animated i {
  position: relative;
  left: 30px;
}

/* ===== 2. standard seachbox ==== */

.search-txt-input{
  padding: 12px 20px;
  font-size:14px;
  border:1px solid #c8c8c8;
  border-right:0px;
  border-top-left-radius: 4px 4px;
  border-bottom-left-radius: 4px 4px;
  width: 200px;
}
.search-button {
  padding: 12px 15px;
  font-size: 16px;
  outline: none;
  text-align: center;
  text-decoration: none;
  color: #ffffff;
  border: solid 1px #c8c8c8;
  border-right: 0px;
  background: #3f5df4;
  border-top-right-radius: 4px 4px;
  border-bottom-right-radius: 4px 4px;
  position: relative;
  left:-5px;
}
.search-button:hover {
  text-decoration: none;
  background: #0a26b6;
}

/* Fixes submit button height problem in Firefox */
.search-button::-moz-focus-inner {
  border: 0;
}

/* === 3. standard animated seachbox === */

#animated-2 .search-txt-input{
  width: 200px;
  -webkit-transition: width 0.5s ease-out;
  transition: width 0.5s ease-out;
}

#animated-2 input[type=text]:focus {
    width: 500px;
}

/* == 4. standard seachbox with icon === */

input[type='submit'] {
background-color:#E51284 !important;
color:#fff !important;
cursor:pointer !important!important;
}
input[type='submit']:hover {
background-color:#ea419c !important;
color:#fff !important;
cursor:pointer !important;
}

/* === 5. standard seachbox with icon animated === */

#standard-3 .search-txt-input{
  width: 200px;
  -webkit-transition: width 0.5s ease-out;
  transition: width 0.5s ease-out;
}

#standard-3 input[type=text]:focus {
    width: 500px;
}

#animated-2{
    text-align: center;
}
.title{
	text-align: center;
	color: white;
	margin-top: 70px;
	font-size: 70px;
    font-weight: bold;
}

.header {
  overflow: hidden;
  background-color: #020c39;
  padding: 0px 10px;
}

.header a {
  float: left;
  color: white;
  text-align: center;
  padding: 12px;
  text-decoration: none;
  font-size: 18px; 
  line-height: 25px;
  border-radius: 4px;
}

.header a.logo {
  font-size: 25px;
  font-weight: bold;
}

.header a.active {
  color: white;
}

.header-right {
  float: right;
}

@media screen and (max-width: 500px) {
  .header a {
    float: none;
    display: block;
    text-align: left;
  }
  
  .header-right {
    float: none;
  }
}

.active:hover{
	background-color: #3f5df4
}
</style>
<body>
	<div class="header">
	  <a class="logo">SEARCH IMAGE</a>
	  <div class="header-right">
	  <% 
	  	 String username = (String) request.getAttribute("username");
	  	 String email = (String) request.getAttribute("email");
	  %>
	    <a class="active" href="User?email=<%= email %>"><%= username %></a>
	  </div>
	</div>
	<div class="search-body">
		<h1 class="title">SEARCH IMAGE</h1>
		<form id="animated-2" action="XuLySearch" method="post">
			<input type="hidden" class="search-txt-input" name="email" value=<%= email %>>
		    <input type="text" class="search-txt-input" name="keyword" maxlength="100">
		    <input type="submit" value="search" class="search-button" placeholder="Search for something">
		 </form>  
	</div>
	<div class="mt-3 mb-2 text-center text-white text-xl">
		<%
			String keywordSearch =(String) request.getAttribute("keywordSearch");
		    if(keywordSearch!=null && !keywordSearch.isEmpty()) {
		    	%>
		    	<span>Results of search keyword : <span><%=keywordSearch %></span></span>
		    	<%
		    }
		%>
	</div>
	<div class="grid grid-cols-3 gap-4 mt-3 px-12">
		
		<% JSONObject jsonRes = (JSONObject) request.getAttribute("jsonResult");
			JSONArray linksImg= null;
			String[] linksArray = {};
		   if(jsonRes !=null &&jsonRes.has("links")){
			   linksImg =(JSONArray) jsonRes.get("links");
			  
		   }
		   if(linksImg != null && linksImg.length()>0){
		   		for(int i = 0 ; i <linksImg.length();i++) {
		   			%>
		   			<div class="shadow-lg rounded-lg h-72 overflow-hidden bg-white">
		   				<img class="w-full object-cover object-center h-full duration-300 ease-in hover:scale-105" src="<%=linksImg.get(i).toString() %>" alt="something"/>
		   			</div>
		   			<%
		   		}
		   }
		  %>
	</div>
</body>
</html>