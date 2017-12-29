<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta http-equiv="X-UA-Compatible" content="ie=edge">
<!-- Boostrap (slide)-->
<link rel="stylesheet" href="./CSS/bootstrap.min.css">
<script src="./JS/jquery-3.2.1.min.js"></script>
<script src="./JS/bootstrap.min.js"></script>
<!-- Glyphicons -->
<link rel="stylesheet" href="./CSS/font-awesome.min.css">
<link rel="stylesheet" href="./CSS/w3.css">
<title>Lịch khai giảng</title>

<link rel="stylesheet" href="./CSS/dangkykhoahoc.css">
<link rel="stylesheet" href="./CSS/lichkhaigiang.css">
<link rel="stylesheet" href="./CSS/header-menu-fooder.css" />

<script src="./JS/updown.js"></script>
<script src="./JS/include-html.js"></script>
<script src="./JS/lichkhaigiang.js"></script>
</head>

<body>
	<!-- Logo and menu bar -->
	<header id="header-menu"></header>

	<!--Slide-->
	<div class="container">
		<div id="myCarousel" class="carousel slide" data-ride="carousel">
			<!-- Indicators -->
			<ol class="carousel-indicators">
				<li data-target="#myCarousel" data-slide-to="0" class="active"></li>
				<li data-target="#myCarousel" data-slide-to="1"></li>
				<li data-target="#myCarousel" data-slide-to="2"></li>
				<li data-target="#myCarousel" data-slide-to="3"></li>
				<li data-target="#myCarousel" data-slide-to="4"></li>
			</ol>

			<!-- Wrapper for slides -->
			<div class="carousel-inner">
				<div class="item active">
					<img src="./Pic/tongkhaigiang.png" alt="Tong khai giang"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="./Pic/office.png" alt="Tin hoc van phong"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="./Pic/thietkeweb.jpg" alt="Thiet ke web"
						style="width: 100%;">
				</div>

				<div class="item">
					<img src="./Pic/mobile.png" alt="Lap trinh mobile"
						style="width: 100%;">
					<div class="carousel-caption">
						<h3>Lập trình di động</h3>
					</div>
				</div>

				<div class="item">
					<img src="./Pic/CSDL.jpg" alt="Thiet ke co so du lieu"
						style="width: 100%;">
					<div class="carousel-caption">
						<h3>Thiết kế Cơ sở dữ liệu</h3>
					</div>
				</div>
			</div>

			<!-- Left and right controls -->
			<a class="left carousel-control" href="#myCarousel" data-slide="prev">
				<span class="glyphicon glyphicon-chevron-left"></span> <span
				class="sr-only">Previous</span>
			</a> <a class="right carousel-control" href="#myCarousel"
				data-slide="next"> <span
				class="glyphicon glyphicon-chevron-right"></span> <span
				class="sr-only">Next</span>
			</a>
		</div><br /><br />

<!-- 		<div class="col-md-12"> -->
<!-- 			<div style="text-align: center"> -->
<!-- 				<h1 style="color: orangered"> -->
<!-- 					<strong>Thông tin ưu đãi học phí</strong> -->
<!-- 				</h1> -->
<!-- 				<img src="./Pic/ngoisao_cam.png" width="250px"> -->
<!-- 			</div> -->
<!-- 			<br> -->

<!-- 			<div class="col-md-12 khoang-cach-5"> -->
<!-- 				<div style="text-align: center;"> -->
<!-- 					<div style="text-align: left;"> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							<strong>ÁP DỤNG CHO CÁC LỚP TIN HỌC VĂN PHÒNG</strong> -->
<!-- 						</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							Giảm<strong>&nbsp;<span style="color: #ff0000;">30.000đ</span> -->
<!-- 							</strong>khi đăng ký ONLINE -->
<!-- 						</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							Giảm<span style="color: #ff0000;"> <strong>50.000đ</strong></span> -->
<!-- 							cho SV, <span style="color: #ff0000;"><strong>30.000đ</strong></span> -->
<!-- 							cho các đối tượng khác -->
<!-- 						</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;">Ưu đãi giảm -->
<!-- 							50.000đ khi đăng ký nhóm 5 học viên</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							<strong>ÁP DỤNG CHO CÁC LỚP LẬP TRÌNH</strong> -->
<!-- 						</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							Giảm <span style="color: #ff0000;"><strong>50.000đ</strong></span> -->
<!-- 							khi đăng ký online cho các lớp <strong>Lập trình trên -->
<!-- 								Mobile</strong> -->
<!-- 						</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							<strong>ÁP DỤNG CHO CÁC LỚP THIẾT KẾ</strong> -->
<!-- 						</p> -->
<!-- 						<p style="margin-left: 30pt; text-align: center;"> -->
<!-- 							Giảm <span style="color: #ff0000;"><strong>30.000đ</strong></span> -->
<!-- 							khi đăng ký online cho các lớp <strong>Thiết kế Web</strong> -->
<!-- 						</p> -->
<!-- 						<h3 style="color: lightseagreen"> -->
<!-- 							<u><strong>Lưu ý:</strong></u> -->
<!-- 						</h3> -->
<!-- 						<p style="text-align: center; color: lightseagreen"> -->
<!-- 							<strong>Thời hạn cuối cùng được nhận ưu đãi đến hết ngày</strong><span -->
<!-- 								style="color: #ff0000;"><strong>&nbsp;14/10/2017</strong></span> -->
<!-- 						</p> -->
<!-- 						<p style="text-align: center; color: lightseagreen"> -->
<!-- 							**<strong> Học trực tiếp trên máy - 1 học viên/máy - Học -->
<!-- 								phí đã bao gồm giáo trình, lệ phí thi và cấp chứng chỉ </strong>** -->
<!-- 						</p> -->
<!-- 						<br> -->
<!-- 						<br> -->
<!-- 					</div> -->
<!-- 				</div> -->
<!-- 			</div> -->
<!-- 		</div> -->

		<div class="col-sm-12" style="padding:0">
			<div style="text-align: center">
				<h1 class="tieu-de-muc" style="color: orangered">
					<strong>Lịch khai giảng</strong>
				</h1>
				<h3 id="khoa" style="color: orangered">
					<strong></strong>
				</h3>
				<img src="./Pic/ngoisao_cam.png" width="250px">
			</div>
			<br>
			
			<div class="table-responsive lich-khai-giang">
				<table class="table table-bordered table-striped" id="table-lich-khai-giang">
					<thead style="background-color: rgb(223, 244, 255);">
						<tr>
							<th>Mã lớp</th>
							<th>Tên lớp</th>
							<th>Thời gian</th>
							<th>Số buổi</th>
							<th>Học phí</th>
							<th>Ngày khai giảng</th>
							<th>Địa điểm học</th>
							<th></th>
						</tr>
					</thead>
					<tbody>
					</tbody>
				</table>
			</div>
			
			<div class="hoc-phi" style="text-align:center; color:blue">
				<strong><i>Học viên đăng ký đến đóng học phí và học tại Trung tâm Tin học Angel</i></strong><br />
				<strong>Địa chỉ: Số 01, Võ Văn Ngân, Q. Thủ Đức, Tp. HCM - Tel: (028)99.999.999</strong>
			</div><br />
			<!--             <div class=" nganh-khoang-cach"> -->
			<!--                 <div class="panel-group" id="accordion"> -->

			<!--                     <div class="panel panel-primary"> -->
			<!--                         <div class="panel-heading pnl1" data-toggle="collapse" data-target="#collapse1" data-parent="#accordion"> -->
			<!--                             <strong>LẬP TRÌNH TRÊN MOBILE</strong> -->
			<!--                             <span class="glyphicon glyphicon-menu-up" style="float:right"></span> -->
			<!--                         </div> -->
			<!--                         <div id="collapse1" class="collapse in" style="width: 100%"> -->
			<!--                             <div class="panel-body"> -->
			<!--                                 <h4 style="color: orangered"><strong id="tenlop0"></strong></h4> -->
			<!--                                 <div class="nganh-hoc-phi"><strong id="hocphi0"></strong></div> -->
			<!--                                 <p> -->
			<!--                                     <strong>Ưu đãi: </strong> -->
			<!--                                     <em>giảm <span style="color:#ff0000 ;"><strong>50.000 VND</strong></span> khi đăng ký ONLINE</em> -->
			<!--                                 </p> -->
			<!--                                 <div class="table-responsive"> -->
			<!--                                     <table class="col-sm-12 table-bordered table-condensed w3-striped" id="table0" style="padding: 0px"> -->
			<!--                                         <thead> -->
			<!--                                             <tr class="w3-blue"> -->
			<!--                                                 <td>Mã lớp</td> -->
			<!--                                                 <td>Thời gian</td> -->
			<!--                                                 <td>Ngày khai giảng</td> -->
			<!--                                                 <td>Địa điểm học</td> -->
			<!--                                                 <td></td> -->
			<!--                                             </tr> -->
			<!--                                         </thead> -->
			<!--                                         <tbody> -->
			<!--                                         </tbody> -->
			<!--                                     </table> -->
			<!--                                 </div> -->

			<!--                                 <h4 style="color: orangered; line-height: 1cm;border-left: 2px"><strong id="tenlop1"></strong></h4> -->
			<!--                                 <div class="nganh-hoc-phi"><strong id="hocphi1"></strong></div> -->
			<!--                                 <p> -->
			<!--                                     <strong>Ưu đãi: </strong> -->
			<!--                                     <em>giảm <span style="color:#ff0000 ;"><strong>50.000 VND</strong></span> khi đăng ký ONLINE</em> -->
			<!--                                 </p> -->
			<!--                                 <div class="w3-border"> -->
			<!--                                     <table class="col-sm-12 table-bordered table-condensed w3-striped" id="table1"> -->
			<!--                                         <thead> -->
			<!--                                             <tr class="w3-blue"> -->
			<!--                                                 <td>Mã lớp</td> -->
			<!--                                                 <td>Thời gian</td> -->
			<!--                                                 <td>Ngày khai giảng</td> -->
			<!--                                                 <td>Địa điểm học</td> -->
			<!--                                                 <td></td> -->
			<!--                                             </tr> -->
			<!--                                         </thead> -->
			<!--                                         <tbody> -->
			<!--                                         </tbody> -->
			<!--                                     </table> -->
			<!--                                 </div> -->
			<!--                             </div> -->
			<!--                         </div> -->
			<!--                     </div><br> -->

			<!--                     <div class="panel panel-primary"> -->
			<!--                         <div class="panel-heading pnl2" data-toggle="collapse" data-target="#collapse2" data-parent="#accordion"> -->
			<!--                             <strong>ỨNG DỤNG CNTT NÂNG CAO (TIN HỌC VĂN PHÒNG)</strong> -->
			<!--                             <span class="glyphicon glyphicon-menu-down" style="float:right"></span> -->
			<!--                         </div> -->
			<!--                         <div id="collapse2" class="collapse" style="width: 100%"> -->
			<!--                             <div class="panel-body"> -->
			<!--                                 <h4 style="color: orangered"><strong id="tenlop2"></strong></h4> -->
			<!--                                 <div class="nganh-hoc-phi"><strong id="hocphi2"></strong></div><br> -->
			<!--                                 <p> -->
			<!--                                     <em style="font-size: 13px">Máy tính & mạng máy tính, Internet và ứng dụng, Word- Excel- Powerpoint nâng cao</em> -->
			<!--                                 </p> -->
			<!--                                 <div class="table-responsive"> -->
			<!--                                     <table class="col-sm-12 table-bordered table-condensed w3-striped" style="padding: 0px" id="table2"> -->
			<!--                                         <thead> -->
			<!--                                             <tr class="w3-blue"> -->
			<!--                                                 <td>Mã lớp</td> -->
			<!--                                                 <td>Thời gian</td> -->
			<!--                                                 <td>Ngày khai giảng</td> -->
			<!--                                                 <td>Địa điểm học</td> -->
			<!--                                                 <td></td> -->
			<!--                                             </tr> -->
			<!--                                         </thead> -->
			<!--                                         <tbody> -->
			<!--                                         </tbody> -->
			<!--                                     </table> -->
			<!--                                 </div> -->

			<!--                             </div> -->
			<!--                         </div> -->
			<!--                     </div><br> -->


			<!--                     <div class="panel panel-primary"> -->
			<!--                         <div class="panel-heading pnl3" data-toggle="collapse" data-target="#collapse3" data-parent="#accordion"> -->
			<!--                             <strong>CÁC LỚP CHUYÊN ĐỀ</strong> -->
			<!--                             <span class="glyphicon glyphicon-menu-down" style="float:right"></span> -->
			<!--                         </div> -->
			<!--                         <div id="collapse3" class="collapse" style="width: 100%"> -->
			<!--                             <div class="panel-body"> -->
			<!--                                 <h4 style="color: orangered"><strong id="CDT0"></strong></h4> -->
			<!--                                 <div class="nganh-hoc-phi"><strong id="CDHP0"></strong></div> -->
			<!--                                 <p> -->
			<!--                                     <strong>Ưu đãi: </strong> -->
			<!--                                     <em>giảm <span style="color:#ff0000 ;"><strong>50.000 VND</strong></span> khi đăng ký ONLINE</em> -->
			<!--                                 </p> -->
			<!--                                 <div class="table-responsive"> -->
			<!--                                     <table class="col-sm-12 table-bordered table-condensed w3-striped" style="padding: 0px" id="CDTable0"> -->
			<!--                                         <thead> -->
			<!--                                             <tr class="w3-blue"> -->
			<!--                                                 <td>Mã lớp</td> -->
			<!--                                                 <td>Thời gian</td> -->
			<!--                                                 <td>Ngày khai giảng</td> -->
			<!--                                                 <td>Địa điểm học</td> -->
			<!--                                                 <td></td> -->
			<!--                                             </tr> -->
			<!--                                         </thead> -->
			<!--                                         <tbody> -->
			<!--                                         </tbody> -->
			<!--                                     </table> -->
			<!--                                 </div> -->

			<!--                                 <h4 style="color: orangered; line-height: 1cm;border-left: 2px"><strong id="CDT1"></strong></h4> -->
			<!--                                 <div class="nganh-hoc-phi"><strong id="CDHP1"></strong></div> -->
			<!--                                 <p> -->
			<!--                                     <strong>Ưu đãi: </strong> -->
			<!--                                     <em>giảm <span style="color:#ff0000 ;"><strong>30.000 VND</strong></span> khi đăng ký ONLINE</em> -->
			<!--                                 </p> -->
			<!--                                 <div class="w3-border"> -->
			<!--                                     <table class="col-sm-12 table-bordered table-condensed w3-striped" id="CDTable1"> -->
			<!--                                         <thead> -->
			<!--                                             <tr class="w3-blue"> -->
			<!--                                                 <td>Mã lớp</td> -->
			<!--                                                 <td>Thời gian</td> -->
			<!--                                                 <td>Ngày khai giảng</td> -->
			<!--                                                 <td>Địa điểm học</td> -->
			<!--                                                 <td></td> -->
			<!--                                             </tr> -->
			<!--                                         </thead> -->
			<!--                                         <tbody> -->
			<!--                                         </tbody> -->
			<!--                                     </table> -->
			<!--                                 </div> -->
			<!--                             </div> -->
			<!--                         </div> -->
			<!--                     </div><br> -->
			<!--                 </div> -->
		</div>
	</div>

	<!-- Footer: Thông tin, địa chỉ -->
	<footer id="footer"></footer>
</body>

</html>