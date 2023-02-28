<%@page import="pabasaraead2.entity.Employee"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<script src="../resources/index.js"></script>
<title>Manage Employees</title>
<link href="style.css" />
</head>
<body>

	<div>
		<table >
		  <thead>
		    <tr>
		      <th scope="col" >NIC</th>
		      <th scope="col" >Name</th>
		      <th scope="col" >Department</th>
		      <th scope="col" >Designation</th>
		      <th scope="col" >Joined</th>
		      <th scope="col" >Take Action</th>
		    </tr>
		  </thead>
		  <tbody>
		  
<% 
	ArrayList<Employee> list = (ArrayList<Employee>) request.getAttribute("userList");
	for(int i=0; i <list.size() ; i++){	
		
		int id = list.get(i).getId();
		String nic = list.get(i).getNic();
		String name = list.get(i).getName();
		String department = list.get(i).getDepartment();
		String designation = list.get(i).getDesignation();
		String joinedDate = list.get(i).getJoinedDate();
%>


		    <tr>
		      <th ><%= nic %></th>
		      <td ><%= name %></td>
		      <td ><%= department %></td>
		      <td ><%= designation %></td>
		      <td ><%= joinedDate %></td>
		      <td >
		 
		      <form action="employee/employee-page-load" method="GET">
		      <input type="hidden" name="id" value="<%= id %>">
		      	<button >Edit</button>
		      
		      </form>
		      	<button onClick="handleDelete('<%= id %>')"  >Delete</button>

		      </td>
		    </tr>
<%	
	}
%>

		  </tbody>
	</table>
	</div>
	<a href="/pabasaraead2">
		Home
	
	</a>
	
	<script >
	async function handleDelete(id){
		const result = await fetch("http://localhost:8080/pabasaraead2/employee/employee-delete/?id="+id , {method: 'delete'} )
		console.log(result)
		window.location.reload();
	}
	
	
	
	</script>
</body>
</html>