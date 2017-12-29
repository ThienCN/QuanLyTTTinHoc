<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Nhập điểm</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!--My CSS-->
    <link rel="stylesheet" href="./CSS/menu-nhan-vien.css">
    <link rel="stylesheet" href="./CSS/GV-nhap-diem-chi-tiet.css">
    <!--My JS-->
    <script src="./JS/GV-nhap-diem-chi-tiet.js"></script>
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
                        <a href="nhanvien.html"><i class="fa fa-user-circle"></i><span class="page-trich-dan"> GIÁO VIÊN NHẬP ĐIỂM</span> </a>
                    </div>
                </div>
                <div class="nav navbar-nav navbar-right">
                    <a class="image-nhan-vien" style="text-decoration:none"><img src="Pic/doremon.png" alt="GiaoVien"><span><%=request.getSession().getAttribute("nameUser") %></span></a>
                </div>
            </div>
        </nav>
        <!-- MENU -->
        <nav class="navbar-default nav-menu">
            <div id="nav-left" class="navbar-collapse collapse">
                <ul class="nav">
                    <li><a href="giaovien"><i class="fa fa-user-circle"></i> Trang của bạn</a></li>
                    <li><a href="GV_thongtincanhan"><i class="fa fa-user-circle-o"></i> Thông tin cá nhân</a></li>
                    <li><a href="GV_lichgiangday"><i class="fa fa-calendar"></i> Lịch giảng dạy</a></li>
                    <li class="active"><a href="GV_nhapdiem"><i class="glyphicon glyphicon-list-alt"></i> Nhập điểm</a></li>
                    <li><a href="GV_posttailieu"><i class="fa fa-upload"></i> Post tài liệu</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
        </nav>

    </header>

    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h3 style="font-weight: bold;" id="tenlop"></h3>
        <label style="color:#197485"><strong><u> Danh sách các học viên: </u></strong></label>
        <div class="row" style="margin-top:10px">
        	<div class="col-lg-5 col-md-5 col-sm-5 col-xs-9">
        		<input id="thongTinTimKiem" type="text" class="form-control"  placeholder="Nhập thông tin tìm kiếm">
        	</div>
        	<div class="col-lg-2 col-md-2 col-sm-2 col-xs-2">
        		<div class="input-group-btn">
                            <a style="background: #197485;color:white;" class="btn btn-default" id="btn-tim">
                                Tìm <i class="glyphicon glyphicon-search"></i>
                            </a>
                        </div>
        	</div>
        </div>
        <br />
        <div>
            <form>
                <fieldset>
                    <div>
                        <table class="table" id="table-bang-diem-hoc-vien">
                            <thead>
                                <tr>
                                    <th style="width:50px;">STT</th>
                                    <th>Mã số HV</th>
                                    <th>Họ tên HV</th>
                                    <th>Điểm LT</th>
                                    <th>Điểm TH</th>
                                    <th>Điểm TB</th>
                                </tr>
                            </thead>
                            <tbody id="myTable"></tbody>
                        </table>
                    </div>
                </fieldset>
                <div class="row">
                    <div class="col-lg-5 col-md-5 col-sm-5">
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                        <div class="input-group-btn">
                            <a id="btn-chinh-sua" class="btn btn-default" style="float:right;">
                                Chỉnh sửa <i class="glyphicon glyphicon-edit"></i>
                            </a>
                        </div>
                    </div>
                    <div class="col-lg-3 col-md-3 col-sm-3 col-xs-6">
                        <div class="input-group-btn">
                            <a id="btn-xac-nhan" class="btn btn-default">
                                Xác nhận <i class="glyphicon glyphicon-ok"></i>
                            </a>
                        </div>
                    </div>
                </div>
            </form>
        </div>
    </section>
</body>
</html>