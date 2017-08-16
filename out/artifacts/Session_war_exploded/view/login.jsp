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
</head>
<body>
    <%
        if (session.getAttribute("username") != null && session.getAttribute("password") != null)
            response.sendRedirect("../web/view/index.jsp");
    %>

    <fieldset>
        <legend>
            <h3>Login</h3>
        </legend>

        <form method="post" action="../controller/actionLogin.jsp">
            <table>
                <tr>
                    <td>Username</td>
                    <td>:</td>
                    <td>
                        <input type="text" name="username" placeholder="Masukkan username..." required>
                    </td>
                </tr>
                <tr>
                    <td>Password</td>
                    <td>:</td>
                    <td>
                        <input type="text" name="password" placeholder="Masukkan password..." required>
                    </td>
                </tr>
                <tr>
                    <td colspan="2"></td>
                    <td>
                        <input type="submit" placeholder="Login">
                    </td>
                </tr>
            </table>
        </form>
    </fieldset>
</body>
</html>
