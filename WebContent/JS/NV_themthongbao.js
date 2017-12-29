$(document).ready(function (e) {
	
	//Load mã thông báo mới 
	$.ajax({
		type:"PUT",
		url:"NV_themthongbao",
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				alert("Server đang bận!");
				return;
			}
			$("#maThongBao").val(result.maTBMoi);
		}
	})
	
    var error_tieuDeThongBao = true;
    var error_tomTatThongBao = true;
    var error_hinhAnh = true;
    var error_tepDinhKem = true;


    $("#tieuDeThongBao").focusout(function (e) {
        if ($("#tieuDeThongBao").val().trim().length <= 0) {
            $("#error-tieuDeThongBao").html(" Mời bạn nhập tiêu đề thông báo");
            $("#error-tieuDeThongBao").show();
            error_tieuDeThongBao = true;
        }
        else {
            $("#error-tieuDeThongBao").hide();
            error_tieuDeThongBao = false;
        }
        
    });
    $('#tomTatThongBao').focusout(function (e) {
        if ($('#tomTatThongBao').val().trim().length <= 0) {
            $("#error-tomTatThongBao").html(" Mời bạn cung cấp nội dung tóm tắt thông báo");
            $("#error-tomTatThongBao").show();
            error_tomTatThongBao = true;
        }
        else {
            $("#error-tomTatThongBao").hide();
            error_tomTatThongBao = false;
        }

    });
    $("#hinhAnh").focusout(function (e) {
        if ($("#hinhAnh").val().trim().length <= 0) {
            error_hinhAnh = true;
        }
        else {
            $("#error-hinhAnh").hide();
            error_hinhAnh = false;
        }

    });
    $("#tepDinhKem").focusout(function (e) {
        if ($("#tepDinhKem").val().trim().length <= 0) {
            error_tepDinhKem = true;
        }
        else {
            $("#error-tepDinhKem").hide();
            error_tepDinhKem = false;
        }

    });


    $("#luu-thong-bao").click(function (e) {
        if (error_tieuDeThongBao == true || error_tomTatThongBao == true 
            || error_hinhAnh == true || error_tepDinhKem == true)
        {
            if ($("#tieuDeThongBao").val().trim().length <= 0) {
	            $("#error-tieuDeThongBao").html(" Mời bạn nhập tiêu đề thông báo");
	            $("#error-tieuDeThongBao").show();
	            error_tieuDeThongBao = true;
	        }
            if ($('#tomTatThongBao').val().trim().length <= 0) {
                $("#error-tomTatThongBao").html(" Mời bạn cung cấp nội dung tóm tắt thông báo");
                $("#error-tomTatThongBao").show();
                error_tomTatThongBao = true;
            }
            if ($("#hinhAnh").val().trim().length <= 0) {
                $("#error-hinhAnh").html(" Mời bạn chọn hình ảnh thông báo");
                $("#error-hinhAnh").show();
                error_hinhAnh = true;
            }
            if ($("#tepDinhKem").val().trim().length <= 0) {
                $("#error-tepDinhKem").html(" Mời bạn chọn tệp đính kèm cho thông báo");
                $("#error-tepDinhKem").show();
                error_tepDinhKem = true;
            }
            alert("Mời bạn nhập đầy đủ thông tin cho Thông báo này!")
        }
        else {
        	var fileExtensionImage = ['jpeg', 'jpg', 'png','gif'];
        	
        	var hinhAnh = $('#hinhAnh').get()[0].files[0];
			var hinhAnhUpload = $('#hinhAnh').val();
			if(!hinhAnh){
				alert("Vui lòng chọn file");
				return;
			}
			if ($.inArray($('#hinhAnh').val().split('.').pop().toLowerCase(), fileExtensionImage) == -1) {
	            alert("Only formats are allowed : "+fileExtensionImage.join(', '));
	            return;
	        }
			
			var fileExtensionFile = ['pdf']; 
			
			var tepDinhKem = $('#tepDinhKem').get()[0].files[0];
			var tepDinhKemUpload = $('#tepDinhKem').val();
			if(!tepDinhKem){
				alert("Vui lòng chọn file");
				return;
			}
			if ($.inArray($('#tepDinhKem').val().split('.').pop().toLowerCase(), fileExtensionFile) == -1) {
	            alert("Only formats are allowed : "+fileExtensionFile.join(', '));
	            return;
	        }
			
			var tieuDeThongBao = $("#tieuDeThongBao").val().trim();
			var tomTatThongBao = $('#tomTatThongBao').val().trim();
			var ngayThongBao = $("#ngayThongBao").val();
			var tepDinhKem = $("#tepDinhKem").val();
            var hinhAnh = $("#hinhAnh").val();

            if (tepDinhKem.substring(3, 11) == 'fakepath') {
                tepDinhKem = tepDinhKem.substring(12);
            }

            var hinhAnh = $("#hinhAnh").val();
            if (hinhAnh.substring(3, 11) == 'fakepath') {
                hinhAnh = hinhAnh.substring(12);
            }
            
            //Lưu thông báo mới vào csdl và trả về mã TB
            //thông báo mới khi lưu vào csdl luôn có stt = 1
            
            $.ajax({
            	type:"POST",
            	url:"NV_themthongbao",
            	data:{
            		tieuDeThongBao:tieuDeThongBao,
            		tomTatThongBao:tomTatThongBao,
            		ngayThongBao:ngayThongBao,
            		hinhAnh:hinhAnh,
            		tepDinhKem:tepDinhKem
            	},
            	dataType:"json",
            	success:function(result){
            		
            		if(result.hinhAnh == "fail"){
            			alert('Yêu cầu đổi tên file Ảnh!!');
            			return;
            		}
            		if(result.file == "fail"){
            			alert('Yêu cầu đổi tên file Thông báo!!');
            			return;
            		}
            		if(result.check == "fail"){
            			alert('Thêm thông báo mới không thành công!');
            			return;
            		}
            		if(result.maTBMoi != null){
            			var maTBMoi = result.maTBMoi;
            			//Thêm ảnh vào folder PIC
            			$.ajax({
            				type: 'POST',
            				url: 'NV_themhinhanh',
            				data: new FormData($('#hinhAnhTBMoi')[0]),
            				processData: false,
							contentType: false,
							dataType:"json",
							success:function(result){
								if(result.check == "fail"){
									$.ajax({
										type:"DELETE",
										url:"NV_themthongbao",
										data:{
											maTBMoi:maTBMoi
										}
									})
									alert('Thêm thông báo mới không thành công!');
									return;
								}
								else{
									$.ajax({
			            				type: 'POST',
			            				url: 'NV_themfile',
			            				data: new FormData($('#tepDinhKemTBMoi')[0]),
			            				processData: false,
										contentType: false,
										dataType:"json",
										success:function(result){
											if(result.check == "fail"){
												$.ajax({
													type:"DELETE",
													url:"NV_themthongbao",
													data:{
														maTBMoi:maTBMoi
													}
												})
												alert('Thêm thông báo mới không thành công!');
												return;
											}
											alert("Mã thông báo mới của bạn là: " + maTBMoi);
											window.location.assign("NV_quanlythongbao");
											return;
										}
			            			})
								}
							}
            			})
            		}
            	}
            });
        }
    });
});