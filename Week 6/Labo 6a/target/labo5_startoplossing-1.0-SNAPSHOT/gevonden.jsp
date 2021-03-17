<%@ page import="be.ucll.labo5_startoplossing.domain.model.Student" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Gevonden</title>
<link rel="stylesheet" href="css/sample.css">
</head>
<body>
<header>
	<jsp:include page="Header.jsp">
	<jsp:param name="title" value="zoek"/>
	</jsp:include>


		
</header>
<main>
<p id="boodschap">Je vroeg naar volgende gegevens: ${student.format()}</p>
</main>

</body>
</html>