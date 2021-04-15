<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
	<%@ taglib prefix = "form" uri="http://www.springframework.org/tags/form"%>

<!--<c:out value="value"/> -->

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
    <link rel="stylesheet" href="/webjars/bootstrap/4.5.0/css/bootstrap.min.css" />
    <link rel="stylesheet" href="/css/main.css" />
    <script src="/webjars/jquery/3.5.1/jquery.min.js"></script>
    <script src="/webjars/bootstrap/4.5.0/js/bootstrap.min.js"></script>
    <title>Title Here</title>
</head>
<body>
	<div class= "container">
        <h1>Your Gold: <c:out value="${gold}"/></h1>
        <a class="btn btn-danger" href="/reset" role="button">RESET GOLD</a>
	    <div>
			<h3>Farm</h3>
			<p>(earns 10-20 gold)</p>
			<form action="/gold" method="post">
				<input type="submit" name="farm" value="Find Gold">
				<input type="hidden" name="location" value="farm">
			</form>
		</div>
	    <div>
			<h3>Cave</h3>
			<p>(earns 5-10 gold)</p>
			<form action="/gold" method="post">
				<input type="submit" name="farm" value="Find Gold">
				<input type="hidden" name="location" value="cave">
			</form>
		</div>
	    <div>
			<h3>House</h3>
			<p>(earns 2-5 gold)</p>
			<form action="/gold" method="post">
				<input type="submit" name="farm" value="Find Gold">
				<input type="hidden" name="location" value="house">
			</form>
		</div>
	    <div>
			<h3>Casino</h3>
			<p>(earns or loses 0-50 gold)</p>
			<form action="/gold" method="post">
				<input type="submit" name="farm" value="Find Gold">
				<input type="hidden" name="location" value="casino">
			</form>
		</div>
		<br>
		<textarea rows="5" cols="55"><c:out value="${activities}"></c:out></textarea>
	</div>
</body>
</html>