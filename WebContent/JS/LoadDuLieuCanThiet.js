$(document).ready(function(){
	//Load danh sách học phí, buổi học, giờ học, phòng, giáo viên, khóa học lên các combobox
	//flag = 1: HỌC PHÍ
	flag=1;
	$.ajax({
		type:"GET",
		url:"Admin_LoadDuLieuCanThiet",
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
				$("#cbHocPhi option").remove();
				for(i=0; i<n; i++){
					$("#cbHocPhi").append(
						$('<option>').val(result[i].MaHocPhi).text(result[i].HocPhi)
					)
				}
			}
		}
	})
	//flag = 2: BUỔI HỌC
	flag=2;
	$.ajax({
		type:"GET",
		url:"Admin_LoadDuLieuCanThiet",
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
				$("#cbBuoiHoc option").remove();
				for(i=0; i<n; i++){
					$("#cbBuoiHoc").append(
						$('<option>').val(result[i].MaBuoiHoc).text(result[i].BuoiHoc)
					)
				}
			}
		}
	})
	//flag = 3: GIỜ HỌC
	flag=3;
	$.ajax({
		type:"GET",
		url:"Admin_LoadDuLieuCanThiet",
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
				$("#cbGioHoc option").remove();
				for(i=0; i<n; i++){
					$("#cbGioHoc").append(
						$('<option>').val(result[i].MaGioHoc).text(result[i].GioBatDau+" - "+result[i].GioKetThuc)
					)
				}
			}
		}
	})
	
	//flag = 4: PHÒNG HỌC
	flag=4;
	$.ajax({
		type:"GET",
		url:"Admin_LoadDuLieuCanThiet",
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
				$("#cbPhongHoc option").remove();
				for(i=0; i<n; i++){
					$("#cbPhongHoc").append(
						$('<option>').val(result[i].MaPhong).text(result[i].SoPhong)
					)
				}
			}
		}
	})
	//flag = 5: GIÁO VIÊN
	flag=5;
	$.ajax({
		type:"GET",
		url:"Admin_LoadDuLieuCanThiet",
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
				$("#cbGiaoVien option").remove();
				for(i=0; i<n; i++){
					$("#cbGiaoVien").append(
						$('<option>').val(result[i].MaGV).text(result[i].HoTenGV)
					)
				}
			}
		}
	})
	
	
	
	//flag = 1: KHÓA HỌC
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
				$("#cbKhoaHoc option").remove();
				for(i=0; i<n; i++){
					$("#cbKhoaHoc").append(
						$('<option>').val(result[i].maKhoaHoc).text(result[i].maKhoaHoc)
					)
				}
				//flag = 1: Load ds Lớp học lên combobox theo mã Khóa tương ứng ngay khi vừa load trang
				var maKH = $("#cbKhoaHoc").val();
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
								$("#cbLopHoc").append('<option value='+ result[i].MaLop +'>' + result[i].TenLop + "</option>");
							}
						}
					}
				})
			}
		}
	})
	
})