<%-- 
    Document   : AddSubject
    Created on : Apr 27, 2023, 4:31:04 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Subject</title>
        <link href="css/AddUser.css" rel="stylesheet">
    </head>
    <body style="background-image: url('img/addUser.jpg');">
        <div class="container">
            <form action="addSubject" method="post">
                <div class="row">
                    <h2>Add the new Subject Info</h2>
                    <div class="input-group">
                        <input type="text" name="courseId" placeholder="CourseID: 1-SE 2-AI 3-IA "><br>
                        <input type="text" name="name" placeholder="Subject Name"><br>
                        <input type="number" name="day" placeholder="Day of the week"><br>
                        <input type="number" name="slot" placeholder="Slot of the day"><br>
                        <input type="text" name="semester" placeholder="Semester"><br>
                        <input type="text" name="class" placeholder="Class"><br> 
                    </div>
                </div>
                <input type="submit" name="student" value="Add new Subject">
            </form>
        </div>
    </body>
</html>
