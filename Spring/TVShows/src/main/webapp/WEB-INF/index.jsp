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
	<h1>Welcome, <c:out value="${user.name}" />!</h1>
	<p style="color: red;"><c:out value="${error}" /></p>
	<table>
		<thead>
			<tr>
				<th>Show</th>
				<th>Network</th>
				<th>AVG Rating</th>
			</tr>
		</thead>
		<tbody>
		<c:forEach items="${shows}" var="s">
			<tr>
				<td><a href="/shows/${s.id}">${s.title}</a></td>
				<td>${s.network}</td>
				<td>${s.avgRating}</td>
			</tr>
		</c:forEach>
		</tbody>
	</table>
	<a href="/shows/new">Add a show</a>
	<a href="/logout">Log Out</a>
</body>
</html>