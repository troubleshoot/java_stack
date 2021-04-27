<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>  

<!DOCTYPE html>
<html>
<head>
	<meta charset="UTF-8">
	<title>Show Course</title>
</head>
<body>
	<div>
		<a href="/courses">Home</a>
		<a href="/courses/new">Add course</a>
		<a href="/logout">Logout</a>	
		<div>
			<h1>Edit <c:out value="${course.course_name}"/></h1>
			<h5>Instructor: <c:out value="${course.instructor}"/></h5>		
			<h5>Capacity: <c:out value="${course.capacity}"/></h5>
			<a href="/course/${course.id}/edit">Edit</a>
			<a href="/course/${course.id}/delete">Delete</a>				
		</div>		
	</div>
</body>
</html>