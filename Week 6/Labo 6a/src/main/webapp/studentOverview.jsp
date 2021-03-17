<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="java.util.Collection"%>
<%@ page import="be.ucll.labo5_startoplossing.domain.model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Overzicht Studenten</title>
</head>
<body>
	<header>
		<jsp:include page="Header.jsp">
			<jsp:param name="title" value="overview"/>
		</jsp:include>

	</header>

	<main id="container">
	<article>
		<h2>Overzicht studenten</h2>
		<c:choose>
			<c:when test="${studenten == null}">
				<p>Er zijn nog geen studenten toegevoegd.</p>
			</c:when>
			<c:otherwise>
				<table id="overview">
					<tr>
						<th>Naam</th>
						<th>Voornaam</th>
						<th class="getal">Leeftijd</th>
						<th>Studierichting</th>
					</tr>
					<c:forEach var="student" items="${studenten}">
						<tr>
							<td>${student.naam}</td>
							<td>${student.voornaam}</td>
							<td>${student.leeftijd}</td>
							<td>${student.studierichting}</td>
						</tr>
					</c:forEach>
				</table>
			</c:otherwise>
		</c:choose>


	</article>
	</main>
</body>
</html>