/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Subject;
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
public class DeleteUser extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }

    //This page would be redirected by the user when the user clicked on the link to delete the student
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList<User> student = new ArrayList<>();
        //Delete the corresponding student from the list
        try {
            if (req.getParameter("mode").equals("1")) {
                int mode = 1;
                String id = req.getParameter("id");
                User u = new User();
                u.deleteUser(mode, id);
                student = u.getListStudent();
            } //Delete Subject
            else if (req.getParameter("mode").equals("4")) {
                ArrayList<Subject> subject = new ArrayList<>();
                String classes = req.getParameter("classes");
                int day = Integer.parseInt(req.getParameter("day"));
                int slot = Integer.parseInt(req.getParameter("slot"));
                String name = req.getParameter("name");
                Subject s = new Subject();
                s.deleteSubject(classes, day, slot, name);
                subject = s.getListSubject();
                req.setAttribute("subject", subject);
                req.getRequestDispatcher("Admin.jsp").forward(req, resp);
            }
        } catch (Exception e) {
            System.out.println("Delete: " + e.getMessage());
        }
        req.setAttribute("student", student);
        req.getRequestDispatcher("Admin.jsp").forward(req, resp);
    }

}
