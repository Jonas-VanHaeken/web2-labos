package be.ucll.labo5_startoplossing.ui.controller;


import be.ucll.labo5_startoplossing.domain.db.StudentDB;
import be.ucll.labo5_startoplossing.domain.model.Student;

import java.io.IOException;
import java.util.ArrayList;

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
    	ArrayList<String> errors = new ArrayList<String>();
    	Student student = new Student();
    	setNaam(student,request,errors);
    	setVoornaam(student,request,errors);
    	setLeeftijd(student,request,errors);
    	setStudierichting(student,request,errors);

		if(errors.size() == 0){
			try {
				klas.voegToe(student);
				return overview(request);
			} catch (IllegalArgumentException exc) {
				request.setAttribute("errors",exc.getMessage());
				return "studentForm.jsp";
			}
		} else{
			request.setAttribute("errors",errors);
			return "studentForm.jsp";
		}
	}

	private void setStudierichting(Student student, HttpServletRequest request, ArrayList<String> errors) {
		String studierichting = request.getParameter("studierichting");
		try {
			student.setStudierichting(studierichting);
			request.setAttribute("studierichtingClass","has-success");
			request.setAttribute("studierichtingPreviousValue", studierichting);
		} catch (IllegalArgumentException exc){
			errors.add(exc.getMessage());
			request.setAttribute("studierichtingClass","has-error");
		}

	}

	private void setLeeftijd(Student student, HttpServletRequest request, ArrayList<String> errors) {
		String leeftijd = request.getParameter("leeftijd");
		try {
			student.setLeeftijd(Integer.parseInt(leeftijd));
			request.setAttribute("leeftijdClass","has-success");
			request.setAttribute("leeftijdPreviousValue", leeftijd);
		} catch (IllegalArgumentException exc){
			errors.add(exc.getMessage());
			request.setAttribute("leeftijdClass","has-error");
		} catch (Exception  exception){
			errors.add("Ongeldige waarde voor leeftijd");
			request.setAttribute("leeftijdClass","has-error");
		}

	}

	private void setVoornaam(Student student, HttpServletRequest request, ArrayList<String> errors) {
		String voornaam = request.getParameter("voornaam");
		try {
			student.setVoornaam(voornaam);
			request.setAttribute("voornaamClass","has-success");
			request.setAttribute("voornaamPreviousValue", voornaam);
		} catch (IllegalArgumentException exc){
			errors.add(exc.getMessage());
			request.setAttribute("voornaamClass","has-error");
		}
	}

	private void setNaam(Student student, HttpServletRequest request, ArrayList<String> errors) {
		String naam = request.getParameter("naam");
		try {
			student.setNaam(naam);
			request.setAttribute("naamClass","has-success");
			request.setAttribute("naamPreviousValue", naam);
		} catch (IllegalArgumentException exc){
			errors.add(exc.getMessage());
			request.setAttribute("naamClass","has-error");
		}
	}

}
