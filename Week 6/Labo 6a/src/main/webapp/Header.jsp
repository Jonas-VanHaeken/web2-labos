<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<div>
    <h1>Studentenregistratie</h1>
    <nav>
        <ul>
            <c:choose>
                <c:when test="${param.title}==home">
                <li><a class="active" href="index.jsp">Home</a></li>
                <li><a href="zoekForm.jsp">Zoek een student</a></li>
                <li><a href="studentForm.jsp">Voeg een student toe</a></li>
                <li><a href="StudentInfo?command=overview">Bekijk alle studenten</a></li>
                </c:when>
                <c:when test="${param.title}==zoek">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a class="active" href="zoekForm.jsp">Zoek een student</a></li>
                    <li><a href="studentForm.jsp">Voeg een student toe</a></li>
                    <li><a href="StudentInfo?command=overview">Bekijk alle studenten</a></li>
                </c:when>
                <c:when test="${param.title}==add">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="zoekForm.jsp">Zoek een student</a></li>
                    <li><a class="active" href="studentForm.jsp">Voeg een student toe</a></li>
                    <li><a href="StudentInfo?command=overview">Bekijk alle studenten</a></li>
                </c:when>
                <c:when test="${param.title}==overview">
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="zoekForm.jsp">Zoek een student</a></li>
                    <li><a href="studentForm.jsp">Voeg een student toe</a></li>
                    <li><a class="active" href="StudentInfo?command=overview">Bekijk alle studenten</a></li>
                </c:when>
                <c:otherwise>
                    <li><a href="index.jsp">Home</a></li>
                    <li><a href="zoekForm.jsp">Zoek een student</a></li>
                    <li><a href="studentForm.jsp">Voeg een student toe</a></li>
                    <li><a href="StudentInfo?command=overview">Bekijk alle studenten</a></li>
                </c:otherwise>
            </c:choose>



        </ul>
    </nav>
</div>

<img alt="Toscane" src="images/student.jpg">