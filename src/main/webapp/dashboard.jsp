<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 
<%@ page import="java.util.List" %>
<%@ page import="com.shantanu.Request" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% 
		response.setHeader("Cache-Control", "no-cache, no-store, must-revalidate");
		
		response.setHeader("Pragma", "no-cache");
	
		if(session.getAttribute("username") == null) {
			response.sendRedirect("login");
		}
	%>

	
	<form action="logout" method="post" align="right">
		<input type="submit" value="Logout">
	</form>
	
	<h1>Archived Requests</h1>
	<table border="1" cellspacing="0" cellpadding="5" align="center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Request Status</th>
				<th>Toggle Request Status</th>
			</tr>
		</thead>
		
		<tbody>
			<% 				
				List<Request> requestList = (List<Request>) request.getAttribute("requestList");
				for(Request req: requestList) {
					if(!req.isActive()) {
			%>
			
			<tr>
				<td><%= req.getId() %></td>
				<td><%= req.getFullName() %></td>
				<td><%= req.getEmail() %></td>
				<td><%= req.getMessage() %></td>
				<td><%= req.isActive() %></td>
				<td>
					<form action="dashboard" method="post">
						<button type="submit" value="<%= req.getId() %>" name="reqId">Active</button>
					</form>
				</td>		
			</tr>
			
			<% 
					}
				}
			%>
		</tbody>
	</table>
	
	
	
	<h1>Active Requests</h1>
	<table border="1" cellspacing="0" cellpadding="5" align="center">
		<thead>
			<tr>
				<th>Id</th>
				<th>Full Name</th>
				<th>Email</th>
				<th>Message</th>
				<th>Request Status</th>
				<th>Toggle Request Status</th>
			</tr>
		</thead>
		
		<tbody>
			<%
				for(Request req: requestList) {
					if(req.isActive()) {
			%>
			
			<tr>
				<td><%= req.getId() %></td>
				<td><%= req.getFullName() %></td>
				<td><%= req.getEmail() %></td>
				<td><%= req.getMessage() %></td>
				<td><%= req.isActive() %></td>
				<td>
					<form action="dashboard" method="post">
						<button type="submit" value="<%= req.getId() %>" name="reqId">Archive</button>
					</form>
				</td>		
			</tr>
			
			<% 		}
				}
			%>
		</tbody>
	</table>
	
	
</body>
</html>