<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<title>List Students</title>

<!-- reference style sheet -->
<link type="text/css" rel="stylesheet"
	href="${pageContext.request.contextPath}/resources/css/style.css" />

</head>
<body>
	<!-- put new button : Add new student -->
	<input type="button" value="Add Student"
		onclick="window.location.href='showFormForAddStudent'; return false;"
		class="add-button" />
	<div id="wrapper">
		<div id="header">

			<h1>Students List</h1>
		</div>
	</div>

	<div id="container">
		<div id="content">
			<table>
				<tr>
					<th>First Name</th>
					<th>Last Name</th>
					<th>Action</th>
				</tr>

				<c:forEach var="tempUser" items="${students}">
				<!-- construct an update link with customer id -->
					<c:url var="updateLink" value="/student/showFormForUpdateStudent" >
						<c:param name="studentId" value="${tempUser.id }" />
					</c:url>
					
					<!-- construct an delete link with customer id -->
					<c:url var="deleteLink" value="/student/delete" >
						<c:param name="studentId" value="${tempUser.id }" />
					</c:url>
				
					<tr>
						<td>${tempUser.firstName}</td>
						<td>${tempUser.lastName}</td>
						<td>
							<a href="${ updateLink}">Update</a>
							|
							<a href="${ deleteLink}"
								onclick="if(!(confirm('Are you sure you want to delete this'))) return false">Delete	</a>
						</td>
					</tr>
				</c:forEach>
			</table>
		</div>
		<div style=""></div>
		<p>
			<a href="${pageContext.request.contextPath }">Home</a>
		</p>
	</div>
</body>
</html>