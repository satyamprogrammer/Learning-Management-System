<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>List Users</title>
		<!-- reference style sheet -->
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Users List</h2>
			</div>
		</div>
		
		<div id="container" >
			<div id="content">
				<table>
					<tr>
					<th>First Name</th>
					<th>Last Name</th>
					</tr>
					
					<c:forEach var="tempInstructor" items="${instructors}">
						<tr>
							<td> ${tempInstructor.firstName}</td>
							<td> ${tempInstructor.lastName}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>