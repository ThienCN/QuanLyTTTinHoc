$(document).ready(function(){
	//Load thông báo muốn chỉnh sửa lên
	var flag=1;
	var hinhAnhTBEdit, fileTBEdit;
	//flag = 1: load thông báo muốn chỉnh sửa lên
	$.ajax({
		type:"POST",
		url:"NV_chinhsuathongbao",
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
				$("#maThongBao").val(result[0].maThongBao);
				$("#tieuDeThongBao").val(result[0].tieuDeThongBao);
				$("#tomTatThongBao").val(result[0].tomTatThongBao);
				$("#ngayThongBao").val(result[0].ngayThongBao);
				
				hinhAnhTBEdit = result[0].hinhAnh;
				fileTBEdit = result[0].tepDinhKem;
				
				$("#tenHinhAnh").text(result[0].hinhAnh.substring(4));
				$("#tenFile").text(result[0].tepDinhKem.substring(5));
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

	//Sự kiện click vào tên file thông báo
	$("#tenFile").click(function(e){
		e.preventDefault();
		
		//Lưu lại tên file
		var flag=1;
		$.ajax({
			type:"POST",
			url:"noidungthongbao",
			data:{
				flag:flag,
				fileTBEdit:fileTBEdit
			},
			success:function(){
				window.location.assign("noidungthongbao");
			}
		})
		
		
	})
	
	
	
	var error_tieuDeThongBao = false;
    var error_tomTatThongBao = false;
    var error_hinhAnh = false;
    var error_tepDinhKem = false;
    
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
                alert("Mời bạn nhập đầy đủ thông tin cho Thông báo này!")
            }
            else {
            	var maThongBao = $("#maThongBao").val().trim();
    			var tieuDeThongBao = $("#tieuDeThongBao").val().trim();
    			var tomTatThongBao = $('#tomTatThongBao').val().trim();
    			var ngayThongBao = $("#ngayThongBao").val();
    			
    			var tepDinhKem = fileTBEdit.substring(5);
                var hinhAnh = hinhAnhTBEdit.substring(4);
                
    			if($("#hinhAnh").val() != ""){
    				var fileExtensionImage = ['jpeg', 'jpg', 'png', 'gif'];
                	
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
    			
    			if($("#tepDinhKem").val() != ""){
    				var fileExtensionFile = ['pdf']; 
        			
        			var tepDinhKem = $('#tepDinhKem').get()[0].files[0];
        			var tepDinhKemUpload = $('#tepDinhKem').val();
        			if ($.inArray($('#tepDinhKem').val().split('.').pop().toLowerCase(), fileExtensionFile) == -1) {
        	            alert("Thông báo phải là dạng file : "+fileExtensionFile.join(', '));
        	            return;
        	        }
        			
        			if ($("#tepDinhKem").val().substring(3, 11) == 'fakepath') {
                        tepDinhKem = $("#tepDinhKem").val().substring(12);
                    }
    			}
    			
    			//flag=2: cập nhật thông tin mới
                flag=2;
                $.ajax({
                	type:"POST",
                	url:"NV_chinhsuathongbao",
                	data:{
                		flag:flag,
                		maThongBao:maThongBao,
                		tieuDeThongBao:tieuDeThongBao,
                		tomTatThongBao:tomTatThongBao,
                		ngayThongBao:ngayThongBao,
                		tepDinhKem:tepDinhKem,
                		hinhAnh:hinhAnh
                	},
                	dataType:"json",
                	success:function(result){
                		if(result.check == "ok"){
                			alert("Chỉnh sửa thông báo thành công!");
                			
                			if($("#hinhAnh").val() != ""){
                				$.ajax({
                    				type: 'POST',
                    				url: 'NV_themhinhanh',
                    				data: new FormData($('#hinhAnhTBMoi')[0]),
                    				processData: false,
        							contentType: false
                				})
                			}
                			
                			if($("#tepDinhKem").val() != ""){
                				$.ajax({
    	            				type: 'POST',
    	            				url: 'NV_themfile',
    	            				data: new FormData($('#tepDinhKemTBMoi')[0]),
    	            				processData: false,
    								contentType: false
                    			})
                			}
                			
                			window.location.assign("NV_quanlythongbao");
                			
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