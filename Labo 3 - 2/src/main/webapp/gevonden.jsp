<%@ page import="javax.xml.crypto.Data" %>
<%@ page import="domain.db.Database" %><%--
  Created by IntelliJ IDEA.
  User: jonas
  Date: 16/02/2021
  Time: 15:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Gevonden</title>
</head>
<body>
<p><%= request.getAttribute("resultaat") %></p>
<a href="zoek.jsp">back</a>
</body>
</html>