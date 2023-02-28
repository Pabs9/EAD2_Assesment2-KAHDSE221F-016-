<%@page import="pabasaraead2.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="resources/index.js"></script>
<title>Edit Employee</title>
<link href="./style.css" />
</head>
<body>
<% 
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("userList");

		String nic = list.get(0).getNic();
		int id = list.get(0).getId();
		String name = list.get(0).getName();
		String department = list.get(0).getDepartment();
		String designation = list.get(0).getDesignation();

%>


	<div >
		<form action="/pabasaraead2/employee/employee-update/?id=<%= id %>" method="POST" >
			<div>
				<div>
					<label for="nic">NIC</label>
					<input id="nic" name="nic" value="<%= nic %>" type="text"/>
				</div>
				<div >
					<label for="name">Name</label>
					<input id="name" name="name" value="<%= name %>" type="text"/>
				</div>
				<div >
					<label for="department">Department</label>
					<input id="department" name="department" value="<%= department %>"  type="text"/>
				</div>
				<div >
					<label for="designation">Designation</label>
					<input id="designation" name="designation" value="<%= designation %>"  type="text"/>
				</div>
			</div>
			<div>
				<button >Update</button>
			</div>
		</form>
		
		
	</div>
	
	<form action="load-all-employees" method="GET">
		<button type="Submit"> See all Employees</button>
	</form>

</body>
</html>