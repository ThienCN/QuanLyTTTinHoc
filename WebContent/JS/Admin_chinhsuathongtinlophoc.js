$(document).ready(function(){
	$("#thong-tin-lop-hoc").css("display","none");
	$("#thong-tin-chinh-sua-lop-hoc").css("display","none");
	
	var error_maLop = false;
	var error_tenLop = false;
    var error_soHV = false;
    var error_soBuoi = false;
    
    $("#maLopHoc").focusout(function (e) {
        if ($("#maLopHoc").val().trim().length <= 0) {
            $("#error-maLop").html("Mời bạn nhập mã lớp");
            $("#error-maLop").show();
            error_maLop = true;
        }
        else {
            $("#error-maLop").hide();
            error_maLop = false;
        }
    })
    
    $("#tenLop").focusout(function (e) {
        if ($("#tenLop").val().trim().length <= 0) {
            $("#error-tenLop").html("Mời bạn nhập mã lớp");
            $("#error-tenLop").show();
            error_tenLop = true;
        }
        else {
            $("#error-tenLop").hide();
            error_tenLop = false;
        }
    })
    $("#soHV").focusout(function (e) {
        if ($("#soHV").val().trim().length <= 0) {
            $("#error-soHV").html("Mời bạn nhập mã lớp");
            $("#error-soHV").show();
            error_soHV = true;
        }
        else {
            $("#error-soHV").hide();
            error_soHV = false;
        }
    })
    $("#soBuoi").focusout(function (e) {
        if ($("#soBuoi").val().trim().length <= 0) {
            $("#error-soBuoi").html("Mời bạn nhập mã lớp");
            $("#error-soBuoi").show();
            error_soBuoi = true;
        }
        else {
            $("#error-soBuoi").hide();
            error_soBuoi = false;
        }
    })
	
    var flag;
    
	$("#cbKhoaHoc").change(function(e){
		maKH = $("#cbKhoaHoc").val();
		$("#cbLopHoc option").remove();
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
						$("#cbLopHoc").append(
							$('<option>').val(result[i].MaLop).text(result[i].TenLop)
						)
					}
				}
			}
		})
	});
	
	
	$("#btn-tim-kiem-lop-hoc").click(function(e){
		var maLopHoc = $("#cbLopHoc").val();
		
		$("#table-lop-hoc > tbody").children().remove();
		
		//flag=1: Lấy mã lớp học đi tìm kiếm thông tin lớp học
		var flag=1;
		$.ajax({
			type:"POST",
			url:"Admin_chinhsuathongtinlophoc",
			data:{
				flag:flag,
				maLopHoc:maLopHoc
			},
			dataType:"json",
			success:function(result){
				$("#maLopHoc").val(result[0].MaLop);
				$("#tenLop").val(result[0].TenLop);
				$("#soHV").val(result[0].SoHV);
				$("#soBuoi").val(result[0].SoBuoi);
				
				$("#cbHocPhi option").each(function () {
				        if ($(this).html() == result[0].HocPhi) {
				            $(this).attr("selected", "selected");
				            return;
				        }
				});
				
				$("#ngayBatDau").val(result[0].NgayBatDau);
				$("#ngayKetThuc").val(result[0].NgayKetThuc);
				
				$("#cbBuoiHoc option").each(function () {
				        if ($(this).html() == result[0].BuoiHoc) {
				            $(this).attr("selected", "selected");
				            return;
				        }
				});
				
				$("#cbGioHoc option").each(function () {
				        if ($(this).html() == result[0].GioHoc) {
				            $(this).attr("selected", "selected");
				            return;
				        }
				});
				
				$("#cbPhongHoc option").each(function () {
				        if ($(this).html() == result[0].SoPhong) {
				            $(this).attr("selected", "selected");
				            return;
				        }
				});
				
				$("#cbGiaoVien option").each(function () {
				        if ($(this).html() == result[0].GiaoVienGiangDay) {
				            $(this).attr("selected", "selected");
				            return;
				        }
				});
				
				$("#cbTinhTrang option").each(function () {
				        if ($(this).html() == result[0].TinhTrang) {
				            $(this).attr("selected", "selected");
				            return;
				        }
				});
				
				
				if(result[0].TinhTrang == 1){
					tinhTrang = "Mở";
					color="blue";
				}
				else if(result[0].TinhTrang == 2){
					tinhTrang = "Khóa";
					color="red";
				}
				else if(result[0].TinhTrang == 0){
					tinhTrang = "Đóng";
					color="red";
				}
				
				$("#table-lop-hoc > tbody").append(
					$('<tr>').append(
							$('<td>').text(result[0].MaLop)	
							).append(
							$('<td>').text(result[0].TenLop)	
							).append(
							$('<td>').text(result[0].SoHV)	
							).append(
							$('<td>').text(result[0].SoBuoi)	
							).append(
							$('<td>').text(result[0].NgayBatDau)	
							).append(
							$('<td>').text(result[0].NgayKetThuc)	
							).append(
							$('<td>').text(result[0].GiaoVienGiangDay)	
							).append(
							$('<td>').text(result[0].SoPhong)	
							).append(
							$('<td>').text(result[0].BuoiHoc)	
							).append(
							$('<td>').text(result[0].GioHoc)	
							).append(
							$('<td>').text(result[0].HocPhi)	
							).append(
							$('<td style="color: '+ color +'">').text(tinhTrang)	
					)
				)
				$("#thong-tin-lop-hoc").css("display","block");
				$("#thong-tin-chinh-sua-lop-hoc").css("display","block");
			}
		})
	})
	
	$("#huy-cap-nhat-lop-hoc").click(function(e){
		$("#thong-tin-lop-hoc").css("display","none");
		$("#thong-tin-chinh-sua-lop-hoc").css("display","none");
	})
	
	$("#cap-nhat-lop-hoc").click(function(e){
		
		if(error_tenLop == true || error_soHV == true || error_soBuoi == true || error_maLop == true){
			if ($("#tenLop").val().trim().length <= 0) {
	            $("#error-tenLop").html("Mời bạn nhập mã lớp");
	            $("#error-tenLop").show();
	            error_tenLop = true;
	        }
			if ($("#soHV").val().trim().length <= 0) {
	            $("#error-soHV").html("Mời bạn nhập mã lớp");
	            $("#error-soHV").show();
	            error_soHV = true;
	        }
			if ($("#soBuoi").val().trim().length <= 0) {
	            $("#error-soBuoi").html("Mời bạn nhập mã lớp");
	            $("#error-soBuoi").show();
	            error_soBuoi = true;
	        }
			alert("Mời bạn nhập đầy đủ thông tin!");
			return;
		}
		
		
		var maLopHocMoi = $("#maLopHoc").val().trim();
		var tenLopHocMoi =$("#tenLop").val().trim();
		var soHVMoi = $("#soHV").val().trim();
		var soBuoiHocMoi = $("#soBuoi").val().trim();
		var hocPhiMoi =	$("#cbHocPhi").val();
		var ngayBatDauMoi =	$("#ngayBatDau").val();
		var buoiHocMoi = $("#cbBuoiHoc").val();
		var gioHocMoi =	$("#cbGioHoc").val();
		var ngayKetThucMoi = $("#ngayKetThuc").val();
		var phongHocMoi = $("#cbPhongHoc").val();
		var giaoVienMoi = $("#cbGiaoVien").val();
		var tinhTrangMoi = $("#cbTinhTrang").val();
		
		var maLopHocCu = $("#table-lop-hoc > tbody").find("> tr:first").find('td:nth-child(1)').text();
		
		//flag=2: Cập nhật lớp học mới
		flag=2;
		$.ajax({
			type:"POST",
			url:"Admin_chinhsuathongtinlophoc",
			data:{
				flag:flag,
				maLopHocMoi:maLopHocMoi,
				tenLopHocMoi:tenLopHocMoi,
				soHVMoi:soHVMoi,
				soBuoiHocMoi:soBuoiHocMoi,
				hocPhiMoi:hocPhiMoi,
				ngayBatDauMoi:ngayBatDauMoi,
				buoiHocMoi:buoiHocMoi,
				gioHocMoi:gioHocMoi,
				ngayKetThucMoi:ngayKetThucMoi,
				phongHocMoi:phongHocMoi,
				giaoVienMoi:giaoVienMoi,
				tinhTrangMoi:tinhTrangMoi,
				maLopHocCu:maLopHocCu
			},
			dataType:"json",
			success:function(result){
				if(result.check == "ok"){
					alert("Cập nhật thông tin lớp học thành công!");
					window.location.assign('Admin_chinhsuathongtinlophoc');
					return;
				}
				else{
					$("#error-maLop").html("Mời bạn nhập mã lớp mới");
		            $("#error-maLop").show();
		            error_maLop = true;
					alert("Mã lớp học mới không hợp lệ!\rMời bạn nhập mã lớp học mới!");
					return;
				}
				
			}
		})
	})
})