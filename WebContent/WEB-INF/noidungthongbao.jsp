<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<title>Nội dung thông báo</title>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <!-- Boostrap-->
    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <!-- W3 CSS -->
    <link rel="stylesheet" href="./CSS/w3.css" />
    <!-- My CSS -->
    <link rel="stylesheet" href="./CSS/thongbao_tintuc.css" />
    <link rel="stylesheet" href="./CSS/header-menu-fooder.css" />
    <!-- MY JS  -->
    <script src="./JS/include-html.js"></script>
    
    <script>
	  //Hiển thị file
		var flag=2;
		$.ajax({
			type:"POST",
			url:"noidungthongbao",
			data:{
				flag:flag
			},
			success:function(result){
				if(result.fileTB != null){
					$("#fileThongBao").attr("src",result.fileTB);
				}
				else{
					alert("Server đang bận!");
					window.location.assign("NV_quanlythongbao");
				}
			}
		})
    </script>
</head>
<body>
	<section class="container">
        <iframe id="fileThongBao" style="position: relative;width:100%; height: 800px;border: none;"></iframe>
    </section>
</body>
</html>