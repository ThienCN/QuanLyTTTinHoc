$(document).ready(function() {
	var tuan = 0;
	var flag = false;
	var nam = 0;
	var thang = 0;
	
	$.ajax({
		type : "GET",
		url : "khoahoc",
		dataType : "json",
		success : function(result) {
			if (result.check == "fail") {
				alert("Không load được khóa học");
			} else {
				var n = Object.keys(result).length;
				if(n>0){
					for(i=0; i<n; i++){
						$("#khoahoc").append('<option value="'+result[i].NgayKhaiGiang+'">' + result[i].MaKH + "</option>");
					}
				}
				
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
				$("#ngaykhaigiang").text(dd + '/' + mm + '/' + yyyy);
				
				$("#khoahoc option:selected").each(function() {
					$.ajax({
						type : "POST",
						url : "HV_xemdiem",
						dataType : "json",
						success : function(result) {
							if(result.check == "fail"){
								alert("Chưa có thông tin điểm số");
							}
							else{
								var hinh, color;
								var n = Object.keys(result).length;
					            if(n>0){
					            	$("#table-diem > tbody").children().remove();
					            	for(i=0; i<n; i++){
					            		DiemTB = (result[i].DiemTH + result[i].DiemLT)/2;
					            		if(result[i].ChungChi == undefined || result[i].ChungChi == null){
					            			if(result[i].DiemLT == 0){
						            			result[i].DiemLT = "";
						            			DiemTB = "";
						            			hinh = "";
						            			color = "";
					            			}
					            			if(result[i].DiemTH == 0){
						            			result[i].DiemTH = "";
						            			DiemTB = "";
						            			hinh = "";
						            			color = "";
					            			}
					            		}
					            		if(result[i].ChungChi == "Đậu"){
					            			hinh = "fa fa-check";
					            			color = "green";
					            		}
					            		if(result[i].ChungChi == "Rớt"){
					            			hinh = "fa fa-times";
					            			color = "red";
					            		}
					                	$("#table-diem > tbody").append(
					                        $('<tr>').append(
					                        	$('<td>').text(parseInt(i+1))
				                            	).append(
					                            $('<td>').text(result[i].MaLop)
					                            ).append(
					                            $('<td>').text(result[i].TenLop)
					                            ).append(
					                            $('<td>').text(result[i].DiemLT)
					                            ).append(
					                            $('<td>').text(result[i].DiemTH)
					                            ).append(
					                            $('<td>').text(DiemTB)
					                            ).append(
					                            $('<td class="'+hinh+'" style="text-align:center;display: table-cell;color:'+color+'">')
					                            )
					                    );
					              	}
					            }
							}
							
						},
						error : function(jqXHR, exception) {
							if (jqXHR.status == 500)
								alert("Không xem được điểm rồi");
						}
					});
				});
			}
		},
		error : function(jqXHR, exception) {
			if (jqXHR.status == 500)
				alert("Khóa học không load được");
		}
	});
	
	$("#khoahoc").change(function() {
		$("#khoahoc option:selected").each(function() {
			$.ajax({
				type : "POST",
				url : "HV_xemdiem",
				dataType : "json",
				success : function(result) {
					if(result.check == "fail"){
						alert("Chưa có thông tin điểm số");
					}
					else{
						var hinh, color;
						var n = Object.keys(result).length;
			            if(n>0){
			            	$("#table-diem > tbody").children().remove();
			            	for(i=0; i<n; i++){
			            		DiemTB = (result[i].DiemTH + result[i].DiemLT)/2;
			            		if(result[i].ChungChi == undefined || result[i].ChungChi == null){
			            			if(result[i].DiemLT == 0){
				            			result[i].DiemLT = "";
				            			DiemTB = "";
				            			hinh = "";
				            			color = "";
			            			}
			            			if(result[i].DiemTH == 0){
				            			result[i].DiemTH = "";
				            			DiemTB = "";
				            			hinh = "";
				            			color = "";
			            			}
			            		}
			            		
			            		if(result[i].ChungChi == "Đậu"){
			            			hinh = "fa fa-check";
			            			color = "green";
			            		}
			            		if(result[i].ChungChi == "Rớt"){
			            			hinh = "fa fa-times";
			            			color = "red";
			            		}
			                	$("#table-diem > tbody").append(
			                        $('<tr>').append(
			                        	$('<td>').text(parseInt(i+1))
		                            	).append(
			                            $('<td>').text(result[i].MaLop)
			                            ).append(
			                            $('<td>').text(result[i].TenLop)
			                            ).append(
			                            $('<td>').text(result[i].DiemLT)
			                            ).append(
			                            $('<td>').text(result[i].DiemTH)
			                            ).append(
			                            $('<td>').text(DiemTB)
			                            ).append(
			                            $('<td class="'+hinh+'" style="text-align:center;display: table-cell;color:'+color+'">')
			                            )
			                    );
			              	}
			            }
					}
					
				},
				error : function(jqXHR, exception) {
					if (jqXHR.status == 500)
						alert("Không xem được điểm rồi");
				}
			});
		});
	}).trigger("change");
	
});