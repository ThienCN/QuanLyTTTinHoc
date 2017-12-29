<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>Thống kê danh sách lớp học</title>
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
    <script src="./JS/NV-thong-ke-DSLH.js"></script>
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
		                <a class="navbar-brand"><i class="fa fa-calendar-check-o"></i></a>
		            </div>
		            <div class="nav navbar-nav navbar-left">
		                <a id="page-trich-dan" href="Admin_themkhoahocmoi">THỐNG KÊ DANH SÁCH LỚP HỌC</a>
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
        <label style="font-weight: bold; text-decoration: underline; color: #197485;"> Thông tin thống kê: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <div class="input-group">
                    <select class="form-control" id="dsKhoaHoc">
                    </select>
                    <div class="input-group-btn" style="text-align: right">
                        <button id="btn-thong-ke-dsLopHoc" class="btn btn-default" style="background-color: #197485; color:white; width:150px; ">
                            Thống kê <i class="glyphicon glyphicon-list"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <hr />
        <!-- Danh sách lớp học -->
        <fieldset id="ket-qua-thong-ke"  style="display:none">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">KẾT QUẢ THỐNG KÊ: </p>
            <p style="font-weight: bold;">Số lượng: <span id="soLuong" style="color:red">0</span> lớp học</p>
            <div class="table-responsive">
                <table class="table tablefixed" id="table-ds-lop-hoc">
                    <thead>
                        <tr>
                        	<th>STT</th>
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
        <div style="text-align: center;">
        	<p><strong id="danh-sach-trong"></strong></p>
        </div>
    </section>
    
</body>
</html>