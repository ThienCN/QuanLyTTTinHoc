<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Tin tức</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge,chrome=1">
    <!-- Boostrap-->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- W3 CSS -->
    <link rel="stylesheet" href="./CSS/w3.css"/>
    <!-- My CSS -->
    <link rel="stylesheet" href="./CSS/thongbao_tintuc.css" />
    <link rel="stylesheet" href="./CSS/header-menu-fooder.css" />
    <!-- My JS -->
    <script src="./JS/login.js"></script>
    <script src="./JS/include-html.js"></script>
    <script src="./JS/tintuc.js"></script>
    <!-- TƯ VẤN -->
    <script src="./JS/tuvan.js"></script>
</head>
<body>
	<!-- Logo and menu bar -->
    <header id="header-menu"></header>
    <div class="container duong-dan">
        <p><a href="index">Trang chủ</a> / <a href="tintuc">Tin tức</a></p>
    </div>
    <!-- TIN TỨC CHÍNH -->
    <section class="container" style="padding: 0;">
    	<div id="tintucChinh" style="display: none;">
    		<div class="col-xs-12 col-sm-12 col-md-12">
            <div class="col-md-12 line"></div>
	            <div class="col-xs-12 col-sm-12 col-md-7">
	                <video id="divVideoTinTuc" width="100%" controls style="display: none;">
	                    <source id="videoTTChinh" type="video/mp4" >
	                </video>
	                <img id="imageTTChinh" alt="Tin tức" width="100%" style="display: none;">
	            </div>
	            <div class="col-xs-12 col-sm-12 col-md-5 thong-bao-tin-tuc">
	            	<h3>
		            	<a id="tieuDeTTChinh" style="font-weight: bold;"></a>
		            	<image src="./Pic/icon-new.gif" style="width: 50px"></image>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayDangTTChinh"></span>
		            <p id="noiDungTomTatTTChinh" class="noi-dung-tom-tat-chinh"></p>
	            </div>
	        </div>
    	</div>
    </section>
    <!-- TIN TỨC PHỤ-->
    <section class="container" style="padding: 0;">
    	<!-- TT Phụ 1 -->
		<div id="TTPhu1" style="display: none">
			<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-5 col-sm-5 col-md-3">
		        	<video id="divVideoTinTucPhu1" width="100%" controls style="display: none;">
	                    <source id="videoTTPhu1" type="video/mp4" >
	                </video>
	                <img id="imageTTPhu1" alt="Tin tức" width="100%" style="display: none;">
		        </div>
		        <div class="col-xs-7 col-sm-7 col-md-9 thong-bao-tin-tuc">
		            <h3>
		            	<a id="tieuDeTTPhu1"></a>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayDangTTPhu1"></span>
		            <p id="noiDungTomTatTTPhu1" class="noi-dung-tom-tat"></p>            
		        </div>
		    </div>
		</div>
		
        <!-- TT Phụ 2 -->
	    <div id="TTPhu2" style="display: none">
	    	<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-5 col-sm-5 col-md-3">
		        	<video id="divVideoTinTucPhu2" width="100%" controls style="display: none;">
	                    <source id="videoTTPhu2" type="video/mp4" >
	                </video>
		            <img id="imageTTPhu2" alt="Tin tức" width="100%">
		        </div>
		        <div class="col-xs-7 col-sm-7 col-md-9 thong-bao-tin-tuc">
		            <h3>
		            	<a id="tieuDeTTPhu2"></a>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayTTPhu2"></span>
		            <p id="noiDungTomTatTTPhu2" class="noi-dung-tom-tat"></p>            
		        </div>
		    </div>
	    </div>
	    
	    <!-- TT Phụ 3 -->
	    <div id="TTPhu3" style="display: none">
	    	<div class="col-xs-12 col-sm-12 col-md-12">
		        <div class="col-md-12 line"></div>
		        <div class="col-xs-5 col-sm-5 col-md-3">
		        	<video id="divVideoTinTucPhu3" width="100%" controls style="display: none;">
	                    <source id="videoTTPhu3" type="video/mp4" >
	                </video>
		            <img id="imageTTPhu3" alt="Tin tức" width="100%">
		        </div>
		        <div class="col-xs-7 col-sm-7 col-md-9 thong-bao-tin-tuc">
		            <h3>
		            	<a id="tieuDeTTPhu3"></a>
		            </h3>
		            <i class="fa fa-clock-o"></i>
		            <span id="ngayTTPhu3"></span>
		            <p id="noiDungTomTatTTPhu3" class="noi-dung-tom-tat"></p>            
		        </div>
		    </div>
	    </div>
	    <div class="col-md-12 line"></div>
	    
	    <div style="text-align: center;" >
	    	<ul class="pagination pagination-sm" id="paginationTinTuc">
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
    <footer id="footer"> </footer>
</body>
</html>