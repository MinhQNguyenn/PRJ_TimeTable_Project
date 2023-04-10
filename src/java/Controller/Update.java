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
import java.io.IOException;
import java.util.ArrayList;

/**
 *
 * @author minh
 */
public class Update extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> student = new ArrayList<>();
        try {
            if (req.getParameter("update") != null) {
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
                u.updateStudent(id);
                student = u.getListStudent();
            }
        } catch (Exception e) {
            System.out.println("Update: " + e.getMessage());
        }
        req.setAttribute("student", student);
        req.getRequestDispatcher("Admin.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        User u = new User(id);
        try {
            //ERROR BUG
            u.setUser(id);
        } catch (Exception e) {
            System.out.println("Update:" + e.getMessage());
        }
        req.setAttribute("student", u);
        req.getRequestDispatcher("Update.jsp").forward(req, resp);
    }

}
