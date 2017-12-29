<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Thông tin cá nhân</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- MY CSS -->
    <link rel="stylesheet" href="./CSS/menu-nhan-vien.css">
    <link rel="stylesheet" href="./CSS/GV-thong-tin-ca-nhan.css">
	<!--MY JS -->
	<script src="./JS/HV-thong-tin-ca-nhan.js"></script>
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
                        <a href="HV-thong-tin-ca-nhan.html"><i class="fa fa-user-circle-o"></i><span class="page-trich-dan"> THÔNG TIN CÁ NHÂN</span> </a>
                    </div>
                </div>
                <div class="nav navbar-nav navbar-right">
                    <a class="image-nhan-vien" style="text-decoration:none"><img src="Pic/doremon.png" alt="HocVien"><span><%=request.getSession().getAttribute("nameUser") %></span></a>
                </div>
            </div>
        </nav>
        <!-- MENU -->
        <nav class="navbar-default nav-menu">
            <div id="nav-left" class="navbar-collapse collapse">
                <ul class="nav">
                    <li><a href="hocvien"><i class="fa fa-home"></i> Trang của bạn</a></li>
                    <li class="active"><a href="HV_thongtincanhan"><i class="fa fa-user-circle-o"></i> Thông tin cá nhân</a></li>
                    <li><a href="HV_thoikhoabieu"><i class="fa fa-calendar"></i> Thời khóa biểu</a></li>
                    <li><a href="HV_caclopdangtheohoc"><i class="fa fa-wpforms"></i> Các lớp đang theo học</a></li>
                    <li><a href="HV_xemdiem"><i class="fa fa-graduation-cap"></i> Xem điểm</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
        </nav>

    </header>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="row">
        	<div class="col-lg-5 col-sm-5 col-md-5 col-xs-12" style="line-height:40px">
                <img alt="GiaoVien" src="Pic/1.png" style="border-radius: 50%;display: block;margin: 55px auto;height: 200px">
            </div>
            <div class="col-lg-7 col-sm-7 col-md-7 col-xs-12" style="line-height:40px">
                <h3 class="thong-tin-hoc-vien">THÔNG TIN HỌC VIÊN</h3>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    Mã học viên
                </div>
                <div id="MaGV" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    Họ và tên
                </div>
                <div id="HoTenGV" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    Ngày sinh
                </div>
                <div id="NgaySinh" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    CMND
                </div>
                <div id="CMND" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    SĐT
                </div>
                <div id="SDT" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    Email
                </div>
                <div id="Email" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="col-lg-6 col-sm-6 col-md-6 col-xs-5">
                    Địa chỉ
                </div>
                <div id="DiaChi" class="col-lg-6 col-sm-6 col-md-6 col-xs-7" style="color:#197485">
                    <span style="color:black">: </span>
                </div>
                <div class="cap-nhat">
                    <button id="btn-cap-nhat" class="btn btn-default">Cập nhật <span class="fa fa-pencil-square-o"></span></button>
                </div>
            </div>
            
        </div>

    </section>
</body>
</html>