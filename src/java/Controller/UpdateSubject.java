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
public class UpdateSubject extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList <Subject> subject = new ArrayList<>();
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

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String classes = req.getParameter("class");
        int day = Integer.parseInt(req.getParameter("day"));
        int slot = Integer.parseInt(req.getParameter("slot"));
        String name = req.getParameter("name");
        Subject u = new Subject(name, classes, slot, day);
        req.setAttribute("student", u);
        req.getRequestDispatcher("Update.jsp").forward(req, resp);
    }
    
}
