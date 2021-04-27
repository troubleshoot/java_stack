<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%> 
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>  
<%@ page isErrorPage="true" %>
  
<!DOCTYPE html>
<html>
	<head>
	<meta charset="UTF-8">
	<title>Create course</title>
</head>
<body>
	<div class="container">
		<a href="/courses">Home</a>
		<a href="/logout">Logout</a>
		<h3>Add a new course</h3>
		<p><form:errors path="course.*"/></p>
		<form:form action="/course/create" method="post" modelAttribute="course">
		<form:hidden path="" value="${user.id}"/>
			<p>
				<form:label path="course_name">Course: </form:label>
				<form:input path="course_name" type="text" class="form-control"/>
			</p>
        	
        	<p>
				<form:label path="instructor">Instructor:</form:label>
	            <form:input path="instructor" type="text" class="form-control"/>
			</p>
			
			<p>
	            <form:label path="capacity">Capacity:</form:label>
	            <form:input path="capacity" type="text" class="form-control"/>
        	</p>
			<input type="submit" value="Submit" />
			<a href="/courses">Cancel</a>
		</form:form>
	</div>
</body>
</html>