$(document).ready(function(){
	var rowTableClick, maKhoaHocCu;
	$("#ket-qua-thong-ke").css("display","none");
	$("#danh-sach-trong").css("display","none");
	
	//Load toàn bộ ds Khóa học lên table
	var flag=1;
	$.ajax({
		type:"POST",
		url:"Admin_themkhoahocmoi",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				$("#danh-sach-trong").text("Danh sách trống!");
				$("#danh-sach-trong").css("display","block");
				return;
			}
			if(result.check != null){
				$("#danh-sach-trong").text(result.check);
				$("#danh-sach-trong").css("color","red");
				$("#danh-sach-trong").css("display","block");
				return;
			}
			
			var n = Object.keys(result).length;
			$("#table-ds-lop-hoc > tbody").children().remove();
			var tinhTrang;
			for(i=0; i<n; i++){
				
				if(result[i].tinhTrang == 1)
					tinhTrang = "Mở";
				else if(result[i].tinhTrang == 2)
					tinhTrang = "Khóa";
				else if(result[i].tinhTrang == 0)
					tinhTrang = "Đóng";
				
				$("#table-ds-lop-hoc > tbody").append(
					$('<tr>').append(
						$('<td>').text(result[i].maKhoaHoc)	
						).append(
						$('<td>').text(result[i].ngayKhaiGiang)	
						).append(
						$('<td>').text(result[i].soLopHoc)	
						).append(
						$('<td>').text(tinhTrang)	
						).append(
						$('<td>').append(
							$('<button class="btn btn-info" style="background-color:#197485">')
								.text("Chỉnh sửa")
								.click(function(e){
									e.preventDefault();
									
									maKhoaHocCu = $(this).closest('tr').find('td:nth-child(1)').text();
									var ngayKhaiGiang = $(this).closest('tr').find('td:nth-child(2)').text();
									
									$("#maKhoaHoc").val(maKhoaHocCu);
									$("#ngayKhaiGiang").val(ngayKhaiGiang);
									
									$("#fromChinhSuaKH").css("display","block");
									rowTableClick=this;
								})
							)		
						)
				)
			}
			$("#ket-qua-thong-ke").css("display","block");
		}
	})
	
	
	$("#btn-HuyChinhSuaKH").click(function(){
		$("#fromChinhSuaKH").css("display","none");
	})
	
	$("#btn-chinhSuaKhoaHoc").click(function(){
		var maKhoaHoc = $("#maKhoaHoc").val().trim();
		var ngayKhaiGiang = $("#ngayKhaiGiang").val();
		var tinhTrang = $("#cbtinhTrang option:selected").val();
		
		
		$.ajax({
			type:"POST",
			url:"Admin_chinhsuathongtinkhoahoc",
			data:{
				maKhoaHoc:maKhoaHoc,
				ngayKhaiGiang:ngayKhaiGiang,
				tinhTrang:tinhTrang
			},
			dataType:"json",
			success:function(result){
				if(result.check == "fail"){
					alert("Chỉnh sửa khóa học không thành công!");
					return;
				}
				else{
					alert("Chỉnh sửa khóa học thành công!");
					$(rowTableClick).closest('tr').find('td:nth-child(1)').text(maKhoaHoc);
					$(rowTableClick).closest('tr').find('td:nth-child(2)').text(ngayKhaiGiang);
					if(tinhTrang == 1)
						$(rowTableClick).closest('tr').find('td:nth-child(4)').text("Mở");
					else if(tinhTrang == 2)
						$(rowTableClick).closest('tr').find('td:nth-child(4)').text("Khóa");
					else if(tinhTrang == 0)
						$(rowTableClick).closest('tr').find('td:nth-child(4)').text("Đóng");
					
					$("#fromChinhSuaKH").css("display","none");
				}
			}
		})
		
		
		
	})
	
})