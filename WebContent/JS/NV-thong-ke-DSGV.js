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
				
				$("#dsKhoaHoc").append("<option>Tất cả</option>");
				for(i=0; i<n; i++){
					$("#dsKhoaHoc").append(
						$('<option>').val(result[i].maKhoaHoc)
									.text(result[i].maKhoaHoc + " (Khai giảng: "+result[i].ngayKhaiGiang+")")
					)
				}
			}
		}
	})
	
	$("#btn-thong-ke-ds-Giao-Vien").click(function(e){
		$("#danh-sach-trong").css("display","none");
		$("#ket-qua-thong-ke").css("display","none");
		
		var maKH = $("#dsKhoaHoc").val();
		//maKH = Tất cả: load lên toàn bộ ds Giáo viên ở trung tâm
		//maKH != Tất cả:Load ds Giáo viên giảng dạy của từng khóa
		
		$.ajax({
			type:"POST",
			url:"NV_thongkeDSGV",
			data:{
				maKH:maKH
			},
			dataType:'json',
			success:function(result){
				if(result.check == "fail"){
					$("#danh-sach-trong").text("Danh sách trống!");
					$("#danh-sach-trong").css("display","block");
					return;
				}
				else if(result.check != null){
					$("#danh-sach-trong").text(result.check);
					$("#danh-sach-trong").css("display","block");
					return;
				}
				else{
					var n = Object.keys(result).length;
					$("#soLuong").text(n);
					$("#table-ds-giao-vien > tbody").children().remove();
					
					var gioiTinh;
					for(i=0; i<n; i++){
						if(result[i].GioiTinh)
							gioiTinh = "Nữ";
						else
							gioiTinh = "Nam";
						
						$("#table-ds-giao-vien > tbody").append(
							$('<tr>').append(
								$('<td>').text(i+1)	
								).append(
								$('<td>').text(result[i].MaGV)	
								).append(
								$('<td>').text(result[i].HoTenGV)	
								).append(
								$('<td>').text(result[i].NgaySinh)	
								).append(
								$('<td>').text(result[i].CMND)	
								).append(
								$('<td>').text(result[i].DiaChi)	
								).append(
								$('<td>').text(gioiTinh)	
								).append(
								$('<td>').text(result[i].DienThoai)	
								).append(
								$('<td>').text(result[i].TenTrinhDoHV)	
								).append(
								$('<td>').text(result[i].EmailGV)	
								)
						)
					}
					
					$("#ket-qua-thong-ke").css("display","block");
				}
			}
		})
	});
	
	
	$("#btn-xuat-file-GiaoVien").click(function(e){
		window.location.assign("WriteFileExcelGiaoVien.jsp?maKH="+$("#dsKhoaHoc").val());
	})
	
})