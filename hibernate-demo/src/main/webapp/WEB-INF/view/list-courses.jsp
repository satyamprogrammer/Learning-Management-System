<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
	<head>
		<title>List Courses</title>
		<!-- reference style sheet -->
		<link type="text/css"
				rel="stylesheet"
				href="${pageContext.request.contextPath}/resources/css/style.css" />F
	</head>
	<body>
		<div id="wrapper">
			<div id="header">
				<h2>Courses List</h2>
			</div>
		</div>
		
		<div id="container" >
			<div id="content">
				<table>
					<tr>
					<th>Course Name</th>
					<th>Description</th>
					</tr>
					
					<c:forEach var="tempCourse" items="${courses}">
						<tr>
							<td> ${tempCourse.name}</td>
							<td> ${tempCourse.description}</td>
						</tr>
					</c:forEach>
				</table>
			</div>
		</div>
	</body>
</html>