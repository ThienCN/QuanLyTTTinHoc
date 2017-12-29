<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Quản lý thông báo</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <link rel="stylesheet" href="./CSS/w3.css">
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- MY JS -->
    <script src="./JS/NV_quanlythongbao.js"></script>
    <!-- MY CSS -->
    <link rel="stylesheet" href="./CSS/menu-nhan-vien.css">

	<script>
		$(document).ready(function(){
			  $("#thongTinTimKiem").on("keyup", function() {
			    var value = $(this).val().toLowerCase();
			    $("#myTable tr").filter(function() {
			      $(this).toggle($(this).text().toLowerCase().indexOf(value) > -1)
			    });
			  });
		});
	</script>
    <style>
        div.w3-dropdown-hover{
            position: static;
            background-color: white !important;
            float:right !important;
        }
        button.w3-button {
            background-color: #197485 !important;
            color:white;
        }
        a.w3-bar-item.w3-button {
            text-decoration: none;
        }
    </style>
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
                        <a href="NV_quanlythongbao">
	                        <i class="glyphicon glyphicon-globe"></i>
	                        <span class="page-trich-dan">QUẢN LÝ THÔNG BÁO</span> 
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
                    <li><a href="NV_thongkeDSDKOnL"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Đăng ký online</a></li>
                    <li><a href="NV_thongkeDSHV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Học viên</a></li>
                    <li><a href="NV_thongkeDSGV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Giáo viên</a></li>
                    <li><a href="NV_thongkeDSLH"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Lớp học</a></li>
                    <li class="active"><a href="NV_quanlythongbao"><i class="glyphicon glyphicon-globe"></i> Quản lý thông báo</a></li>
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
    <section class="phan-noi-dung"  style="max-width: 1400px !important">
        <label> Tiêu đề: </label>
        <div class="row">
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="input-group search">
                    <input id="thongTinTimKiem" type="text" class="form-control" placeholder="Nhập tiêu đề thông báo vào đây">
                    <div class="input-group-btn">
                        <button id="timKiemThongBao" class="btn btn-default" style="background-color: #197485; color:white;">
                            Tìm <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div> 
                </div>
            </div>
            <div class="col-xs-12 col-sm-6 col-md-6">
                <div class="form-group" style="float:right">
                    <a href="NV_themthongbao" class="btn btn-default" style="background-color: #197485; color:white; width: 280px;">
                        Thêm thông báo mới <i class="glyphicon glyphicon-plus "></i>
                    </a>
                </div>
            </div>
        </div>
        <hr />
        <label style="color: #197485; font-weight: bold; text-decoration: underline"> Danh sách thông báo: </label>

        <!-- Danh sách thông báo -->
        <fieldset id="ket-qua-thong-ke" style="display:none">
            <div class="table-responsive"  style="max-height: 1000px">  
                <table class="table" id="table-dsThongBao">
                    <thead>
                        <tr>
                            <th>Mã thông báo</th>
                            <th>Tiêu đề thông báo</th>
                            <th>Tóm tắt thông báo</th>
                            <th>Ngày thông báo</th>
                            <th>Tình trạng</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="myTable">
<!--                         <tr> -->
<!--                             <td>TB01</td> -->
<!--                             <td>Thông báo lịch khai giảng sắp tới</td> -->
<!--                             <td>Trung Tâm Tin Học thông báo lịch khai giảng các Lớp Tin Học Văn Phòng Chứng chỉ Quốc tế.</td> -->
<!--                             <td>16-10-2017</td> -->
<!--                             <td>Hiện</td> -->
<!--                             <td> -->
<!--                                 <div class="w3-dropdown-hover"> -->
<!--                                     <button class="w3-button w3-round-xxlarge"><span class="glyphicon glyphicon-edit"></span></button> -->
<!--                                     <div class="w3-dropdown-content w3-bar-block w3-card-4"> -->
<!--                                         <a href="#" class="w3-bar-item w3-button">Đưa lên đầu</a> -->
<!--                                         <a href="NV-chinh-sua-thong-bao.html" class="w3-bar-item w3-button">Chỉnh sửa</a> -->
<!--                                         <a href="#" class="w3-bar-item w3-button">Hiện</a> -->
<!--                                         <a href="#" class="w3-bar-item w3-button">Ẩn</a> -->
<!--                                         <a href="#" class="w3-bar-item w3-button">Xóa</a> -->
<!--                                     </div> -->
<!--                                 </div> -->
<!--                             </td> -->
<!--                         </tr> -->
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