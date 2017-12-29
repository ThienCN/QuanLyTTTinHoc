<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Trang cá nhân Quản trị viên</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge,chrome=1">
    <!-- Boostrap-->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- CSS -->
    <link rel="stylesheet" href="./CSS/w3.css">
    <!-- MY CSS -->
    <link rel="stylesheet" href="./CSS/header-menu-Admin.css" />
    <link rel="stylesheet" href="./CSS/Admin.css"/>
    <!-- MY JS -->
    <script src="./JS/header-menu-admin.js"></script>
</head>
<body>
	<!-- HEADER -->
    <header id="header">
    	<!-- LOGO HOTEL -->
		<div class="container">
		    <img src="./Pic/logo-TTTH.png" alt="logo" class="logo">
		</div>		
		<!-- NAVBAR -->
		<div>
		    <nav class="navbar navbar-default">
		        <div class="container">
		            <div class="navbar-header">
		                <button type="button" class="navbar-toggle" data-toggle="collapse" data-target="#nav-left">
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                    <span class="icon-bar"></span>
		                </button>
		                <a class="navbar-brand"><i class="fa fa-user-secret"></i></a>
		            </div>
		            <div class="nav navbar-nav navbar-left">
		                <a id="page-trich-dan" href="admin">TRANG CỦA BẠN</a>
		            </div>
		            <div class="nav navbar-nav navbar-right">
		                <a class="image-nhanvien">
			                <img src="./Pic/doremon.png" alt="NhanVien">
			                <span><%=request.getSession().getAttribute("nameUser") %> </span> 
		                </a>
		            </div>
		        </div>
		    </nav>
		</div>    	
    </header>

    <!-- MENU-LEFT -->
    <section id="menu"> </section>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_themgiaovien">
                        <i class="fa fa-user-plus"></i>
                        <h4>Thêm Giáo viên mới</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_chinhsuathongtingiaovien">
                        <i class="fa fa-pencil-square-o"></i>
                        <h4>Chỉnh sửa thông tin Giáo viên</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_thongkeDSGV">
                        <i class="fa fa-list"></i>
                        <h4>Thống kê danh sách Giáo viên</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_themkhoahocmoi">
                        <i class="fa fa-plus-square"></i>
                        <h4>Thêm khóa học mới</h4>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_themnguoidung">
                        <i class="glyphicon glyphicon-plus-sign"></i>
                        <h4>Thêm Người dùng mới</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_chinhsuathongtinnguoidung">
                        <i class="glyphicon glyphicon-edit"></i>
                        <h4>Chỉnh sửa thông tin Người dùng</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_thongkeDSND">
                        <i class="fa fa-align-justify"></i>
                        <h4>Thống kê danh sách Người dùng </h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_chinhsuathongtinkhoahoc">
                        <i class="fa fa-pencil-square"></i>
                        <h4>Chỉnh sửa thông tin Khóa học</h4>
                    </a>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_themlophocmoi">
                        <i class="glyphicon glyphicon-plus"></i>
                        <h4>Thêm Lớp học mới</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_chinhsuathongtinlophoc">
                        <i class="glyphicon glyphicon-pencil"></i>
                        <h4>Chỉnh sửa thông tin Lớp học</h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_thongkeDSLH">
                        <i class="glyphicon glyphicon-th"></i>
                        <h4>Thống kê danh sách Lớp học </h4>
                    </a>
                </div>
            </div>
            <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                <div class="div-square">
                    <a href="Admin_chinhsuathongtinlophoc">
                        <i class="fa fa-pencil-square"></i>
                        <h4>Chỉnh sửa thông tin Lớp học</h4>
                    </a>
                </div>
            </div>
        </div>
    </section>

</body>
</html>