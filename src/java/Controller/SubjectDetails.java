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

/**
 *
 * @author minh
 */
public class SubjectDetails extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //Assume that we get the name
        String name = req.getParameter("Detail");
        Subject s = new Subject();
        s.setSubject(name);
        req.setAttribute("info", s);
        req.getRequestDispatcher("SubjectInfo.jsp").forward(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try{
            int day = Integer.parseInt(req.getParameter("day"));
            int slot = Integer.parseInt(req.getParameter("slot"));
            Subject subject = new Subject();
            subject.setSubject(day + 1, slot + 1);
            req.setAttribute("info", subject);
            req.getRequestDispatcher("SubjectInfo.jsp").forward(req, resp);
        }catch(Exception e){
            System.out.println("Subject: " + e.getMessage());
        }
    }
    
}
