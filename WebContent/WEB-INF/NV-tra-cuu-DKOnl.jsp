<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Tra cứu đăng ký online</title>
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
    <script src="./JS/NV-tra-cuu-DKOnl.js"></script>
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
                        <a href="NV_tracuuDKOnl"><i class="fa fa-search"></i><span class="page-trich-dan"> TRA CỨU ĐĂNG KÝ ONLINE</span> </a>  
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
                    <li class="active"><a href="NV_tracuuDKOnl"><i class="fa fa-search"></i> Tra cứu đăng ký online</a></li>
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
        <label> Mã đăng ký Online: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <div class="input-group search">
                    <input type="text" id="MaDkyOnl" class="form-control" placeholder="Nhập mã đăng ký online vào đây" >
                    <div class="input-group-btn">
                        <button id="btn-tra-cuu-dkyonline" class="btn btn-default" style="background-color: #197485; color:white">
                            Tìm <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <br />
        <div>
            <label> KẾT QUẢ TÌM KIẾM: </label>
            <div id="thong-tin-nguoi-dang-ky" style="display: none">
                <fieldset>
                    <p style="color: #197485; font-weight: bold; text-decoration: underline">Thông tin người đăng ký: </p>
                    <div class="table-responsive">
                        <table class="table" id="table-thong-tin-nguoi-dang-ky">
                            <thead>
                                <tr>
                                    <th>Họ tên </th>
                                    <th>Ngày sinh</th>
                                    <th>Địa chỉ</th>
                                    <th>SĐT</th>
                                    <th>Email</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                </fieldset>
                <br />
             </div>
             <div id="thong-tin-lop-hoc-dang-ky" style="display:none">
                <fieldset>
                    <p style="color: #197485; font-weight: bold; text-decoration: underline">Thông tin lớp học đăng ký: </p>
                    <div class="table-responsive">
                        <table class="table" id="table-thong-tin-lop-hoc-dang-ky">
                            <thead>
                                <tr>
                                    <th>Mã lớp </th>
		                            <th>Tên lớp</th>
		                            <th>Số buổi học</th>
		                            <th>Ngày bắt đầu</th>
		                            <th>Ngày kết thúc</th>
		                            <th>Buổi học</th>
		                            <th>Giờ học</th>
		                            <th>Học phí</th>
		                            <th>Ngày đăng ký</th>
		                            <th>Tình trạng</th>
                                </tr>
                            </thead>
                            <tbody>
                            </tbody>
                        </table>
                    </div>
                    <label style="font-style:italic">Tổng số lớp học đã đăng ký: 
                    	<span id="tongSoLopHocDky" style="color:red">0</span> lớp
                    </label><br />
                    <label style="font-style:italic">Tổng số tiền học phí cần đóng: 
                    	<span id="tongTienHocPhi" style="color:red">0</span> VNĐ
                    </label>
                </fieldset>

                <br />
                <div class="input-group-btn">
                    <button  class="btn btn-default" id="btn-dky-KH" style="width:200px">
                        Đăng ký khóa học <i class="glyphicon glyphicon-edit"></i>
                    </button>
                </div>
            </div>


            <div style="text-align: center">
                <label id="khong-co-ket-qua"></label>
            </div>
        </div>
    </section>
</body>
</html>