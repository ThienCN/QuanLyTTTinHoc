$(document).ready(function(){
	$("#danh-sach-trong").css("display","none");
	$("#ket-qua-thong-ke").css("display","none");
	
	//flag=1: Load toàn bộ danh sách giáo viên
	var flag=1;
	$.ajax({
		type:"POST",
		url:"Admin_chinhsuathongtingiaovien",
		data:{
			flag:flag
		},
		dataType:'json',
		success:function(result){
			if(result.check == "fail"){
				$("#danh-sach-trong").text("Danh sách trống!");
				$("#danh-sach-trong").css("display","block");
				return;
			}
			else if(result.check != null){
				$("#danh-sach-trong").text(result.check);
				$("#danh-sach-trong").css("display","block");
				return;
			}
			else{
				var n = Object.keys(result).length;
				$("#soLuong").text(n);
				$("#table-ds-giao-vien > tbody").children().remove();
				
				var gioiTinh;
				for(i=0; i<n; i++){
					if(result[i].GioiTinh)
						gioiTinh = "Nữ";
					else
						gioiTinh = "Nam";
					
					$("#table-ds-giao-vien > tbody").append(
						$('<tr>').append(
							$('<td>').text(i+1)	
							).append(
							$('<td>').text(result[i].MaGV)	
							).append(
							$('<td>').text(result[i].HoTenGV)	
							).append(
							$('<td>').text(result[i].NgaySinh)	
							).append(
							$('<td>').text(result[i].CMND)	
							).append(
							$('<td>').text(result[i].DiaChi)	
							).append(
							$('<td>').text(gioiTinh)	
							).append(
							$('<td>').text(result[i].DienThoai)	
							).append(
							$('<td>').text(result[i].TenTrinhDoHV)	
							).append(
							$('<td>').text(result[i].EmailGV)	
							).append(
							$('<td>').append(
									$('<a style="text-decoration: none">').text("Chỉnh sửa")	
											.css("cursor","pointer")
											.click(function(e){
												e.preventDefault();
												
												var maGV = $(this).closest('tr').find('td:nth-child(2)').text();
												
												//flag=3: Lấy mã GV đi lấy thông tin của GV đó
												//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
												flag=3;
												$.ajax({
													type:"POST",
													url:"Admin_chinhsuathongtingiaovien",
													data:{
														flag:flag,
														maGV:maGV
													},
													dataType:"json",
													success:function(result){
														if(result.check == "fail"){
															alert("Server đang bận!");
															return;
														}
														else if(result.check == "ok"){
															window.location.assign("Admin_chinhsuachitietthongtinGV");
														}
													}
												})
												
												
												
											})
									)	
							)
					)
				}
				
				$("#ket-qua-thong-ke").css("display","block");
			}
		}
	})
	
	
	
	
	
	//Tìm kiếm thông tin giáo viên
	$("#btn-tim-kiem-giao-vien").click(function(){
		var thongTinTimKiem = $("#thongTinTimKiem").val().trim();
		
		if(thongTinTimKiem.length <= 0){
			alert("Mời bận nhập thông tin tìm kiếm!");
			window.location.assign("Admin_chinhsuathongtingiaovien");
			return;
		}
		else{
			//flag=2: Tìm kiếm thông tin giáo viên
			flag=2;
			$.ajax({
				type:"POST",
				url:"Admin_chinhsuathongtingiaovien",
				data:{
					flag:flag,
					thongTinTimKiem:thongTinTimKiem
				},
				dataType:"json",
				success:function(result){
					if(result.check == "fail"){
						$("#danh-sach-trong").text("Danh sách trống!");
						$("#danh-sach-trong").css("display","block");
						return;
					}
					else if(result.check != null){
						$("#danh-sach-trong").text(result.check);
						$("#danh-sach-trong").css("display","block");
						return;
					}
					else{
						var n = Object.keys(result).length;
						$("#soLuong").text(n);
						$("#table-ds-giao-vien > tbody").children().remove();
						console.log("ok");
						var gioiTinh;
						for(i=0; i<n; i++){
							if(result[i].GioiTinh)
								gioiTinh = "Nữ";
							else
								gioiTinh = "Nam";
							
							$("#table-ds-giao-vien > tbody").append(
								$('<tr>').append(
									$('<td>').text(i+1)	
									).append(
									$('<td>').text(result[i].MaGV)	
									).append(
									$('<td>').text(result[i].HoTenGV)	
									).append(
									$('<td>').text(result[i].NgaySinh)	
									).append(
									$('<td>').text(result[i].CMND)	
									).append(
									$('<td>').text(result[i].DiaChi)	
									).append(
									$('<td>').text(gioiTinh)	
									).append(
									$('<td>').text(result[i].DienThoai)	
									).append(
									$('<td>').text(result[i].TenTrinhDoHV)	
									).append(
									$('<td>').text(result[i].EmailGV)	
									).append(
									$('<td>').append(
											$('<a style="text-decoration: none">').text("Chỉnh sửa")	
													.css("cursor","pointer")
													.click(function(e){
														e.preventDefault();
														
														var maGV = $(this).closest('tr').find('td:nth-child(2)').text();
														
														//flag=3: Lấy mã GV đi lấy thông tin của GV đó
														//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
														flag=3;
														$.ajax({
															type:"POST",
															url:"Admin_chinhsuathongtingiaovien",
															data:{
																flag:flag,
																maGV:maGV
															},
															dataType:"json",
															success:function(result){
																if(result.check == "fail"){
																	alert("Server đang bận!");
																	return;
																}
																else if(result.check == "ok"){
																	window.location.assign("Admin_chinhsuachitietthongtinGV");
																}
															}
														})
														
														
														
													})
											)	
									)
							)
						}
						
						$("#ket-qua-thong-ke").css("display","block");
					}
				}
			})
		}
	})
	
	
	var error_hoTen = false;
    var error_CMND = false;
    var error_diaChi = false;
    var error_SDT = false;
    var error_email = false;
    
    var error_matKhau = false;

    $("#hoTen").focusout(function () {
        var hoTen = $("#hoTen").val().trim();
        if (hoTen.length <= 0) {
            $("#error-hoTen").html(" Mời bạn nhập họ tên giáo viên");
            $("#error-hoTen").show();
            error_hoTen = true;
        }
        else {
            $("#error-hoTen").hide();
            error_hoTen = false;
        }
    });

    $("#CMND").focusout(function () {
        var CMND = $("#CMND").val().trim();
        if (CMND.length <= 0) {
            $("#error-CMND").html(" Mời bạn nhập số CMND giáo viên");
            $("#error-CMND").show();
            error_CMND = true;
        }
        else {
            $("#error-CMND").hide();
            error_CMND = false;
            $("#matKhau").val($("#CMND").val().trim());
        }
    });

    $("#diaChi").focusout(function () {
        var diaChi = $("#diaChi").val().trim();
        if (diaChi.length <= 0) {
            $("#error-diaChi").html(" Mời bạn nhập địa chỉ của giáo viên");
            $("#error-diaChi").show();
            error_diaChi = true;
        }
        else {
            $("#error-diaChi").hide();
            error_diaChi = false;
        }
    });

    $("#SDT").focusout(function () {
        var SDT = $("#SDT").val().trim();
        if (SDT.length <= 0) {
            $("#error-SDT").html(" Mời bạn nhập số điện thoại của giáo viên");
            $("#error-SDT").show();
            error_SDT = true;
        }
        else {
            $("#error-SDT").hide();
            error_SDT = false;
        }
    });
    
    $("#email").focusout(function () {
        var email = $("#email").val().trim();
        if (email.length <= 0) {
            $("#error-email").html(" Mời bạn nhập email của giáo viên");
            $("#error-email").show();
            error_email = true;
        }
        else {
            $("#error-email").hide();
            error_email = false;
        }
    });

    $("#matKhau").focusout(function () {
        if ($("#matKhau").val().trim().length <= 0) {
            $("#error-matKhau").html(" Mời bạn nhập mật khẩu cho tài khoản của giáo viên");
            $("#error-matKhau").show();
            error_matKhau = true;
        }
        else {
            $("#error-matKhau").hide();
            error_matKhau = false;
        }
    });

    $("#btn-cap-nhat-thong-tin-giao-vien").click(function(e){
    	if (error_hoTen == true || error_diaChi == true || error_CMND == true
                && error_email == true || error_SDT == true || error_matKhau == true) {
            	if ($("#hoTen").val().trim().length <= 0) {
                    $("#error-hoTen").html(" Mời bạn nhập họ tên giáo viên");
                    $("#error-hoTen").show();
                    error_hoTen = true;
                }
                if ($("#CMND").val().trim().length <= 0) {
                    $("#error-CMND").html(" Mời bạn nhập số CMND giáo viên");
                    $("#error-CMND").show();
                    error_CMND = true;
                }
                if ($("#diaChi").val().trim().length <= 0) {
                    $("#error-diaChi").html(" Mời bạn nhập địa chỉ của giáo viên");
                    $("#error-diaChi").show();
                    error_diaChi = true;
                }
                if ($("#SDT").val().trim().length <= 0) {
                    $("#error-SDT").html(" Mời bạn nhập số điện thoại của giáo viên");
                    $("#error-SDT").show();
                    error_SDT = true;
                }
                if ($("#email").val().trim().length <= 0) {
                    $("#error-email").html(" Mời bạn nhập email của giáo viên");
                    $("#error-email").show();
                    error_email = true;
                }
                if ($("#matKhau").val().trim().length <= 0) {
                    $("#error-matKhau").html(" Mời bạn nhập mật khẩu cho tài khoản của giáo viên");
                    $("#error-matKhau").show();
                    error_matKhau = true;
                }
                
                alert("Mời bạn nhập đầy đủ thông tin!");
                return;
            }
            else{
            	var maGiaoVien = $("#maGiaoVien").val().trim();
            	var hoTen = $("#hoTen").val().trim();
            	var CMND = $("#CMND").val().trim();
            	var ngaySinh = $("#ngaySinh").val();
            	var diaChi = $("#diaChi").val().trim();
            	var SDT = $("#SDT").val().trim();
            	var gioiTinh = $("#cbGioiTinh").val();
            	var trinhDoHV = $("#cbTrinhDoHocVan").val();
            	var email = $("#email").val().trim();
            	var matKhau = $("#matKhau").val().trim();
            	
            	//flag=2: Cập nhật thông tin Giáo viên
            	flag=2;
            	$.ajax({
            		type:"POST",
            		url:"Admin_chinhsuachitietthongtinGV",
            		data:{
            			flag:flag,
            			maGiaoVien:maGiaoVien,
            			hoTen:hoTen,
            			CMND:CMND,
            			ngaySinh:ngaySinh,
            			diaChi:diaChi,
            			SDT:SDT,
            			gioiTinh:gioiTinh,
            			trinhDoHV:trinhDoHV,
            			email:email,
            			matKhau:matKhau
            		},
            		dataType:"json",
            		success:function(result){
            			if(result.check == "ok"){
            				alert("Cập nhật thông tin giáo viên mới thành công!");
            				window.location.assign("Admin_chinhsuathongtingiaovien");
            				return;
            			}
            			if(result.check == "fail"){
            				alert("Server bận!");
            				window.location.assign("Admin_chinhsuathongtingiaovien");
            				return;
            			}
            		}
            	})
            }
    })
    
})