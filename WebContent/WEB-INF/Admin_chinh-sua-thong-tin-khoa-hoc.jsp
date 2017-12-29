<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>Chỉnh sửa thông tin khóa học</title>
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
    <script src="./JS/Admin_chinhsuathongtinkhoahoc.js"></script>
    
    <script>
		$(document).ready(function(){
			  $("#maKhoaHocTimKiem").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
		});
	</script>
	
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
		                <a id="page-trich-dan" href="Admin_chinhsuathongtinkhoahoc">CHỈNH SỬA THÔNG TIN KHÓA HỌC</a>
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
        <h5> CHỈNH SỬA THÔNG TIN KHÓA HỌC</h5>
        <label>Khóa học: </label>
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="input-group search">
                    <input id="maKhoaHocTimKiem" type="text" class="form-control" placeholder="Nhập mã khóa học vào đây">
                    <div class="input-group-btn">
                        <button id="timKiemKhoaHoc" class="btn btn-default" style="background-color: #197485; color:white; width:60px;height: 35px;">
                            <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div> 
                </div>
            </div>
        </div>

        <br />
        <!-- Thông tin Khóa học -->
        <fieldset id="fromChinhSuaKH" style="display: none">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin Chỉnh sửa Khóa học: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <div class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã khóa học:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="maKhoaHoc" type="text" class="form-control" readonly>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày khai giảng:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="ngayKhaiGiang" type="date" class="form-control">
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Tình trạng:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <select class="form-control" id="cbtinhTrang">
                            	<option value='1'>Mở (Cho đăng ký LH)</option>
                            	<option value='2'>Khóa (Khóa đăng ký LH)</option>
                            	<option value='0'>Đóng (Kết thúc)</option>
                    		</select>
                        </div>
		                <div class="input-group-btn">
		                	<button id="btn-HuyChinhSuaKH" class="btn btn-default">
		                        Hủy <i class="glyphicon glyphicon-trash"></i>
		                    </button>
		                    <button id="btn-chinhSuaKhoaHoc" class="btn btn-default">
		                        Lưu <i class="glyphicon glyphicon-ok"></i>
		                    </button>
		                </div>
                    </div>
                </div>
            </div>
            
        </fieldset>
        <br>
        <!-- Danh sách khóa học -->
        <fieldset id="ket-qua-thong-ke">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">DANH SÁCH KHÓA HỌC: </p>
            <div class="table-responsive">
                <table class="table" id="table-ds-lop-hoc">
                    <thead>
                        <tr>
                            <th>Mã khóa học </th>
                            <th>Ngày bắt đầu</th>
                            <th>Số lớp học</th>
                            <th>Tình trạng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="myTable">
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