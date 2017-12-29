<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<%@ page import="model.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<title>Thu học phí</title>
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
    <script src="./JS/NV-thu-hoc-phi.js"></script>
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
                        <a href="NV_thuhocphi"><i class="glyphicon glyphicon-usd"></i><span class="page-trich-dan"> THU HỌC PHÍ</span> </a>  
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
                    <li class="active"><a href="#"><i class="glyphicon glyphicon-usd"></i> Thu học phí</a></li>
                    <li><a href="NV_thongkeDSDKOnL"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Đăng ký online</a></li>
                    <li><a href="NV_thongkeDSHV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Học viên</a></li>
                    <li><a href="NV_thongkeDSGV"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Giáo viên</a></li>
                    <li><a href="NV_thongkeDSLH"><i class="glyphicon glyphicon-list-alt"></i> Thống kê DS Lớp học</a></li>
                    <li><a href="NV_quanlythongbao"><i class="glyphicon glyphicon-globe"></i> Quản lý thông báo</a></li>
                    <li><a href="NV_quanlytintuc"><i class="glyphicon glyphicon-globe"></i> Quản lý tin tức</a></li>
                    <li><a href="index"><i class="glyphicon glyphicon-log-out"></i>  Thoát</a></li>
                </ul>
            </div>
        </nav>

    </header>  
   
    <!-- CONTENT -->
    <section class="phan-noi-dung">
        <h3 style="color:#197485; font-weight:bold; text-decoration:underline">BIÊN LAI THU TIỀN</h3>
        <br />
        <div>  
            <div class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã học viên:</label>
                    <div class="col-xs-12 col-sm-8 col-md-6">
                        <input type="text" class="form-control" id="maHocVien" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên người nộp:</label>
                    <div class="col-xs-12 col-sm-8 col-md-6">
                        <input type="text" class="form-control" id="hoTenHV" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Số tiền nộp:</label>
                    <div class="col-xs-12 col-sm-8 col-md-6">
                        <input type="text" class="form-control" id="hocPhiPhaiThanhToan" readonly>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày nộp:</label>
                    <div class="col-xs-12 col-sm-8 col-md-6">
                        <input type="date" id="ngay-nop-HP" class="form-control" readonly 
                        <%
                        	Date date = new Date();
                        	SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
                        %>
                        	value="<%=simpleDateFormat.format(date) %>"
                        >
                    </div>

                </div>
                <div class="form-group">
                    <div class="col-xs-12 col-sm-12 col-md-8">
                        <div class="input-group-btn">
                            <button href="#" class="btn btn-default" id="btn-xuat-bien-lai" style="width: 200px;">
                                Xuất biên lai <i class="glyphicon glyphicon-ok"></i>
                            </button>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <hr/>
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
                    <tbody>
                    	<%
                        	List<LopHocModel> dsLopHocDangKy = (List<LopHocModel>)getServletContext().getAttribute("dsLopHocDangKy");  
                     		for(int i=0; i<dsLopHocDangKy.size(); i++) { %>   
                    			<tr>
                    				<td><%=dsLopHocDangKy.get(i).getMaLop() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getTenLop() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getSoBuoi() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getNgayBatDau() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getNgayKetThuc() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getSoPhong() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getBuoiHoc() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getGioHoc() %></td>
                    				<td><%=dsLopHocDangKy.get(i).getHocPhi() %></td>
                    			</tr>
                    	<%} %>
                    </tbody>
                </table>
            </div>
        </fieldset>
    </section>
</body>
</html>