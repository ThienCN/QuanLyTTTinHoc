$(document).ready(function(){
	$("#table-ds-lop-hoc > tbody").children().remove();
	var flag;
	
	var error_maLop = true;
    var error_tenLop = true;
    var error_soHV = true;
    var error_soBuoi = true;

    $("#maLop").focusout(function (e) {
        if ($("#maLop").val().trim().length <= 0) {
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
    
    $("#them-lop-hoc").click(function (e) {
        if ($("#maLop").val().trim().length <= 0) {
            $("#error-maLop").html("Mời bạn nhập mã lớp");
            $("#error-maLop").show();
            error_maLop = true;
        }
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

        if (error_maLop == true || error_tenLop == true || error_soHV == true || error_soBuoi == true) {
            alert("Mời bạn nhập đầy đủ thông tin!"); 
            return;
        }
        else{
        	
        	var MaLop = $("#maLop").val().trim();
        	var TenLop = $("#tenLop").val().trim();
        	var SoHV = $("#soHV").val().trim();
        	var SoBuoi = $("#soBuoi").val().trim();
        	var HocPhi = $("#cbHocPhi").val();
        	var NgayBatDau = $("#ngayBatDau").val();
        	var NgayKetThuc = $("#ngayKetThuc").val();
        	var BuoiHoc = $("#cbBuoiHoc").val();
        	var GioHoc = $("#cbGioHoc").val();
        	var PhongHoc = $("#cbPhongHoc").val();
        	var GiaoVien = $("#cbGiaoVien").val();
        	var KhoaHoc = $("#cbKhoaHoc").val();
        	
        	$.ajax({
        		type:"POST",
        		url:"Admin_themlophocmoi",
        		data:{
        			MaLop:MaLop,
        			TenLop:TenLop,
        			SoHV:SoHV,
        			SoBuoi:SoBuoi,
        			HocPhi:HocPhi,
        			NgayBatDau:NgayBatDau,
        			NgayKetThuc:NgayKetThuc,
        			BuoiHoc:BuoiHoc,
        			GioHoc:GioHoc,
        			PhongHoc:PhongHoc,
        			GiaoVien:GiaoVien,
        			KhoaHoc:KhoaHoc
        		},
        		dataType:"json",
        		success:function(result){
        			if(result.check == "fail"){
        				alert("Mã lớp học không hợp lệ!\rMời bạn nhập lại!");
        				$("#error-maLop").html("Mời bạn nhập mã lớp mới");
        	            $("#error-maLop").show();
        	            error_maLop = true;
        				return;
        			}
        			else{
        				alert("Thêm lớp học thành công!");
        				$("#maLop").val("");
        	        	$("#tenLop").val("");
        	        	$("#soHV").val("");
        	        	$("#soBuoi").val("");
        	        	
        				$("#table-ds-lop-hoc > tbody").append(
        					$('<tr>').append(
        						$('<td>').text(KhoaHoc)	
        						).append(
        						$('<td>').text(MaLop)	
        						).append(
        						$('<td>').text(TenLop)	
        						).append(
        						$('<td>').text(SoHV)	
        						).append(
        						$('<td>').text(SoBuoi)	
        						).append(
        						$('<td>').text(NgayBatDau)	
        						).append(
        						$('<td>').text(NgayKetThuc)	
        						).append(
        						$('<td>').text($("#cbGiaoVien option:selected").text())	
        						).append(
        						$('<td>').text($("#cbPhongHoc option:selected").text())	
        						).append(
        						$('<td>').text($("#cbBuoiHoc option:selected").text())	
        						).append(
        						$('<td>').text($("#cbGioHoc option:selected").text())	
        						).append(
        						$('<td>').text($("#cbHocPhi option:selected").text())	
        						)
        				)
        				return;
        			}
        		}
        	})
        }
    });
})