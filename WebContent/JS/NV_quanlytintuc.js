$(document).ready(function(){
	//timKiemTinTuc
	$("#timKiemTinTuc").click(function(e){
		var thongTinTimKiem = $("#thongTinTimKiem").val().trim();
		if(thongTinTimKiem.length <= 0){
			alert("Mời bạn nhập tiêu đề tin tức!");
			window.location.assign("NV_quanlytintuc");
			return;
		}
		else{
			$.ajax({
				type:"PUT",
				url:"NV_quanlytintuc?thongTinTimKiem="+thongTinTimKiem,
				dataType:"json",
				success:function(result){
					var n = Object.keys(result).length;
					
					$("#table-dsTinTuc > tbody").children().remove();
					
					var tinhTrang;
					for(i=0; i<n; i++){
						if(result[i].tinhTrang == 1)
							tinhTrang = "Hiện";
						else
							tinhTrang = "Ẩn";
						
						$("#table-dsTinTuc > tbody").append(
							$('<tr>').append(
								$('<td>').text(result[i].maTinTuc.trim())	
								).append(
								$('<td>').text(result[i].tieuDeTinTuc)		
								).append(
								$('<td>').text(result[i].tomTatTinTuc)		
								).append(
								$('<td>').text(result[i].ngayDangTinTuc)		
								).append(
								$('<td>').text(tinhTrang)		
								).append(
								$('<td>').append(
									$('<div class="w3-dropdown-hover">').append(
										$('<button class="w3-button w3-round-xxlarge">').append(
											$('<span class="glyphicon glyphicon-edit">')	
											)	
										).append(
										$('<div class="w3-dropdown-content w3-bar-block w3-card-4">').append(
											$('<a>').text("Đưa lên đầu")
													.addClass("w3-bar-item w3-button")
													.click(function(e){
														e.preventDefault();
														var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
														//flag = 2: Đưa 1 TT lên đầu
														flag=2;
														$.ajax({
															type:"POST",
															url:"NV_quanlytintuc",
															data:{
																flag:flag,
																maTT:maTT
															},
															dataType:"json",
															success:function(result){
																if(result.check == "fail"){
																	alert("Thao tác thực hiện không thành công!");
																	return;
																}
																if(result.check == "ok"){
																	window.location.assign("NV_quanlytintuc");
																}
															}
														})
													})
											).append(
											$('<a>').text("Chỉnh sửa")
													.addClass("w3-bar-item w3-button")		
													.click(function(e){
														e.preventDefault();
														var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
														//flag = 5: lấy tin tức bỏ vào scope...chuẩn bị cho chuyển qua trang chỉnh sửa tin tức
														flag = 5;
														$.ajax({
															type:"POST",
															url:"NV_quanlytintuc",
															data:{
																flag:flag,
																maTT:maTT
															},
															dataType:"json",
															success:function(result){
																if(result.check == "fail"){
																	alert("Thao tác thực hiện không thành công!");
																	return;
																}
																if(result.check == "ok"){
																	window.location.assign("NV_chinhsuatintuc");
																}
															}
														})
														
													})
											).append(
											$('<a>').text("Hiện")	
													.addClass("w3-bar-item w3-button")
													.click(function(e){
														e.preventDefault();
														var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
														var temp = this;
														
														//flag = 3: Update hiện/ẩn tin tức
														flag=3;
														var tinhTrang=1;
														$.ajax({
															type:"POST",
															url:"NV_quanlytintuc",
															data:{
																flag:flag,
																maTT:maTT,
																tinhTrang:tinhTrang
															},
															dataType:"json",
															success:function(result){
																if(result.check == "fail"){
																	alert("Thao tác thực hiện không thành công!");
																	return;
																}
																if(result.check == "ok"){
																	$(temp).closest('tr').find('td:nth-child(5)').css("color","red");
																	$(temp).closest('tr').find('td:nth-child(5)').text("Hiện");
																}
															}
														})
													})
											).append(
											$('<a>').text("Ẩn")
													.addClass("w3-bar-item w3-button")
													.click(function(e){
														e.preventDefault();
														var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
														var temp = this;
														
														//flag = 3: Update hiện/ẩn tin tức
														flag=3;
														var tinhTrang=0;
														$.ajax({
															type:"POST",
															url:"NV_quanlytintuc",
															data:{
																flag:flag,
																maTT:maTT,
																tinhTrang:tinhTrang
															},
															dataType:"json",
															success:function(result){
																if(result.check == "fail"){
																	alert("Thao tác thực hiện không thành công!");
																	return;
																}
																if(result.check == "ok"){
																	$(temp).closest('tr').find('td:nth-child(5)').css("color","red");
																	$(temp).closest('tr').find('td:nth-child(5)').text("Ẩn");
																}
															}
														})
													})
											).append(
											$('<a>').text("Xóa")
													.addClass("w3-bar-item w3-button")
													.click(function(e){
														e.preventDefault();
														
														if(confirm('Bạn có chắc chắn muốn xóa không?')){
															var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
															var temp = this;
															
															$.ajax({
																type:"DELETE",
																url:"NV_quanlytintuc?maTT="+maTT,
																dataType:"json",
																success:function(result){
																	if(result.check == "fail"){
																		alert("Thao tác thực hiện không thành công!");
																		return;
																	}
																	if(result.check == "ok"){
																		alert("Xóa tin tức thành công!");
																		$(temp).closest('tr').remove();
																	}
																}
															})
														}
													})
											)		
										)	
									)		
								)
						)
					}
					$("#ket-qua-thong-ke").css("display","block");
				}
			})
		}
	})
	
	$("#danh-sach-trong").css("display","none");
	$("#ket-qua-thong-ke").css("display","none");
	
	var flag=1;
	//flag=1: Lấy toàn bộ tin tức
	$.ajax({
		type:"POST",
		url:"NV_quanlytintuc",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				$("#danh-sach-trong").text("Không có tin tức nào");
				$("#danh-sach-trong").css("display","block");
				return;
			}
			else if(result.check != null){
				$("#danh-sach-trong").text(result.check);
				$("#danh-sach-trong").css("display","block");
				$("#danh-sach-trong").css("color","red");
				return;
			}
			else{
				var n = Object.keys(result).length;
				
				$("#table-dsTinTuc > tbody").children().remove();
				
				var tinhTrang;
				for(i=0; i<n; i++){
					if(result[i].tinhTrang == 1)
						tinhTrang = "Hiện";
					else
						tinhTrang = "Ẩn";
					
					$("#table-dsTinTuc > tbody").append(
						$('<tr>').append(
							$('<td>').text(result[i].maTinTuc.trim())	
							).append(
							$('<td>').text(result[i].tieuDeTinTuc)		
							).append(
							$('<td>').text(result[i].tomTatTinTuc)		
							).append(
							$('<td>').text(result[i].ngayDangTinTuc)		
							).append(
							$('<td>').text(tinhTrang)		
							).append(
							$('<td>').append(
								$('<div class="w3-dropdown-hover">').append(
									$('<button class="w3-button w3-round-xxlarge">').append(
										$('<span class="glyphicon glyphicon-edit">')	
										)	
									).append(
									$('<div class="w3-dropdown-content w3-bar-block w3-card-4">').append(
										$('<a>').text("Đưa lên đầu")
												.addClass("w3-bar-item w3-button")
												.click(function(e){
													e.preventDefault();
													var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
													//flag = 2: Đưa 1 TT lên đầu
													flag=2;
													$.ajax({
														type:"POST",
														url:"NV_quanlytintuc",
														data:{
															flag:flag,
															maTT:maTT
														},
														dataType:"json",
														success:function(result){
															if(result.check == "fail"){
																alert("Thao tác thực hiện không thành công!");
																return;
															}
															if(result.check == "ok"){
																window.location.assign("NV_quanlytintuc");
															}
														}
													})
												})
										).append(
										$('<a>').text("Chỉnh sửa")
												.addClass("w3-bar-item w3-button")		
												.click(function(e){
													e.preventDefault();
													var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
													//flag = 5: lấy tin tức bỏ vào scope...chuẩn bị cho chuyển qua trang chỉnh sửa tin tức
													flag = 5;
													$.ajax({
														type:"POST",
														url:"NV_quanlytintuc",
														data:{
															flag:flag,
															maTT:maTT
														},
														dataType:"json",
														success:function(result){
															if(result.check == "fail"){
																alert("Thao tác thực hiện không thành công!");
																return;
															}
															if(result.check == "ok"){
																window.location.assign("NV_chinhsuatintuc");
															}
														}
													})
													
												})
										).append(
										$('<a>').text("Hiện")	
												.addClass("w3-bar-item w3-button")
												.click(function(e){
													e.preventDefault();
													var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
													var temp = this;
													
													//flag = 3: Update hiện/ẩn tin tức
													flag=3;
													var tinhTrang=1;
													$.ajax({
														type:"POST",
														url:"NV_quanlytintuc",
														data:{
															flag:flag,
															maTT:maTT,
															tinhTrang:tinhTrang
														},
														dataType:"json",
														success:function(result){
															if(result.check == "fail"){
																alert("Thao tác thực hiện không thành công!");
																return;
															}
															if(result.check == "ok"){
																$(temp).closest('tr').find('td:nth-child(5)').css("color","red");
																$(temp).closest('tr').find('td:nth-child(5)').text("Hiện");
															}
														}
													})
												})
										).append(
										$('<a>').text("Ẩn")
												.addClass("w3-bar-item w3-button")
												.click(function(e){
													e.preventDefault();
													var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
													var temp = this;
													
													//flag = 3: Update hiện/ẩn tin tức
													flag=3;
													var tinhTrang=0;
													$.ajax({
														type:"POST",
														url:"NV_quanlytintuc",
														data:{
															flag:flag,
															maTT:maTT,
															tinhTrang:tinhTrang
														},
														dataType:"json",
														success:function(result){
															if(result.check == "fail"){
																alert("Thao tác thực hiện không thành công!");
																return;
															}
															if(result.check == "ok"){
																$(temp).closest('tr').find('td:nth-child(5)').css("color","red");
																$(temp).closest('tr').find('td:nth-child(5)').text("Ẩn");
															}
														}
													})
												})
										).append(
										$('<a>').text("Xóa")
												.addClass("w3-bar-item w3-button")
												.click(function(e){
													e.preventDefault();
													
													if(confirm('Bạn có chắc chắn muốn xóa không?')){
														var maTT = $(this).closest('tr').find('td:nth-child(1)').text();
														var temp = this;
														
														$.ajax({
															type:"DELETE",
															url:"NV_quanlytintuc?maTT="+maTT,
															dataType:"json",
															success:function(result){
																if(result.check == "fail"){
																	alert("Thao tác thực hiện không thành công!");
																	return;
																}
																if(result.check == "ok"){
																	alert("Xóa tin tức thành công!");
																	$(temp).closest('tr').remove();
																}
															}
														})
													}
												})
										)		
									)	
								)		
							)
					)
				}
				$("#ket-qua-thong-ke").css("display","block");
			}
		}
	})
})