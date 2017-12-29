$(document).ready(function () {
	//flag=1: Load mã Giáo viên mới lên
	var flag=1;
	$.ajax({
		type:"POST",
		url:"Admin_themgiaovien",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			$("#maGiaoVien").val(result.maGVMoi);
			$("#tenTaiKhoan").val(result.maGVMoi);
		}
	})
	
	//flag=2: Load ds Trình độ học vấn
	flag=2;
	$.ajax({
		type:"POST",
		url:"Admin_themgiaovien",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == null){
				var n = Object.keys(result).length;
				for(i=0; i<n; i++){
					$("#cbTrinhDoHocVan").append(
							$('<option>').val(result[i].MaTrinhDoHV).text(result[i].TenTrinhDoHV)
						)
				}
			}
		}
	})
	
	
    var error_hoTen = true;
    var error_CMND = true;
    var error_diaChi = true;
    var error_SDT = true;
    var error_email = true;
    

    $("#hoTen").focusout(function () {
        var hoTen = $("#hoTen").val().trim();
        if (hoTen.length <= 0) {
            $("#error-hoTen").html(" Mời bạn nhập họ tên giáo viên");
            $("#error-hoTen").show();
            error_hoTen = true;
        }
        else {
            $("#error-hoTen").hide();
            error_hoTen = false;
        }
    });

    $("#CMND").focusout(function () {
        var CMND = $("#CMND").val().trim();
        if (CMND.length <= 0) {
            $("#error-CMND").html(" Mời bạn nhập số CMND giáo viên");
            $("#error-CMND").show();
            error_CMND = true;
        }
        else {
            $("#error-CMND").hide();
            error_CMND = false;
            $("#matKhau").val($("#CMND").val().trim());
        }
    });

    $("#diaChi").focusout(function () {
        var diaChi = $("#diaChi").val().trim();
        if (diaChi.length <= 0) {
            $("#error-diaChi").html(" Mời bạn nhập địa chỉ của giáo viên");
            $("#error-diaChi").show();
            error_diaChi = true;
        }
        else {
            $("#error-diaChi").hide();
            error_diaChi = false;
        }
    });

    $("#SDT").focusout(function () {
        var SDT = $("#SDT").val().trim();
        if (SDT.length <= 0) {
            $("#error-SDT").html(" Mời bạn nhập số điện thoại của giáo viên");
            $("#error-SDT").show();
            error_SDT = true;
        }
        else {
            $("#error-SDT").hide();
            error_SDT = false;
        }
    });
    
    $("#email").focusout(function () {
        var email = $("#email").val().trim();
        if (email.length <= 0) {
            $("#error-email").html(" Mời bạn nhập email của giáo viên");
            $("#error-email").show();
            error_email = true;
        }
        else {
            $("#error-email").hide();
            error_email = false;
        }
    });



    $("#btn-them-giao-vien").click(function (e) {
        if (error_hoTen == true || error_diaChi == true || error_CMND == true
            && error_email == true || error_SDT == true) {
        	if ($("#hoTen").val().trim().length <= 0) {
                $("#error-hoTen").html(" Mời bạn nhập họ tên giáo viên");
                $("#error-hoTen").show();
                error_hoTen = true;
            }
            if ($("#CMND").val().trim().length <= 0) {
                $("#error-CMND").html(" Mời bạn nhập số CMND giáo viên");
                $("#error-CMND").show();
                error_CMND = true;
            }
            if ($("#diaChi").val().trim().length <= 0) {
                $("#error-diaChi").html(" Mời bạn nhập địa chỉ của giáo viên");
                $("#error-diaChi").show();
                error_diaChi = true;
            }
            if ($("#SDT").val().trim().length <= 0) {
                $("#error-SDT").html(" Mời bạn nhập số điện thoại của giáo viên");
                $("#error-SDT").show();
                error_SDT = true;
            }
            if ($("#email").val().trim().length <= 0) {
                $("#error-email").html(" Mời bạn nhập email của giáo viên");
                $("#error-email").show();
                error_email = true;
            }

            alert("Mời bạn nhập đầy đủ thông tin!");
            return;
        }
        else{
        	var hoTen = $("#hoTen").val().trim();
        	var CMND = $("#CMND").val().trim();
        	var ngaySinh = $("#ngaySinh").val();
        	var diaChi = $("#diaChi").val().trim();
        	var SDT = $("#SDT").val().trim();
        	var gioiTinh = $("#cbGioiTinh").val();
        	var trinhDoHV = $("#cbTrinhDoHocVan").val();
        	var email = $("#email").val().trim();
        	
        	//flag=3: Thêm 1 giáo viên mới
        	flag=3;
        	$.ajax({
        		type:"POST",
        		url:"Admin_themgiaovien",
        		data:{
        			flag:flag,
        			hoTen:hoTen,
        			CMND:CMND,
        			ngaySinh:ngaySinh,
        			diaChi:diaChi,
        			SDT:SDT,
        			gioiTinh:gioiTinh,
        			trinhDoHV:trinhDoHV,
        			email:email
        		},
        		dataType:"json",
        		success:function(result){
        			if(result.maGVMoi != null){
        				alert("Thêm giáo viên mới thành công!\rMã giáo viên mới là: "+ result.maGVMoi);
        				window.location.assign("admin");
        				return;
        			}
        			if(result.check == "fail"){
        				alert("Server bận!");
        				return;
        			}
        		}
        	})
        }
    });
});