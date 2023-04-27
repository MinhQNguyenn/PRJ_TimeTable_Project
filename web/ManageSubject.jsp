<%-- 
    Document   : ManageSubject
    Created on : Apr 27, 2023, 4:11:59 PM
    Author     : minh
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import = "Model.Subject" %>
<%@page import="java.util.ArrayList" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manage Subject</title>
        <link href="css/admin.css" rel="stylesheet">
    </head>
    <body>
        <body style="background-image: url('img/admin.jpg');">
        <input type="submit" onClick="getInformation()" value="Logout"/> 
        <h2>List of Students</h2>
        <div class="table-wrapper">
        <form action="manageSubject" method="post">
            <table class="fl-table">
                    <thead>
                        <tr>
                            <th>Course Name</th>
                            <th>Subject Name</th>
                            <th>Day</th>
                            <th>Slot</th>
                            <th>Semeter</th>
                            <th>Class</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.subject}" var="item">
                        <tr>
                            <td>${item.getCourseID()}</td>
                            <td>${item.getName()}</td>
                            <td>${item.getDay()}</td>
                            <td>${item.getSlot()}</td>
                            <td>${item.getSemester()}</td>
                            <td>${item.getClasses()}</td>
                            <td><a href="delete?mode=4&class=${item.getClasses()}&name=${item.getName()}&day=${item.getDay()}&slot=${item.getSlot()}" onclick="return confirm('Are you sure you want to delete this item?');">Delete</a></td>
                            <td><a href="updateSubject?mode=3&class=${item.getClasses()}&name=${item.getName()}&day=${item.getDay()}&slot=${item.getSlot()}">Update</a></td>
                        </tr>
                    </c:forEach>
                </table>
        </form>
        <button onclick="location.href = 'AddSubject.jsp'">Add new Subject</button><br>
        </div>
    </body>
</html>
