<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>
  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Update course</title>
</head>
<body>
	<div>
		<a href="/courses">Home</a>	
		<a href="/logout">Logout</a>
		<h1>Edit <c:out value="${course.course_name}"/></h1>
		<div>
			<p><form:errors path="course.*"/></p>
			<form:form action="/course/${course.id}/update" method="post" modelAttribute="course">
			<input type="hidden" name="_method" value="put">
				<p>
					<form:label path="course_name">Course: </form:label>
					<form:input path="course_name" type="text" var="course_name" class="form-control"/>
				</p>
	        	<p>
					<form:label path="instructor">Instructor:</form:label>
		            <form:input path="instructor" type="text" class="form-control"/>
				</p>
				<p>
		            <form:label path="capacity">Capacity:</form:label>
		            <form:input path="capacity" type="text" class="form-control"/>
	        	</p>
		        <input type="submit" value="Submit"/>
		        <a href="/courses">Cancel</a>
	        </form:form>
		</div>
	</div>
</body>
</html>