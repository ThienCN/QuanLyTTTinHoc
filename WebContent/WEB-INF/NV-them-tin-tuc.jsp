<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Thêm tin tức</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./CSS/w3.css">
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- MY CSS -->
    <link rel="stylesheet" href="./CSS/menu-nhan-vien.css">
    <!--MY JS-->
    <script src="JS/NV_themtintuc.js"></script>
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
                        <a href=NV_themtintuc><i class="glyphicon glyphicon-globe"></i><span class="page-trich-dan"> THÊM TIN TỨC</span> </a>  
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
                    <li><a href="nhanvien"><i class="fa fa-user-circle"></i> Trang của bạn</a></li>
                    <li><a href="NV_tracuuDKOnl"><i class="fa fa-search"></i> Tra cứu đăng ký online</a></li>
                    <li><a href="NV_dangkykhoahoc"><i class="glyphicon glyphicon-edit"></i> Đăng ký khóa học</a></li>
                    <li><a href="#" id="menu-thu-hoc-phi"><i class="glyphicon glyphicon-usd"></i> Thu học phí</a></li>
                    <li><a href="NV_thongkeDSDKOnL"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Đăng ký online</a></li>
                    <li><a href="NV_thongkeDSHV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Học viên</a></li>
                    <li><a href="NV_thongkeDSGV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Giáo viên</a></li>
                    <li><a href="NV_thongkeDSLH"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Lớp học</a></li>
                    <li><a href="NV_quanlythongbao"><i class="glyphicon glyphicon-globe"></i> Quản lý thông báo</a></li>
                    <li class="active"><a href="NV_quanlytintuc"><i class="glyphicon glyphicon-globe"></i> Quản lý tin tức</a></li>
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
        <br />
        <div class="w3-row">
            <div class="w3-twothird">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-3 col-md-3">Mã tin tức:</label>
                        <div class="col-xs-12 col-sm-9 col-md-9">
                            <input type="text" id="maTinTuc" class="form-control" readonly>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-3 col-md-3">Tiêu đề tin tức:</label>
                        <div class="col-xs-12 col-sm-9 col-md-9">
                            <input type="text" id="tieuDeTinTuc" class="form-control">
                            <span id="error-tieuDeTinTuc" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-3 col-md-3">Tóm tắt tin tức:</label>
                        <div class="col-xs-12 col-sm-9 col-md-9">
                            <textarea class="form-control" id="tomTatTinTuc" rows="10" cols="50"></textarea>
                            <span id="error-tomTatTinTuc" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-3 col-md-3">Ngày đăng tin tức:</label>
                        <div class="col-xs-12 col-sm-9 col-md-9">
                            <input type="date" id="ngayDangTinTuc" class="form-control"
                            <%
                       			Date date = new Date();                        			  
                       			String strDateFormat = "yyyy-MM-dd";                        			  
                       			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat1.format(date)%>
                             >
                            <span id="error-ngayDangTinTuc" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-3 col-md-3">Hình ảnh:</label>
                        <div class="col-xs-12 col-sm-9 col-md-9">
                        	<form id="hinhAnhTTMoi" class="form-horizontal" enctype="multipart/form-data">
								<div class="input-group">
									<input id="hinhAnh" type="file" name="hinhAnh">
									<span id="error-hinhAnh" style="color:red; font-size:8px"></span>
								</div>
							</form>
                        </div>
                    </div>
                </div>
                <div class="form-group col-xs-9 col-sm-10 col-md-11">
                    <div class="input-group-btn" style="float:right">
                        <button id="luu-tin-tuc" class="btn btn-default" style="background-color: #197485; color:white; width: 100px;">
                            Lưu <i class="glyphicon glyphicon-ok"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
    </section>
</body>
</html>