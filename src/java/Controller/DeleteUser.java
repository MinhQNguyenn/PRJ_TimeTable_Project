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
public class DeleteUser extends HttpServlet{

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ArrayList <User> student = new ArrayList<>();
        ArrayList <User> teacher = new ArrayList<>();
        try{
            if(req.getParameter("mode").equals("1")){
                int mode = 1;
                String id = req.getParameter("id");
                User u = new User();
                u.deleteUser(mode, id);
                student = u.getListStudent();
            }else{
                int mode = 2;
                String id = req.getParameter("id");
                User u = new User();
                u.deleteUser(mode, id);
                teacher = u.getListTeacher();
            }
        }catch(Exception e){
            System.out.println("Delete: " + e.getMessage());
        }
        req.setAttribute("student", student);
        req.setAttribute("teacher", teacher);
        req.getRequestDispatcher("Admin.jsp").forward(req, resp);
    }
    
}
