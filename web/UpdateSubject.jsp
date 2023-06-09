<%-- 
    Document   : UpdateSubject
    Created on : Apr 27, 2023, 10:54:01 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Update student</title>
        <link href="css/UpdateUser.css" rel="stylesheet">
    </head>
    <body style="background-image: url('img/addUser.jpg');">
        <%
        User u = new User();
        if(request.getAttribute("subject") != null){
            u = (User)request.getAttribute("student");
        }
        %>
        <div class="container">
            <form action="updateSubject" method="post">
                <div class="row">
                    <h2>Update Student Info</h2>
                    <div class="input-group">
                        <input type="text" name="id" value="<%=u.getID()%>" readonly>
                        <input type="text" name="name" value="<%=u.getName()%>"><br>
                        <input type="email" name="email" value="<%=u.getEmail()%>"><br>
                        <input type="text" name="pass" value="<%=u.getPassword()%>"><br>
                        <input type="text" name="class" value="<%=u.getClasses()%>"><br>
                        <input type="text" name="semester" value="<%=u.getSemester()%>"><br> 
                        <select name="facility">
                            <option>Select Campus</option>
                            <option value="Hola">FU-Hòa Lạc</option>
                            <option value="Xavalo">FU-Hồ Chí Minh</option>
                            <option value="Fuda">FU-Đà Nẵng</option>
                            <option value="Hovilo">FU-Cần Thơ</option>
                            <option value="QN">FU-Quy Nhơn</option>
                        </select>
                    </div>
                </div>

                <div class="row">
                    <div class="col-half">
                        <h4>Date of birth</h4>
                        <div class="input-group">
                            <div class="col-third">
                                <input type="date" name="dob" value="<%=u.getDob()%>">
                            </div>
                        </div>
                    </div>
                    <div class="col-half">
                        <h4>Gender</h4>
                        <div class="input-group">
                            <input type="radio" name="gender" value="1" id="gender-male">
                            <label for="gender-male">Male</label>
                            <input type="radio" name="gender" value="0" id="gender-female">
                            <label for="gender-female">Female</label>
                        </div>
                    </div>
                </div>
                <input type="submit" name="update" value="Update to Student">
            </form>
        </div>
    </body>
