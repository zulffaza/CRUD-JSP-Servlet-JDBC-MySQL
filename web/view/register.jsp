<%--
  Created by IntelliJ IDEA.
  User: faza
  Date: 20/04/17
  Time: 0:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session - Login</title>

    <link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <script src="<%= application.getContextPath() %>/assets/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <script src="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>

<%
    if (session.getAttribute("username") != null && session.getAttribute("password") != null)
        response.sendRedirect(application.getContextPath() + "/Index");
%>

<div class="container">
    <div class="jumbotron">
        <h2>Register</h2>
    </div>
</div>

<div class="container">
    <div class="jumbotron">
        <form action="<%= application.getContextPath() %>/Register" class="form-horizontal" method="post">
            <div class="form-group">
                <label class="control-label col-sm-2" for="username">Username :</label>
                <div class="col-sm-10">
                    <input type="text" class="form-control" id="username" name="username" placeholder="Masukkan username..." required>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-sm-2" for="password">Password :</label>
                <div class="col-sm-10">
                    <input type="password" class="form-control" id="password" name="password" placeholder="Masukkan password..." required>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-offset-2 col-sm-10">
                    <a href="<%= application.getContextPath() %>/Index">
                        <button type="button" class="btn btn-default">
                            <span class='glyphicon glyphicon-triangle-left'>&nbsp;</span>
                            Kembali
                        </button>
                    </a>

                    <button type="submit" class="btn btn-success">
                        <span class='glyphicon glyphicon-floppy-disk'>&nbsp;</span>
                        Register
                    </button>
                </div>
            </div>
        </form>
    </div>
</div>
</body>
</html>