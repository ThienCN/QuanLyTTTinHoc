$(document).ready(function(){
	//Load thông báo muốn chỉnh sửa lên
	var flag=1;
	var imageVideoTTEdit;
	//flag = 1: load tin tức muốn chỉnh sửa lên
	$.ajax({
		type:"POST",
		url:"NV_chinhsuatintuc",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				alert("Server đang bận!");
				return;
			}
			else{
				$("#maTinTuc").val(result[0].maTinTuc);
				$("#tieuDeTinTuc").val(result[0].tieuDeTinTuc);
				$("#tomTatTinTuc").val(result[0].tomTatTinTuc);
				$("#ngayDangTinTuc").val(result[0].ngayDangTinTuc);
				
				imageVideoTTEdit = result[0].imageVideo;
				
				if(result[0].imageVideo.substring(0,3) == "Pic")
					$("#tenHinhAnh").text(result[0].imageVideo.substring(4));
				else
					$("#tenHinhAnh").text(result[0].imageVideo.substring(6));
			}
		}
	})
	
	// Sự kiện click vào tên file hình ảnh thông báo cũ
	$("#tenHinhAnh").click(function(e){
		e.preventDefault();
		$("#myModal").css("display","block");
		$("#img01").attr("src",hinhAnhTBEdit);
		$("#caption").innerHTML = this.alt;
	})

	// Sự kiện click vào nút đóng (close X ) trên modal image
	$("span.close").click(function(e){
		e.preventDefault();
		$("#myModal").css("display","none");
	})

	
	
	var error_tieuDeTinTuc = false;
    var error_tomTatTinTuc = false;
    var error_ngayDangTinTuc = false;
    var error_hinhAnh = false;
    
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
            alert("Mời bạn nhập đầy đủ thông tin cho Thông báo này!")
        }
            else {
            	var maTinTuc = $("#maTinTuc").val().trim();
    			var tieuDeTinTuc = $("#tieuDeTinTuc").val().trim();
    			var tomTatTinTuc = $('#tomTatTinTuc').val().trim();
    			var ngayDangTinTuc = $("#ngayDangTinTuc").val();
    			var hinhAnh;
    			if(imageVideoTTEdit.substring(0,3) == "Pic")
    				hinhAnh = imageVideoTTEdit.substring(4);
				else
					hinhAnh = imageVideoTTEdit.substring(6);
                
    			if($("#hinhAnh").val() != ""){
    				var fileExtensionImage = ['jpeg', 'jpg', 'png', 'gif','mp4'];
                	
                	var hinhAnh = $('#hinhAnh').get()[0].files[0];
        			var hinhAnhUpload = $('#hinhAnh').val();
    				if ($.inArray($('#hinhAnh').val().split('.').pop().toLowerCase(), fileExtensionImage) == -1) {
        	            alert("Hình ảnh phải là loại : "+fileExtensionImage.join(', '));
        	            return;
        	        }
    				
    				if ($("#hinhAnh").val().substring(3, 11) == 'fakepath') {
                        hinhAnh = $("#hinhAnh").val().substring(12);
                    }
    			}
    			//flag=2: cập nhật thông tin mới
                flag=2;
                $.ajax({
                	type:"POST",
                	url:"NV_chinhsuatintuc",
                	data:{
                		flag:flag,
                		maTinTuc:maTinTuc,
                		tieuDeTinTuc:tieuDeTinTuc,
                		tomTatTinTuc:tomTatTinTuc,
                		ngayDangTinTuc:ngayDangTinTuc,
                		hinhAnh:hinhAnh
                	},
                	dataType:"json",
                	success:function(result){
                		if(result.check == "ok"){
                			alert("Chỉnh sửa tin tức thành công!");
                			
                			if($("#hinhAnh").val() != ""){
                				$.ajax({
                    				type: 'POST',
                    				url: 'NV_themhinhanh',
                    				data: new FormData($('#hinhAnhTTMoi')[0]),
                    				processData: false,
        							contentType: false
                				})
                			}
                			
                			window.location.assign("NV_quanlytintuc");
                			
                		}
                		if(result.check == "fail"){
                			alert("Chỉnh sửa không thành công!");
                			return;
                		}
                	}
                })
                
    			
            }
    })
})