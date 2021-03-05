package controller;

import domain.db.StudentDB;
import domain.model.Student;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/VoegToeServlet")
public class VoegToeServlet extends HttpServlet {
    public StudentDB db = new StudentDB();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naam = request.getParameter("naam");
        String voornaam = request.getParameter("voornaam");
        String leeftijdParameter = request.getParameter("leeftijd");
        int leeftijd = Integer.parseInt(leeftijdParameter);
        String studierichting = request.getParameter("studierichting");

        RequestDispatcher view;

        if (naam == null || naam.trim().isEmpty() || voornaam == null || voornaam.trim().isEmpty() ||
                leeftijd <= 0 || studierichting == null || studierichting.trim().isEmpty()) {
            request.setAttribute("error", "U vulde niet alle velden in");
            view = request.getRequestDispatcher("studentForm.jsp");

        } else {
            Student student = new Student(naam, voornaam, studierichting, leeftijd);
            request.setAttribute("student", student);
            view = request.getRequestDispatcher("studentInfoOverzicht.jsp");
        }
        view.forward(request, response);
    }
}
