$(document).ready(function () {
	var flag = 1; //Nhân viên
	$.ajax({
        type: "POST",
        url: "Admin_thongkeDSND",
        data:{
        	flag: flag
        },
        dataType: "json",
        success: function (result) { 
        	
        	if(result.check != null){
				alert(result.check);
				return;
			}
        	if (result.check == "fail") {
            	alert("Hiện chưa có người dùng nào");
            	return;
     	    }
			else{
				var n = Object.keys(result).length;
	              if(n>0){
	            	  
	            	$("#table-ds-nguoi-dung > tbody").children().remove();
	            	var valueTD;
	              	for(i=0; i<n; i++){
	              		if(result[i].GioiTinh == true){
	              			result[i].GioiTinh = "Nữ";
	              		}
	              		else{
	              			result[i].GioiTinh = "Nam";
	              		}
	                	$("#table-ds-nguoi-dung > tbody").append(
	                        $('<tr>').append(
	                            $('<td style="width:50px;">').text(parseInt(i+1))
	                            ).append(
	                            $('<td>').text(result[i].MaND)
	                            ).append(
	                            $('<td>').text(result[i].HoTenND)
	                            ).append(
	                            $('<td>').text(result[i].NgaySinh)
	                            ).append(
	                            $('<td>').text(result[i].CMND)
	                            ).append(
	                            $('<td>').text(result[i].DiaChi)
	                            ).append(
	                            $('<td>').text(result[i].GioiTinh)
	                            ).append(
	                            $('<td>').text(result[i].DienThoai)
	                            ).append(
	                            $('<td>').text(result[i].TenTrinhDoHV)
	                            ).append(
	                            $('<td>').text(result[i].EmailND)
	                            )
	                    );
	              	}
	              }
     	   }
        },
        error: function (jqXHR, exception) {
            if (jqXHR.status == 500)
                alert("Chưa thêm người dùng nào");
        }
    });
	
	$("#btn-thong-ke-danh-sach-nguoi-dung").click(function (e) {
		if($("#chuc-vu").val() == "3"){
			flag = 1; //Nhân viên
			$.ajax({
		        type: "POST",
		        url: "Admin_thongkeDSND",
		        data:{
		        	flag: flag
		        },
		        dataType: "json",
		        success: function (result) { 
		        	
		        	if(result.check != null){
						alert(result.check);
						return;
					}
		        	if (result.check == "fail") {
		            	alert("Hiện chưa có người dùng nào");
		            	return;
		     	    }
					else{
						var n = Object.keys(result).length;
			              if(n>0){
			            	  
			            	$("#table-ds-nguoi-dung > tbody").children().remove();
			            	var valueTD;
			              	for(i=0; i<n; i++){
			              		if(result[i].GioiTinh == true){
			              			result[i].GioiTinh = "nữ";
			              		}
			              		else{
			              			result[i].GioiTinh = "nam";
			              		}
			                	$("#table-ds-nguoi-dung > tbody").append(
			                        $('<tr>').append(
			                            $('<td style="width:50px;">').text(parseInt(i+1))
			                            ).append(
			                            $('<td>').text(result[i].MaND)
			                            ).append(
			                            $('<td>').text(result[i].HoTenND)
			                            ).append(
			                            $('<td>').text(result[i].NgaySinh)
			                            ).append(
			                            $('<td>').text(result[i].CMND)
			                            ).append(
			                            $('<td>').text(result[i].DiaChi)
			                            ).append(
			                            $('<td>').text(result[i].GioiTinh)
			                            ).append(
			                            $('<td>').text(result[i].DienThoai)
			                            ).append(
			                            $('<td>').text(result[i].TenTrinhDoHV)
			                            ).append(
			                            $('<td>').text(result[i].EmailND)
			                            )
			                    );
			              	}
			              }
		     	   }
		        },
		        error: function (jqXHR, exception) {
		            if (jqXHR.status == 500)
		                alert("Chưa thêm người dùng nào");
		        }
		    });
		}
		else{
			flag = 2; //Admin
			$.ajax({
		        type: "POST",
		        url: "Admin_thongkeDSND",
		        data:{
		        	flag: flag
		        },
		        dataType: "json",
		        success: function (result) { 
		        	
		        	if(result.check != null){
						alert(result.check);
						return;
					}
		        	if (result.check == "fail") {
		            	alert("Hiện chưa có người dùng nào");
		            	return;
		     	    }
					else{
						var n = Object.keys(result).length;
			              if(n>0){
			            	  
			            	$("#table-ds-nguoi-dung > tbody").children().remove();
			            	var valueTD;
			              	for(i=0; i<n; i++){
			              		if(result[i].GioiTinh == true){
			              			result[i].GioiTinh = "nữ";
			              		}
			              		else{
			              			result[i].GioiTinh = "nam";
			              		}
			                	$("#table-ds-nguoi-dung > tbody").append(
			                        $('<tr>').append(
			                            $('<td style="width:50px;">').text(parseInt(i+1))
			                            ).append(
			                            $('<td>').text(result[i].MaND)
			                            ).append(
			                            $('<td>').text(result[i].HoTenND)
			                            ).append(
			                            $('<td>').text(result[i].NgaySinh)
			                            ).append(
			                            $('<td>').text(result[i].CMND)
			                            ).append(
			                            $('<td>').text(result[i].DiaChi)
			                            ).append(
			                            $('<td>').text(result[i].GioiTinh)
			                            ).append(
			                            $('<td>').text(result[i].DienThoai)
			                            ).append(
			                            $('<td>').text(result[i].TenTrinhDoHV)
			                            ).append(
			                            $('<td>').text(result[i].EmailND)
			                            )
			                    );
			              	}
			              }
		     	   }
		        },
		        error: function (jqXHR, exception) {
		            if (jqXHR.status == 500)
		                alert("Chưa thêm người dùng nào");
		        }
		    });
		}
		
	});
	
	$("#btn-xuat-file-NguoiDung").click(function(e){
		if($("#chuc-vu").val() == "3")
			flag = 1; //Nhân viên
		else//admin
			flag=2;
		window.location.assign("WriteFileExcelNguoiDung.jsp?flag="+flag);
	})
	
	
});