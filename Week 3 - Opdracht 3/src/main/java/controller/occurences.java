package controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Occurences")
public class occurences extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String woord = request.getParameter("woord");
        String letter = request.getParameter("letter");
        char[] letterArr = letter.toCharArray();
        char[] chars = woord.toCharArray();
        int count = 0;
        for (char c:chars) {
            char kleineC = Character.toLowerCase(c);
            char kleineLetter = Character.toLowerCase(letterArr[0]);
            if (kleineC==kleineLetter){
                count++;
            }
        }

        request.setAttribute("result", count);
        RequestDispatcher view = request.getRequestDispatcher("result.jsp");
        view.forward(request, response);


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
