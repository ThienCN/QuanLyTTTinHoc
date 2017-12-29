$(document).ready(function () {
	
	$.ajax({
        type: "POST",
        url: "lichkhaigiang",
        dataType: "json",
        success: function (result) { 
     	   if (result.check == "fail") {
            	alert("Khóa học chưa có lịch khai giảng");
     	   }
     	   else{
     		  var date = new Date(result[0].NgayKhaiGiang);
				var dd = date.getDate();
				var mm = date.getMonth() + 1; // January is 0!
	
				var yyyy = date.getFullYear();
				if (dd < 10) {
					dd = '0' + dd;
				}
				if (mm < 10) {
					mm = '0' + mm;
				}
				
     		  $("#khoa").text("Khóa "+result[0].MaKH+" - Ngày bắt đầu "+ dd + '/' + mm + '/' + yyyy);
     		  var n = Object.keys(result).length;
              if(n>0){
            	  $("#table-lich-khai-giang > tbody").children().remove();
              	for(i=0; i<n; i++){
              		var date = new Date(result[i].NgayBatDau);
    				var dd = date.getDate();
    				var mm = date.getMonth() + 1; // January is 0!
    	
    				var yyyy = date.getFullYear();
    				if (dd < 10) {
    					dd = '0' + dd;
    				}
    				if (mm < 10) {
    					mm = '0' + mm;
    				}
    				
                	$("#table-lich-khai-giang > tbody").append(
                        $('<tr>').append(
                            $('<td class="bo">').text(result[i].MaLop)
                            ).append(
                            $('<td class="bo">').text(result[i].TenLop)
                            ).append(
                            $('<td class="bo">').text(result[i].BuoiHoc+" ("+result[i].GioBatDau+" - "+result[i].GioKetThuc+")")
                            ).append(
                            $('<td class="bo">').text(result[i].SoBuoi)
                            ).append(
                            $('<td class="bo">').text(result[i].SoTien)
                            ).append(
                            $('<td class="bo">').text(dd + '/' + mm + '/' + yyyy)
                            ).append(
                            $('<td class="bo">').text("Phòng "+result[i].SoPhong)
                            ).append(
                                    $('<td class="bo" style="text-align:center">').append(
                                 		   $('<a class="nganh-dang-ky-hoc w3-round" style="text-decoration: none">').text("Đăng ký")
                                 		   		.css('cursor', 'pointer')
                             		   			.click(function(e){
	                        		   				e.preventDefault();
	                        		   				var MaLop = $(this).closest('tr').find('td:nth-child(1)').text();
	                        		   				window.location.assign("dangkykhoahoc?MaLop="+MaLop);
                             		   			})
                                    	   		)
                                    )
                    );
              	}
              }
     	   }
        },
        error: function (jqXHR, exception) {
            if (jqXHR.status == 500)
                alert("Lịch khai giảng không load được");
        }
    });
	
});