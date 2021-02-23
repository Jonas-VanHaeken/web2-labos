<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zoek</title>
</head>
<body>
<form action="Servlet" method="GET">
    <p><label for="voornaam">Voornaam: </label>
        <input type="text" id="voornaam" name="voornaamField"></p>
    <p><label for="achternaam">Achternaam: </label>
        <input type="text" id="achternaam" name="achternaamField"></p>
    <p><input type="submit" value="Zoek"></p>
</form>
<a href="studentInfoOverzicht.jsp">Overzicht</a>
</body>
</html>
