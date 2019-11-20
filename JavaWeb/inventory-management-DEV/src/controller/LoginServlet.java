package controller;

import model.Staff;
import service.StaffJDBCServiceImpl;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


@WebServlet(name = "LoginServlet", urlPatterns = "/logins")
public class LoginServlet extends HttpServlet {
    private RequestDispatcher dispatcher;
    private HttpSession session;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String userName = request.getParameter("userName");
        String pass = request.getParameter("pass");
        StaffJDBCServiceImpl staffJDBCServiceImpl = new StaffJDBCServiceImpl();
        Staff staff= staffJDBCServiceImpl.CheckLogin(pass, userName);
        if (staff != null){
            session =  request.getSession();
            session.setAttribute("userLogin","sadad");
            response.sendRedirect("/homes");
        }
        else {
            request.setAttribute("errorLogin","Nhap sai");
            dispatcher = request.getRequestDispatcher("staff/login.jsp");
            dispatcher.forward(request, response);
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        if (session.getAttribute("userLogin") == null ){
            dispatcher = request.getRequestDispatcher("staff/login.jsp");
            dispatcher.forward(request, response);
        }
        else {
            response.sendRedirect("/homes");
        }

    }
}