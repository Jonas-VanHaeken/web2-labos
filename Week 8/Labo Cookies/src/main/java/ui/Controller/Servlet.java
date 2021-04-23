package ui.Controller;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet("/Servlet")
public class Servlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        processRequest(request,response);
    }

    private void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String destination;
        String command = request.getParameter("command");
        if (command==null) command = "home";
        switch (command){
            case "more":
                destination = "more.jsp";
                break;
            case "addCookie":
                destination = addCookie(request,response);
                break;
            default:
                destination = goHome(request,response);
                break;
        }
        request.getRequestDispatcher(destination).forward(request, response);
    }

    private String addCookie(HttpServletRequest request, HttpServletResponse response) {
        String quoteValue = request.getParameter("quote");
        if (quoteValue != null){
            Cookie quoteCookie = new Cookie("quote",quoteValue);
            response.addCookie(quoteCookie);
            request.setAttribute("quote",quoteCookie.getValue());
        }
        return "index.jsp";
    }

    private String goHome(HttpServletRequest request, HttpServletResponse response) {
        Cookie cookie = getQuoteCookie(request);
        if (cookie != null){
            request.setAttribute("quote", cookie.getValue());
        }
        return "index.jsp";
    }

    private Cookie getQuoteCookie(HttpServletRequest request){
        Cookie[] cookies = request.getCookies();
        if (cookies==null) return null;
        for (Cookie c:cookies) {
            if (c.getName().equals("quote")) {
                return c;
            }
        }
        return null;
    }
}
