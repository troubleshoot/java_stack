<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>   
 
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Shows</title>
</head>
<body>
	<h2>${show.title}</h2>
    <p style="color: red;"><form:errors path="show.*"/></p>
	<form:form method="POST" action="/shows/${show.id}/update" modelAttribute="show">
        <p>
            <form:label path="title">Title:</form:label>
            <form:input type="text" path="title" />
        </p>
        <p>
            <form:label path="network">Network:</form:label>
            <form:input type="text" path="network" />
        </p>
    	    <form:input type="hidden" path="avgRating" value="${show.avgRating}"/>
        <form:input type="hidden" path="userT" value="${user.id}"/>
        <input type="submit" value="Update Show"/> <a href="/shows/${show.id}">Cancel</a>
    </form:form>
    <form action="/shows/${show.id}" method="post">
    	<input type="hidden" name="_method" value="delete">
    	<input type="submit" value="Delete Show">
	</form> 
</body>
</html>