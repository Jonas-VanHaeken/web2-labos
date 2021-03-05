<%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 24/02/2021
  Time: 21:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Voeg een student toe</title>
</head>
<body>
<h2>Voeg een student toe</h2>
<p id="message"><%= request.getAttribute("error")==null?"":request.getAttribute("error") %></p>

<form action="/VoegToeServlet" method="post">
    <p><label for="naam">Naam: </label>
        <input type="text" name="naam" id="naam">
    </p>
    <p><label for="voornaam">Voornaam: </label>
        <input type="text" name="voornaam" id="voornaam">
    </p>
    <p><label for="leeftijd">Leeftijd: </label>
        <input type="number" name="leeftijd" id="leeftijd">
    </p>
    <p><label for="studierichting">Studierichting: </label>
        <input type="text" name="studierichting" id="studierichting">
    </p>
    <p><input type="submit" value="Bewaar" id="bewaar"></p>
</form>

<a href="studentInfoOverzicht.jsp">Overzicht</a> <br>
<a href="zoek.jsp">Zoek student</a>

</body>
</html>
