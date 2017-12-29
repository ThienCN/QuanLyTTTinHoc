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
				for(i=0; i<9; i++){
					$("#tuan").append('<option>' + parseInt(i+1) + "</option>");
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
				
				nam = result[0].Nam;
				thang = result[0].Thang;
				
				$("#tuan option:selected").each(function() {
					tuan = $(this).val();
					
					var firstDateOfMonth = new Date(nam, thang-1, 1); // Date:year-month-01

					var firstDayOfMonth = firstDateOfMonth.getDay() - 1; // 0 (Sun) to 6 (Sat)

					var firstDateOfWeek = new Date(firstDateOfMonth); // copy firstDateOfMonth

					firstDateOfWeek.setDate( // move the Date object
					firstDateOfWeek.getDate() + // forward by the number of
					(firstDayOfMonth ? 7 - firstDayOfMonth : 0) // days needed to go to
					); // Sunday, if necessary

					firstDateOfWeek.setDate( // move the Date object
					firstDateOfWeek.getDate() + // forward by the number of
					7 * (tuan - 1) // weeks required (week - 1)
					);

					var dateNumbersOfMonthOnWeek = []; // output array of date #s
					var datesOfMonthOnWeek = []; // output array of Dates

					for (var i = 0; i < 7; i++) { // for seven days...

						dateNumbersOfMonthOnWeek.push( // push the date number on
						firstDateOfWeek.getDate()); // the end of the array

						datesOfMonthOnWeek.push( // push the date object on
						new Date(+firstDateOfWeek)); // the end of the array

						firstDateOfWeek.setDate(firstDateOfWeek.getDate() + 1); // move to the next day
					}
					var dd = datesOfMonthOnWeek[0].getDate();
					var mm = datesOfMonthOnWeek[0].getMonth() + 1; // January is 0!

					var yyyy = datesOfMonthOnWeek[0].getFullYear();
					if (dd < 10) {
						dd = '0' + dd;
					}
					if (mm < 10) {
						mm = '0' + mm;
					}
					var today = dd + '/' + mm + '/' + yyyy;

					var dd1 = datesOfMonthOnWeek[6].getDate();
					var mm1 = datesOfMonthOnWeek[6].getMonth() + 1; // January is 0!

					var yyyy1 = datesOfMonthOnWeek[6].getFullYear();
					if (dd1 < 10) {
						dd1 = '0' + dd1;
					}
					if (mm1 < 10) {
						mm1 = '0' + mm1;
					}
					var today1 = dd1 + '/' + mm1 + '/' + yyyy1;

					$("#khoangngay").text("Từ ngày " + today + " đến ngày " + today1);
					
					$.ajax({
						type : "POST",
						url : "HV_thoikhoabieu",
						data : {
							TuNgay: yyyy + '-' + mm + '-' + dd,
							DenNgay: yyyy1 + '-' + mm1 + '-' + dd1
						},
						dataType : "json",
						success : function(result) {
							if(result.check == "fail"){
								$("#table-thoi-khoa-bieu > tbody").children().remove();
				            	$("#table-thoi-khoa-bieu > thead > tr").children().remove();
							}
							else{
								var n = Object.keys(result).length;
					            if(n>0){
					            	$("#table-thoi-khoa-bieu > tbody").children().remove();
					            	$("#table-thoi-khoa-bieu > thead > tr").children().remove();
					            	var buoihoc = 0;
					            	var k=0;
					            	var color = ["danger","info","warning","success"];
					            	$("#table-thoi-khoa-bieu > thead > tr").append($('<th style="color:white;background:#197485;width:50px">').text("PHÒNG"));
					              	for(i=0; i<n; i++){
					              		if(buoihoc != result[i].BuoiHoc){
					              			buoihoc = result[i].BuoiHoc;
					              			k++;
						              		$("#table-thoi-khoa-bieu > thead > tr").append(
							                            $('<th style="color:white;background:gray;width:250px">').text("Thứ " + result[i].BuoiHoc)
							                    );
					              		}
					              		$("#table-thoi-khoa-bieu > tbody").append($('<tr>').append($('<td class="active">').append(result[i].SoPhong)));
					              		for(j=1; j<k; j++){
					              			$("#table-thoi-khoa-bieu > tbody > tr").append($('<td>'));
					              		}
					              		$("#table-thoi-khoa-bieu > tbody > tr:last").append($('<td class="'+color[i]+'">').append(
			                            		$("<strong>").append(result[i].TenLop)).append("<br/>"+result[i].GioBatDau+" -> "+result[i].GioKetThuc
		                        				).append("<br/>GV: "+result[i].HoTenGV));
					              	}
					            }
							}
							
						},
						error : function(jqXHR, exception) {
							if (jqXHR.status == 500)
								alert("Thời khóa biểu không load được");
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
			var date = new Date($(this).val());
			nam = date.getFullYear();
			thang = date.getMonth() + 1;
			
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
		});
		
		var temp = 1;
		$("#tuan").val(temp);
		$("#tuan option:selected").each(function() {
			tuan = $(this).val();
		
		var firstDateOfMonth = new Date(nam, thang - 1, 1); // Date:year-month-01

		var firstDayOfMonth = firstDateOfMonth.getDay() - 1; // 0 (Sun) to 6 (Sat)

		var firstDateOfWeek = new Date(firstDateOfMonth); // copy firstDateOfMonth

		firstDateOfWeek.setDate( // move the Date object
		firstDateOfWeek.getDate() + // forward by the number of
		(firstDayOfMonth ? 7 - firstDayOfMonth : 0) // days needed to go to
		); // Sunday, if necessary

		firstDateOfWeek.setDate( // move the Date object
		firstDateOfWeek.getDate() + // forward by the number of
		7 * (tuan - 1) // weeks required (week - 1)
		);

		var dateNumbersOfMonthOnWeek = []; // output array of date #s
		var datesOfMonthOnWeek = []; // output array of Dates

		for (var i = 0; i < 7; i++) { // for seven days...

			dateNumbersOfMonthOnWeek.push( // push the date number on
			firstDateOfWeek.getDate()); // the end of the array

			datesOfMonthOnWeek.push( // push the date object on
			new Date(+firstDateOfWeek)); // the end of the array

			firstDateOfWeek.setDate(firstDateOfWeek.getDate() + 1); // move to the next day
		}
		var dd = datesOfMonthOnWeek[0].getDate();
		var mm = datesOfMonthOnWeek[0].getMonth() + 1; // January is 0!

		var yyyy = datesOfMonthOnWeek[0].getFullYear();
		if (dd < 10) {
			dd = '0' + dd;
		}
		if (mm < 10) {
			mm = '0' + mm;
		}
		var today = dd + '/' + mm + '/' + yyyy;

		var dd1 = datesOfMonthOnWeek[6].getDate();
		var mm1 = datesOfMonthOnWeek[6].getMonth() + 1; // January is 0!

		var yyyy1 = datesOfMonthOnWeek[6].getFullYear();
		if (dd1 < 10) {
			dd1 = '0' + dd1;
		}
		if (mm1 < 10) {
			mm1 = '0' + mm1;
		}
		var today1 = dd1 + '/' + mm1 + '/' + yyyy1;

		$("#khoangngay").text("Từ ngày " + today + " đến ngày " + today1);
		
		$.ajax({
			type : "POST",
			url : "HV_thoikhoabieu",
			data : {
				TuNgay: yyyy + '-' + mm + '-' + dd,
				DenNgay: yyyy1 + '-' + mm1 + '-' + dd1
			},
			dataType : "json",
			success : function(result) {
				if(result.check == "fail"){
					$("#table-thoi-khoa-bieu > tbody").children().remove();
	            	$("#table-thoi-khoa-bieu > thead > tr").children().remove();
				}
				else{
					var n = Object.keys(result).length;
		            if(n>0){
		            	$("#table-thoi-khoa-bieu > tbody").children().remove();
		            	$("#table-thoi-khoa-bieu > thead > tr").children().remove();
		            	var buoihoc = 0;
		            	var k=0;
		            	var color = ["danger","info","warning","success"];
		            	$("#table-thoi-khoa-bieu > thead > tr").append($('<th style="color:white;background:#197485;width:50px">').text("PHÒNG"));
		              	for(i=0; i<n; i++){
		              		if(buoihoc != result[i].BuoiHoc){
		              			buoihoc = result[i].BuoiHoc;
		              			k++;
			              		$("#table-thoi-khoa-bieu > thead > tr").append(
				                            $('<th style="color:white;background:gray;width:250px">').text("Thứ " + result[i].BuoiHoc)
				                    );
		              		}
		              		$("#table-thoi-khoa-bieu > tbody").append($('<tr>').append($('<td class="active">').append(result[i].SoPhong)));
		              		for(j=1; j<k; j++){
		              			$("#table-thoi-khoa-bieu > tbody > tr").append($('<td>'));
		              		}
		              		$("#table-thoi-khoa-bieu > tbody > tr:last").append($('<td class="'+color[i]+'">').append(
                            		$("<strong>").append(result[i].TenLop)).append("<br/>"+result[i].GioBatDau+" -> "+result[i].GioKetThuc
                    				).append("<br/>GV: "+result[i].HoTenGV));
		              	}
		            }
				}
			},
			error : function(jqXHR, exception) {
				if (jqXHR.status == 500)
					alert("Thời khóa biểu không load được");
			}
		});
	});
	}).trigger("change");
	
	$("#tuan").change(function() {
		$("#tuan option:selected").each(function() {
			tuan = $(this).val();
		
		var firstDateOfMonth = new Date(nam, thang - 1, 1); // Date:year-month-01

		var firstDayOfMonth = firstDateOfMonth.getDay() - 1; // 0 (Sun) to 6 (Sat)

		var firstDateOfWeek = new Date(firstDateOfMonth); // copy firstDateOfMonth

		firstDateOfWeek.setDate( // move the Date object
		firstDateOfWeek.getDate() + // forward by the number of
		(firstDayOfMonth ? 7 - firstDayOfMonth : 0) // days needed to go to
		); // Sunday, if necessary

		firstDateOfWeek.setDate( // move the Date object
		firstDateOfWeek.getDate() + // forward by the number of
		7 * (tuan - 1) // weeks required (week - 1)
		);

		var dateNumbersOfMonthOnWeek = []; // output array of date #s
		var datesOfMonthOnWeek = []; // output array of Dates

		for (var i = 0; i < 7; i++) { // for seven days...

			dateNumbersOfMonthOnWeek.push( // push the date number on
			firstDateOfWeek.getDate()); // the end of the array

			datesOfMonthOnWeek.push( // push the date object on
			new Date(+firstDateOfWeek)); // the end of the array

			firstDateOfWeek.setDate(firstDateOfWeek.getDate() + 1); // move to the next day
		}
		var dd = datesOfMonthOnWeek[0].getDate();
		var mm = datesOfMonthOnWeek[0].getMonth() + 1; // January is 0!

		var yyyy = datesOfMonthOnWeek[0].getFullYear();
		if (dd < 10) {
			dd = '0' + dd;
		}
		if (mm < 10) {
			mm = '0' + mm;
		}
		var today = dd + '/' + mm + '/' + yyyy;

		var dd1 = datesOfMonthOnWeek[6].getDate();
		var mm1 = datesOfMonthOnWeek[6].getMonth() + 1; // January is 0!

		var yyyy1 = datesOfMonthOnWeek[6].getFullYear();
		if (dd1 < 10) {
			dd1 = '0' + dd1;
		}
		if (mm1 < 10) {
			mm1 = '0' + mm1;
		}
		var today1 = dd1 + '/' + mm1 + '/' + yyyy1;

		$("#khoangngay").text("Từ ngày " + today + " đến ngày " + today1);
		
		$.ajax({
			type : "POST",
			url : "HV_thoikhoabieu",
			data : {
				TuNgay: yyyy + '-' + mm + '-' + dd,
				DenNgay: yyyy1 + '-' + mm1 + '-' + dd1
			},
			dataType : "json",
			success : function(result) {
				if(result.check == "fail"){
					$("#table-thoi-khoa-bieu > tbody").children().remove();
	            	$("#table-thoi-khoa-bieu > thead > tr").children().remove();
				}
				else{
					var n = Object.keys(result).length;
		            if(n>0){
		            	$("#table-thoi-khoa-bieu > tbody").children().remove();
		            	$("#table-thoi-khoa-bieu > thead > tr").children().remove();
		            	var buoihoc = 0;
		            	var k=0;
		            	var color = ["danger","info","warning","success"];
		            	$("#table-thoi-khoa-bieu > thead > tr").append($('<th style="color:white;background:#197485;width:50px">').text("PHÒNG"));
		              	for(i=0; i<n; i++){
		              		if(buoihoc != result[i].BuoiHoc){
		              			buoihoc = result[i].BuoiHoc;
		              			k++;
			              		$("#table-thoi-khoa-bieu > thead > tr").append(
				                            $('<th style="color:white;background:gray;width:250px">').text("Thứ " + result[i].BuoiHoc)
				                    );
		              		}
		              		$("#table-thoi-khoa-bieu > tbody").append($('<tr>').append($('<td class="active">').append(result[i].SoPhong)));
		              		for(j=1; j<k; j++){
		              			$("#table-thoi-khoa-bieu > tbody > tr").append($('<td>'));
		              		}
		              		$("#table-thoi-khoa-bieu > tbody > tr:last").append($('<td class="'+color[i]+'">').append(
                            		$("<strong>").append(result[i].TenLop)).append("<br/>"+result[i].GioBatDau+" -> "+result[i].GioKetThuc
                    				).append("<br/>GV: "+result[i].HoTenGV));
		              	}
		            }
				}
			},
			error : function(jqXHR, exception) {
				if (jqXHR.status == 500)
					alert("Thời khóa biểu không load được");
			}
		});
	});
	}).trigger("change");
});