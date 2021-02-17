<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 16/02/2021
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Zoek student</title>
</head>
<body>
<form action="gevonden.jsp" method="GET">
    <p><label for="voornaam">Voornaam: </label>
        <input type="text" id="voornaam" name="voornaamField"></p>
    <p><label for="achternaam">Achternaam: </label>
        <input type="text" id="achternaam" name="achternaamField"></p>
    <p><input type="submit" value="Zoek"></p>
</form>
</body>
</html>
