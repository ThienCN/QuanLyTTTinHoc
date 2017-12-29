$(document).ready(function() {
		$.ajax({
			type : "POST",
			url : "HV_xemdiem",
			dataType : "json",
			success : function(result) {
				if(result.check == "fail"){
					alert("Học viên chưa đăng ký lớp học");
				}
				else{
					var n = Object.keys(result).length;
		            if(n>0){
		            	$("section").children().remove();
		            	for(i=0; i<n; i++){
		                	$("section").append(
		                        $('<h1 class="mon-hoc">').append(
		                        	$('<a href="HV_caclopdangtheohocchitiet?MaLop='+result[i].MaLop + '" style="text-decoration:none">').text(result[i].TenLop)
	                            	)
		                    );
		              	}
		            }
				}
				
			},
			error : function(jqXHR, exception) {
				if (jqXHR.status == 500)
					alert("Không xem được lớp học");
			}
		});

});