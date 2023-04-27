/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.Subject;
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
public class AddSubject extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList <Subject> subject = new ArrayList<>();
        String courseID = req.getParameter("courseId");
        String name = req.getParameter("name");
        int day = Integer.parseInt(req.getParameter("day"));
        int slot = Integer.parseInt(req.getParameter("slot"));
        String semester = req.getParameter("semester");
        String classes = req.getParameter("class");
        Subject s = new Subject(name, day, semester, classes, courseID, slot);
        s.addSubject();
        subject = s.getListSubject();
        req.setAttribute("subject", subject);
        req.getRequestDispatcher("Admin.jsp").forward(req, resp);
    }
    
}
