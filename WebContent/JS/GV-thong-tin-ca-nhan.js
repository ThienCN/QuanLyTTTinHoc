$(document).ready(function() {
	
	$.ajax({
		type : "POST",
		url : "GV_thongtincanhan",
		dataType : "json",
		success : function(result) {
			if (result.check == "fail") {
				alert("no");
				alert("Giáo viên không có thông tin cá nhân");
			} else {
				var date = new Date(result.NgaySinh);
				var dd = date.getDate();
				var mm = date.getMonth() + 1; // January is 0!

				var yyyy = date.getFullYear();
				if (dd < 10) {
					dd = '0' + dd;
				}
				if (mm < 10) {
					mm = '0' + mm;
				}
				$("#MaGV").append(result.MaGV);
				$("#HoTenGV").append(result.HoTenGV);
				$("#NgaySinh").append(dd + '/' + mm + '/' + yyyy);
				$("#CMND").append(result.CMND);
				$("#TDHV").append(result.TenTrinhDoHV);
				$("#SDT").append(result.DienThoai);
				$("#Email").append(result.EmailGV);
				$("#DiaChi").append(result.DiaChi);
			}
		},
		error : function(jqXHR, exception) {
			if (jqXHR.status == 500)
				alert("Khóa học không load được");
		}
	});
	
});