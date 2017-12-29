<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Danh sách các lớp đang giảng dạy</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!--My CSS-->
    <link rel="stylesheet" href="./CSS/menu-nhan-vien.css">
    <link rel="stylesheet" href="./CSS/nhanvien.css">
	<!--MY JS -->
	<script src="./JS/GV-post-tai-lieu.js"></script>
	<script>
 		  $(document).ready(function(){
		  $("#MaDkyOnl").on("keyup", function() {
 				    var value = $(this).val().toLowerCase();
				    $("#myTable tr").filter(function() {
 				      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
 				    });
 			  });
 		});
	</script>
</head>
<body>
    <!-- HEADER MENU -->
    <header>
        <!-- LOGO HOTEL -->
        <div class="container">
            <img src="./Pic/logo-TTTH.png" alt="logo" class="logo w3-animate-zoom ">
        </div>
        <nav class="navbar navbar-default">
            <div class="container">
                <div class="navbar-header">
                    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-left">
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                        <span class="icon-bar"></span>
                    </button>
                    <div class="navbar-brand">
                        <a href="nhanvien.html"><i class="fa fa-user-circle"></i><span class="page-trich-dan"> POST TÀI LIỆU</span> </a>
                    </div>
                </div>
                <div class="nav navbar-nav navbar-right">
                    <a class="image-nhan-vien" style="text-decoration:none"><img src="Pic/doremon.png" alt="GiaoVien"><span><%=request.getSession().getAttribute("nameUser") %></span></a>
                </div>
            </div>
        </nav>
        <!-- MENU -->
        <nav class="navbar-default nav-menu">
            <div id="nav-left" class="navbar-collapse collapse">
                <ul class="nav">
                    <li><a href="giaovien"><i class="fa fa-user-circle"></i> Trang của bạn</a></li>
                    <li><a href="GV_thongtincanhan"><i class="fa fa-user-circle-o"></i> Thông tin cá nhân</a></li>
                    <li><a href="GV_lichgiangday"><i class="fa fa-calendar"></i> Lịch giảng dạy</a></li>
                    <li><a href="GV_nhapdiem"><i class="glyphicon glyphicon-list-alt"></i> Nhập điểm</a></li>
                    <li class="active"><a href="GV_posttailieu"><i class="fa fa-upload"></i> Post tài liệu</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
        </nav>

    </header>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h3><strong> Danh sách các lớp đang giảng dạy trong học kỳ này: </strong></h3>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form>
                    <div class="input-group search">
                        <input type="text" id="MaDkyOnl" class="form-control" size="50" placeholder="Nhập mã lớp vào đây">
                        <div class="input-group-btn">
                            <button id="btn-tra-cuu-dkyonline" class="btn btn-default" type="submit" style="background-color: #197485; color:white">
                                Tìm <i class="glyphicon glyphicon-search"></i>
                            </button>
                        </div>
                    </div>
                </form>
            </div>
        </div>
        <br />
        <div class="ket-qua-tim-kiem" >
            <div id="co-ket-qua" style="display:block">
                <fieldset>
                    <div class="table-responsive">
                        <table class="table" id="table-danh-sach-giang-day">
                            <thead>
                                <tr>
                                    <th>Mã lớp </th>
                                    <th>Tên lớp</th>
                                    <th>Thời gian</th>
                                    <th>Địa điểm học</th>
                                    <th>Post tài liệu</th>
                                </tr>
                            </thead>
                            <tbody id="myTable">
                            </tbody>
                        </table>
                    </div>
                </fieldset>
                <br />
            </div>
        </div>
    </section>
</body>
</html>