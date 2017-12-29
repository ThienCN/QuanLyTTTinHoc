<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>Chỉnh sửa thông tin lớp học</title>
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
    <link rel="stylesheet" href="./CSS/Admin.css" />
    <!-- MY JS -->
    <script src="./JS/header-menu-admin.js"></script>
    <script src="./JS/LoadDuLieuCanThiet.js"></script>
    <script src="./JS/Admin_chinhsuathongtinlophoc.js"></script>
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
		                <a class="navbar-brand"><i class="fa fa-calendar-plus-o"></i></a>
		            </div>
		            <div class="nav navbar-nav navbar-left">
		                <a id="page-trich-dan" href="Admin_chinhsuathongtinlophoc">CHỈNH SỬA THÔNG TIN KHÓA HỌC</a>
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
        <h5>CHỈNH SỬA THÔNG TIN LỚP HỌC</h5>
        <label style="font-weight: bold; text-decoration: underline; color: #197485;"> Thông tin tìm kiếm: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-4">Khóa học:</label>
                        <div class="col-xs-12 col-sm-8 col-md-8">
                            <select class="form-control" id="cbKhoaHoc">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-4">Lớp học:</label>
                        <div class="col-xs-12 col-sm-8 col-md-8">
                            <select class="form-control" id="cbLopHoc">
                            </select>
                        </div>
                    </div>
                </form>
                <div class="input-group-btn" style="text-align: right">
                    <button id="btn-tim-kiem-lop-hoc" class="btn btn-default" style="background-color: #197485; color:white; width:150px; ">
                        Tìm <i class="glyphicon glyphicon-search"></i>
                    </button>
                </div>
            </div>
        </div>
        <hr />
        <!-- Thông tin lớp học   -->
        <fieldset id="thong-tin-lop-hoc"  style="display:none">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin lớp học: </p>
            <div class="table-responsive">
                <table class="table tablefixed" id="table-lop-hoc">
                    <thead>
                        <tr>
                            <th>Mã lớp </th>
                            <th>Tên lớp</th>
                            <th>Số HV</th>
                            <th>Số buổi</th>
                            <th>Ngày bắt đầu</th>
                            <th>Ngày kết thúc</th>
                            <th>GVGD</th>
                            <th>Phòng học</th>
                            <th>Buổi học</th>
                            <th>Giờ học</th>
                            <th>Học phí</th>
                            <th>Tình trạng</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <br />
        </fieldset>
        <hr/>
        <!-- Thông tin Chỉnh sửa Lớp học -->
        <fieldset id="thong-tin-chinh-sua-lop-hoc" style="display:none">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin chỉnh sửa lớp học: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Mã lớp:</label>
                        <div class="col-xs-12 col-sm-4 col-md-2">
                            <input id="maLopHoc" type="text" class="form-control">
                            <span id="error-maLop" style="color:red; font-size:8px"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Tên lớp:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <input type="text" id="tenLop" class="form-control">
                            <span id="error-tenLop" style="color:red; font-size:8px"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-2">Số HV dự kiến:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <input type="text" id="soHV" class="form-control">
                            <span id="error-soHV" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Số buổi:</label>
                        <div class="col-xs-12 col-sm-4 col-md-2">
                            <input type="text" id="soBuoi" class="form-control">
                            <span id="error-soBuoi" style="color:red; font-size:8px"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Học phí:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <select id="cbHocPhi" class="form-control">
                            </select>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-2">Ngày bắt đầu:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <input type="date" id="ngayBatDau" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Buổi học:</label>
                        <div class="col-xs-12 col-sm-4 col-md-2">
                            <select id="cbBuoiHoc" class="form-control">
                            </select>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Giờ học:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <select id="cbGioHoc" class="form-control">
                            </select>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-2">Ngày kết thúc:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <input type="date" id="ngayKetThuc" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Phòng:</label>
                        <div class="col-xs-12 col-sm-4 col-md-2">
                             <select id="cbPhongHoc" class="form-control">
                            </select>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-1">Giáo viên:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <select id="cbGiaoVien" class="form-control">
                            </select>
                        </div>
                        <label class="control-label col-xs-12 col-sm-2 col-md-2">Tình trạng:</label>
                        <div class="col-xs-12 col-sm-4 col-md-3">
                            <select id="cbTinhTrang" class="form-control">
                            	<option value='1'>Mở</option>
                            	<option value='2'>Khóa</option>
                            	<option value='0'>Đóng</option>
                            </select>
                        </div>
                    </div>
                </form>
                <div class="input-group-btn">
                	<button id="huy-cap-nhat-lop-hoc" class="btn btn-default">
                        Hủy <i class="glyphicon glyphicon-trash"></i>
                    </button>
                    
                    <button id="cap-nhat-lop-hoc" class="btn btn-default">
                        Cập nhật <i class="glyphicon glyphicon-ok"></i>
                    </button>
                </div>
            </div>
        </fieldset>
        <br />
    </section>

    
</body>
</html>