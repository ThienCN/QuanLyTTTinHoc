<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Thống kê danh sách đăng ký online</title>
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- MY JS -->  
    <script src="./JS/NV_thongkeDSDKOnL.js"></script>
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
                        <a href="NV_thongkeDSDKOnL">
                        	<i class="glyphicon glyphicon-list-alt"></i>
                        	<span class="page-trich-dan"> THỐNG KÊ DANH SÁCH ĐĂNG KÝ ONLINE</span> 
                        </a>  
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
                    <li class="active"><a href="NV_thongkeDSDKOnL"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Đăng ký online</a></li>
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
        <label style="font-weight: bold; text-decoration: underline; color: #197485;"> Thông tin thống kê: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-4">Khóa học:</label>
                        <div class="col-xs-12 col-sm-8 col-md-8">
                            <select class="form-control" id="dsKhoaHoc">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-4">Lớp học:</label>
                        <div class="col-xs-12 col-sm-8 col-md-8">
                            <select class="form-control" id="dsLopHoc">
                            </select>
                        </div>
                    </div>
                </form>
                <div class="input-group-btn" style="text-align: right">
                    <button id="btn-thong-ke-DSDKOnl" class="btn btn-default" type="submit" style="background-color: #197485; color:white; width:150px; ">
                        Thống kê <i class="glyphicon glyphicon-list"></i>
                    </button>
                </div>
            </div>            
        </div>
        <hr />
        <!-- Danh sách đăng ký online -->
        <fieldset id="ket-qua-thong-ke"  style="display: none">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">KẾT QUẢ THỐNG KÊ: </p>
            <p style="font-weight: bold;">Số lượng: <span id="soLuong" style="color:red">0</span></p>
            <div class="table-responsive" >
                <table class="table" id="table-ds-hoc-vien-dkonl">
                    <thead>
                        <tr>
                        	<th>STT</th>
                            <th>Mã ĐKONL </th>
                            <th>Họ tên</th>
                            <th>Ngày sinh</th>
                            <th>Địa chỉ</th>
                            <th>Số điện thoại</th>
                            <th>Email</th>
                        </tr>
                    </thead>
                    <tbody>
                    </tbody>
                </table>
            </div>
            <br />
            <div class="input-group-btn" style="text-align: right">
                <button id="btn-xuat-file-DSDKOnl" class="btn btn-default" type="submit" style="background-color: #197485; color:white; width:130px; ">
                    Xuất file <i class="fa fa-print"></i>
                </button>
            </div>
        </fieldset>
        <div style="text-align: center;">
        	<p><strong id="danh-sach-trong"></strong></p>
        </div>
        
    </section>
</body>
</html>