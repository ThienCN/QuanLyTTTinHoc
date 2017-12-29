$(document).ready(function () {
	var flag = 1; //Nhân viên
	function thongTinNguoiDung(){ //Hàm load danh sách nhân viên
		$.ajax({
	        type: "POST",
	        url: "Admin_thongkeDSND",
	        data:{
	        	flag: flag
	        },
	        dataType: "json",
	        success: function (result) { 
	        	
	        	if(result.check != null){
					alert(result.check);
					return;
				}
	        	if (result.check == "fail") {
	            	alert("Hiện chưa có người dùng nào");
	            	return;
	     	    }
				else{
					AppendResultInTable(result);
	     	    }
	        },
	        error: function (jqXHR, exception) {
	            if (jqXHR.status == 500)
	                alert("Chưa thêm người dùng nào");
	        }
	    });
	}
	
	thongTinNguoiDung();
	
	$('input[type=radio][name=gender]').change(function() {
		$("#thongTinTimKiem").val("");
        if (this.value == 'NhanVien') {
        	flag = 1; //Nhân viên
        	thongTinNguoiDung();
        }
        else if (this.value == 'Admin') {
        	flag = 2; //Admin
			$.ajax({
		        type: "POST",
		        url: "Admin_thongkeDSND",
		        data:{
		        	flag: flag
		        },
		        dataType: "json",
		        success: function (result) { 
		        	
		        	if(result.check != null){
						alert(result.check);
						return;
					}
		        	if (result.check == "fail") {
		            	alert("Hiện chưa có người dùng nào");
		            	return;
		     	    }
					else{
						AppendResultInTable(result);
		     	    }
		        },
		        error: function (jqXHR, exception) {
		            if (jqXHR.status == 500)
		                alert("Chưa thêm người dùng nào");
		        }
		    });
        }
    });
	
	
	 $("#btn-tim-kiem-nguoi-dung").click(function(e){
		 if($("#thongTinTimKiem").val().trim().length == 0){
			 alert("Mời bạn nhập thông tin tìm kiếm");
		 }
		 else{ 
			 var thongTinTimKiem = $("#thongTinTimKiem").val().trim();
			 var flag = $('input[name=gender]:checked', '#check-role').val();
			 
			 if(flag == "NhanVien")
				 flag = 1; //Nhân viên
			 else
				 flag = 2; //Admin
			 
			 $.ajax({
			        type: "POST",
			        url: "Admin_chinhsuathongtinnguoidung",
			        data:{
			        	flag: flag,
			        	thongTinTimKiem: thongTinTimKiem
			        },
			        dataType: "json",
			        success: function (result) { 
			        	
			        	if(result.check != null){
							alert("Không có người nào giống với kết quả tìm kiếm");
							return;
						}
			        	if (result.check == "fail") {
			            	alert("Hiện chưa có người dùng nào");
			            	return;
			     	    }
						else{
							AppendResultInTable(result);
			     	    }
			        },
			        error: function (jqXHR, exception) {
			            if (jqXHR.status == 500)
			                alert("Chưa thêm người dùng nào");
			        }
			    });
		 }
	 });
	 
	 
	 
	 //Append kết quả Người dùng vào Bảng
	 function AppendResultInTable(result){
			var n = Object.keys(result).length;
			$("#soLuong").text(n);
              if(n>0){
            	  
            	$("#table-ds-nguoi-dung > tbody").children().remove();
            	var valueTD;
              	for(i=0; i<n; i++){
              		if(result[i].GioiTinh == true){
              			result[i].GioiTinh = "Nữ";
              		}
              		else{
              			result[i].GioiTinh = "Nam";
              		}
                	$("#table-ds-nguoi-dung > tbody").append(
                        $('<tr>').append(
                            $('<td style="width:50px;">').text(parseInt(i+1))
                            ).append(
                            $('<td>').text(result[i].MaND)
                            ).append(
                            $('<td>').text(result[i].HoTenND)
                            ).append(
                            $('<td>').text(result[i].NgaySinh)
                            ).append(
                            $('<td>').text(result[i].CMND)
                            ).append(
                            $('<td>').text(result[i].DiaChi)
                            ).append(
                            $('<td>').text(result[i].GioiTinh)
                            ).append(
                            $('<td>').text(result[i].DienThoai)
                            ).append(
                            $('<td>').text(result[i].TenTrinhDoHV)
                            ).append(
                            $('<td>').text(result[i].EmailND)
                            ).append(
                                    $('<td>').append(
	                                  		   $('<a style="text-decoration: none">').text("Chỉnh sửa")
	                                  		   		.css('cursor', 'pointer')
	                             		   			.click(function(e){
	                             		   				
		                             		   			var flag = $('input[name=gender]:checked', '#check-role').val();
		                             					 
		                             					if(flag == "NhanVien"){
		                             						var maNV = $(this).closest('tr').find('td:nth-child(2)').text();
															
															//flag=4: Lấy mã NV đi lấy thông tin của Nhân viên đó
															//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
															flag=4;
															$.ajax({
																type:"POST",
																url:"Admin_chinhsuathongtinnguoidung",
																data:{
																	flag:flag,
																	maNV:maNV
																},
																dataType:"json",
																success:function(result){
																	if(result.check == "fail"){
																		alert("Server đang bận!");
																		return;
																	}
																	else if(result.check == "ok"){
																		window.location.assign("Admin_chinhsuachitietthongtinnguoidung");
																	}
																}
															})
		                             					}
		                             					else{
		                             						var maAdmin = $(this).closest('tr').find('td:nth-child(2)').text();
															
															//flag=3: Lấy mã Admin đi lấy thông tin của Admin đó
															//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
															flag=3;
															$.ajax({
																type:"POST",
																url:"Admin_chinhsuathongtinnguoidung",
																data:{
																	flag:flag,
																	maAdmin:maAdmin
																},
																dataType:"json",
																success:function(result){
																	if(result.check == "fail"){
																		alert("Server đang bận!");
																		return;
																	}
																	else if(result.check == "ok"){
																		window.location.assign("Admin_chinhsuachitietthongtinnguoidung");
																	}
																}
															})
		                             					}
	                             		   			})
	                                   )
	                        )
                    );
              	}
              }
	 }
	 
	 
	 	var error_hoTen = false;
	    var error_CMND = false;
	    var error_diaChi = false;
	    var error_SDT = false;
	    var error_email = false;
	    var error_matKhau = false;

	    $("#hoTen").focusout(function () {
	        if ($("#hoTen").val().trim().length <= 0) {
	            $("#error-hoTen").html(" Mời bạn nhập họ tên người dùng");
	            $("#error-hoTen").show();
	            error_hoTen = true;
	        }
	        else {
	            $("#error-hoTen").hide();
	            error_hoTen = false;
	        }
	    });

	    $("#CMND").focusout(function () {
	        if ($("#CMND").val().trim().length <= 0) {
	            $("#error-CMND").html(" Mời bạn nhập số CMND người dùng");
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
	        if ($("#diaChi").val().trim().length <= 0) {
	            $("#error-diaChi").html(" Mời bạn nhập địa chỉ của người dùng");
	            $("#error-diaChi").show();
	            error_diaChi = true;
	        }
	        else {
	            $("#error-diaChi").hide();
	            error_diaChi = false;
	        }
	    });

	    $("#SDT").focusout(function () {
	        if ($("#SDT").val().trim().length <= 0) {
	            $("#error-SDT").html(" Mời bạn nhập số điện thoại của người dùng");
	            $("#error-SDT").show();
	            error_SDT = true;
	        }
	        else {
	            $("#error-SDT").hide();
	            error_SDT = false;
	        }
	    });

	    $("#email").focusout(function () {
	        if ($("#email").val().trim().length <= 0) {
	            $("#error-email").html(" Mời bạn nhập email của người dùng");
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
	            $("#error-matKhau").html(" Mời bạn nhập mật khẩu của người dùng");
	            $("#error-matKhau").show();
	            error_matKhau = true;
	        }
	        else {
	            $("#error-matKhau").hide();
	            error_matKhau = false;
	        }
	    });
	    
	    
	    $("#btn-cap-nhat-nguoi-dung").click(function(){
	    	if (error_hoTen == true || error_diaChi == true || error_CMND == true
	                && error_email == true || error_SDT == true || error_matKhau == true) {
	    		if ($("#hoTen").val().trim().length <= 0) {
	                $("#error-hoTen").html(" Mời bạn nhập họ tên người dùng");
	                $("#error-hoTen").show();
	                error_hoTen = true;
	            }
	            if ($("#CMND").val().trim().length <= 0) {
	                $("#error-CMND").html(" Mời bạn nhập số CMND người dùng");
	                $("#error-CMND").show();
	                error_CMND = true;
	            }
	            if ($("#diaChi").val().trim().length <= 0) {
	                $("#error-diaChi").html(" Mời bạn nhập địa chỉ của người dùng");
	                $("#error-diaChi").show();
	                error_diaChi = true;
	            }
	            if ($("#SDT").val().trim().length <= 0) {
	                $("#error-SDT").html(" Mời bạn nhập số điện thoại của người dùng");
	                $("#error-SDT").show();
	                error_SDT = true;
	            }
	            if ($("#email").val().trim().length <= 0) {
	                $("#error-email").html(" Mời bạn nhập email của người dùng");
	                $("#error-email").show();
	                error_email = true;
	            }
	            if ($("#matKhau").val().trim().length <= 0) {
		            $("#error-matKhau").html(" Mời bạn nhập mật khẩu của người dùng");
		            $("#error-matKhau").show();
		            error_matKhau = true;
		        }
	            alert("Mời bạn nhập đầy đủ thông tin!");
	            return;
	         }
	    	else{
	    		var maND = $("#maNguoiDung").val().trim();
	    		var hoTen = $("#hoTen").val().trim();
	    		var CMND = $("#CMND").val().trim();
	    		var ngaySinh = $("#ngaySinh").val();
	    		var diaChi = $("#diaChi").val().trim();
	    		var SDT = $("#SDT").val().trim();
	    		var gioiTinh = $("#cbGioiTinh").val();
	    		var trinhDoHV = $("#cbTrinhDoHocVan").val();
	    		var email = $("#email").val().trim();
	    		var matKhau = $("#matKhau").val().trim();
	    		
	    		var chucDanh = $("#cbChucDanh").val();
	    		//3: Nhân viên
	    		//4: Quản trị viên
	    		
	    		//flag=2: Cập nhật người dùng
	    		flag=2;
	    		$.ajax({
	    			type:"POST",
	    			url:"Admin_chinhsuachitietthongtinnguoidung",
	    			data:{
	    				flag:flag,
	    				maND:maND,
	    				hoTen:hoTen,
	    				CMND:CMND,
	    				ngaySinh:ngaySinh,
	    				diaChi:diaChi,
	    				SDT:SDT,
	    				gioiTinh:gioiTinh,
	    				trinhDoHV:trinhDoHV,
	    				email:email,
	    				matKhau:matKhau,
	    				chucDanh:chucDanh
	    			},
	    			dataType:"json",
	    			success:function(result){
	    				if(result.check == "ok"){
	    					alert("Cập nhật thông tin người dùng thành công!");
	    				}
	    				if(result.check == "fail"){
	    					alert("Cập nhật thông tin người dùng không thành công!\rThông tin cập nhật không hợp lệ!");
	    				}
	    				window.location.assign("Admin_chinhsuathongtinnguoidung");
	    				return;
	    			}
	    		})
	    	}
	})
});