$(document).ready(function(){
	var flag;
	//flag=2: Load tin tức đầu lên trang tin tức
	flag=2;
	$.ajax({
		type:"POST",
		url:"tintuc",
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
			if(result[0].imageVideo.substring(0,3) == "Pic"){
				$('#imageTTChinh').attr("src",result[0].imageVideo);
				$("#imageTTChinh").css('display','block');
			}
			else{
				$('#videoTTChinh').attr("src",result[0].imageVideo);
				$("#divVideoTinTuc")[0].load();
				$("#divVideoTinTuc").css('display','block');
			}
			$('#tieuDeTTChinh').text(result[0].tieuDeTinTuc);
			$('#ngayDangTTChinh').text(result[0].ngayDangTinTuc);
			$('#noiDungTomTatTTChinh').text(result[0].tomTatTinTuc);
			$("#tintucChinh").css('display','block');
			
			LoadTinTucPhu(2,4);
		}
	});
	
	//flag = 1: Đếm số lượng Tin tức để tạo số trang paginationTinTuc
	//Và sự kiện click cho từng page của paginationTicTuc
	flag=1;
	$.ajax({
		type:"POST",
		url:"tintuc",
		data:{
			flag:flag
		},
		dataType:"json",
		success:function(result){
			var soTrangTinTuc = Math.floor((result.soLuong-1)/3);
			
			if(result.soLuong > 4){
				var temp = result.soLuong;
				$("ul#paginationTinTuc").append(
					$("<li class='active'>").append(
						$('<a>').text('1')
								.click(function(e){
									e.preventDefault();
									window.location.assign('tintuc');
								})
						)
				);
				
				var nLap = soTrangTinTuc;
				
				if(((result.soLuong-1)%3) > 0)
					nLap = soTrangTinTuc+1;
				
				for(i=2; i<=nLap; i++){
					$("ul#paginationTinTuc").append(
						$('<li>').append(
							$('<a>').text(i)	
									.click(function(e){
										e.preventDefault();
										var tbMax = this.text;
										$("ul#paginationTinTuc li").removeClass("active");
										LoadTinTucPhu(tbMax*3-1,tbMax*3+1);
									})
							).click(function(e){
								$(this).addClass("active");
							})
					);
				}
			}
		}
	})
	
	
	//Hàm load 3 Tin tức phụ
	function LoadTinTucPhu(start,end){
		//flag=3: Load 3 tin tức phụ lên trang tin tức theo stt từ [start,end]
		flag=3;
		
		$.ajax({
			type:"POST",
			url:"tintuc",
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
				$('#TTPhu1').css('display','none');
				$('#TTPhu2').css('display','none');
				$('#TTPhu3').css('display','none');
				$("#imageTTPhu1").css('display','none');
				$("#divVideoTinTucPhu1").css('display','none');
				$("#imageTTPhu2").css('display','none');
				$("#divVideoTinTucPhu2").css('display','none');
				$("#imageTTPhu3").css('display','none');
				$("#divVideoTinTucPhu3").css('display','none');
				
				var n = Object.keys(result).length;
				//Load 3 thông báo phụ
				for(i=0; i<n; i++){
					
					if(i==0){
						if(result[0].imageVideo.substring(0,3) == "Pic"){
							$('#imageTTPhu1').attr("src",result[0].imageVideo);
							$("#imageTTPhu1").css('display','block');
						}
						else{
							$('#videoTTPhu1').attr("src",result[0].imageVideo);
							$("#divVideoTinTucPhu1")[0].load();
							$("#divVideoTinTucPhu1").css('display','block');
						}
						$('#tieuDeTTPhu1').text(result[0].tieuDeTinTuc);
						$('#ngayDangTTPhu1').text(result[0].ngayDangTinTuc);
						$('#noiDungTomTatTTPhu1').text(result[0].tomTatTinTuc);
						$("#TTPhu1").css('display','block');
					}
					if(i==1){
						if(result[1].imageVideo.substring(0,3) == "Pic"){
							$('#imageTTPhu2').attr("src",result[1].imageVideo);
							$("#imageTTPhu2").css('display','block');
						}
						else{
							$('#videoTTPhu2').attr("src",result[1].imageVideo);
							$("#divVideoTinTucPhu2")[0].load();
							$("#divVideoTinTucPhu2").css('display','block');
						}
						$('#tieuDeTTPhu2').text(result[1].tieuDeTinTuc);
						$('#ngayDangTTPhu2').text(result[1].ngayDangTinTuc);
						$('#noiDungTomTatTTPhu2').text(result[1].tomTatTinTuc);
						$("#TTPhu2").css('display','block');
					}
					if(i==2){
						if(result[2].imageVideo.substring(0,3) == "Pic"){
							$('#imageTTPhu3').attr("src",result[2].imageVideo);
							$("#imageTTPhu3").css('display','block');
						}
						else{
							$('#videoTTPhu3').attr("src",result[2].imageVideo);
							$("#divVideoTinTucPhu3")[0].load();
							$("#divVideoTinTucPhu3").css('display','block');
						}
						$('#tieuDeTTPhu3').text(result[2].tieuDeTinTuc);
						$('#ngayDangTTPhu3').text(result[2].ngayDangTinTuc);
						$('#noiDungTomTatTTPhu3').text(result[2].tomTatTinTuc);
						$("#TTPhu3").css('display','block');
					}
				}
			}
		});
	}
})