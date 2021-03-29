<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="css/sample.css">
<title>Niet gevonden</title>
</head>
<body>
	<header role="banner">
		<jsp:include page="Header.jsp">
			<jsp:param name="title" value="zoek"/>
		</jsp:include>
		
	</header>
	<main>
	<p id="foutboodschap">Helaas, de student waarnaar je vraagt is niet gevonden. </p>
	</main>

</body>
</html>