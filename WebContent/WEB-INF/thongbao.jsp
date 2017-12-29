<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Thông báo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge,chrome=1">
    <!-- Boostrap -->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- W3 CSS -->
    <link rel="stylesheet" href="./CSS/w3.css" />    
    <!-- My CSS -->
    <link rel="stylesheet" href="./CSS/thongbao_tintuc.css" />
    <link rel="stylesheet" href="./CSS/header-menu-fooder.css" />
    <!-- MY JS -->
    <script src="./JS/login.js"></script>
    <script src="./JS/include-html.js"></script>
    <script src="./JS/thongbao.js"></script>
    
    <!-- TƯ VẤN -->
    <script src="./JS/tuvan.js"></script>
</head>
<body>
	<!-- Logo and menu bar -->
	<header id="header-menu"></header>
	<div class="container duong-dan">
	    <p><a href="index">Trang chủ</a> / <a href="thongbao">Thông báo</a></p>
	</div>
	<!-- THÔNG BÁO CHÍNH -->
	<section class="container" style="padding: 0;">
		<div id="TBChinh" style="display: none">
			<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-12 col-sm-12 col-md-7">
		            <img id="imageTBChinh" alt="Thông báo" width="100%">
		        </div>
		        <div class="col-xs-12 col-sm-12 col-md-5 thong-bao-tin-tuc">
		            <h3>
		            	<input type="hidden" id="maTBChinh"/>
		            	<a id="tieuDeTBChinh" style="font-weight: bold;"></a>
		            	<image src="./Pic/icon-new.gif" style="width: 50px"></image>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayTBChinh"></span>
		            <p id="noiDungTomTatTBChinh" class="noi-dung-tom-tat-chinh"></p>
		        </div>
		        <div class="xem-tiep-noi-dung"><a id="xemTiepNoiDungTBChinh"></a></div>
		    </div>
		</div>
	</section>
	
	
	<!-- THÔNG BÁO PHỤ-->
	<section class="container" style="padding: 0;">  
		<!-- TB Phụ 1 -->
		<div id="TBPhu1" style="display: none">
			<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-5 col-sm-5 col-md-3">
		            <img id="imageTBPhu1" alt="Thông báo" width="100%">
		        </div>
		        <div class="col-xs-7 col-sm-7 col-md-9 thong-bao-tin-tuc">
		            <h3>
		            	<input type="hidden" id="maTBPhu1"/>
		            	<a id="tieuDeTBPhu1"></a>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayTBPhu1"></span>
		            <p id="noiDungTomTatTBPhu1" class="noi-dung-tom-tat"></p>            
		        </div>
		        <div class="xem-tiep-noi-dung"><a id="xemTiepNoiDungTBPhu1"></a></div>
		    </div>
		</div>
	    
	    <!-- TB Phụ 2 -->
	    <div id="TBPhu2" style="display: none">
	    	<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-5 col-sm-5 col-md-3">
		            <img id="imageTBPhu2" alt="Thông báo" width="100%">
		        </div>
		        <div class="col-xs-7 col-sm-7 col-md-9 thong-bao-tin-tuc">
		            <h3>
		            	<input type="hidden" id="maTBPhu2"/>
		            	<a id="tieuDeTBPhu2"></a>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayTBPhu2"></span>
		            <p id="noiDungTomTatTBPhu2" class="noi-dung-tom-tat"></p>            
		        </div>
		        <div class="xem-tiep-noi-dung"><a id="xemTiepNoiDungTBPhu2"></a></div>
		    </div>
	    </div>
	    
	    <!-- TB Phụ 3 -->
	    <div id="TBPhu3" style="display: none">
	    	<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-5 col-sm-5 col-md-3">
		            <img id="imageTBPhu3" alt="Thông báo" width="100%">
		        </div>
		        <div class="col-xs-7 col-sm-7 col-md-9 thong-bao-tin-tuc">
		            <h3>
		            	<input type="hidden" id="maTBPhu3"/>
		            	<a id="tieuDeTBPhu3"></a>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayTBPhu3"></span>
		            <p id="noiDungTomTatTBPhu3" class="noi-dung-tom-tat"></p>            
		        </div>
		        <div class="xem-tiep-noi-dung"><a id="xemTiepNoiDungTBPhu3"></a></div>
		    </div>
	    </div>
	    <div class="col-md-12 line"></div>
	    
	    <div style="text-align: center;" >
	    	<ul class="pagination pagination-sm" id="paginationThongBao">
			</ul>
	    </div>
	    
	</section>
	
	<!-- ĐĂNG KÝ -->
	<section>
	    <div>
	        <a href="dangkykhoahoc.jsp"><img src="./Pic/dangky-right.png" alt="Lịch thi" class="imgDKKH-right"></a>
	    </div>
	    <div>
	        <a href="dangkykhoahoc.jsp"><img src="./Pic/dangky-bottom.png" alt="Lịch thi" class="imgDKKH-bottom"></a>
	    </div>
	</section>
	
	<br><br>
	
	<!-- Footer: Thông tin, địa chỉ -->
	<footer id="footer"></footer>
</body>
</html>