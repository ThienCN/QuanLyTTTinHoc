$(document).ready(function (e) {
	
	//Load mã tin tức mới 
	$.ajax({
		type:"PUT",
		url:"NV_themtintuc",
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				alert("Server đang bận!");
				return;
			}
			$("#maTinTuc").val(result.maTTMoi);
		}
	})
	
	var error_tieuDeTinTuc = true;
    var error_tomTatTinTuc = true;
    var error_ngayDangTinTuc = true;
    var error_hinhAnh = true;


    $("#tieuDeTinTuc").focusout(function (e) {
        if ($("#tieuDeTinTuc").val().trim().length <= 0) {
            $("#error-tieuDeTinTuc").html(" Mời bạn nhập tiêu đề tin tức");
            $("#error-tieuDeTinTuc").show();
            error_tieuDeTinTuc = true;
        }
        else {
            $("#error-tieuDeTinTuc").hide();
            error_tieuDeTinTuc = false;
        }
        
    });
    $('#tomTatTinTuc').focusout(function (e) {
        if ($('#tomTatTinTuc').val().trim().length <= 0) {
            $("#error-tomTatTinTuc").html(" Mời bạn cung cấp nội dung tóm tắt tin tức");
            $("#error-tomTatTinTuc").show();
            error_tomTatTinTuc = true;
        }
        else {
            $("#error-tomTatTinTuc").hide();
            error_tomTatTinTuc = false;
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


    $("#luu-tin-tuc").click(function (e) {
        if (error_tieuDeTinTuc == true || error_tomTatTinTuc == true || error_hinhAnh == true)
        {
        	if ($("#tieuDeTinTuc").val().trim().length <= 0) {
                $("#error-tieuDeTinTuc").html(" Mời bạn nhập tiêu đề tin tức");
                $("#error-tieuDeTinTuc").show();
                error_tieuDeTinTuc = true;
            }
        	if ($('#tomTatTinTuc').val().trim().length <= 0) {
                $("#error-tomTatTinTuc").html(" Mời bạn cung cấp nội dung tóm tắt tin tức");
                $("#error-tomTatTinTuc").show();
                error_tomTatTinTuc = true;
            }
            if ($("#hinhAnh").val().trim().length <= 0) {
                $("#error-hinhAnh").html(" Mời bạn chọn hình ảnh thông báo");
                $("#error-hinhAnh").show();
                error_hinhAnh = true;
            }
            alert("Mời bạn nhập đầy đủ thông tin cho Thông báo này!")
        }
        else {
        	var fileExtensionImage = ['jpeg', 'jpg', 'png','gif','mp4'];
        	
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
			
			var tieuDeTinTuc = $("#tieuDeTinTuc").val().trim();
			var tomTatTinTuc = $('#tomTatTinTuc').val().trim();
			var ngayDangTinTuc = $("#ngayDangTinTuc").val();
            var hinhAnh = $("#hinhAnh").val();

            var hinhAnh = $("#hinhAnh").val();
            if (hinhAnh.substring(3, 11) == 'fakepath') {
                hinhAnh = hinhAnh.substring(12);
            }
            
            //Lưu tin tức mới vào csdl và trả về mã TT
            //tin tức mới khi lưu vào csdl luôn có stt = 1
            
            $.ajax({
            	type:"POST",
            	url:"NV_themtintuc",
            	data:{
            		tieuDeTinTuc:tieuDeTinTuc,
            		tomTatTinTuc:tomTatTinTuc,
            		ngayDangTinTuc:ngayDangTinTuc,
            		hinhAnh:hinhAnh
            	},
            	dataType:"json",
            	success:function(result){
            		if(result.imageVideo == "fail"){
            			alert('Yêu cầu đổi tên hình ảnh (video)!');
            			return;
            		}
            		if(result.check == "fail"){
            			alert('Thêm tin tức mới không thành công!');
            			return;
            		}
            		if(result.maTTMoi != null){
            			var maTTMoi = result.maTTMoi;
            			//Thêm ảnh vào folder PIC
            			$.ajax({
            				type: 'POST',
            				url: 'NV_themhinhanh',
            				data: new FormData($('#hinhAnhTTMoi')[0]),
            				processData: false,
							contentType: false,
							dataType:"json",
							success:function(result){
								if(result.check == "fail"){
									$.ajax({
										type:"DELETE",
										url:"NV_themtintuc",
										data:{
											maTTMoi:maTTMoi
										}
									})
									alert('Thêm tin tức mới không thành công!');
									return;
								}
								else{
									alert("Mã tin tức mới của bạn là: " + maTTMoi);
									window.location.assign("NV_quanlytintuc");
									return;
								}
							}
            			})
            		}
            	}
            });
        }
    });
});