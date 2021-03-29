<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Voeg een student toe</title>
</head>
<body>
	<header>
		<jsp:include page="Header.jsp">
			<jsp:param name="title" value="add"/>
		</jsp:include>

	</header>

	<main id="container">
	<article>
		<h2>Voeg een student toe</h2>

		<c:if test="${not empty errors}">
			<div class="alert alert-danger">
				<ul>
					<c:forEach items="${errors}" var="error">
						<li id="errorItem">${error}</li>
					</c:forEach>
				</ul>
			</div>
		</c:if>

		<form method="POST" action="StudentInfo?command=voegToe" novalidate>
			<fieldset>
				<legend>Student informatie</legend>
				<p class="form-group">
					<label class="control-label" for="naam">Naam: </label> <input
						id="naam" name="naam" type="text" value="${naamPreviousValue}" required>
				</p>
				<p class="form-group">
					<label class="control-label" for="voornaam">Voornaam: </label> <input
						id="voornaam" name="voornaam" type="text" value="${voornaamPreviousValue}">
				</p>
				<p class="form-group">
					<label class="control-label" for="leeftijd">Leeftijd: </label> <input
						id="leeftijd" name="leeftijd" type="text" value="${leeftijdPreviousValue}">
				</p>
				<p class="form-group">
					<label class="control-label" for="studierichting">Studierichting: </label> <input
						id="studierichting" name="studierichting" type="text" value="${studierichtingPreviousValue}">
				</p>
			</fieldset>
			<p>
				<label for="bewaar">&nbsp;</label> <input id="bewaar" type="submit"
					value="Voeg Student Toe">
			</p>

		</form>
	</article>
	</main>
</body>
</html>