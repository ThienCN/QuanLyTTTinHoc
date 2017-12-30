$(document).ready(function(){
	//Load dsKhoaHoc lên combobox
	//flag=1: Lấy thông tin toàn bộ các khóa học
	flag=1;
	$.ajax({
		type:"POST",
		url:"Admin_themkhoahocmoi",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				alert("Server đang bân!");
				window.location.assign("admin");
				return;
			}
			else{
				var n = Object.keys(result).length;
				$("#dsKhoaHoc option").remove();
				for(i=0; i<n; i++){
					$("#dsKhoaHoc").append(
						$('<option>').val(result[i].maKhoaHoc)
									.text(result[i].maKhoaHoc + " (Khai giảng: "+result[i].ngayKhaiGiang+")")
					)
				}
			}
		}
	})
	
	$("#btn-thong-ke-dsLopHoc").click(function(e){
		
		$("#danh-sach-trong").css("display","none");
		$("#ket-qua-thong-ke").css("display","none");
		
		var maKH = $("#dsKhoaHoc").val();
		
		$.ajax({
			type:"POST",
			url:"NV_thongkeDSLH",
			data:{
				maKH:maKH
			},
			dataType:"json",
			success:function(result){
				if(result.check != null){
					if(result.check == "fail")
						$("#danh-sach-trong").text("Danh sách trống!");
					else
						$("#danh-sach-trong").text(result.check);
					$("#danh-sach-trong").css("display","block");
					return;
				}
				else{
					var n = Object.keys(result).length;
					
					$("#soLuong").text(n);
					
					$("#table-ds-lop-hoc > tbody").children().remove();
					var tinhTrang, color;
					
					for(i=0; i<n; i++){
						if(result[i].TinhTrang == 1){
							tinhTrang = "Mở";
							color="blue";
						}
						else if(result[i].TinhTrang == 2){
							tinhTrang = "Khóa";
							color="red";
						}
						else if(result[i].TinhTrang == 0){
							tinhTrang = "Đóng";
							color="red";
						}
						
						$("#table-ds-lop-hoc > tbody").append(
							$('<tr>').append(
								$('<td>').text(i+1)	
								).append(
								$('<td>').text(result[i].MaLop)	
								).append(
								$('<td>').text(result[i].TenLop)	
								).append(
								$('<td>').text(result[i].SoHV)	
								).append(
								$('<td>').text(result[i].SoBuoi)	
								).append(
								$('<td>').text(result[i].NgayBatDau)	
								).append(
								$('<td>').text(result[i].NgayKetThuc)	
								).append(
								$('<td>').text(result[i].GiaoVienGiangDay)	
								).append(
								$('<td>').text(result[i].SoPhong)	
								).append(
								$('<td>').text(result[i].BuoiHoc)	
								).append(
								$('<td>').text(result[i].GioHoc)	
								).append(
								$('<td>').text(result[i].HocPhi)	
								).append(
								$('<td style="color: '+ color +'">').text(tinhTrang)	
								)
						)
					}
					$("#ket-qua-thong-ke").css("display","block");
					
				}
			}
		})
		
	})
	
	
	$("#btn-xuat-file-LopHoc").click(function(e){
		window.location.assign("WriteFileExcelLopHoc.jsp?maKH="+$("#dsKhoaHoc").val());
	})
	
})
