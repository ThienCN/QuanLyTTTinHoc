$(document).ready(function () {
	$.ajax({
        type: "POST",
        url: "GV_posttailieu",
        dataType: "json",
        success: function (result) { 
     	   if (result.check == "fail") {
            	alert("Giáo viên không có lịch giảng dạy trong khóa này");
     	   }
     	   else{
     		  var n = Object.keys(result).length;
              if(n>0){
            	  
            	$("#table-danh-sach-giang-day > tbody").children().remove();
              	for(i=0; i<n; i++){
                	$("#table-danh-sach-giang-day > tbody").append(
                        $('<tr>').append(
                            $('<td>').text(result[i].MaLop)
                            ).append(
                            $('<td>').text(result[i].TenLop)
                            ).append(
                            $('<td>').text("Thứ " + result[i].BuoiHoc+" ("+result[i].GioBatDau+" - "+result[i].GioKetThuc+")")
                            ).append(
                            $('<td>').text(result[i].SoPhong)
                            ).append(
                                $('<td>').append(
                             		   $('<a href="GV_posttailieuchitiet" style="text-decoration: none">').text("Thêm tài liệu")
                             		   		.css('cursor', 'pointer')
                             		   		.click(function(e){
                        		   				e.preventDefault();
                        		   				var MaLop = $(this).closest('tr').find('td:nth-child(1)').text();
                        		   				window.location.assign("GV_posttailieuchitiet?MaLop="+MaLop);
                        		   				
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
                alert("Không load được lịch giảng dạy");
        }
    });
});