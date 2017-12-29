$(document).ready(function () {
	var flag=1, maDKOnline;
	
	$("#btn-tra-cuu-dkyonline").click(function(e){
		e.preventDefault();
		
		$("#thong-tin-nguoi-dang-ky").css("display","none");
		$("#thong-tin-lop-hoc-dang-ky").css("display","none");
		$("#khong-co-ket-qua").css("display","none");
		
		var MaDkyOnl = $("#MaDkyOnl").val().trim();
		
		if(MaDkyOnl.length <= 0){
			alert("Mời bạn nhập thông tin tìm kiếm!");
			return;
		}
		else{
			//flag = 1: lấy thông tin cá nhân của người đăng ký
			flag = 1;
			
			$.ajax({
				type:"POST",
				url:"NV_tracuuDKOnl",
				data:{
					flag:flag,
					MaDkyOnl:MaDkyOnl
				},
				dataType:"json",
				success: function(result){
					if(result.check == "fail"){
						$("#khong-co-ket-qua").text("Mã đăng ký online không tồn tại!");
						$("#khong-co-ket-qua").css("display","block");
						return;
					}
					else{
						$("#table-thong-tin-nguoi-dang-ky > tbody").children().remove();
						
						maDKOnline = result.maDkyOnl;
						
						$("#table-thong-tin-nguoi-dang-ky > tbody").append(
							$('<tr>').append(
								$('<td>').text(result.hoTen)
								).append(
								$('<td>').text(result.ngaySinh)
								).append(
								$('<td>').text(result.diaChi)		
								).append(
								$('<td>').text(result.SDT)		
								).append(
								$('<td>').text(result.email)		
								)
						);
						
						$("#thong-tin-nguoi-dang-ky").css("display","block");
						
						//flag = 2: lấy thông tin đăng ký lớp học
						flag = 2;
						
						$.ajax({
							type:"POST",
							url:"NV_tracuuDKOnl",
							data:{
								flag:flag,
								maDKOnline:maDKOnline
							},
							dataType:"json",
							success:function(result){
								if(result.check != null){
									if(result.check =="fail")
										$("#khong-co-ket-qua").text("Không có thông tin lớp học đã đăng ký online!");
									else{
										$("#khong-co-ket-qua").text(result.check);
										$("#khong-co-ket-qua").css("color","red");
									}
									$("#khong-co-ket-qua").css("display","block");
									return;
								}
								else{
									$("#table-thong-tin-lop-hoc-dang-ky > tbody").children().remove();
									
									var n = Object.keys(result).length;
									
									var tinhTrang, tongTienHocPhi = 0;
									for(i=0; i<n; i++){
										
										if(result[i].tinhTrang == 1)
											tinhTrang = "Đã nhận lớp";
										else
											tinhTrang = "Chưa nhận lớp";
										
										$("#table-thong-tin-lop-hoc-dang-ky > tbody").append(
												$('<tr>').append(
													$('<td>').text(result[i].MaLop)		
													).append(
													$('<td>').text(result[i].TenLop)		
													).append(
													$('<td>').text(result[i].SoBuoi)		
													).append(
													$('<td>').text(result[i].NgayBatDau)		
													).append(
													$('<td>').text(result[i].NgayKetThuc)		
													).append(
													$('<td>').text(result[i].BuoiHoc)		
													).append(
													$('<td>').text(result[i].GioHoc)		
													).append(
													$('<td>').text(result[i].HocPhi)		
													).append(
													$('<td>').text(result[i].ngayDangKy)		
													).append(
													$('<td style="color:blue">').text(tinhTrang)		
													)
											)
										tongTienHocPhi = tongTienHocPhi	+ parseFloat(result[i].HocPhi);
									}
									$("#thong-tin-lop-hoc-dang-ky").css("display","block");
									$("#tongSoLopHocDky").text(n);
									$("#tongTienHocPhi").text(tongTienHocPhi);
								}
							}
						})
						
					}
				}
			});
		}
	});
	
	
	
	$("#btn-dky-KH").click(function(e){
		e.preventDefault();
		$.ajax({
			type:"GET",
			url:"HVDKyOnlNhanLop",
			data:{
				maDKOnline:maDKOnline
			},
			dataType:"json",
			success:function(result){
				if(result.check == "fail"){
					alert("Hiện tại server đang bận!");
					return;
				}
				else
					window.location.assign('NV_dangkykhoahoc');
			}
		});
		
		
		
	});
});