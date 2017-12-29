$(document).ready(function () {

    /////VALIDATE NHẬP THÔNG TIN CÁ NHÂN CỦA HỌC VIÊN
    //Ẩn thông báo lỗi và khai báo cờ
    $("#error-hotenHV").hide();
    $("#error-diachi").hide();
    $("#error-SDT").hide();
    $("#error-CMND").hide();
    $("#error-email").hide();
    var error_hotenHV = true, error_diachi = true, error_SDT = true, error_CMND = true, error_email=true;

    $("#hoTenHV").focusout(function () {
        if ($("#hoTenHV").val().trim().length <= 0)
        {
            $("#error-hotenHV").html(" Mời bạn nhập tên học viên");
            $("#error-hotenHV").show();
            error_hotenHV = true;
        }
        else
        {
            $("#error-hotenHV").hide();
            error_hotenHV = false;
        }
    });
    $("#diachi").focusout(function () {
        if ($("#diachi").val().trim().length <= 0)
        {
            $("#error-diachi").html(" Mời bạn nhập địa chỉ học viên");
            $("#error-diachi").show();
            error_diachi = true;
        }
        else
        {
            $("#error-diachi").hide();
            error_diachi = false;
        }
    });
    $("#SDT").focusout(function () {
        if ($("#SDT").val().trim().length <= 0)
        {
            $("#error-SDT").html(" Mời bạn nhập số điện thoại học viên");
            $("#error-SDT").show();
            error_SDT = true;
        }
        else
        {
            $("#error-SDT").hide();
            error_SDT = false;
        }
    });
    $("#CMND").focusout(function () {
        if ($("#CMND").val().trim().length <= 0)
        {
            $("#error-CMND").html(" Mời bạn nhập số CMND học viên");
            $("#error-CMND").show();
            error_CMND = true;
        }
        else
        {
            $("#error-CMND").hide();
            error_CMND = false;
        }
    });
    $("#email").focusout(function () {
        if ($("#email").val().trim().length <= 0)
        {
            $("#error-email").html(" Mời bạn nhập email liên lạc với học viên");
            $("#error-email").show();
            error_email = true;
        }
        else
        {
            $("#error-email").hide();
            error_email = false;
        }
    });
    
    //Load dsLopHocHienTai lên combobox
    $.ajax({
    	type:"PUT",
    	url:"NV_dangkykhoahoc",
    	dataType:"json",
    	success:function(result){
    		if(result.check == "fail"){
    			alert("Không phải thời gian đăng ký lớp học.\rCảm ơn!!!");
    			window.location.assign("nhanvien");
    		}
    		else{
    			$("#cbLopHoc option").remove();
    			var n = Object.keys(result).length;
    			for(i=0; i<n; i++){
    				$("#cbLopHoc").append(
        					$('<option>').val(result[i].MaLop).text(result[i].TenLop)
        			)
    			}
    		}
    	}
    })
    
    //Load thông tin cá nhân và thông tin đăng ký lớp học online nếu được chuyển đến từ trang tra cứu đky online
    var flag = 1; //Lấy thông tin cá nhân học viên đăng ký online
    $.ajax({
    	type:"POST",
    	url:"HVDKyOnlNhanLop",
    	data:{
    		flag:flag
    	},
    	dataType:"json",
    	success:function(result){
    		if(result.check == null){
    			error_hotenHV = false;
    			error_diachi = false;
    			error_SDT = false; 
				error_email = false;
				
            	$("#hoTenHV").val(result.hoTen);
            	$("#ngaysinh").val(result.ngaySinh);
            	$("#diachi").val(result.diaChi);
            	$("#SDT").val(result.SDT);
            	$("#email").val(result.email);
    		}
    	}
    });
    
    flag = 2; //Lấy thông tin đăng ký lớp học online của học viên đăng ký online
    $.ajax({
    	type:"POST",
    	url:"HVDKyOnlNhanLop",
    	data:{
    		flag:flag
    	},
    	dataType:"json",
    	success:function(result){
    		if(result.check == null){
    			var n = Object.keys(result).length;
    			
    			for(i=0; i<n; i++){
    				$("#cbLopHoc option[value='" + result[i].MaLop + "']").remove();
    				
    				if(result[i].tinhTrang == 0){
    					$("#table-dky-khoahoc > tbody").append(
        	    				$("<tr>").append(
        	    						$("<td>").text(result[i].MaLop)
        	    						).append(
        	    						$("<td>").text(result[i].TenLop)		
        	    						).append(
        								$("<td>").text(result[i].SoBuoi)		
        	    						).append(
        								$("<td>").text(result[i].NgayBatDau)		
        	    						).append(
        								$("<td>").text(result[i].NgayKetThuc)		
        	    						).append(
        								$("<td>").text(result[i].SoPhong)		
        	    						).append(
        								$("<td>").text(result[i].BuoiHoc)		
        	    						).append(
        								$("<td>").text(result[i].GioHoc)		
        	    						).append(
        								$("<td>").text(result[i].HocPhi)		
        	    						).append(
        								$("<td>").append(
        									$("<a style='color: red; text-decoration:none '>")
        										.text("Hủy")
        										.css('cursor','pointer')
        										.click(function(e){
        											e.preventDefault();
        											
        											if(confirm("Bạn có chắc chắn muốn hủy không?")){
        												var MaLop = $(this).closest('tr').find('td:nth-child(1)').text();
        												var TenLop = $(this).closest('tr').find('td:nth-child(2)').text();
        												
        												$('#cbLopHoc').append("<option value='" + MaLop + "'>" + TenLop + "</option>");
        												
        												//flag=4: Xóa 1 lớp học mà đã đăng ký (online) nhưng muốn hủy đi
        												flag = 4;
        												$.ajax({
        													type:"DELETE",
        													url:"NV_dangkykhoahoc?MaLop=" + MaLop + "&flag=" + flag,
        												});
        												
        												$(this).closest('tr').remove();
        												//Tổng học phí phải thanh toán
        												var hocPhi = $(this).closest('tr').find('td:nth-child(9)').text();
        							            		$("#hocPhiPhaiThanhToan").text(parseFloat($("#hocPhiPhaiThanhToan").text()) - parseFloat(hocPhi));
        											}
        										})
        									)		
        	    						)
        	        		)
        	        		//Tổng học phí phải thanh toán
        	        		$("#hocPhiPhaiThanhToan").text(parseFloat($("#hocPhiPhaiThanhToan").text()) + parseFloat(result[i].HocPhi));
    				}
    			}
    		}
    	}
    });
    
    //flag = 1: lấy mã học viên tiếp theo
    flag = 1;
    $.ajax({
    	type: "POST",
    	url: "NV_dangkykhoahoc",
    	data:{
    		flag: flag
    	},
    	dataType: "json",
    	success: function(result){
    		if(result.maHVMoi != null){
    			$("#maHocVien").val(result.maHVMoi);
    		}
    		else{
    			alert("Không lấy được mã học viên mới!");
    			return;
    		}
    	}
    })
    
    //flag=1: Xóa danh sách lớp học đăng ký trước đó (nếu có), 
    flag = 1;
    $.ajax({
    	type: "DELETE",
    	url: "NV_dangkykhoahoc?flag=" + flag,
    });
    
    
    var flagNhapThongTin = true;
    //Hàm kiểm tra nhập thông tin cá nhân học viên
    function KiemTraNhapThongTinCaNhan(){
    	if (error_hotenHV == true || error_diachi == true || error_SDT == true 
				|| error_CMND == true || error_email == true)
		{
    		flagNhapThongTin = true;
			if ($("#hoTenHV").val().trim().length <= 0)
			{
			   $("#error-hotenHV").html(" Mời bạn nhập tên học viên");
			   $("#error-hotenHV").show();
			   error_hotenHV = true;
			}
			if ($("#diachi").val().trim().length <= 0)
			{
			   $("#error-diachi").html(" Mời bạn nhập địa chỉ học viên");
			   $("#error-diachi").show();
			   error_diachi = true;
			}
			if ($("#SDT").val().trim().length <= 0)
			{
			   $("#error-SDT").html(" Mời bạn nhập số điện thoại học viên");
			   $("#error-SDT").show();
			   error_SDT = true;
			}
			if ($("#CMND").val().trim().length <= 0)
			{
			   $("#error-CMND").html(" Mời bạn nhập số CMND học viên");
			   $("#error-CMND").show();
			   error_CMND = true;
			}
			if ($("#email").val().trim().length <= 0)
			{
			   $("#error-email").html(" Mời bạn nhập email liên lạc với học viên");
			   $("#error-email").show();
			   error_email = true;
			}
			alert("MỜI BẠN NHẬP ĐẦY ĐỦ THÔNG TIN CÁ NHÂN CỦA HỌC VIÊN");
		}
    	else
    		flagNhapThongTin = false;
    }
    
    //Tìm kiếm thông tin học viên nếu là học viên cũ
    $("#btn-tra-cuu-hoc-vien").click(function(e){
    	e.preventDefault();
    	Reset();
    	var maTimKiem = $("#maTimKiem").val().trim();
    	if(maTimKiem.length <= 0)
    		alert("Mời bạn nhập thông tin tìm kiếm!");
    	else{
    		$.ajax({
    			type:"GET",
    			url:"NV_tracuuhocvien",
    			data:{
    				maTimKiem:maTimKiem
    			},
    			dataType:"json",
    			success:function(result){
    				if(result.check == "fail"){
    					alert("Học viên không tồn tại!");
    					return;
    				}
    				else{
    					$("#maHocVien").val(result.MaHV);
    	            	$("#hoTenHV").val(result.HoTenHV);
    	            	$("#ngaysinh").val(result.NgaySinh);

    	            	if(result.GioiTinh)
    	            		$("#GioiTinh").val(1);
    	            	if(!result.gioiTinh)
    	            		$("#GioiTinh").val(0);
    	            	
    	            	$("#diachi").val(result.DiaChi);
    	            	$("#SDT").val(result.SDT);
    	            	$("#CMND").val(result.CMND);
    	            	$("#email").val(result.EmailHV);
    	            	
    	            	error_hotenHV = false, error_diachi = false, error_SDT = false, error_CMND = false, error_email=false;
    				}
    			}
    		})
    	}
    })
    
    $("#btn-reset").click(function(e){
    	Reset();
    	//flag = 1: Cập nhật lại mã học viên
        flag = 1;
        $.ajax({
        	type: "POST",
        	url: "NV_dangkykhoahoc",
        	data:{
        		flag: flag
        	},
        	dataType: "json",
        	success: function(result){
        		if(result.maHVMoi != null){
        			$("#maHocVien").val(result.maHVMoi);
        		}
        		else{
        			alert("Không lấy được mã học viên mới!");
        			return;
        		}
        	}
        })
    })

    
    //Reset: 
    //flag=3: Xóa danh sách lớp học đăng ký trước đó (nếu có), 
	//Xóa thông tin học viên đăng ký online trước đó (nếu có),
	//Xóa danh sách đăng ký online lớp học trước đó (nếu có)
    function Reset(){
    	flag = 3;
	    $.ajax({
	    	type: "DELETE",
	    	url: "NV_dangkykhoahoc?flag=" + flag,
	    });
    	$("#hoTenHV").val("");
    	$("#diachi").val("");
    	$("#SDT").val("");
    	$("#CMND").val("");
    	$("#email").val("");
    	$("#hocPhiPhaiThanhToan").text("0");
    	$("#table-dky-khoahoc > tbody").children().remove();
    }
    

    //Lấy thông tin đăng ký lớp học lên bảng
    $("#btn-chon-lop-hoc").click(function (e) {
        e.preventDefault();
        
        KiemTraNhapThongTinCaNhan();
        
        if(!flagNhapThongTin){                                            
            var MaLop = $("#cbLopHoc option:selected").val();
            $("#cbLopHoc option:selected").remove();
            
            flag = 2;
            //flag = 2: Lấy thông tin lớp học vừa chọn
    		//Đồng thời lưu thông tin lại để sử dụng cho việc thanh toán học phí
            $.ajax({
            	type:"POST",
            	url:"NV_dangkykhoahoc",
            	data:{
            		flag:flag,
            		MaLop:MaLop
            	},
            	dataType:"json",
            	success:function(result){
            		$("#table-dky-khoahoc > tbody").append(
        				$("<tr>").append(
        						$("<td>").text(result.MaLop)
        						).append(
        						$("<td>").text(result.TenLop)		
        						).append(
								$("<td>").text(result.SoBuoi)		
        						).append(
								$("<td>").text(result.NgayBatDau)		
        						).append(
								$("<td>").text(result.NgayKetThuc)		
        						).append(
								$("<td>").text(result.SoPhong)		
        						).append(
								$("<td>").text(result.BuoiHoc)		
        						).append(
								$("<td>").text(result.GioHoc)		
        						).append(
								$("<td>").text(result.HocPhi)		
        						).append(
								$("<td>").append(
									$("<a style='color: red; text-decoration:none '>")
										.text("Hủy")
										.css('cursor','pointer')
										.click(function(e){
											e.preventDefault();
											
											if(confirm("Bạn có chắc chắn muốn hủy không?")){
												var MaLop = $(this).closest('tr').find('td:nth-child(1)').text();
												var TenLop = $(this).closest('tr').find('td:nth-child(2)').text();
												
												$('#cbLopHoc').append("<option value='" + MaLop + "'>" + TenLop + "</option>");
												
												//flag=2: Xóa 1 lớp học mà đã đăng ký nhưng muốn hủy đi
												flag = 2;
												$.ajax({
													type:"DELETE",
													url:"NV_dangkykhoahoc?MaLop=" + MaLop + "&flag=" + flag,
												});
												
												$(this).closest('tr').remove();
												//Tổng học phí phải thanh toán
												var hocPhi = $(this).closest('tr').find('td:nth-child(9)').text();
							            		$("#hocPhiPhaiThanhToan").text(parseFloat($("#hocPhiPhaiThanhToan").text()) - parseFloat(hocPhi));
											}
										})
									)		
        						)
            		)
            		//Tổng học phí phải thanh toán
            		$("#hocPhiPhaiThanhToan").text(parseFloat($("#hocPhiPhaiThanhToan").text()) + parseFloat(result.HocPhi));
            	}
            })
        }
    });

    $('#btn-thanhtoanHP').click(function (e) {
    	e.preventDefault();
    	
        var n = $("#table-dky-khoahoc > tbody").find("> tr:first").length;         
        
        KiemTraNhapThongTinCaNhan();
        
        if(!flagNhapThongTin){                                            
        	if (n == 0) {
                alert("MỜI BẠN ĐĂNG KÝ LỚP HỌC CHO HỌC VIÊN");
            }
            else{
            	var maHV = $("#maHocVien").val().trim();
            	var hoTenHV = $("#hoTenHV").val().trim();
            	var ngaySinh = $("#ngaysinh").val().trim();
            	var gioiTinh = $("#GioiTinh").val();
            	var diachi = $("#diachi").val().trim();
            	var SDT = $("#SDT").val().trim();
            	var CMND = $("#CMND").val().trim();
            	var email = $("#email").val().trim();
            	var hocPhiPhaiThanhToan = $("#hocPhiPhaiThanhToan").text();
            	
            	//flag = 1: lưu thông tin cá nhân, học phí cần đóng của học viên mới
            	//Nếu là hv đăng ký online thì lưu ds Lớp học đăng ký ol
            	flag=1;
            	$.ajax({
            		type:"POST",
            		url:"NV_thuhocphi",
            		data:{
            			flag:flag,
            			maHV:maHV,
            			hoTenHV:hoTenHV,
            			ngaySinh:ngaySinh,
            			gioiTinh:gioiTinh,
            			diachi:diachi,
            			SDT:SDT,
            			CMND:CMND,
            			email:email,
            			hocPhiPhaiThanhToan:hocPhiPhaiThanhToan
            		},
            		dataType:"json",
            		success:function(result){
            			if(result.check == "ok")
            				window.location.assign("NV_thuhocphi");
            		}
            	})
            }
        }
    });
});