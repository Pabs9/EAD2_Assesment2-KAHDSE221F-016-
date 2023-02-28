<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

  <!DOCTYPE html>
<html>
<head>

<meta charset="UTF-8">
<script src="resources/index.js"></script>
<title>Manage Employees</title>
<link rel="stylesheet" href="style.css" />
</head>
<body>


	<div >
		<form action="register-new-employee" method="POST" >
			<div >
				<div >
					<label class="emp_label" for="nic">NIC</label>
					<input id="nic" name="nic"  type="text"/>
				</div>
				<div >
					<label for="name">Name</label>
					<input id="name" name="name"  type="text"/>
				</div>
				<div >
					<label for="department">Department</label>
					<input id="department" name="department"  type="text"/>
				</div>
				<div >
					<label for="designation">Designation</label>
					<input id="designation" name="designation"  type="text"/>
				</div>
			</div>
			<div >
				<button >Add new Employee</button>
			</div>
		</form>
		
		
	</div>
	
	<form action="load-all-employees?" method="GET">
		<button type="Submit">See all Employees</button>
	</form>

</body>
</html>

