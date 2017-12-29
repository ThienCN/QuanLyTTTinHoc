$(document).ready(function() {
		$.ajax({
			type : "POST",
			url : "HV_caclopdangtheohocchitiet",
			dataType : "json",
			success : function(result) {
				if(result.check == "fail"){
					alert("Lớp học hiện chưa có tài liệu");
				}
				else{
					$("#khoahoc").text(result[0].TenLop);
					var n = Object.keys(result).length;
		            if(n>0){
		            	$("#danh-sach-tai-lieu").children().remove();
		            	var src;
		            	for(i=0; i<n; i++){
		            		var noidung = result[i].NoiDungTaiLieu;
		            		var loaiFile = result[i].LinkTaiLieu.split('.').pop();
		            		if(loaiFile == "wmv" || loaiFile == "mp4" || loaiFile == "mov" || loaiFile == "mpeg"){
		            			src="./Pic/video.PNG";
		            		}
		            		else if(loaiFile == "doc" || loaiFile == "docx"){
		            			src="./Pic/tailieu.PNG";
		            		}
		            		else{
		            			src="./Pic/thongbao.PNG"
		            		}
		                	$("#danh-sach-tai-lieu").append(
		                        $('<li id="'+result[i].NoiDungTaiLieu+'" class="chi-tiet" style="line-height:50px;">').append(
		                        	$('<img src="'+src+'" style="height:35px;">')
	                            	).append(" "+result[i].TenTaiLieu).click(function(e){
	            		   				e.preventDefault();
	            		   				window.location.assign("HV_downloadtailieu?TenTaiLieu="+this.id);
	            		   			})
		                    );
		              	}
		            }
				}
				
			},
			error : function(jqXHR, exception) {
				if (jqXHR.status == 500)
					alert("Không có tài liệu nào");
			}
		});

});