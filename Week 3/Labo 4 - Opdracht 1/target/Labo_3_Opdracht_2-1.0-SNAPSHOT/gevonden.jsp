<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gevonden</title>
</head>
<body>
<p><%= request.getAttribute("resultaat") %></p>
<a href="zoek.jsp">back</a>
<a href="studentInfoOverzicht.jsp">Overzicht</a>
</body>
</html>
