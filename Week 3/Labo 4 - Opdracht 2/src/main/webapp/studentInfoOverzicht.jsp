<%@ page import="domain.model.Student" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="domain.db.StudentDB" %>
<%! StudentDB db = new StudentDB();%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Overzicht Studenten</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>
<h2>Overzicht studenten</h2>
<table>
    <thead>
    <tr>
        <th>Naam</th>
        <th>Voornaam</th>
        <th>Leeftijd</th>
        <th>Studierichting</th>
    </tr>
    </thead>
    <tbody>
    <%
        if (request.getAttribute("student")!=null){
            db.add((Student) request.getAttribute("student"));
        }
        ArrayList<Student> studenten = db.getList();
        for (Student student:studenten){
    %>
    <tr>
        <td><%=student.getNaam()%></td>
        <td><%=student.getVoornaam()%></td>
        <td><%=student.getLeeftijd()%></td>
        <td><%=student.getStudierichting()%></td>
    </tr>
    <%
        }
    %>
    </tbody>
</table>
<a href="zoek.jsp">Zoek student</a> <br>
<a href="studentForm.jsp">Voeg student toe</a>
</body>
</html>
