<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Trang cá nhân Nhân viên</title>
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
    <link  rel="stylesheet" href="./CSS/nhanvien.css">
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
                        <a href="nhanvien"><i class="fa fa-user-circle"></i><span class="page-trich-dan"> TRANG CỦA BẠN</span> </a>  
                    </div>
                </div>
                <div class="nav navbar-nav navbar-right">
                    <a class="image-nhan-vien"  style="text-decoration:none">
                    	<img src="./Pic/doremon.png" alt="NhanVien">
                    	<span><%=request.getSession().getAttribute("nameUser") %> </span> 
                    </a>
                </div>
            </div>
        </nav>
        <!-- MENU -->
        <nav class="navbar-default nav-menu">
            <div id="nav-left" class="navbar-collapse collapse">
                <ul class="nav">
                    <li class="active"><a href="nhanvien"><i class="fa fa-user-circle"></i> Trang của bạn</a></li>
                    <li><a href="NV_tracuuDKOnl"><i class="fa fa-search"></i> Tra cứu đăng ký online</a></li>
                    <li><a href="NV_dangkykhoahoc"><i class="glyphicon glyphicon-edit"></i> Đăng ký khóa học</a></li>
                    <li><a href="#" id="menu-thu-hoc-phi"><i class="glyphicon glyphicon-usd"></i> Thu học phí</a></li>
                    <li><a href="NV_thongkeDSDKOnL"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Đăng ký online</a></li>
                    <li><a href="NV_thongkeDSHV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Học viên</a></li>
                    <li><a href="NV_thongkeDSGV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Giáo viên</a></li>
                    <li><a href="NV_thongkeDSLH"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Lớp học</a></li>
                    <li><a href="NV_quanlythongbao"><i class="glyphicon glyphicon-globe"></i> Quản lý thông báo</a></li>
                    <li><a href="NV_quanlytintuc"><i class="glyphicon glyphicon-globe"></i> Quản lý tin tức</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
            <script>
                $("#menu-thu-hoc-phi").click(function (e) {
                    alert("Mời bạn đăng ký khóa học cho học viên trước khi thu học phí!!!");
                });
            </script>
        </nav>

    </header>  
   
    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_tracuuDKOnl">
                        <i class="fa fa-search"></i>
                        <h4>Tra cứu</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="#">
                        <i class="fa fa-comments-o"></i>
                        <h4>Tư vấn</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_dangkykhoahoc">
                        <i class="glyphicon glyphicon-edit"></i>
                        <h4>Đăng ký </h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="#" id="icon-thu-hoc-phi">
                        <i class="glyphicon glyphicon-usd"></i>
                        <h4>Thu học phí</h4>
                    </a>
                </div>
                <script>
                    $("#icon-thu-hoc-phi").click(function (e) {
                        alert("Mời bạn đăng ký khóa học cho học viên trước khi thu học phí!!!");
                    });
                </script>

            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_thongkeDSDKOnL">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <h4>TKĐK Online</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_thongkeDSHV">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <h4>TKDS Học viên</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_quanlythongbao">
                        <i class="glyphicon glyphicon-bullhorn"></i>
                        <h4>Thông báo </h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_quanlytintuc">
                        <i class="glyphicon glyphicon-globe"></i>
                        <h4>Tin tức</h4>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_thongkeDSGV">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <h4>TKDS Giáo viên</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="NV_thongkeDSLH">
                        <i class="glyphicon glyphicon-list-alt"></i>
                        <h4>TKDS Lớp học</h4>
                    </a>
                </div>
            </div>
        </div>

    </section>
  
</body>
</html>