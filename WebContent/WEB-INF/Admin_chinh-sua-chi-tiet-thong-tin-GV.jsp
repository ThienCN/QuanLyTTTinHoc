<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.*, java.text.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta charset="UTF-8">
    <title>Chỉnh sửa thông tin chi tiết của Giáo viên</title>
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
    <link rel="stylesheet" href="./CSS/Admin.css"/>
    <!-- MY JS -->
    <script src="./JS/header-menu-admin.js"></script>
    <script src="./JS/Admin_chinhsuathongtingiaovien.js"></script>
    
    <script>
    
  //flag=2: Load ds Trình độ học vấn
	var flag=2;
	$.ajax({
		type:"POST",
		url:"Admin_themgiaovien",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == null){
				var n = Object.keys(result).length;
				for(i=0; i<n; i++){
					$("#cbTrinhDoHocVan").append(
							$('<option>').val(result[i].MaTrinhDoHV).text(result[i].TenTrinhDoHV)
						)
				}
				//flag=1: Load thông tin giáo viên cần chỉnh sửa lên trang
				var flag = 1;
				$.ajax({
					type:"POST",
					url:"Admin_chinhsuachitietthongtinGV",
					data:{
						flag:flag
					},
					dataType:"json",
					success:function(result){
						if(result.check == "fail"){
							alert("Server bận!");
							window.location.assign("admin");
						}
						else{
							$("#maGiaoVien").val(result.MaGV);
							$("#hoTen").val(result.HoTenGV);
							$("#CMND").val(result.CMND);
							$("#ngaySinh").val(result.NgaySinh);
							$("#diaChi").val(result.DiaChi);
							$("#SDT").val(result.DienThoai);
							
							if(result.GioiTinh)
								$("#cbGioiTinh").val('1');
							else
								$("#cbGioiTinh").val('0');
							
							
							$("#cbTrinhDoHocVan option").each(function () {
							        if ($(this).html() == result.TenTrinhDoHV) {
							            $(this).attr("selected", "selected");
							            return;
							        }
							});
							
							$("#email").val(result.EmailGV);
							$("#tenTaiKhoan").val(result.MaGV);
							$("#matKhau").val(result.PassGV);
						}
						
					}
					
				})
			}
		}
	})
  
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
		                <a class="navbar-brand"><i class="fa fa-user-circle"></i></a>
		            </div>
		            <div class="nav navbar-nav navbar-left">
		                <a id="page-trich-dan" href="Admin_chinhsuathongtinchitietGV">CHỈNH SỬA CHI TIẾT THÔNG TIN GIÁO VIÊN</a>
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
        <h5>THÔNG TIN CHỈNH SỬA</h5>
        <!-- Thông tin Giáo viên -->
        <fieldset>
            <p style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin Giáo viên: </p>
            <div class="col-xs-12 col-sm-12 col-md-12">
                <form class="form-horizontal">
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Mã Giáo viên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" id="maGiaoVien" class="form-control" readonly>
                            <span id="error-maGiaoVien" style="color:red; font-size:8px"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Họ tên:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" id="hoTen" class="form-control">
                            <span id="error-hoTen" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">CMND:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" id="CMND" class="form-control">
                            <span id="error-CMND" style="color:red; font-size:8px"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Ngày sinh:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="date" id="ngaySinh" class="form-control" 
                            <%
                       			Date date = new Date();                        			  
                       			String strDateFormat = "yyyy-MM-dd";                        			  
                       			SimpleDateFormat simpleDateFormat1 = new SimpleDateFormat(strDateFormat);
                        	%>
                        		value= <%=simpleDateFormat1.format(date)%>
                               >
                            <span id="error-ngaySinh" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Địa chỉ:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" id="diaChi" class="form-control">
                            <span id="error-diaChi" style="color:red; font-size:8px"></span>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">SĐT:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="text" id="SDT" class="form-control">
                            <span id="error-SDT" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Giới tính:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <select id="cbGioiTinh" class="form-control">
                                <option value='0'>Nam</option>
                                <option value='1'>Nữ</option>
                            </select>
                        </div>
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Trình độ học vấn:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <select id="cbTrinhDoHocVan" class="form-control">
                            </select>
                        </div>
                    </div>
                    <div class="form-group">
                        <label class="control-label col-xs-12 col-sm-4 col-md-2">Email:</label>
                        <div class="col-xs-12 col-sm-8 col-md-4">
                            <input type="email" id="email" class="form-control">
                            <span id="error-email" style="color:red; font-size:8px"></span>
                        </div>
                    </div>
                </form>
            </div>
        </fieldset>
        <br />
        <fieldset>
            <label style="font-weight: bold; text-decoration: underline; color: #197485;">Thông tin tài khoản:</label>
            <form class="form-horizontal">
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Tên tài khoản:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="text" class="form-control" id="tenTaiKhoan" readonly>
                    </div>
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Mật khẩu:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="text" id="matKhau" class="form-control" id="matKhau">
                        <span id="error-matKhau" style="color:red; font-size:8px"></span>
                    </div>
                </div>
                <div class="form-group">
                    <label class="control-label col-xs-12 col-sm-4 col-md-2">Quyền truy cập:</label>
                    <div class="col-xs-12 col-sm-8 col-md-4">
                        <input type="text" class="form-control" value="Giáo viên" readonly>
                    </div>
                </div>
            </form>
            <div class="input-group-btn">
	           <button id="btn-cap-nhat-thong-tin-giao-vien" class="btn btn-default" style="width:120px;">
	               Cập nhật <i class="glyphicon glyphicon-edit"></i>
	           </button>
	        </div>
        </fieldset>
    </section>
    
    
</body>
</html>