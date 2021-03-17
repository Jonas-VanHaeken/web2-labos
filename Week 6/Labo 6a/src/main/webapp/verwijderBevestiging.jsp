<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="css/sample.css">
    <meta charset="UTF-8">
    <title>Verwijder een student</title>
</head>
<body>
<header>
    <jsp:include page="Header.jsp">
        <jsp:param name="title" value="overview"/>
    </jsp:include>

</header>

<main id="container">
    <article>
        <h2>Verwijder deze student</h2>

        <p>Ben je zeker dat je de student ${param.voornaam} ${param.naam} wil verwijderen?</p>
        <form action="StudentInfo?command=delete&naam=${param.naam}&voornaam=${param.voornaam}" method="post">
            <input type="submit" value="Zeker" name="knop">
            <input type="submit" value="Toch niet" name="knop">
        </form>
    </article>
</main>
</body>
</html>