<%@ page import="java.util.ArrayList" %>
<%@ page import="Model.UserModel" %>
<%@ page import="Model.FoodModel" %>
<%@ page import="java.text.NumberFormat" %><%--
  Created by IntelliJ IDEA.
  User: faza
  Date: 20/04/17
  Time: 0:21
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Session - Home</title>

    <link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <script src="<%= application.getContextPath() %>/assets/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <script src="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <%
        ArrayList<UserModel> userList = (ArrayList<UserModel>) request.getAttribute("userModels");
    %>

    <div class="container">
        <div class="jumbotron">
            <h2>
                Welcome

                <%
                    if (session.getAttribute("username") != null)
                        out.print(session.getAttribute("username") + "...");
                    else
                        out.print("Anonymous...");
                %>
            </h2>
        </div>
    </div>

    <div class="container">
        <div class="jumbotron">
            <table class="table table-hover">
                <thead>
                <tr>
                    <th>Nomor</th>
                    <th>Username</th>
                    <th>Waktu Terakhir Login</th>
                </tr>
                </thead>
                <tbody>
                <%
                    int i = 1;

                    for (UserModel userModel : userList) {
                %>

                <tr>
                    <td>
                        <%= i %>
                    </td>
                    <td>
                        <%= userModel.getUsername() %>
                    </td>
                    <td>
                        <%= userModel.getLastLogin() %>
                    </td>
                </tr>

                <%
                        i++;
                    }
                %>
                </tbody>
            </table>

            <br>
            <br>

            <%
                if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
            %>

            <a href="<%= application.getContextPath() %>/Index?action=logout">
                <button class="btn btn-warning">
                    <span class="glyphicon glyphicon-log-out">&nbsp;</span>
                    Logout
                </button>
            </a>

            <%
                } else {
            %>

            <a href="<%= application.getContextPath() %>/Register">
                <button type="button" class="btn btn-info">
                    <span class="glyphicon glyphicon-floppy-disk">&nbsp;</span>
                    Register
                </button>
            </a>

            <a href="<%= application.getContextPath() %>/Login">
                <button type="button" class="btn btn-primary">
                    <span class="glyphicon glyphicon-log-in">&nbsp;</span>
                    Login
                </button>
            </a>

            <%
                }
            %>
        </div>
    </div>

    <%
        if (session.getAttribute("username") != null && session.getAttribute("password") != null) {
    %>

    <div class="container">
        <div class="jumbotron">
            <h2>Daftar Makanan & Minuman</h2>

            <br>
            <div class="table-responsive">
                <a href="<%= application.getContextPath() %>/AddFood">
                    <button class="btn btn-default">
                        <span class="glyphicon glyphicon-plus">&nbsp;</span>
                        <b>Tambah Data</b>
                    </button>
                </a>

                <br>
                <br>

                <%
                    ArrayList<FoodModel> dataList = (ArrayList<FoodModel>) request.getAttribute("foodModels");
                    UserModel userModel = (UserModel) request.getAttribute("userModel");

                    NumberFormat format = NumberFormat.getNumberInstance();
                %>

                <table class='table table-hover'>
                    <thead>
                        <tr>
                            <th>Nomor</th>
                            <th>Nama</th>
                            <th>Harga</th>
                            <th>Asal</th>
                            <th>Opsi</th>
                        </tr>
                    </thead>

                <%
                    if (dataList != null) {
                        i = 1;

                %>
                    <tbody>
                <%
                        for (FoodModel model : dataList) {
                            String harga = format.format(model.getHarga());
                %>
                    <tr>
                        <td> <%= i %> </td>
                        <td> <%= model.getNama() %> </td>
                        <td>Rp. <%= harga.replace(',', '.') %> ,00 </td>
                        <td> <%= model.getAsal() %> </td>
                <%
                    if (model.getUserId() == userModel.getId()) {
                %>

                        <td>
                            <a href='<%= application.getContextPath() %>/AddFood?id=<%= model.getId() %>'>
                                <button type='button' class='btn btn-default'>
                                    <span class='glyphicon glyphicon-edit'></span>
                                </button>
                            </a>

                            &nbsp;&nbsp;

                            <a href='<%= application.getContextPath() %>/Index?action=delete&id=<%= model.getId() %>'>
                                <button type='submit' class='btn btn-default'>
                                    <span class='glyphicon glyphicon-trash'></span>
                                </button>
                            </a>
                        </td>

                <%
                    } else {

                %>
                        <td>
                            -
                        </td>
                <%
                    }
                %>
                    </tr>
                <%
                            i++;
                        }
                %>
                    </tbody>
                <%
                    }
                %>

                </table>
            </div>
        </div>
    </div>

    <%
        }
    %>
</body>
</html>