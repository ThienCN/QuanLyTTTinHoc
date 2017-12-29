$(document).ready(function () {
	var MaTL;
	var MLop;
	var flag = true;
	loadDuLieu();
	function loadDuLieu(){
		$.ajax({
	        type: "POST",
	        url: "GV_posttailieuchitiet",
	        dataType: "json",
	        success: function (result) { 
	     	   if (result.check == "fail") {
	            	alert("Chưa có tài liệu nào được thêm");
	     	   }
	     	   else{
	     		  MLop = result[0].MaLop;
	     		   $("#tenlop").text(result[0].TenLop);
	     		  var n = Object.keys(result).length;
	              if(n>0){
	            	  
	            	$("#table-tai-lieu > tbody").children().remove();
	              	for(i=0; i<n; i++){
	                	$("#table-tai-lieu > tbody").append(
	                        $('<tr>').append(
	                            $('<td style="width:50px;">').text(parseInt(i+1))
	                            ).append(
	                            $('<td>').text(result[i].TenTaiLieu)
	                            ).append(
	                            $('<td>').text(result[i].NoiDungTaiLieu)
	                            ).append(
	                            $('<td>').text(result[i].LoaiTaiLieu)
	                            ).append(
                                $('<td>').append(
                             		   $('<a class="btnXoa" id="'+result[i].MaTaiLieu+'" style="text-decoration: none">').text("Xóa")
                             		   		.css('cursor', 'pointer')
                                	   		)
                                )
	                    );
	              	}
	              }
	     	   }
	     	  $(".btnXoa").click(function (e) {
	     		 e.preventDefault();
	   				if (confirm('Bạn có chắc chắn muốn xóa tài liệu này không?')) {
		   				MaTL = this.id;
		   				$.ajax({
							type:"GET",
							url:"GV_xoatailieu",
							data:{
								MaTLMoi: MaTL
							},
							dataType: "json",
		   					success: function (result) {
		   						if(result.check == "fail"){
		   							alert("Xóa tài liệu không thành công");
		   						}
		   						else{
		   							alert("Xóa tài liệu thành công");
		   							loadDuLieu();
		   						}
		   					}
						})
	   				}
	     	  })

              $("#thongTinTimKiem").val("");
	        },
	        error: function (jqXHR, exception) {
	            if (jqXHR.status == 500)
	                alert("Không load được tài liệu");
	        }
	    });
	}
	
	
	$("#btn-xac-nhan").click(function (e) {
        if ($("#tenfile").val().trim().length <= 0) {
        	$("#error-file").fadeIn(1000, function () {
            	$(this).fadeOut(500);
             })
        }
        else {
        	var noiDungFile = $("#noidungfile").val();
        	var fileRong = $('#noidungfile').get()[0].files[0];
        	var tenFile = $('#tenfile').val();
        	var loaiFile = noiDungFile.split('.').pop();
			if(!fileRong){
				alert("Vui lòng chọn file");
			}
			else{
				var fileExtensionFile = ['doc','docx','pptx','ppt','xlsx','rar','pdf','txt','mp4','mov','mpeg','wmv'];
				if ($.inArray($('#noidungfile').val().split('.').pop().toLowerCase(), fileExtensionFile) == -1) {
		            alert("Chỉ cho phép các file : "+fileExtensionFile.join(', '));
		        }
				else{
					if (noiDungFile.substring(3, 11) == 'fakepath') {
						noiDungFile = noiDungFile.substring(12);
		            }
					//Lưu file mới vào csdl và trả về mã tài liệu
		            $.ajax({
		            	type:"GET",
		            	url:"GV_luutailieu",
		            	data:{
		            		NoiDungTaiLieu: noiDungFile,
		            		TenTaiLieu: tenFile,
		            		LoaiTaiLieu: loaiFile,
		            		MaLop: MLop
		            	},
		            	dataType:"json",
		            	success:function(result){
		            		if(result.file == "fail"){
		            			alert('Yêu cầu đổi tên nội dung tài liệu!!');
		            			return;
		            		}
		            		if(result.check == "fail"){
		            			alert('Thêm tài liệu mới không thành công!');
		            			return;
		            		}
		            		if(result.MaTLMoi != null){
		            			var MaTLMoi = result.MaTLMoi;
		            			if(loaiFile == "wmv" || loaiFile == "mp4" || loaiFile == "mov" || loaiFile == "mpeg"){
		            				//Thêm video vào folder Video
		            				$.ajax({
			            				type: 'POST',
			            				url: 'GV_luuvideo',
			            				data: new FormData($('#formTaiLieu')[0]),
			            				processData: false,
										contentType: false,
										dataType:"json",
										success:function(result){
											if(result.check == "fail"){
												$.ajax({
													type:"GET",
													url:"GV_xoatailieu",
													data:{
														MaTLMoi: MaTLMoi
													}
												})
												alert('Thêm tài liệu mới không thành công!');
											}
											else{
												alert('Thêm tài liệu mới thành công!');
												$("#tenfile").val("");
												$("#noidungfile").val("");
												loadDuLieu();
											}
										}
			            			});
		            			}
		            			else{
		            				//Thêm file vào folder File
		            				$.ajax({
			            				type: 'POST',
			            				url: 'GV_luutailieu',
			            				data: new FormData($('#formTaiLieu')[0]),
			            				processData: false,
										contentType: false,
										dataType:"json",
										success:function(result){
											if(result.check == "fail"){
												$.ajax({
													type:"GET",
													url:"GV_xoatailieu",
													data:{
														MaTLMoi: MaTLMoi
													}
												})
												alert('Thêm tài liệu mới không thành công!');
											}
											else{
												alert('Thêm tài liệu mới thành công!');
												$("#tenfile").val("");
												$("#noidungfile").val("");
												loadDuLieu();
											}
										}
			            			});
		            			}
		            		}
		            	}
		            });
				}
			}
        }
    });
	
	$("#btn-tim").click(function (e) {
		if($("#thongTinTimKiem").val().trim().length == 0){
			alert("Mời bạn nhập thông tin tìm kiếm");
		}
	});
});