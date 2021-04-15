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
	<p style= "color:red"><c:out value="${error}"/></p>
	<form method="POST" action="/result">
    	<label>
    		Your Name: <input type="text" name="name">
    	</label>
		<label>
			Dojo Location:<select name="location">
				<option value="Burbank">Burbank</option>
				<option value="San-Jose">San-Jose</option>
				<option value="Seattle">Seattle</option>
			</select>
		</label>
		<label>
			Favorite Language:<select name="language">
				<option value="Python">Python</option>
				<option value="MERN">MERN</option>
				<option value="Java">Java</option>
			</select>
		</label>
    	<label>
    		Comment: <input type="text" name="comment">
    	</label>
    	<button>Button</button>
	</form>
</body>
</html>