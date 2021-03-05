<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>zoek</title>
</head>
<body>
<form action="ZoekServlet" method="GET">
    <p><label for="voornaam">Voornaam: </label>
        <input type="text" id="voornaam" name="voornaamField"></p>
    <p><label for="achternaam">Achternaam: </label>
        <input type="text" id="achternaam" name="achternaamField"></p>
    <p><input type="submit" value="Zoek" id="zoek"></p>
</form>
<a href="studentInfoOverzicht.jsp">Overzicht</a> <br>
<a href="studentForm.jsp">Voeg student toe</a>
</body>
</html>
