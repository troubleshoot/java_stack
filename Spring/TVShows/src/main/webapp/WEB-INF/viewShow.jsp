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
		<h3><c:out value="${show.title}" /></h3>
		<h5>Network: <c:out value="${show.network}"/></h5>
		<h3>Users who rated this show: (Avg Rating: <c:out value="${show.avgRating}" />)</h3>
		<table>
			<thead>
				<tr>
					<th>Name</th>
					<th>Rating</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${show.reviews}" var="s">
					<tr>
						<td>${s.user.name}</td>
						<td>${s.rating}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
		<div>
			<h3>Rate this Show</h3>
			<p style="color: black;"><c:out value="${error}" /></p>
		    <p style="color: black;"><form:errors path="review.*"/></p>
			<form:form method="POST" action="/shows/${show.id}/review" modelAttribute="review">
		        <p>
		            <form:label path="rating">Rating:</form:label>
			            <form:input type="text" path="rating"/>
		        </p>
		        <form:input type="hidden" path="user" value="${user.id}" />
		        <form:input type="hidden" path="show" value="${show.id}" />
		        <input type="submit" value="Submit Rating"/>
		    </form:form>
		</div>
		<a href="/shows/${show.id}/edit">Edit This Show</a>
		<a href="/shows">Dashboard</a>
</body>
</html>