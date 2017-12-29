<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>Chỉnh sửa thông tin Giáo viên</title>
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
    <!-- MY JS -->
    <script src="./JS/Admin_chinhsuathongtingiaovien.js"></script>
    
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
		                <a id="page-trich-dan" href="#">CHỈNH SỬA THÔNG TIN GIÁO VIÊN</a>
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
        <label style="font-weight: bold; text-decoration: underline; color: #197485;"> Tìm kiếm: </label>
        <div class="row">
            <div class="col-xs-12 col-md-6">
                <div class="input-group">
                    <input type="text" id="thongTinTimKiem" class="form-control" placeholder="Nhập thông tin tìm kiếm vào đây" >
                    <div class="input-group-btn" style="text-align: right">
                        <button id="btn-tim-kiem-giao-vien" class="btn btn-default" style="background-color: #197485; color:white; width:150px; ">
                            Tìm kiếm <i class="glyphicon glyphicon-search"></i>
                        </button>
                    </div>
                </div>
            </div>
        </div>
        <hr />
        <!-- Danh sách đăng ký online -->
        <fieldset id="ket-qua-thong-ke">
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">KẾT QUẢ THỐNG KÊ: </p>
            <p style="font-weight: bold;">Số lượng: <span id="soLuong" style="color:red">0</span> Giáo viên</p>
            <div class="table-responsive">
                <table class="table" id="table-ds-giao-vien" >
                    <thead>
                        <tr>
                        	<th>STT</th>
                            <th>Mã Giáo viên </th>
                            <th>Họ tên</th>
                            <th>Ngày sinh</th>
                            <th>CMND</th>
                            <th>Địa chỉ</th>
                            <th>Giới tính</th>
                            <th>Số điện thoại</th>
                            <th>Trình độ học vấn</th>
                            <th>Email</th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody id="myTable"></tbody>
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