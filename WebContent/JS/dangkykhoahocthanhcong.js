$(document).ready(function () {
	var tongtien = 0;
	$.ajax({
        type: "POST",
        url: "dangkykhoahocthanhcong",
        dataType: "json",
        success: function (result) { 
     	   if (result.check == "fail") {
            	alert("Không load được danh sách lớp học");
     	   }
     	   else{
     		  var n = Object.keys(result).length;
              if(n>0){
            	  $("#table-dang-ky-thanh-cong > tbody").children().remove();
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
    				tongtien += parseFloat(result[i].SoTien);
                	$("#table-dang-ky-thanh-cong > tbody").append(
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
                            )
                    );
              	}
              }
              $("#tongtien").text(" "+tongtien+" VND");
     	   }
        },
        error: function (jqXHR, exception) {
            if (jqXHR.status == 500)
                alert("Danh sách lớp học không load được");
        }
    });
	
});