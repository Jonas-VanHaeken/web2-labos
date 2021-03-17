package be.ucll.labo5_startoplossing.ui.controller;


import be.ucll.labo5_startoplossing.domain.db.StudentDB;
import be.ucll.labo5_startoplossing.domain.model.Student;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/StudentInfo")
public class StudentInformatie extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	StudentDB klas=new StudentDB();
       
    public StudentInformatie() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		processRequest(request, response);
	}

	private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String destination;
		String command = request.getParameter("command");
		if (command == null) command = "home";
		switch (command) {
			case "zoek":
				destination = zoek(request);
				break;
			case "voegToe":
				destination = voegToe(request);
				break;
			case "overview":
				destination = overview(request);
				break;
			case "deleteConfirmation":
				destination = "verwijderBevestiging.jsp";
				break;
			case "delete":
				destination = delete(request);
				break;
			default:
				destination = goHome(request);
		}
		request.getRequestDispatcher(destination).forward(request, response);
	}

	private String delete(HttpServletRequest request) {
    	String naam = request.getParameter("naam");
    	String voornaam = request.getParameter("voornaam");
    	String staat = request.getParameter("knop");

    	if(staat.equals("Zeker")){
    		klas.verwijder(naam,voornaam);
			request.setAttribute("studenten", klas.getKlas());
			return "studentOverview.jsp";
		} else {
    		return "index.jsp";
		}
	}


	private String overview(HttpServletRequest request) {
		request.setAttribute("studenten", klas.getKlas());
		return "studentOverview.jsp";
	}

	private String goHome(HttpServletRequest request) {
    	return  "index.jsp";
	}

	private String zoek(HttpServletRequest request) {
		String naam= request.getParameter("naam");
		String voornaam= request.getParameter("voornaam");
		String destination="";

		if (naam==null || voornaam== null) {
			destination="nietGevonden.jsp";
		}
		else {
			Student student=klas.vind(naam, voornaam);
			if (student==null) {
				destination="nietGevonden.jsp";
			}
			else {
				destination="gevonden.jsp";
				request.setAttribute("student", student);
			}
		}
		return destination;
	}

	private String voegToe(HttpServletRequest request) {
		String naam = request.getParameter("naam");
		String voornaam = request.getParameter("voornaam");
		String leeftijd = request.getParameter("leeftijd");
		String studierichting = request.getParameter("studierichting");

		String destination = "index.jsp";

		if (naam.isEmpty() || voornaam.isEmpty() || leeftijd.isEmpty() || studierichting.isEmpty()) {
			destination = "studentForm.jsp";
		}
		else {
			Student student = new Student(naam, voornaam, Integer.parseInt(leeftijd), studierichting);
			klas.voegToe(student);
			request.setAttribute("studenten", klas.getKlas());
			destination = "studentOverview.jsp";
		}
		return destination;
	}

}
