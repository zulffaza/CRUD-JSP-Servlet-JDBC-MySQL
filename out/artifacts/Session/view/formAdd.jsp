<%@ page import="Model.FoodModel" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Session - Add Food</title>

    <link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/css/bootstrap.min.css">
    <link rel="stylesheet" type="text/css" href="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/css/bootstrap-theme.min.css">
    <script type="text/javascript" src="<%= application.getContextPath() %>/assets/jquery-3.2.1/jquery-3.2.1.min.js"></script>
    <script type="text/javascript" src="<%= application.getContextPath() %>/assets/bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
</head>
<body>
    <%
        FoodModel model = (FoodModel) request.getAttribute("foodModel");
    %>

    <div class="container">
        <div class="jumbotron">
            <h2>Tambah Makanan & Minuman</h2>
        </div>
    </div>

    <div class="container">
        <div class="jumbotron">
            <a href="<%= application.getContextPath() %>/Index">
                <button class="btn btn-default">
                    <span class="glyphicon glyphicon-chevron-left">&nbsp;</span>
                    <b>Kembali</b>
                </button>
            </a>

            <br>
            <br>

            <form class="form-horizontal" method="post" action="<%= application.getContextPath() %>/AddFood">
                <input name="id" value="<% if (model != null) out.print(model.getId()); %>" hidden>

                <div class="form-group">
                    <label class="control-label col-sm-2" for="nama">Nama :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="nama" name="nama" value="<% if (model != null) out.print(model.getNama()); %>" placeholder="Masukkan Nama Makanan / Minuman" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="harga">Harga :</label>
                    <div class="col-sm-10">
                        <input type="number" class="form-control" id="harga" name="harga" value="<% if (model != null) out.print(model.getHarga()); %>" placeholder="Masukkan Harga Makanan / Minuman" required>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-sm-2" for="asal">Asal :</label>
                    <div class="col-sm-10">
                        <input type="text" class="form-control" id="asal" name="asal" value="<% if (model != null) out.print(model.getAsal()); %>" placeholder="Masukkan Asal Makanan / Minuman" required>
                    </div>
                </div>
                <div class="form-group">
                    <div class="col-sm-offset-2 col-sm-10">
                        <button type="submit" class="btn btn-default">
                            <span class="glyphicon glyphicon-plus">&nbsp;</span>
                            <b>Tambahkan</b>
                        </button>
                    </div>
                </div>
            </form>
        </div>
    </div>

    <div class="container">
        <div class="jumbotron">
            <h5>Author : Faza Zulfika Permana Putra / 2110151023</h5>
        </div>
    </div>
</body>
</html>