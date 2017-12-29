<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="model.LopHocModel" %>
<%@page import="java.util.*" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Đăng ký khóa học</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!--CSS-->
    <link rel="stylesheet" href="./CSS/w3.css">
    <!-- MY JS -->
    <script src="JS/NV-dky-khoa-hoc.js"></script>
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
                        <a href="NV_dangkykhoahoc"><i class="glyphicon glyphicon-edit"></i><span class="page-trich-dan"> ĐĂNG KÝ KHÓA HỌC</span> </a>  
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
                    <li class="active"><a href="NV_dangkykhoahoc"><i class="glyphicon glyphicon-edit"></i> Đăng ký khóa học</a></li>
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
    	<label> Chứng minh nhân dân hoặc mã học viên: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <div class="input-group search">
                     <input type="text" id="maTimKiem" class="form-control" placeholder="Nhập chứng minh nhân dân hoặc mã học viên vào đây">
                     <div class="input-group-btn">
                     	<button class="btn btn-default" id="btn-tra-cuu-hoc-vien">
                            Tìm <i class="glyphicon glyphicon-search"></i>
                        </button>
                     </div>
                 </div>
            </div>
            <div class="col-xs-12 col-md-6">
                <div class="input-group search">
                     <div class="input-group-btn">
                     	<button class="btn btn-default" id="btn-reset" style="width: 200px">
                            Làm mới <i class="fa fa-newspaper-o"></i>
                        </button>
                     </div>
                 </div>
            </div>
        </div>
        <br />
        <!-- Thông tin học viên -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin học viên: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã học viên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="maHocVien" type="text" class="form-control" readonly>
                        </div>       
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày sinh:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="ngaysinh" type="date" class="form-control"
                            <%
                            	Date date = new Date();
                            	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                            %>
                            	value="<%=simpleDateFormat.format(date) %>"
                            >
                            <span id="error-ngaysinh" class="span-error"></span>
                        </div>                 
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="hoTenHV" type="text" class="form-control" size="30" placeholder="Nguyễn Văn A">
                            <span id="error-hotenHV" class="span-error"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Giới tính:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <select class="form-control" id="GioiTinh">
                                <option value="0">Nam</option>
                                <option value="1">Nữ</option>
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="diachi" type="text" class="form-control" size="30" placeholder="Số nhà, đường, phường, quận">
                            <span id="error-diachi" class="span-error"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="SDT" type="text" class="form-control" size="30" placeholder="0123456789">
                            <span id="error-SDT" class="span-error"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">CMND:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="CMND" type="text" class="form-control" size="30" placeholder="Số chứng minh nhân dân">
                            <span id="error-CMND" class="span-error"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Email:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="email" type="email" class="form-control" size="30" placeholder="email@gmail.com" required>
                            <span id="error-email" class="span-error"></span>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <br />
        <!-- Thông tin đăng ký lớp học -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin đăng ký lớp học: </p>
            <div class="table-responsive">
                <table class="table" id="table-dky-khoahoc">
                    <thead>
                        <tr>
                            <th>Mã lớp </th>
                            <th>Tên lớp</th>
                            <th>Số buổi học</th>
                            <th>Ngày bắt đầu</th>
                            <th>Ngày kết thúc</th>
                            <th>Phòng học</th>
                            <th>Buổi học</th>
                            <th>Giờ học</th>
                            <th>Học phí</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody></tbody>
                </table>
            </div>
            <br />
            <label style="font-style:italic">Tổng học phí phải thanh toán: <span style="color:red" id="hocPhiPhaiThanhToan">0</span> VNĐ</label>
            <div class="input-group-btn">
                <button  class="btn btn-default" id="btn-thanhtoanHP" style="width: 200px">
                    Thanh toán học phí <i class="glyphicon glyphicon-edit"></i>
                </button>
            </div>
        </fieldset>
        <!-- Chọn lớp học -->
        <br />
        <hr />
        <div class="col-xs-12 col-sm-12 col-md-6" style="background-color:#e7e1e1; padding:20px; border:1px double grey;">
            <label style="font-weight: bold; font-size:20px; text-decoration: underline; color: #197485;">CHỌN LỚP: </label>
            <div class="form-horizontal">
                <div class="form-group">                   
                    <label class="control-label col-xs-12 col-sm-4 col-md-4">Tên lớp:</label>
                    <div class="col-xs-12 col-sm-8 col-md-8">
                        <select class="form-control" id="cbLopHoc">
                        </select>
                        <br />
                        <div class="input-group-btn">
                            <button id="btn-chon-lop-hoc" class="btn btn-default" style="width:100px">
                                Chọn <i class="glyphicon glyphicon-ok"></i>
                            </button>
                        </div>
                    </div>                    
                </div>
            </div>
        </div>
    </section>
</body>
</html>