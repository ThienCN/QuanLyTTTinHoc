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
				//flag = 1: Load ds Lớp học lên combobox theo mã Khóa tương ứng ngay khi vừa load trang
				var maKH = $("#dsKhoaHoc").val();
				var flag = 1;
				$.ajax({
					type:"POST",
					url:"NV_thongkeDSDKOnL",
					data:{
						flag:flag,
						maKH: maKH
					},
					dataType:"json",
					success: function(result){
						if(result.check == "fail"){
							alert("Khóa học hiện chưa có lớp học!");
							return;
						}
						if(result.check != null){
							alert("Server đang bận!");
							return;
						}
						else{
							var n = Object.keys(result).length;
							
							for(i=0; i<n; i++){
								$("#dsLopHoc").append('<option value='+ result[i].MaLop +'>' + result[i].TenLop + "</option>");
							}
						}
					}
				})
			}
		}
	})
	
	
	$("#dsKhoaHoc").change(function(e){
		maKH = $("#dsKhoaHoc").val();
		$("#dsLopHoc option").remove();
		//flag = 1: Load ds Lớp học lên combobox theo mã Khóa tương ứng ngay khi combobox Khóa học có sự thay đổi
		flag = 1;
		$.ajax({
			type:"POST",
			url:"NV_thongkeDSHV",
			data:{
				flag:flag,
				maKH: maKH
			},
			dataType:"json",
			success: function(result){
				if(result.check == "fail"){
					alert("Khóa học hiện chưa có lớp học!");
					return;
				}
				if(result.check != null){
					alert("Server đang bận!");
					return;
				}
				else{
					var n = Object.keys(result).length;
					
					for(i=0; i<n; i++){
						$("#dsLopHoc").append('<option value='+ result[i].MaLop +'>' + result[i].TenLop + "</option>");
					}
				}
			}
		})
	});
	
	
	$("#btn-thong-ke-ds-hoc-vien").click(function(e){
		$("#ket-qua-thong-ke").css("display","none");
		$("#danh-sach-trong").css("display","none");
		
		//flag = 2: lấy ds học viên của một lớp học
		flag = 2;
		$.ajax({
			type:"POST",
			url:"NV_thongkeDSHV",
			data:{
				flag:flag,
				maLopHoc: $("#dsLopHoc").val()
			},
			dataType:"json",
			success: function(result){
				if(result.check != null){
					if(result.check == "fail")
						$("#danh-sach-trong").text("Danh sách trống!");
					else
						$("#danh-sach-trong").text(result.check);
					$("#danh-sach-trong").css("display","block");
					return;
				}
				else{
					$("#table-ds-hoc-vien > tbody").children().remove();
					
					var n = Object.keys(result).length;
					$("#soLuong").text(n);
					
					var gioiTinh;
					for(i=0; i<n; i++){
						if(result[i].GioiTinh)
							gioiTinh = "Nữ";
						else
							gioiTinh = "Nam";
						
						$("#table-ds-hoc-vien > tbody").append(
								$('<tr>').append(
									$('<td>').text(i+1)	
									).append(
									$('<td>').text(result[i].MaHV)		
									).append(
									$('<td>').text(result[i].HoTenHV)		
									).append(
									$('<td>').text(gioiTinh)		
									).append(
									$('<td>').text(result[i].NgaySinh)		
									).append(
									$('<td>').text(result[i].DiaChi)		
									).append(
									$('<td>').text(result[i].SDT)		
									).append(
									$('<td>').text(result[i].CMND)		
									).append(
									$('<td>').text(result[i].EmailHV)		
									)
						)
					}
					$("#ket-qua-thong-ke").css("display","block");
				}
			}
		})
	});
	
	
	$("#btn-xuat-file-HocVien").click(function(e){
		window.location.assign("WriteFileExcelHocVien.jsp?maLopHoc="+$("#dsLopHoc").val());
	})
});