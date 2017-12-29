$(document).ready(function(){
	
	var flag;
	//flag=2: Load thông báo đầu lên trang thông báo
	flag=2;
	$.ajax({
		type:"POST",
		url:"thongbao",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			if(result.check == "fail"){
				alert('Server đang bận!');
				return;
			}
			else if(result.check != null){
				alert(result.check);
				return;
			}
			//Load thông báo chính
			$('#imageTBChinh').attr("src",result[0].hinhAnh);
			$('#maTBChinh').val(result[0].maThongBao);
			$('#tieuDeTBChinh').text(result[0].tieuDeThongBao);
			$('#ngayTBChinh').text(result[0].ngayThongBao);
			$('#noiDungTomTatTBChinh').text(result[0].tomTatThongBao);
			$("#xemTiepNoiDungTBChinh").text('Xem tiếp >>');
			$("#TBChinh").css('display','block');
			LoadThongBaoPhu(2,4);
		}
	});

	
	
	//flag = 1: Đếm số lượng Thông báo để tạo số trang paginationThongBao
	//Và sự kiện click cho từng page của paginationThongBao
	flag=1;
	$.ajax({
		type:"POST",
		url:"thongbao",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			var soTrangThongBao = Math.floor((result.soLuong-1)/3);
			
			if(result.soLuong > 4){
				var temp = result.soLuong;
				$("ul#paginationThongBao").append(
					$("<li class='active'>").append(
						$('<a>').text('1')
								.click(function(e){
									e.preventDefault();
									window.location.assign('thongbao');
								})
						)
				);
				
				var nLap = soTrangThongBao;
				
				if(((result.soLuong-1)%3) > 0)
					nLap = soTrangThongBao+1;
				
				for(i=2; i<=nLap; i++){
					$("ul#paginationThongBao").append(
						$('<li>').append(
							$('<a>').text(i)	
									.click(function(e){
										e.preventDefault();
										var tbMax = this.text;
										$("ul#paginationThongBao li").removeClass("active");
										LoadThongBaoPhu(tbMax*3-1,tbMax*3+1);
									})
							).click(function(e){
								$(this).addClass("active");
							})
					);
				}
			}
		}
	})
	
	
	//Hàm load 3 Thông báo phụ
	function LoadThongBaoPhu(start,end){
		//flag=3: Load 3 thông báo phụ lên trang thông báo theo stt từ [start,end]
		flag=3;
		
		$.ajax({
			type:"POST",
			url:"thongbao",
			data:{
				flag:flag,
				start:start,
				end:end
			},
			dataType:"json",
			success:function(result){
				if(result.check == "fail"){
					alert('Server đang bận!');
					return;
				}
				else if(result.check != null){
					alert(result.check);
					return;
				}
				$('#TBPhu1').css('display','none');
				$('#TBPhu2').css('display','none');
				$('#TBPhu3').css('display','none');
				var n = Object.keys(result).length;
				//Load 3 thông báo phụ
				for(i=0; i<n; i++){
					if(i==0){
						$('#imageTBPhu1').attr("src",result[0].hinhAnh);
						$('#maTBPhu1').val(result[0].maThongBao);
						$('#tieuDeTBPhu1').text(result[0].tieuDeThongBao);
						$('#ngayTBPhu1').text(result[0].ngayThongBao);
						$('#noiDungTomTatTBPhu1').text(result[0].tomTatThongBao);
						$("#xemTiepNoiDungTBPhu1").text('Xem tiếp >>');
						$('#TBPhu1').css('display','block');
					}
					if(i==1){
						$('#imageTBPhu2').attr("src",result[1].hinhAnh);
						$('#maTBPhu2').val(result[1].maThongBao);
						$('#tieuDeTBPhu2').text(result[1].tieuDeThongBao);
						$('#ngayTBPhu2').text(result[1].ngayThongBao);
						$('#noiDungTomTatTBPhu2').text(result[1].tomTatThongBao);
						$("#xemTiepNoiDungTBPhu2").text('Xem tiếp >>');
						$('#TBPhu2').css('display','block');
					}
					if(i==2){
						$('#imageTBPhu3').attr("src",result[2].hinhAnh);
						$('#maTBPhu3').val(result[2].maThongBao);
						$('#tieuDeTBPhu3').text(result[2].tieuDeThongBao);
						$('#ngayTBPhu3').text(result[2].ngayThongBao);
						$('#noiDungTomTatTBPhu3').text(result[2].tomTatThongBao);
						$("#xemTiepNoiDungTBPhu3").text('Xem tiếp >>');
						$('#TBPhu3').css('display','block');
					}
				}
			}
		});
	}
	//flag = 3: lấy maThongBao trả về tên file Thông báo
	flag = 3;
	function XemFileThongBao(maTB){
		$.ajax({
			type:"POST",
			url:"noidungthongbao",
			data:{
				flag:flag,
				maTB:maTB
			},
			dataType:"json",
			success:function(result){
				if(result.check == "fail"){
					alert("Server đang bận!");
					window.location.assgin("thongbao");
					return;
				}
				else{
					window.location.assign("noidungthongbao");
				}
			}
		})
	}
	
	//Sự kiện click của các Tiêu đề và link Xem tiếp của mục Thông báo chính
	$("#tieuDeTBChinh").click(function(e){
		var maTBChinh = $('#maTBChinh').val().trim();
		XemFileThongBao(maTBChinh);
	})
	$("#xemTiepNoiDungTBChinh").click(function(e){
		var maTBChinh = $('#maTBChinh').val().trim();
		XemFileThongBao(maTBChinh);
	})
	//Sự kiện click của các Tiêu đề và link Xem tiếp của mục Thông báo phụ
	$("#tieuDeTBPhu1").click(function(e){
		var maTBChinh = $('#maTBPhu1').val().trim();
		XemFileThongBao(maTBChinh);
	})
	$("#xemTiepNoiDungTBPhu1").click(function(e){
		var maTBChinh = $('#maTBPhu1').val().trim();
		XemFileThongBao(maTBChinh);
	})
	$("#tieuDeTBPhu2").click(function(e){
		var maTBChinh = $('#maTBPhu2').val().trim();
		XemFileThongBao(maTBChinh);
	})
	$("#xemTiepNoiDungTBPhu2").click(function(e){
		var maTBChinh = $('#maTBPhu2').val().trim();
		XemFileThongBao(maTBChinh);
	})
	$("#tieuDeTBPhu3").click(function(e){
		var maTBChinh = $('#maTBPhu3').val().trim();
		XemFileThongBao(maTBChinh);
	})
	$("#xemTiepNoiDungTBPhu3").click(function(e){
		var maTBChinh = $('#maTBPhu3').val().trim();
		XemFileThongBao(maTBChinh);
	})
})