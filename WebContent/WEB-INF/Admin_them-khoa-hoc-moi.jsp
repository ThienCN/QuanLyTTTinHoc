<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>Thêm Khóa học mới</title>
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
    <script src="./JS/Admin_themkhoahocmoi.js"></script>
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
		                <a id="page-trich-dan" href="Admin_themkhoahocmoi">THÊM KHÓA HỌC MỚI</a>
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
        <h5>THÊM KHÓA HỌC MỚI</h5>
        <!-- Thông tin Khóa học -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin Khóa học: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã khóa học:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="maKhoaHoc" type="text" class="form-control" placeholder="Ví dụ: 01-2017, 05-2017 ..">
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày khai giảng:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input id="ngayKhaiGiang" type="date" class="form-control"
                            <%
                       			Date date = new Date();                        			  
                       			String strDateFormat = "yyyy-MM-dd";                        			  
                       			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat1.format(date)%>
                               >
                        </div>
                    </div>
                </form>
                <div class="input-group-btn">
                    <button id="tao-khoa-hoc" class="btn btn-default">
                        Tạo khóa học <i class="glyphicon glyphicon-ok"></i>
                    </button>
                </div>
            </div>
        </fieldset>
        <br />
        <!-- Danh sách khóa học -->
        <fieldset id="ket-qua-thong-ke" style="display:none">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">DANH SÁCH KHÓA HỌC: </p>
            <div class="table-responsive">
                <table class="table" id="table-ds-khoa-hoc">
                    <thead>
                        <tr>
                            <th>Mã khóa học </th>
                            <th>Ngày bắt đầu</th>
                            <th>Lịch học</th>
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