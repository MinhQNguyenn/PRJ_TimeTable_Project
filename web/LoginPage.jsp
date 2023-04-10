<%-- 
    Document   : LoginPage
    Created on : Mar 15, 2023, 12:59:23 PM
    Author     : minh
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<head>
    <meta charset="utf-8">
    <title>FPT University Academic Portal</title>
    <meta content="width=device-width, initial-scale=1.0" name="viewport">
    <meta content="Login Form Template" name="keywords">
    <meta content="Login Form Template" name="description">

    <!-- Stylesheet -->
    <link href="css/login.css" rel="stylesheet">
</head>

<body style="background-image: url('img/background.jpg');">
    <div class="wrapper login-3">
        <div class="container">
            <div class="col-left">
                <div class="login-text">
                    <h2><img src="img/dk_logo.png" alt="Logo"></h2>
                    <p>
                        Trường Đại học FPT được thành lập từ tháng 9/2006, là đại học tư thục đầu tiên do 
                        một doanh nghiệp đứng ra thành lập
                    </p>

                </div>
            </div>
            <div class="col-right">
                <div class="login-form">
                    <h2>Login</h2>
                    <form action="login" method="post">
                        <select name="user">
                            <option>Select user type</option>
                            <option value="1">Student</option>
                            <!--                <option value="2">Teacher</option>-->
                            <option value="3">Admin</option>
                        </select>
                        <select name="facility">
                            <option>Select Campus</option>
                            <option value="hola">FU-Hòa Lạc</option>
                            <option value="xavalo">FU-Hồ Chí Minh</option>
                            <option value="fuda">FU-Đà Nẵng</option>
                            <option value="hovilo">FU-Cần Thơ</option>
                            <option value="qn">FU-Quy Nhơn</option>
                        </select><br><br>
                        <input type="text" name="email" placeholder="account@fpt.edu.vn"><br>
                        <input type="password" name="password" placeholder="Password"><br>
                        <input type="submit" name="Submit" value ="Login">
                    </form><br>
                    <div class="footer" style="font-size: 12px">
                        @Powered by <a href="https://fpt.edu.vn" target=_blank>FPT University</a> | <a
                            href="https://cmshn.fpt.edu.vn" target=_blank>CMS</a> |
                        <a href="https://library.fpt.edu.vn" target=_blank>library</a> | <a
                            href="https://library.books24x7.com/login.asp?ic=0" target=_blank>books24x7</a>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>

</html>
