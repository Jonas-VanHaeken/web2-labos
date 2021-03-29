<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/sample.css">
<meta charset="UTF-8">
<title>Studenten</title>
</head>
<body>
	<header>
		<jsp:include page="Header.jsp">
			<jsp:param name="title" value="zoek"/>
		</jsp:include>
	</header>

	<main id="container">
	<article>
		<h1>Zoek een student</h1>
		<form method="post" action="StudentInfo?command=zoek" novalidate>
			<p>Wie zoek je?</p>
			<p class="form-group">
				<label class="control-label" for="naam">Naam: </label> <input
					id="naam" name="naam" type="text" value="" required>
			</p>
			<p class="form-group">
				<label class="control-label" for="voornaam">Voornaam: </label> <input
					id="voornaam" name="voornaam" type="text" value="">
			</p>

			<p>
				<label for="zoek">&nbsp;</label> <input id="zoek" type="submit"
					value="Vind Student">
			</p>

		</form>
	</article>
	</main>
</body>
</html>