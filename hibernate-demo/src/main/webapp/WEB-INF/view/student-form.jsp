<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!DOCTYPE html>
<html>
	<head>
		<title>Add Student Form</title>	
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css"
		 >
		 <link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/add-student-style.css"
		 >
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2> Add new Student</h2>
				
			</div>
		</div>
		
		<div id="container">
			<h3>Save Student</h3>
			
			<form:form action="saveStudent" modelAttribute="student" method="POST" >
				
				<!-- need to associate this data with customer id -->
				<form:hidden path="id" />
				
				<table>
					<tbody>
					
						<tr>
							<td><label>First Name:</label></td>
							<td><form:input path="firstName" /></td>
						</tr>
						<tr>
							<td><label>Last Name:</label></td>
							<td><form:input path="lastName" /></td>
						</tr>
						<tr>
							<td><label>Email Id:</label></td>
							<td><form:input path="emailId" /></td>
						</tr>
						<tr>
							<td><label>Gender:</label></td>
							<td><form:input path="gender" /></td>
						</tr>
						<tr>
							<td><label>Username:</label></td>
							<td><form:input path="userName" /></td>
						</tr>
						<tr>
							<td><label>Password:</label></td>
							<td><form:input path="password" /></td>
						</tr>
						<tr>
							<td><label></label></td>
							<td><input type="submit" value="Save" class="save" /></td>
						</tr>
						
					</tbody>
				</table>
				
			</form:form>
			
			<div style="clear;both;"></div>
			<p>
				<a href="${pageContext.request.contextPath }/student/students">Back to List</a>
			</p>
			
		</div>
		
	</body>
</html>