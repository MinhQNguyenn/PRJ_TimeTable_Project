<%-- 
    Document   : SubjectInfo
    Created on : Mar 16, 2023, 3:08:17 PM
    Author     : minh
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Subject" %>
<%@page import="java.util.ArrayList" %>
<%@page import="jakarta.servlet.http.HttpSession" %>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Subject Info</title>
        <link href="css/admin.css" rel="stylesheet"> 
    </head>
    <body style="background-image: url('img/admin.jpg');">
        <%
            Subject subject = new Subject();
            if(request.getAttribute("info")!= null)
               subject = (Subject)request.getAttribute("info");
        %>
        <h2>Information of the Subject</h2>
        <div class="table-wrapper">
            <%--Table content of Students--%>
            <form action="admin" method="post" id="admin1">
                <table class="fl-table">
                    <thead>
                        <tr>
                            <th>SUBJECT INFORMATION</th>
                        </tr>
                    </thead>
                    <tr>
                        <td>Subject Name:<%=subject.getName()%></td>
                    </tr>
                    <tr>
                        <td>Course Name: <%=subject.getCourseName()%></td>
                    </tr>
                    <tr>
                        <td>Semester: <%=subject.getSemester()%></td>
                    </tr>
                    <tr>
                        <td>Class: <%=subject.getClasses()%></td>
                    </tr>
                </table>
            </form>
        </div>
    </body>
</html>
