<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <title>Trang của học viên</title>
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
                        <a href="hocvien"><i class="fa fa-home"></i><span class="page-trich-dan"> TRANG CỦA BẠN</span> </a>
                    </div>
                </div>
                <div class="nav navbar-nav navbar-right">
                    <a class="image-nhan-vien" style="text-decoration:none"><img src="./Pic/doremon.png" alt="HocVien"><span><%=request.getSession().getAttribute("nameUser") %></span></a>
                </div>
            </div>
        </nav>
        <!-- MENU -->
        <nav class="navbar-default nav-menu">
            <div id="nav-left" class="navbar-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="hocvien"><i class="fa fa-home"></i> Trang của bạn</a></li>
                    <li><a href="HV_thongtincanhan"><i class="fa fa-user-circle-o"></i> Thông tin cá nhân</a></li>
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
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <div class="div-square">
                    <a href="HV_thongtincanhan">
                        <i class="fa fa-user-circle-o"></i>
                        <h4>Thông tin cá nhân</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <div class="div-square">
                    <a href="HV_thoikhoabieu">
                        <i class="fa fa-calendar"></i>
                        <h4>Thời khóa biểu</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <div class="div-square">
                    <a href="HV_caclopdangtheohoc">
                        <i class="fa fa-wpforms"></i>
                        <h4>Các lớp đang theo học</h4>
                    </a>
                </div>
            </div>
        </div>

        <div class="row">
            <div class="col-lg-4 col-md-4 col-sm-4 col-xs-12">
                <div class="div-square">
                    <a href="HV_xemdiem">
                        <i class="fa fa-graduation-cap"></i>
                        <h4>Xem điểm</h4>
                    </a>
                </div>
            </div>
        </div>

</section>
</body>
</html>