<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Lịch giảng dạy</title>
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
    <link rel="stylesheet" href="./CSS/HV-thoi-khoa-bieu.css">
	<!--MY JS -->
	<script src="./JS/GV-lich-giang-day.js"></script>
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
                        <a href="HV-thoi-khoa-bieu.html"><i class="fa fa-calendar"></i><span class="page-trich-dan"> LỊCH GIẢNG DẠY</span> </a>
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
                    <li class="active"><a href="GV_lichgiangday"><i class="fa fa-calendar"></i> Lịch giảng dạy</a></li>
                    <li><a href="GV_nhapdiem"><i class="glyphicon glyphicon-list-alt"></i> Nhập điểm</a></li>
                    <li><a href="GV_posttailieu"><i class="fa fa-upload"></i> Post tài liệu</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
        </nav>

    </header>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
    
        <div class="row" id="row1">
            <h4 class="head1" style="margin-top:0">GIÁO VIÊN CHỌN TUẦN ĐỂ XEM LỊCH</h4>
            <div class="col-lg-1 col-sm-1 col-md-1 col-xs-12"></div>
            <div class="col-lg-2 col-sm-2 col-md-2 col-xs-12" style=";line-height:35px">
                <strong>Khóa học: </strong>
                <select id="khoahoc" style="width:100px"></select>
            </div>
            <div class="col-lg-3 col-sm-3 col-md-3 col-xs-12" style=";line-height:35px">
                <strong>Ngày khai giảng: </strong>
                <strong id="ngaykhaigiang" style="color:blue"></strong>
            </div>
            <div class="col-lg-6 col-sm-6 col-md-6 col-xs-12" style=";line-height:35px">
                <strong>Tuần: </strong>
                <select style="width:50px" id="tuan">
                </select>
                <strong id="khoangngay"></strong>
            </div>
         </div>
         <div class="table-responsive">
             <table class="table table-bordered" id="table-lich-giang-day">
                 <thead>
                     <tr>
                         <th style="color:white;background:#197485;width:50px">PHÒNG</th>
                     </tr>
                 </thead>
                 <tbody>
                 </tbody>
             </table>
         </div>
    </section>
</body>
</html>