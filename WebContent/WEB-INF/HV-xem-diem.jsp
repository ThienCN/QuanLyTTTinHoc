<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Xem điểm</title>
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
    <link rel="stylesheet" href="./CSS/nhanvien.css">
	<!--MY JS -->
	<script src="./JS/HV-xem-diem.js"></script>
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
                        <a href="HocVien.html"><i class="fa fa-graduation-cap"></i><span class="page-trich-dan"> XEM ĐIỂM</span> </a>
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
                    <li><a href="HV_thongtincanhan"><i class="fa fa-user-circle-o"></i> Thông tin cá nhân</a></li>
                    <li><a href="HV_thoikhoabieu"><i class="fa fa-calendar"></i> Thời khóa biểu</a></li>
                    <li><a href="HV_caclopdangtheohoc"><i class="fa fa-wpforms"></i> Các lớp đang theo học</a></li>
                    <li class="active"><a href="HV_xemdiem"><i class="fa fa-graduation-cap"></i> Xem điểm</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
        </nav>

    </header>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="row" id="row1" style="padding: 10px;">
            <h4 class="head1" style="margin-top:0;border: 2px solid #197485;color: white;background: #197485;padding: 10px;">HỌC VIÊN CHỌN KHÓA ĐỂ XEM ĐIỂM</h4>
            <div class="col-lg-1 col-sm-1 col-md-1 col-xs-12"></div>
            <div class="col-lg-2 col-sm-2 col-md-2 col-xs-12" style=";line-height:35px">
                <strong>Khóa học: </strong>
                <select id="khoahoc" style="width:100px"></select>
            </div>
            <div class="col-lg-3 col-sm-3 col-md-3 col-xs-12" style=";line-height:35px">
                <strong>Ngày khai giảng: </strong>
                <strong id="ngaykhaigiang" style="color:blue"></strong>
            </div>
         </div>
        <div class="table-responsive" style="margin-top:10px;">
            <table class="table table-bordered table-striped" id="table-diem">
                <thead style="background: gray;color: white;">
                    <tr>
                    	<th style="width:50px;">STT</th>
                        <th>Mã lớp</th>
                        <th>Tên lớp</th>
                        <th>Điểm LT</th>
                        <th>Điểm TH</th>
                        <th>Điểm TB</th>
                        <th>Chứng chỉ</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
        </div>

    </section>
</body>
</html>