<%-- 
    Document   : Admin
    Created on : Mar 8, 2023, 11:20:09 PM
    Author     : minh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.User" %>
<%@page import="java.util.ArrayList" %>
<%@page import="jakarta.servlet.http.HttpSession" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Admin Mode</title>
        <link href="css/admin.css" rel="stylesheet"> 
    </head>
    <body style="background-image: url('img/admin.jpg');">
        <h2>List of Students</h2>
        <div class="table-wrapper">
            <%--Table content of Students--%>
            <form action="admin" method="post" id="admin1">
                <table class="fl-table">
                    <thead>
                        <tr>
                            <th>StudentID</th>
                            <th>Name</th>
                            <th>Password</th>
                            <th>Email</th>
                            <th>DOB</th>
                            <th>Gender</th>
                            <th>Class</th>
                            <th>Semester</th>
                            <th>Facility</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.student}" var="item">
                        <tr>
                            <td>${item.getID()}</td>
                            <td>${item.getName()}</td>
                            <td>${item.getPassword()}</td>
                            <td>${item.getEmail()}</td>
                            <td>${item.getDob()}</td>
                            <td>${item.getGender()}</td>
                            <td>${item.getClasses()}</td>
                            <td>${item.getSemester()}</td>
                            <td>${item.getFacility()}</td>
                            <td><a href="delete?mode=1&id=${item.getID()}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
                            <td><a href="update?mode=1&id=${item.getID()}">Update</a></td>
                        </tr>
                    </c:forEach>
                </table>
            </form>
            
            <button onclick="location.href = 'AddUser.jsp'">Add new Student</button><br>
        </div>
        <%--Table content of Teachers
        <form action="admin" method="post" id="admin2">
        <table border = "1">
            <tr>
                <td>TeacherID</td>
                <td>Name</td>
                <td>Password</td>
                <td>Email</td>
                <td>DOB</td>
                <td>Gender</td>
                <td>Class</td>
                <td>Semester</td>
                <td>Facility</td>
            </tr>
            <c:forEach items="${requestScope.teacher}" var="item">
                <tr>
                    <td>${item.getID()}</td>
                    <td>${item.getName()}</td>
                    <td>${item.getPassword()}</td>
                    <td>${item.getEmail()}</td>
                    <td>${item.getDob()}</td>
                    <td>${item.getGender()}</td>
                    <td>${item.getClasses()}</td>
                    <td>${item.getFacility()}</td>
                    <td><a href="delete?mode=2&id=${item.getID()}">Delete</a></td>
                </tr>
            </c:forEach>
        </table>
        </form>
        <a href="AddUser.jsp">Add new Teacher<br>
        --%>
    </body>
</html>
