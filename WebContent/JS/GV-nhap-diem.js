//$(function () {
//    $("#text_diem").focusout(function () {
//        check_diem();
//    });

//    function check_diem() {
//        var diem = $("#form_username").val().length;

//        if (username_length < 5 || username_length > 20) {
//            $("#username_error_message").html(
//                "Should be between 5-20 characters");
//            $("#username_error_message").show();
//            error_username = true;
//        } else {
//            $("#username_error_message").hide();
//            error_username = false;
//        }
//    }
//});

$(document).ready(function () {
    $("#text_diem").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110, 190]) !== -1 ||
            // Allow: Ctrl+A, Command+A
            (e.keyCode === 65 && (e.ctrlKey === true || e.metaKey === true)) ||
            // Allow: home, end, left, right, down, up
            (e.keyCode >= 35 && e.keyCode <= 40)) {
            // let it happen, don't do anything
            return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
        }
    });
    
    $.ajax({
        type: "POST",
        url: "GV_posttailieu",
        dataType: "json",
        success: function (result) { 
     	   if (result.check == "fail") {
            	alert("Giáo viên không có lớp giảng dạy trong khóa này");
     	   }
     	   else{
     		  var n = Object.keys(result).length;
              if(n>0){
            	  
            	$("#table-danh-sach-lop-hoc > tbody").children().remove();
              	for(i=0; i<n; i++){
                	
                	$("#table-danh-sach-lop-hoc > tbody").append(
                        $('<tr>').append(
                            $('<td>').text(result[i].MaLop)
                            ).append(
                            $('<td>').text(result[i].TenLop)
                            ).append(
                            $('<td>').text("Thứ " + result[i].BuoiHoc+" ("+result[i].GioBatDau+" - "+result[i].GioKetThuc+")")
                            ).append(
                            $('<td>').text(result[i].SoHV)
                            ).append(
                            $('<td>').text(result[i].SoPhong)
                            ).append(
                                $('<td>').append(
                             		   $('<a href="GV_nhapdiemchitiet" style="text-decoration: none">').text("Nhập điểm")
                             		   		.css('cursor', 'pointer')
                        		   			.click(function(e){
                        		   				e.preventDefault();
                        		   				var MaLop = $(this).closest('tr').find('td:nth-child(1)').text();
                        		   				window.location.assign("GV_nhapdiemchitiet?MaLop="+MaLop);
                        		   				
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
                alert("Không load được các lớp đang giảng dạy");
        }
    });
});