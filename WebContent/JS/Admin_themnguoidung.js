$(document).ready(function () {
	
	//flag=1: Load mã Nhân viên mới lên
	var flag=1;
	$.ajax({
		type:"POST",
		url:"Admin_themnguoidung",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			$("#maNguoiDung").val(result.maNVMoi);
			$("#tenTaiKhoan").val(result.maNVMoi);
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
	});
	
	//Sự kiện thay đổi option của select Chức danh
	
	$("#cbChucDanh").change(function(e){
		var chucDanh = $("#cbChucDanh").val();
		//3: Nhân viên
		//4: Quản trị viên
		
		if(chucDanh == 3){
			//flag=1: Load mã Nhân viên mới lên
			flag=1;
			$.ajax({
				type:"POST",
				url:"Admin_themnguoidung",
				data:{
					flag:flag
				},
				dataType:"json",
				success:function(result){
					$("#maNguoiDung").val(result.maNVMoi);
					$("#tenTaiKhoan").val(result.maNVMoi);
					$("#quyenTruyCap").val("Nhân viên");
				}
			})
		}
		
		if(chucDanh == 4){
			//flag=2: Load mã Quản trị viên mới lên
			flag=2;
			$.ajax({
				type:"POST",
				url:"Admin_themnguoidung",
				data:{
					flag:flag
				},
				dataType:"json",
				success:function(result){
					$("#maNguoiDung").val(result.maAdminMoi);
					$("#tenTaiKhoan").val(result.maAdminMoi);
					$("#quyenTruyCap").val("Quản trị viên");
				}
			})
		}
		
	});
	
    var error_hoTen = true;
    var error_CMND = true;
    var error_diaChi = true;
    var error_SDT = true;
    var error_email = true;

    $("#hoTen").focusout(function () {
        if ($("#hoTen").val().trim().length <= 0) {
            $("#error-hoTen").html(" Mời bạn nhập họ tên người dùng");
            $("#error-hoTen").show();
            error_hoTen = true;
        }
        else {
            $("#error-hoTen").hide();
            error_hoTen = false;
        }
    });

    $("#CMND").focusout(function () {
        if ($("#CMND").val().trim().length <= 0) {
            $("#error-CMND").html(" Mời bạn nhập số CMND người dùng");
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
        if ($("#diaChi").val().trim().length <= 0) {
            $("#error-diaChi").html(" Mời bạn nhập địa chỉ của người dùng");
            $("#error-diaChi").show();
            error_diaChi = true;
        }
        else {
            $("#error-diaChi").hide();
            error_diaChi = false;
        }
    });

    $("#SDT").focusout(function () {
        if ($("#SDT").val().trim().length <= 0) {
            $("#error-SDT").html(" Mời bạn nhập số điện thoại của người dùng");
            $("#error-SDT").show();
            error_SDT = true;
        }
        else {
            $("#error-SDT").hide();
            error_SDT = false;
        }
    });

    $("#email").focusout(function () {
        if ($("#email").val().trim().length <= 0) {
            $("#error-email").html(" Mời bạn nhập email của người dùng");
            $("#error-email").show();
            error_email = true;
        }
        else {
            $("#error-email").hide();
            error_email = false;
        }
    });
    
    
    $("#btn-them-nguoi-dung").click(function(){
    	if (error_hoTen == true || error_diaChi == true || error_CMND == true
                && error_email == true || error_SDT == true) {
    		if ($("#hoTen").val().trim().length <= 0) {
                $("#error-hoTen").html(" Mời bạn nhập họ tên người dùng");
                $("#error-hoTen").show();
                error_hoTen = true;
            }
            if ($("#CMND").val().trim().length <= 0) {
                $("#error-CMND").html(" Mời bạn nhập số CMND người dùng");
                $("#error-CMND").show();
                error_CMND = true;
            }
            if ($("#diaChi").val().trim().length <= 0) {
                $("#error-diaChi").html(" Mời bạn nhập địa chỉ của người dùng");
                $("#error-diaChi").show();
                error_diaChi = true;
            }
            if ($("#SDT").val().trim().length <= 0) {
                $("#error-SDT").html(" Mời bạn nhập số điện thoại của người dùng");
                $("#error-SDT").show();
                error_SDT = true;
            }
            if ($("#email").val().trim().length <= 0) {
                $("#error-email").html(" Mời bạn nhập email của người dùng");
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
    		
    		var chucDanh = $("#cbChucDanh").val();
    		//3: Nhân viên
    		//4: Quản trị viên
    		
    		//flag=3: Thêm người dùng
    		flag=3;
    		$.ajax({
    			type:"POST",
    			url:"Admin_themnguoidung",
    			data:{
    				flag:flag,
    				hoTen:hoTen,
    				CMND:CMND,
    				ngaySinh:ngaySinh,
    				diaChi:diaChi,
    				SDT:SDT,
    				gioiTinh:gioiTinh,
    				trinhDoHV:trinhDoHV,
    				email:email,
    				chucDanh:chucDanh
    			},
    			dataType:"json",
    			success:function(result){
    				if(result.maNDMoi != null){
    					alert("Thêm người dùng mới thành công!\rMã người dùng mới là: " + result.maNDMoi);
    				}
    				if(result.check == "fail"){
    					alert("Thêm người dùng mới không thành công!");
    				}
    				window.location.assign("admin");
    				return;
    			}
    		})
    		
    	}
    })
})