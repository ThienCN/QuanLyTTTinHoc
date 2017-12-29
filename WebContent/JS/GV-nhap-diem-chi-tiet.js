$(document).ready(function () {
	 var t = false;
	 var MaLop;
	$.ajax({
        type: "POST",
        url: "GV_nhapdiemchitiet",
        dataType: "json",
        success: function (result) { 
     	   if (result.check == "fail") {
            	alert("Lớp này không có SV đăng ký học");
     	   }
     	   else{
     		  MaLop = result[0].MaLop;
     		   $("#tenlop").text(result[0].TenLop);
     		  var n = Object.keys(result).length;
              if(n>0){
            	  
            	$("#table-bang-diem-hoc-vien > tbody").children().remove();
            	var valueTD;
              	for(i=0; i<n; i++){
              		valueTD = (result[i].DiemLT+result[i].DiemTH)/2;
              		if(result[i].ChungChi == undefined){
              			if(result[i].DiemLT == 0){
	              			result[i].DiemLT = "";
	              			valueTD = "";
              			}
              			if(result[i].DiemTH == 0){
              				result[i].DiemTH = "";
	              			valueTD = "";
              			}
              		}
                	$("#table-bang-diem-hoc-vien > tbody").append(
                        $('<tr>').append(
                            $('<td style="width:50px;">').text(i+1)
                            ).append(
                            $('<td>').text(result[i].MaHV)
                            ).append(
                            $('<td>').text(result[i].HoTenHV)
                            ).append(
                            $('<td>').append($('<input id="text-diem" style="text-align:center;width:50px" type="number" min="0" max="10" name="DiemLT" value="'+result[i].DiemLT+'" disabled >')).append($('<span id="loinhap" style="color:red;display:none;">').text(" Chỉ được nhập từ 0-10"))
                            ).append(
                            $('<td>').append($('<input id="text-diem" style="text-align:center;width:50px" type="number" min="0" max="10" name="DiemTH" value="'+result[i].DiemTH+'" disabled >')).append($('<span id="loinhap" style="color:red;display:none;">').text(" Chỉ được nhập từ 0-10"))
                            ).append(
                            $('<td>').append($('<input id="text_diem1" style="text-align:center;width:50px" type="number" min="0" max="10" name="DiemTong" value="'+valueTD+'" disabled >'))
                            )
                    );
              	}
              }
     	   }
     	 

     	 $('input').focus(function () {
     	     var $this = $(this)
     	     
     	     t = setInterval(

     	     function () {

     	        if (($this.val() < 0 || $this.val() > 10) && $this.val().length != 0) {
     	             if ($this.val() < 0) {
     	                 $this.val(0)
     	             }

     	             if ($this.val() > 10) {
     	                 $this.val(10)
     	             }
     	             
     	             $this.closest('tr').find('td > span').fadeIn(1000, function () {
     	            	$(this).fadeOut(500);
     	             })
     	         }
     	     })
     	 })
     	 
     	 $("input").keypress(function (e) {
     		var $this = $(this)
     		if ((e.which != 46 || $(this).val().indexOf('.') != -1) && (e.which != 44 || $(this).val().indexOf(',') != -1) && (e.which < 48 || e.which > 57)  || (e.which == 46 && $(this).caret().start == 0) ) {
     			$this.closest('tr').find('td > span').fadeIn(1000, function () {
     				$(this).fadeOut(500);
     			})
     		}
     	 })

     	 $('input').blur(function () {
     	     if (t != false) {
     	         window.clearInterval(t)
     	         t = false;
     	     }
     	 });
     	     
	 	   $("tr > td > input").change(function() {
	    	  $(this).closest('tr').find('td:nth-child(6) > input').val(
	    			  (parseFloat($(this).closest('tr').find('td:nth-child(4) > input').val())
	    			  + parseFloat($(this).closest('tr').find('td:nth-child(5) > input').val()))/2)
	 	   }).trigger("change");
        },
        error: function (jqXHR, exception) {
            if (jqXHR.status == 500)
                alert("Không có SV nào đăng ký lớp này");
        }
    });
	
	$("#btn-chinh-sua").click(function(e){
		$("tr > td > #text-diem").prop('disabled', false);
	});
	
	$("#btn-xac-nhan").click(function(e){
		var flag = true;
		var DiemLT,DiemTH,DiemTB
		$('#table-bang-diem-hoc-vien > tbody > tr').each(function() {
			if($(this).find('td:nth-child(4) > input').val() == ""){
				DiemLT=null;
			}
			else{
				DiemLT=$(this).find('td:nth-child(4) > input').val();
			}
			if($(this).find('td:nth-child(5) > input').val() == ""){
				DiemTH=null;
			}
			else{
				DiemTH=$(this).find('td:nth-child(5) > input').val();
			}
			if($(this).find('td:nth-child(6) > input').val() == ""){
				DiemTB=null;
			}
			else{
				DiemTB=$(this).find('td:nth-child(6) > input').val();
			}
		    $.ajax({
		        type: "POST",
		        url: "GV_nhapdiem",
		        data: {
		        	MaHV: $(this).find('td:nth-child(2)').text(),
		        	MaLop: MaLop,
		        	DiemLT: DiemLT,
		        	DiemTH: DiemTH,
		        	DiemTB: DiemTB
		        },
		        dataType: "json",
		        success: function (result) { 
		     	   if (result.check == "fail") {
		            	flag = false;
		     	   }
		        },
		        error: function (jqXHR, exception) {
		            if (jqXHR.status == 500)
		                alert("Không cập nhật được điểm");
		        }
		    });
		 });
		if(flag){
			alert("Cập nhật điểm thành công");
			$("#thongTinTimKiem").val("");
			$.ajax({
		        type: "POST",
		        url: "GV_nhapdiemchitiet",
		        dataType: "json",
		        success: function (result) { 
		     	   if (result.check == "fail") {
		            	alert("Lớp này không có SV đăng ký học");
		     	   }
		     	   else{
		     		  MaLop = result[0].MaLop;
		     		   $("#tenlop").text(result[0].TenLop);
		     		  var n = Object.keys(result).length;
		              if(n>0){
		            	  
		            	$("#table-bang-diem-hoc-vien > tbody").children().remove();
		            	var valueTD;
		              	for(i=0; i<n; i++){
		              		valueTD = (result[i].DiemLT+result[i].DiemTH)/2;
		              		if(result[i].ChungChi == undefined){
		              			if(result[i].DiemLT == 0){
			              			result[i].DiemLT = "";
			              			valueTD = "";
		              			}
		              			if(result[i].DiemTH == 0){
		              				result[i].DiemTH = "";
			              			valueTD = "";
		              			}
		              		}
		                	$("#table-bang-diem-hoc-vien > tbody").append(
		                        $('<tr>').append(
		                            $('<td style="width:50px;">').text(i+1)
		                            ).append(
		                            $('<td>').text(result[i].MaHV)
		                            ).append(
		                            $('<td>').text(result[i].HoTenHV)
		                            ).append(
		                            $('<td>').append($('<input id="text-diem" style="text-align:center;width:50px" type="number" min="0" max="10" name="DiemLT" value="'+result[i].DiemLT+'" disabled >')).append($('<span id="loinhap" style="color:red;display:none;">').text(" Chỉ được nhập từ 0-10"))
		                            ).append(
		                            $('<td>').append($('<input id="text-diem" style="text-align:center;width:50px" type="number" min="0" max="10" name="DiemTH" value="'+result[i].DiemTH+'" disabled >')).append($('<span id="loinhap" style="color:red;display:none;">').text(" Chỉ được nhập từ 0-10"))
		                            ).append(
		                            $('<td>').append($('<input id="text_diem1" style="text-align:center;width:50px" type="number" min="0" max="10" name="DiemTong" value="'+valueTD+'" disabled >'))
		                            )
		                    );
		              	}
		              }
		     	   }
		     	 

		     	 $('input').focus(function () {
		     	     var $this = $(this)
		     	     
		     	     t = setInterval(

		     	     function () {

		     	        if (($this.val() < 0 || $this.val() > 10) && $this.val().length != 0) {
		     	             if ($this.val() < 0) {
		     	                 $this.val(0)
		     	             }

		     	             if ($this.val() > 10) {
		     	                 $this.val(10)
		     	             }
		     	             
		     	             $this.closest('tr').find('td > span').fadeIn(1000, function () {
		     	            	$(this).fadeOut(500);
		     	             })
		     	         }
		     	     })
		     	 })
		     	 
		     	 $("input").keypress(function (e) {
		     		var $this = $(this)
		     		if ((e.which != 46 || $(this).val().indexOf('.') != -1) && (e.which != 44 || $(this).val().indexOf(',') != -1) && (e.which < 48 || e.which > 57)  || (e.which == 46 && $(this).caret().start == 0) ) {
		     			$this.closest('tr').find('td > span').fadeIn(1000, function () {
		     				$(this).fadeOut(500);
		     			})
		     		}
		     	 })

		     	 $('input').blur(function () {
		     	     if (t != false) {
		     	         window.clearInterval(t)
		     	         t = false;
		     	     }
		     	 });
		     	     
			 	   $("tr > td > input").change(function() {
			    	  $(this).closest('tr').find('td:nth-child(6) > input').val(
			    			  (parseFloat($(this).closest('tr').find('td:nth-child(4) > input').val())
			    			  + parseFloat($(this).closest('tr').find('td:nth-child(5) > input').val()))/2)
			 	   }).trigger("change");
		        },
		        error: function (jqXHR, exception) {
		            if (jqXHR.status == 500)
		                alert("Không có SV nào đăng ký lớp này");
		        }
		    });
		}
		else{
			alert("Cập nhật điểm không thành công");
			$("#thongTinTimKiem").val("");
		}
	});
    
	$("#btn-tim").click(function (e) {
		if($("#thongTinTimKiem").val().trim().length == 0){
			alert("Mời bạn nhập thông tin tìm kiếm");
		}
	});
});