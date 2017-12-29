<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta charset="utf-8" />
    <title>Đăng ký thành công</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">

    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>

    <link rel="stylesheet" href="./CSS/bootstrap.min.css" />
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- My CSS-->
    <!-- My JS -->
    <script src="./JS/dangkykhoahocthanhcong.js"></script>
</head>
<body style="font-family:'Times New Roman';padding: 20px">
    <!-- HEADER -->
    <div class="container">
            <img src="./Pic/logo-TTTH.png" alt="logo" class="logo w3-animate-zoom ">
    </div><br />

    <div class="container" style="border:2px solid beige">
    	<h1 style="text-align:center"><strong>Chúc mừng bạn đã đăng ký thành công!</strong></h1>
    	<h3 class="makhachdat"><u>Mã code đăng ký online của bạn là:</u><span style="color:red">&nbsp;&nbsp;<%=getServletContext().getAttribute("MaDkyOnl") %></span><i style="color:red; font-size:17px">&nbsp;&nbsp;(Khi đến nhận lớp vui lòng cung cấp mã code đăng ký online)</i></h3><br/>
    	<div>
    		<table class="table" id="table-dang-ky-thanh-cong" style="font-size:20px">
               <thead>
                   <tr>
                       	<th>Mã lớp</th>
						<th>Tên lớp</th>
						<th>Thời gian</th>
						<th>Số buổi</th>
						<th>Học phí</th>
						<th>Ngày khai giảng</th>
						<th>Địa điểm học</th>
                   </tr>
               </thead>
               <tbody>
               </tbody>
             </table>
          </div><br/>
          <h4><strong><u>TỔNG CỘNG:</u><span id="tongtien"></span></strong></h4><br/>
          <i style="color:red; font-size:19px">Vui lòng đến nhận lớp vào ngày khai giảng</i><br/>
          <h3 style="text-align:center">Chân thành cảm ơn bạn!</h3>
          <a href='index' style='text-decoration: none; color: #0d875c; font-size: 20px; float: right'>Trở về trang chủ >></a>
    </div>
  	
  
</body>
</html>