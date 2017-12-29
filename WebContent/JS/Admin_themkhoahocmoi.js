$(document).ready(function(){
	
	$("#ket-qua-thong-ke").css("display","none");
	$("#danh-sach-trong").css("display","none");
	
	var flag=1;
	//flag=1: Lấy thông tin toàn bộ các khóa học
	$.ajax({
		type:"POST",
		url:"Admin_themkhoahocmoi",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				$("#danh-sach-trong").text("Server đang bận");
				$("#danh-sach-trong").css("display","block");
				return;
			}
			if(result.check != null){
				$("#danh-sach-trong").text(result.check);
				$("#danh-sach-trong").css("color","red");
				$("#danh-sach-trong").css("display","block");
				return;
			}
			var n = Object.keys(result).length;
			var lichHoc, tinhTrang;
			$("#table-ds-khoa-hoc > tbody").children().remove();
			for(i=0; i<n; i++){
				if(result[i].soLopHoc > 0 )
					lichHoc = "Lịch học";
				else
					lichHoc = "Lên lịch học";
				
				if(result[i].tinhTrang == 1)
					tinhTrang = "Mở";
				else
					tinhTrang = "Đóng";
				
				$("#table-ds-khoa-hoc > tbody").append(
					$('<tr>').append(
						$('<td>').text(result[i].maKhoaHoc)	
						).append(
						$('<td>').text(result[i].ngayKhaiGiang)		
						).append(
						$('<td>').append(
							$('<a>').text(lichHoc)	
									.css("cursor","pointer")
									.click(function(e){
										e.preventDefault();
										var text = $(this).closest("tr").find("a").text();
										if(text == "Lịch học"){
											window.location.assign("Admin_thongkeDSLH");
										}
										if(text == "Lên lịch học"){
											window.location.assign("Admin_themlophocmoi");
										}
									})
							)		
						).append(
						$('<td>').text(tinhTrang)		
						)
				)
			}
			$("#ket-qua-thong-ke").css("display","block");
		}
	})
	
	//flag=2: Tạo mới 1 khóa học
	flag = 2;
	$("#tao-khoa-hoc").click(function(e){
		var maKhoaHoc = $("#maKhoaHoc").val().trim();
		
		if(maKhoaHoc.length < 1){
			alert("Mời bạn nhập mã khóa học!");
			return;
		}
		else{
			var ngayKhaiGiang = $("#ngayKhaiGiang").val();
			
			$.ajax({
				type:"POST",
				url:"Admin_themkhoahocmoi",
				data:{
					flag:flag,
					maKhoaHoc:maKhoaHoc,
					ngayKhaiGiang:ngayKhaiGiang
				},
				dataType:"json",
				success:function(result){
					if(result.check == "fail"){
						alert("Mã khóa học đã bị trùng!\rMời bạn nhập mã khóa học mới!");
						return;
					}
					else{
						alert("Thêm thành công khóa học!");
						$("#table-ds-khoa-hoc > tbody").append(
								$('<tr>').append(
									$('<td>').text(maKhoaHoc)	
									).append(
									$('<td>').text(ngayKhaiGiang)		
									).append(
									$('<td>').append(
										$('<a>').text("Lên lịch học")	
												.css("cursor","pointer")
												.click(function(e){
													e.preventDefault();
													var text = $(this).closest("tr").find("a").text();
													alert(text);
												})
										)		
									).append(
									$('<td>').text("Mở")		
									)
							)
					}
				}
			})
			
		}
		
		
	})
	
})
