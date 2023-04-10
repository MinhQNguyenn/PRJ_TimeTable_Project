package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author minh
 */
public class LoginController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Check whether any parameter is empty -> not working
        if (req.getParameter("user") == null || req.getParameter("facility") == null
                || req.getParameter("email") == null || req.getParameter("password") == null) {
            resp.sendRedirect("LoginPage.jsp");
        }

        int mode = 2;
        //Set mode for access
        if (req.getParameter("user").equals("3")) {
            mode = 1;
        }
//        else if(req.getParameter("user").equals("2")){
//            mode = 3;
//        }
       
        String facility = req.getParameter("facility");
        String email = req.getParameter("email");
        String pass = req.getParameter("password");

        User u = new User(email, pass, facility);
        boolean check = u.checkUserExist(mode);
        if (check) {
            if (mode == 2) {
                //Setting the session for student
                HttpSession session = req.getSession();
                session.setAttribute("student", u);
                u.getUser(mode);
                //Create a 2 dimensions array -> String[Day][Slot] subject
                String[][] subject = new String[7][4];
                subject = u.setSubject();
                req.setAttribute("subject", subject);
                req.getRequestDispatcher("Schedule.jsp").forward(req, resp);
            } else if (mode==1){
                //Setting the session for admin
                HttpSession session = req.getSession();
                session.setAttribute("admin", u);
                User temp = new User();
                ArrayList<User> student = temp.getListStudent();
                ArrayList<User> teacher = temp.getListTeacher();
                req.setAttribute("student", student);
                req.setAttribute("teacher", teacher);
                req.getRequestDispatcher("Admin.jsp").forward(req, resp);
            }

        } else {
            resp.sendRedirect("LoginPage.jsp");
        }
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

}
