$(document).ready(function () {
	var k = 1;
	var flag1 = true;
	$.ajax({
  		type:"POST",
  		url:"dangkykhoahoc",
  		dataType:'json',
  		success: function(result){
  			if (result.check == "fail") {
            	alert("Không có lớp nào để đăng ký");
     	    }
     	    else{
     	    	var selected;
     	    	var n = Object.keys(result).length;
                if(n>0){
                	for(i=0; i<n; i++){
                		if($(".muc-dang-ky").attr("id") == result[i].MaLop){
                			selected = "selected";
                		}
                		else{
                			selected = "";
                		}
                		if(i%2 != 0){
                			$("#mySelect").append('<option style="background: lightcyan" value="'+result[i].MaLop+'" '+selected+'>' + result[i].TenLop + "</option>");
                		}
                		else{
                			$("#mySelect").append('<option value="'+result[i].MaLop+'" '+selected+'>' + result[i].TenLop + "</option>");
                		}
                	}
                }
     	    }
  		},
  		error : function(jqXHR, exception) {
			if (jqXHR.status == 500)
				alert("Lớp học không load được");
		}
  	});
  	
		// Ẩn các thông báo lỗi
		$("#username_error_message").hide();
		$("#email_error_message").hide();
		$("#telephone_error_message").hide();
		$("#date_error_message").hide();

		// Cờ lỗi
		var error_username = false;
		var error_email = false;
		var error_telephone = false;
		var error_date = false;
		var error_address = false;

		// Click chuột ra khỏi textbox ta sẽ kiểm tra text có hợp lệ hay không
		$("#form_username").focusout(function() {
			check_username();
		});
		$("#form_date").focusout(function() {
			check_date();
		});
		$("#form_email").focusout(function() {
			check_email();
		});
		$("#form_telephone").focusout(function() {
			check_telephone();
		});
		$("#form_address").focusout(function() {
			check_address();
		});
		$("#register_button").click(function(e) {
			e.preventDefault();
			CheckForm();
		})

		// Hàm kiểm tra username có hợp lệ hay không
		function check_username() {
			var username_length = $("#form_username").val().length;

			if (username_length < 5 || username_length > 20) {
				$("#username_error_message").html(
						"Từ 5-20 ký tự");
				$("#username_error_message").show();
				error_username = true;
			} else {
				$("#username_error_message").hide();
				error_username = false;
			}
		}
		
		//Hàm kiểm tra ngày tháng
		function check_date() {
			var date_length = $("#form_date").val().length;

			if (date_length < 9) {
				$("#date_error_message").html(
						"Vui lòng chọn ngày sinh");
				$("#date_error_message").show();
				error_date = true;
			} else {
				$("#date_error_message").hide();
				error_date = false;
			}
		}

		//Hàm kiểm tra SDT có hợp lệ hay không
		function check_telephone() {
			var telephone_length = $("#form_telephone").val().length;

			if (telephone_length < 8) {
				$("#telephone_error_message").html("Ít nhất 10 ký tự");
				$("#telephone_error_message").show();
				error_telephone = true;
			} else {
				$("#telephone_error_message").hide();
				error_telephone = false;
			}
		}
		
		//Hàm kiểm tra SDT có hợp lệ hay không
		function check_address() {
			var address_length = $("#form_address").val().length;

			if (address_length < 5) {
				$("#address_error_message").html("Ít nhất 5 ký tự");
				$("#address_error_message").show();
				error_address = true;
			} else {
				$("#address_error_message").hide();
				error_address = false;
			}
		}

		// Hàm kiểm tra password có hợp lệ hay không
		function check_email() {
			var email_length = $("#form_email").val().length;

			if (email_length < 8) {
				$("#email_error_message").html("Không phải là email");
				$("#email_error_message").show();
				error_email = true;
			} else {
				$("#email_error_message").hide();
				error_email = false;
			}
		}

		//Hàm kiểm tra thông tin nhập đã đúng và hợp lệ không
	    function CheckForm() {
	        //Đặt cờ
	        error_username = false;
	        error_email = false;
	        error_telephone = false;
	        error_date = false;
	        error_address = false;
	        //Lấy giá trị user và pass
	        var username = $.trim($("#form_username").val());
	        var email = $.trim($("#form_email").val());
	        var telephone = $.trim($("#form_telephone").val());
	        var address = $.trim($("#form_address").val());
	        var date = $.trim($("#form_date").val());
	        //Nếu user và pass đang để trống thì thông báo ngay
	        if (username == "" && email == "" && telephone == "" && date == "" && address == "") {
				$("#username_error_message").html("Yêu cầu nhập họ tên");
				$("#username_error_message").show();
				$("#date_error_message").html("Yêu cầu nhập ngày sinh");
				$("#date_error_message").show();
	        	$("#email_error_message").html("Yêu cầu nhập email");
				$("#email_error_message").show();
				$("#telephone_error_message").html("Yêu cầu nhập số điện thoại");
				$("#telephone_error_message").show();
				$("#address_error_message").html("Yêu cầu nhập địa chỉ");
				$("#address_error_message").show();
	            return;
	        } else {
	            if (username == "") {
	            	$("#username_error_message").html("Yêu cầu nhập họ tên");
	    			$("#username_error_message").show();
	                return;
	            }
	            if (date == "") {
	            	$("#date_error_message").html("Yêu cầu nhập ngày sinh");
	    			$("#date_error_message").show();
	                return;
	            }
	            if (telephone == "") {
	            	$("#telephone_error_message").html("Yêu cầu nhập số điện thoại");
	    			$("#telephone_error_message").show();
	                return;
	            }
	            if (address == "") {
	            	$("#address_error_message").html("Yêu cầu nhập địa chỉ");
	    			$("#address_error_message").show();
	                return;
	            }
	            if (email == "") {
	            	$("#email_error_message").html("Yêu cầu nhập email");
	    			$("#email_error_message").show();
	                return;
	            }
	        }

	        //Check thông tin nhập có hợp lệ theo yêu cầu hay không
	        check_username();
	        check_date();
	        check_telephone();
	        check_email();
	        check_address();
	        
	        var x=0;
	    	var flag = true;
	        $("select option:selected").each(function() {
	        	if($(this).val() == 0){
	        		alert("Mời bạn chọn lớp học");
	        		flag = false;
	        		x++;
	        	}
	        	else if($(this).val() != 0 && x == 0){
	        		flag =true;
	        	}
	        });
	        
	        if(flag){
	        	$.ajax({
	    	  		type:"GET",
	    	  		url:"themchitietdangkykhoahoconl",
	    	  		data: {
	    	  			HoTen: $("#form_username").val(),
	    	  			NgaySinh: $("#form_date").val(),
	    	  			DiaChi: $("#form_address").val(),
	    	  			SDT: $("#form_telephone").val(),
	    	  			Email: $("#form_email").val()
	    	  		},
	    	  		dataType:'json',
	    	  		success: function(result){
	    	  			if (result.check == "fail") {
	    	            	alert("Thêm học viên đăng ký online không thành công");
	    	     	    }
	    	     	    else{
	    	     	    	var MaDangKyOnl = result.check;
	    	     	    	var MaLop = 0;
	    			        $("select option:selected").each(function() {
	    			        	MaLop = $(this).val();
	    			        	$.ajax({
	    			    	  		type:"POST",
	    			    	  		url:"themchitietdangkykhoahoconl",
	    			    	  		data: {
	    			    	  			MaDangKyOnl: MaDangKyOnl,
	    			    	  			MaLop: MaLop
	    			    	  		},
	    			    	  		dataType:'json',
	    			    	  		success: function(result){
	    			    	  			if (result.check == "fail") {
	    			    	  				flag1 = false;
	    			    	     	    }
	    			    	     	    else if (result.check == "yes"){
	    			    	     	    	flag1 = true;
	    			    	     	    }
	    			    	  		},
	    			    	  		error : function(jqXHR, exception) {
	    			    				if (jqXHR.status == 500)
	    			    					alert("Không đăng ký online được");
	    			    			}
	    			    	  	});
	    			        });
	    	     	    }
	    	  		},
	    	  		error : function(jqXHR, exception) {
	    				if (jqXHR.status == 500)
	    					alert("Học viên đăng ký online mới không thêm được");
	    			}
	    	  	});
		        if(flag1){
		        	alert("Đăng ký online thành công");
		        	window.location.assign("dangkykhoahocthanhcong");
		        }
		        else{
	            	alert("Đăng ký online không thành công");
	            }
	        }
	    }

	$("#addMH").click(function(e){
		text = '<div id="divthem'+k+'"><hr><div class="form-group"> <div class="row"><div class="col-sm-3 control-label"><label class="">Lớp học:</label></div><div class="col-sm-5 col-xs-10"><select class="form-control col-sm-1 col-xs-1" id="mySelect'+ k +'"><option value="0" disabled selected value>Chọn lớp học</option></select></div><label class="fa fa-minus btnminus" id="divthem'+k+'" onclick="minusText(this.id)" style="font-size:27px;color:red"></label></div></div></div>'
		$("#dkthem").append(text);
		$.ajax({
	  		type:"POST",
	  		url:"dangkykhoahoc",
	  		dataType:'json',
	  		success: function(result){
	  			if (result.check == "fail") {
	            	alert("Không có lớp nào để đăng ký");
	     	    }
	     	    else{
	     	    	var n = Object.keys(result).length;
	                if(n>0){
	                	for(i=0; i<n; i++){
	                		if(i%2 != 0){
	                			$("#mySelect"+k).append('<option style="background: lightcyan" value="'+result[i].MaLop+'">' + result[i].TenLop + "</option>");
	                		}
	                		else{
	                			$("#mySelect"+k).append('<option value="'+result[i].MaLop+'">' + result[i].TenLop + "</option>");
	                		}
	                	}
	                }
	        		k++;
	     	    }
	  		},
	  		error : function(jqXHR, exception) {
				if (jqXHR.status == 500)
					alert("Lớp học không load được");
			}
	  	});
	});

	$('.datepicker').datepicker({
	    format: 'dd/mm/yyyy',
	    startDate: '-3d'
	});
	
	$("#btnminus").click(function(e){
		alert("yes");
	    $("#divthem").remove();
	});
});

function minusText(id) {
	$("#"+id).remove();
}