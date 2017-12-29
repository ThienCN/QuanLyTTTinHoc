$(function() {
	// Ẩn các thông báo lỗi
	$("#username_error_message").hide();
	$("#email_error_message").hide();
	$("#telephone_error_message").hide();

	// Cờ lỗi
	var error_username = false;
	var error_email = false;
	var error_telephone = false;

	// Click chuột ra khỏi textbox ta sẽ kiểm tra text có hợp lệ hay không
	$("#form_username").focusout(function() {
		check_username();
	});
	$("#form_email").focusout(function() {
		check_email();
	});
	$("#form_telephone").focusout(function() {
		check_telephone();
	});
	$("#register_button").click(function(e) {
		e.preventDefault();
		check_form();
	})

	// Hàm kiểm tra username có hợp lệ hay không
	function check_username() {
		var username_length = $("#form_username").val().length;

		if (username_length < 5 || username_length > 20) {
			$("#username_error_message").html(
					"Should be between 5-20 characters");
			$("#username_error_message").show();
			error_username = true;
		} else {
			$("#username_error_message").hide();
			error_username = false;
		}
	}

	//Hàm kiểm tra SDT có hợp lệ hay không
	function check_telephone() {
		var telephone_length = $("#form_telephone").val().length;

		if (telephone_length < 8) {
			$("#telephone_error_message").html("At least 10 characters");
			$("#telephone_error_message").show();
			error_telephone = true;
		} else {
			$("#telephone_error_message").hide();
			error_telephone = false;
		}
	}

	// Hàm kiểm tra password có hợp lệ hay không
	function check_email() {
		var email_length = $("#form_email").val().length;

		if (email_length < 8) {
			$("#email_error_message").html("Not is email");
			$("#email_error_message").show();
			error_email = true;
		} else {
			$("#email_error_message").hide();
			error_email = false;
		}
	}

	// Hàm kiểm tra thông tin đăng nhập có hợp lệ hay không
	function check_form() {
		var x = document.forms["myform"]["usertext"].value;
		var y = document.forms["myform"]["telephonetext"].value;
		var z = document.forms["myform"]["emailtext"].value;
		if (x == "") {
			$("#username_error_message").html("Please enter a fullname");
			$("#username_error_message").show();
		}
		else if (y == "") {
			$("#telephone_error_message").html("Please enter a telephone");
			$("#telephone_error_message").show();
		}
		else if (z == "") {
			$("#email_error_message").html("Please enter a email");
			$("#email_error_message").show();
		}
	}
});


function appendText() {
    var subjects, text, flen, i, j = 1;
    /*subjects = ['value="lta">Lập trình Android',
             'value="lti" style="background: lightcyan">Lập trình IOS', 
             'value="thvp">Ứng dụng CNTT nâng cao (Tin học văn phòng)',
             'value="tkw" style="background: lightcyan">Thiết kế website', 
             'value="csdl">Thiết kế cơ sở dữ liệu'];
    flen = subjects.length;
    text = '<hr><div class="form-group"><label class="control-label col-sm-3">Lớp học:</label><div class="col-sm-5"><select class="form-control col-sm-1" id="select"'+ j +'></div>';
    text += '<option>Chọn lớp học</option>';
    for (i = 0; i < flen; i++) {
        text += '<option' + ' ' + subjects[i] + '</option>';
    }*/
    text = '<div id="divthem"><hr><div class="form-group"> <div class="row"><div class="col-sm-3 control-label"><label class="">Lớp học:</label></div><div class="col-sm-5 col-xs-10"><select class="form-control col-sm-1 col-xs-1" id="mySelect"><option>Chọn lớp học</option><option value="lta">Lập trình Android (Thứ 2-4-6 17:30-21:00)</option><option value="lti" style="background: lightcyan">Lập trình IOS (Thứ 2-4-6 17:30-21:00)</option><option value="thvp">Ứng dụng CNTT nâng cao (Tin học văn phòng) (Thứ 2-4-6 17:30-21:00)</option><option value="tkw" style="background: lightcyan">Thiết kế website (Thứ 2-4-6 17:30-21:00)</option><option value="csdl">Thiết kế cơ sở dữ liệu (Thứ 2-4-6 17:30-21:00)</option></select></div><i class="fa fa-minus" id="btnminus" onclick="minusText()" style="font-size:27px;color:red"></i></div></div></div>'
    $("#dkthem").append(text);
}

$('.datepicker').datepicker({
    format: 'mm/dd/yyyy',
    startDate: '-3d'
});

// $(document).ready(function(){
//     $("#btnminus").click(function(){
//         $("#divthem").remove();
//     });
// });
function minusText() {
    $("#divthem").remove();
}