$(document).ready(function () {
	//flag=2: lấy thông tin học viên mới
    var flag=2;
    $.ajax({
    	type:"POST",
    	url:"NV_thuhocphi",
    	data:{
    		flag:flag
    	},
    	dataType:"json",
    	success:function(result){
    		$("#maHocVien").val(result.MaHV);
    		$("#hoTenHV").val(result.HoTenHV);
    	}
    })
    //flag=3: lấy thông tin học phí phải thanh toán
    flag=3;
    $.ajax({
    	type:"POST",
    	url:"NV_thuhocphi",
    	data:{
    		flag:flag
    	},
    	dataType:"json",
    	success:function(result){
    		$("#hocPhiPhaiThanhToan").val(result.check);
    	}
    })
    
    
    $("#btn-xuat-bien-lai").click(function(e){
    	e.preventDefault();
    	//flag=4: thêm học viên mới và biên lai thanh toán học phí cho học viên này
    	flag=4;
    	$.ajax({
        	type:"POST",
        	url:"NV_thuhocphi",
        	data:{
        		flag:flag
        	},
        	dataType:"json",
        	success:function(result){
        		if(result.check == "fail")
        			alert("Xuất hóa đơn không thành công!\rKiểm tra lại thông tin lớp học đã đăng ký trước đó!");
        		else
        			alert("Xuất hóa đơn thành công!\rMã học viên của bạn là: " + result.check);
        		window.location.assign('nhanvien');
        	}
        })
    })
});