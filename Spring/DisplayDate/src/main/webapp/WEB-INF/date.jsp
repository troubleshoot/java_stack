<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Date</title>
</head>
<body>
	<h1>Date:</h1>
	<h3>
		<c:out value="${date }" />
	</h3>
	<a href="/">Home</a>
</body>
</html>