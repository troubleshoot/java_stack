<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Dojo Survey Index</title>
</head>
<body>
	<h2>Submitted Info</h2>
	<p>Name: <c:out value="${name}"/></p>
	<p>Dojo Location: <c:out value="${location}"/></p>
	<p>Favorite Language: <c:out value="${language}"/></p>
	<p>Comment: <c:out value="${comment}"/></p>
	<a href="/">Go Back</a>
</body>
</html>