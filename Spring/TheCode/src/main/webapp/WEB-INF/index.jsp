<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
    
<!DOCTYPE html>
<html>
<head>
<title>Insert title here</title>
</head>
<body>
	<p style= "color:red"><c:out value="${error}"/></p>
	<form method="POST" action="/code">
    	<label>What is the code? <input type="text" name="code"></label>
    	<button>Try Code</button>
	</form>
</body>
</html>