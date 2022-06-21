<%@page import="java.text.SimpleDateFormat"%>
<%@page import="model.bean.SearchView"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
body{
	background: url("http://i.imgur.com/Eor57Ae.jpg") no-repeat fixed center center;
}
h1{
  font-size: 30px;
  color: #fff;
  text-transform: uppercase;
  font-weight: 300;
  text-align: center;
  margin-bottom: 15px;
}
table{
  width:100%;
  table-layout: fixed;
}
.tbl-header{
  background-color: rgba(255,255,255,0.3);
 }
.tbl-content{
  overflow-x:auto;
  margin-top: 0px;
  border: 1px solid rgba(255,255,255,0.3);
}
th{
  padding: 20px 15px;
  text-align: center;
  font-weight: 1000;
  font-size: 16px;
  color: #fff;
  text-transform: uppercase;
}
td{
  padding: 15px;
  text-align: center;
  vertical-align:middle;
  font-weight: 500;
  font-size: 14px;
  color: #fff;
  border-bottom: solid 1px rgba(255,255,255,0.1);
}

@import url(https://fonts.googleapis.com/css?family=Roboto:400,500,300,700);
section{
  margin: 50px;
}

::-webkit-scrollbar {
    width: 6px;
} 
::-webkit-scrollbar-track {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
} 
::-webkit-scrollbar-thumb {
    -webkit-box-shadow: inset 0 0 6px rgba(0,0,0,0.3); 
}
a{
	color: white
}
</style>
</head>
<body onload="setTimeout('window.location.reload()',60000)">
<section>
  <!--for demo wrap-->
  <h1>HISTORY SEARCH IMAGE TABLE</h1>
  <div class="tbl-header">
    <table>
      <thead>
        <tr>
          <th style="width: 7%;">ID Search</th>
          <th>Email</th>
          <th>Username</th>
          <th>Keyword</th>
          <th>Time Search</th>
          <th style="width: 25%;">Result</th>
          <th>Delete Search</th>
        </tr>
      </thead>

    	<tbody>
    <% ArrayList<SearchView> data = (ArrayList<SearchView>) request.getAttribute("ListSearchView");
    	SimpleDateFormat date = new SimpleDateFormat("hh:mm:ss dd-MM-yyyy");
    	for(SearchView s : data) {%>
    		<tr>
    			<td><%= s.getIdSearch() %></td>
    			<td><%= s.getEmail() %></td>
    			<td><%= s.getUsername() %></td>
    			<td><%= s.getKeyWord() %></td>
    			<td><%= date.format(s.getTimeSearch())%></td>
    			<td><%= s.getResult() %></td>
    			<td><a href="Admin?id=<%= s.getIdSearch() %>">Delete</a></td>
    		</tr>
    <%} %>
    	</tbody>
    </table>
  </div>
</section>

</body>
</html>