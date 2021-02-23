package controller;

import domain.db.Database;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    private Database db = new Database();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String naamFromParameter = request.getParameter("achternaamField");
        String voornaamFromParameter = request.getParameter("voornaamField");
        String resultMessage = db.zoeken(voornaamFromParameter,naamFromParameter);
        request.setAttribute("resultaat", resultMessage);
        RequestDispatcher view;
        if (resultMessage==null) view = request.getRequestDispatcher("nietgevonden.jsp");
        else {
            view = request.getRequestDispatcher("gevonden.jsp");
        }
        view.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
