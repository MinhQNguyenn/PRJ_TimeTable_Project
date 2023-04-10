<%-- 
    Document   : AddUser
    Created on : Mar 11, 2023, 5:16:06 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add new Student</title>

        <link href="css/AddUser.css" rel="stylesheet">
    </head>
    <body style="background-image: url('img/addUser.jpg');">
        <div class="container">
            <form action="admin" method="get">
                <div class="row">
                    <h2>Add the new Student Info</h2>
                    <div class="input-group">
                        <input type="text" name="id" placeholder="ID"><br>
                        <input type="text" name="name" placeholder="Full Name"><br>
                        <input type="email" name="email" placeholder="student@fpt.edu.vn"><br>
                        <input type="text" name="pass" placeholder="Password"><br>
                        <input type="text" name="class" placeholder="Class"><br>
                        <input type="text" name="semester" placeholder="Semester"><br> 
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
                                <input type="date" name="dob">
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
                <input type="submit" name="student" value="Add to Student">
            </form>
        </div>
    </body>
</html>
