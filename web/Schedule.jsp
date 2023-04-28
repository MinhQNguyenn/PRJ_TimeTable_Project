<%-- 
    Document   : Schedule
    Created on : Mar 9, 2023, 11:10:09 AM
    Author     : minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.User" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Time Table</title>
        <link href="css/schedule.css" rel="stylesheet">
    </head>
    <body style="background-image: url('img/schedule2.jpg');">
        <script>
            function getInformation() {
                window.location.href = "LoginPage.jsp";
            }
        </script>
        <%
            String[][] subject = new String[7][4];
            if(request.getAttribute("subject")!= null)
               subject = (String[][])request.getAttribute("subject");
            String s;
        %>
        <h1>My Timetable</h1><br>
        <form action="info" method="post">
            <table class="myTimetable">
                <thead>
                    <tr>
                        <th></th>
                        <th>Monday</th>
                        <th>Tuesday</th>
                        <th>Wednesday</th>
                        <th>Thursday</th>
                        <th>Friday</th>
                        <th>Saturday</th>
                        <th>Sunday</th>
                    </tr>
                </thead>

                <tbody>
                    <tr>
                        <td>Slot 1</td>
                        <td>
                            <%s = subject[0][0];
                               if(!s.isEmpty()){
                                   out.print("<div>(7:30-9:30)</div>");
                               }
                            %>
                            <a href="info?day=0&slot=0">
                            <div class="subject"><%=subject[0][0]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[1][0];
                                if(!s.isEmpty()){
                                    out.print("<div>(7:30-9:30)</div>");
                                }
                            %>
                            <a href="info?day=1&slot=0">
                            <div class="subject"><%=subject[1][0]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[2][0];
                                if(!s.isEmpty()){
                                    out.print("<div>(7:30-9:30)</div>");
                                }
                            %>
                            <a href="info?day=2&slot=0">
                            <div class="subject"><%=subject[2][0]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[3][0];
                                if(!s.isEmpty()){
                                    out.print("<div>(7:30-9:30)</div>");
                                }
                            %>
                            <a href="info?day=3&slot=0">
                            <div class="subject"><%=subject[3][0]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[4][0];
                                if(!s.isEmpty()){
                                    out.print("<div>(7:30-9:30)</div>");
                                }
                            %>
                            <a href="info?day=4&slot=0">
                            <div class="subject"><%=subject[4][0]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[5][0];
                                if(!s.isEmpty()){
                                    out.print("<div>(7:30-9:30)</div>");
                                }
                            %>
                            <a href="info?day=5&slot=0">
                            <div class="subject"><%=subject[5][0]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[6][0];
                                if(!s.isEmpty()){
                                    out.print("<div>(7:30-9:30)</div>");
                                }
                            %>
                            <a href="info?day=6&slot=0">
                            <div class="subject"><%=subject[6][0]%></div>
                            </a>

                        </td>
                    </tr>
                    <tr>
                        <td>Slot 2</td>
                        <td>
                            <%s = subject[0][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=0&slot=1">
                            <div class="subject"><%=subject[0][1]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[1][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=1&slot=1">
                            <div class="subject"><%=subject[1][1]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[2][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=2&slot=1">
                            <div class="subject"><%=subject[2][1]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[3][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=3&slot=1">
                            <div class="subject"><%=subject[3][1]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[4][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=4&slot=1">
                            <div class="subject"><%=subject[4][1]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[5][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=5&slot=1">
                            <div class="subject"><%=subject[5][1]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[6][1];
                                if(!s.isEmpty()){
                                    out.print("<div>(10:00-12:20)</div>");
                                }
                            %>
                            <a href="info?day=6&slot=1">
                            <div class="subject"><%=subject[6][1]%></div>
                            </a>

                        </td>
                    </tr>
                    <tr>
                        <td>Slot 3</td>
                        <td>
                            <%s = subject[0][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=0&slot=2">
                            <div class="subject"><%=subject[0][2]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[1][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=1&slot=2">
                            <div class="subject"><%=subject[1][2]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[2][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=2&slot=2">
                            <div class="subject"><%=subject[2][2]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[3][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=3&slot=2">
                            <div class="subject"><%=subject[3][2]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[4][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=4&slot=2">
                            <div class="subject"><%=subject[4][2]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[5][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=5&slot=2">
                            <div class="subject"><%=subject[5][2]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[6][2];
                                if(!s.isEmpty()){
                                    out.print("<div>(12:50-15:10)</div>");
                                }
                            %>
                            <a href="info?day=6&slot=2">
                            <div class="subject"><%=subject[6][2]%></div>
                            </a>

                        </td>
                    </tr>
                    <tr>
                        <td>Slot 4</td>
                        <td>
                            <%s = subject[0][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=0&slot=3">
                            <div class="subject"><%=subject[0][3]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[1][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=1&slot=3">
                            <div class="subject"><%=subject[1][3]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[2][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=2&slot=3">
                            <div class="subject"><%=subject[2][3]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[3][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=3&slot=3">
                            <div class="subject"><%=subject[3][3]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[4][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=4&slot=3">
                            <div class="subject"><%=subject[4][3]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[5][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=5&slot=3">
                            <div class="subject"><%=subject[5][3]%></div>
                            </a>

                        </td>
                        <td>
                            <%s = subject[6][3];
                                if(!s.isEmpty()){
                                    out.print("<div>(15:20-17:40)</div>");
                                }
                            %>
                            <a href="info?day=6&slot=3">
                            <div class="subject"><%=subject[6][3]%></div>
                            </a>
                        </td>
                    </tr>
                </tbody>
            </table>
        </form><br>
        <input type="submit" onClick="getInformation()" value="Logout"/> 
    </body>
</html>
