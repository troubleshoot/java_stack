<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Welcome Page</title>
</head>
<body>
	<div class="container">
		<a href="/logout">Logout</a>
		
		<h1>Welcome, <c:out value="${user.name}"/>!</h1>
		
		<div>
			<table>
					<thead>
						<tr>
							<th>Courses</th>
							<th>Instructor</th>
							<th>Signups</th>
							<th>Action</th>
						</tr>
					</thead>
					<tbody>
						<c:forEach items="${courses}" var="course">
							<tr>
								<td><a href="/courses/${course.id}"><c:out value="${course.course_name}"/></a></td>
								<td><c:out value="${course.instructor}"/></td>
								<td><c:out value="0/${course.capacity}"/></td>
								<td>
						      		<a href="/course/${ course.id }/addUser">Add</a>
								</td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		<a href="/courses/new">Add course</a>
	</div>
</body>
</html>