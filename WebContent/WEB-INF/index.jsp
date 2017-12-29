<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Trang chủ</title>
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
    <link rel="stylesheet" href="./CSS/index.css"/>
    <link rel="stylesheet" href="./CSS/header-menu-fooder.css" />
    <!-- My JS -->
    <script src="./JS/include-html.js"></script>
    <!-- TƯ VẤN -->
    <script src="./JS/tuvan.js"></script>
    <script>
		//flag = 1: Load 4 thông báo nổi bật lên  
		var flag=1;
		$.ajax({
			type:"POST",
			url:"index",
			data:{
				flag:flag
			},
			dataType:"json",
			success:function(result){
				if(result.check == "fail"){
					alert("Server bận!");
					return;
				}
				else{
					var n = Object.keys(result).length;
					
					for(i=0; i<n; i++){
						$('#dsThongBaoNoiBat').append(
							$('<li>').append(
								$('<a href="thongbao">').text(result[i].tieuDeThongBao)
								).append(
								$('<br>')		
								).append(
								$('<i class="fa fa-clock-o">')		
								).append(
								$('<span>').text(" " + result[i].ngayThongBao)		
								)
						)
					}
				}
			}
		})
		
		//flag = 2: Load 4 tin tức nổi bật lên  
		flag=2;
		$.ajax({
			type:"POST",
			url:"index",
			data:{
				flag:flag
			},
			dataType:"json",
			success:function(result){
				if(result.check == "fail"){
					alert("Server bận!");
					return;
				}
				else{
					var n = Object.keys(result).length;
					
					for(i=0; i<n; i++){
						$('#dsTinTucNoiBat').append(
							$('<li>').append(
								$('<a href="tintuc">').text(result[i].tieuDeTinTuc)
								).append(
								$('<br>')		
								).append(
								$('<i class="fa fa-clock-o">')		
								).append(
								$('<span>').text(" " + result[i].ngayDangTinTuc)		
								)
						)
					}
				}
			}
		})
    </script>
</head>
<body>
	<!-- Logo and menu bar -->
    <header id="header-menu"></header>
    <!-- Image Slide -->
    <section>
        <div class="container">
            <div id="myCarousel" class="carousel slide" data-ride="carousel">
                    <!-- Indicators -->
                <ol class="carousel-indicators">
                    <li data-target="#myCarousel" data-slide-to="0" class="active"></li>
                    <li data-target="#myCarousel" data-slide-to="1"></li>
                    <li data-target="#myCarousel" data-slide-to="2"></li>
                </ol>
                <!-- Wrapper for slides -->
                <div class="carousel-inner">
                    <div class="item active">
                        <img src="./Pic/pic4.jpg" alt="Image1">
                    </div>
        
                    <div class="item">
                        <img src="./Pic/pic3.jpg" alt="Image2">
                    </div>
                    
                    <div class="item">
                        <img src="./Pic/pic2.jpg" alt="Image3">
                    </div>
                </div>
                <!-- Left and right controls -->
                <a class="left carousel-control" href="#myCarousel" data-slide="prev" role="button">
                    <span class="glyphicon glyphicon-chevron-left"></span>
                    <span class="sr-only">Previous</span>
                </a>
                <a class="right carousel-control" href="#myCarousel" data-slide="next" role="button">
                    <span class="glyphicon glyphicon-chevron-right"></span>
                    <span class="sr-only">Next</span>
                </a>
            </div>
        </div>
    </section>
    <!-- Thống kê -->
    <section>
        <div class="tieu-de-thong-ke" >
            <h3> Cảm ơn các bạn đã tin tưởng và đồng hành<br> cùng chúng tôi </h3>
        </div>
        <div class="group-thong-ke">
            <div class="container">
                <div class="box">
                   <div class="bieu-tuong div-square">
                       <i class="fa fa-calendar"></i>    
                       <p><span>></span> 10 </p>
                       <p class="small"> năm </p>                    
                   </div>   
                </div>
                <div class="box">
                    <div class="bieu-tuong div-square">
                        <i class="fa fa-user-circle"></i>    
                        <p><span>></span> 100 000 </p> 
                        <p> học viên </p>                  
                    </div>   
                </div>
                <div class="box">
                    <div class="bieu-tuong div-square">
                        <i class="fa fa-user-circle-o"></i>  
                        <p><span>></span> 100 </p> 
                        <p> giáo viên </p>                     
                    </div>   
                </div>
                <div class="box">
                     <div class="bieu-tuong div-square">
                         <i class="fa fa-address-book"></i>   
                         <p><span>></span> 100 </p>   
                         <p> CT đào tạo </p>                   
                     </div>   
                </div>
            </div>
        </div>
    </section>
    <!-- Lịch thi -->
    <section>
        <div class="container lich-thi">
            <img src="./Pic/lichthi.png" alt="Lịch thi">
        </div>
    </section>
    <!-- Tiện ích: tin tức, thông báo, lịch thi, đăng ký trực tuyến -->
    <section>
        <div class="container">
            <div class="col-xs-12 col-md-4 col-sm-12 khung-tien-ich">
                <div class="tab-tin-tuc-thong-bao">
                    <ul class="nav nav-tabs header-tabs">
                        <li class="active"><a data-toggle="tab" href="#thongbao">THÔNG BÁO</a></li>
                        <li><a data-toggle="tab" href="#tintuc">TIN TỨC</a></li>
                    </ul>
                    <div class="tab-content">
                        <div id="thongbao" class="tab-pane fade in active">
                            <ul id="dsThongBaoNoiBat" class="noidung-tab">
                            </ul>
                            <a class="noidung-tab-all" href="thongbao">See all</a>
                        </div>
                        <div id="tintuc" class="tab-pane fade">
                            <ul id="dsTinTucNoiBat" class="noidung-tab">
                            </ul>
                            <a class="noidung-tab-all" href="tintuc">See all</a>
                        </div>
                    </div>
                </div>
            </div>
            <div class="col-xs-12 col-md-4 col-sm-12 khung-tien-ich">
                <a href="dangkykhoahoc.htm"><img src="./Pic/dangkykhoahoc.gif" alt="Đăng ký khóa học"></a>
            </div>
            
            <div class="col-xs-12 col-md-4 col-sm-12 khung-tien-ich slide">
                <a href="#">
                    <img src="./Pic/lichkhaigiangmoi.jpg" alt="Lịch khai giảng mới nhất">
                    <div class="slide-caption">
                        <h4 style="font-weight: bold !important;">Khai giảng từ ngày 06/06/2017 đến ngày 26/06/2017</h4>
                        <p style="color:black">(Giờ học từ 18g đến 20g30)</p>
                    </div>
                </a>
            </div>
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


    <!-- Footer: Thông tin, địa chỉ -->
   <footer id="footer"></footer>
</body>
</html>