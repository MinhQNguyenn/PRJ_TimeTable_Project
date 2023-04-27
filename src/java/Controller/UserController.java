/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.User;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class UserController extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> student = new ArrayList<>();
        ArrayList<User> teacher = new ArrayList<>();
        //Add the info for the new student to the database based on user's input
        // on the AddUser.jsp page
        try {
            if (req.getParameter("Add1") != null) {
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String pass = req.getParameter("pass");
                String email = req.getParameter("email");
                String dob = req.getParameter("dob");
                String gender = "Male";
                if (req.getParameter("gender").equals("0")) {
                    gender = "Female";
                }
                String classes = req.getParameter("class");
                String semester = req.getParameter("semester");
                String facility = req.getParameter("facility");
                User u = new User(name, id, semester, classes, gender, email, pass, dob, facility);
                u.addUser(0);
                student = u.getListStudent();
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        req.setAttribute("student", student);
        req.getRequestDispatcher("Admin.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        //Add another user to the database
        ArrayList<User> student = new ArrayList<>();
        try {
            if (req.getParameter("student") != null) {
                //Check empty first
                int mode = 2;
                String id = req.getParameter("id");
                String name = req.getParameter("name");
                String pass = req.getParameter("pass");
                String email = req.getParameter("email");
                String dob = req.getParameter("dob");
                String gender = "Female";
                if (req.getParameter("gender").equals("1")) {
                    gender = "Male";
                }
                String classes = req.getParameter("class");
                String semester = req.getParameter("semester");
                String facility = req.getParameter("facility");
                
                User u = new User(name, id, semester, classes, gender, email, pass, dob, facility);
                //Add to the student table in the database
                u.addUser(mode);
                student = u.getListStudent();
            } 
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
        req.setAttribute("student", student);
        req.getRequestDispatcher("Admin.jsp").forward(req, resp);
    }

}
