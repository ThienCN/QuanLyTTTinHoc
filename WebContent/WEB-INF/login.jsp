<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<title>Đăng nhập</title>
	
	<link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min1.js"></script>
    
    <link rel="stylesheet" href="./CSS/font-awesome.min.css" />

	<script src="./JS/login.js"></script> 
	<link rel="stylesheet" href="./CSS/header-menu-fooder.css" />
	
</head>
<body>
	<div class="container" id="modallogin">
          <div class="modal-dialog">
              <div class="modal-content">
                  <div class="modal-header w3-center">
                      <img src="./Pic/logoLogin.png" alt="Avatar" style="width:30%" class="w3-circle w3-margin-top" />
                      <button type="button" class="close"><a style="color: red; text-decoration: none" href="index">&times;</a></button>                      
                  </div>
                  <div class="modal-body">
                      <div> 
                      	  <div class="checkbox-login" id="check-role">
	                          <label class="col-xs-6 col-md-3 col-sm-3"><input type="radio" value="HocVien" name="gender" checked /> Học viên</label>
	                          <label class="col-xs-6 col-md-3 col-sm-3"><input type="radio" value="GiaoVien" name="gender" /> Giáo viên</label>
	                          <label class="col-xs-6 col-md-3 col-sm-3"><input type="radio" value="NhanVien" name="gender" /> Nhân viên</label>
	                          <label class="col-xs-6 col-md-3 col-sm-3"><input type="radio" value="QuanTriVien" name="gender" /> Quản trị viên</label>
                      	  </div>
                          <div class="form-group">
                              <label>Tên đăng nhập:</label>
                              <input type="text" class="form-control" id="txt-user" placeholder="Từ 3 đến 15 ký tự" name="username" required />
                              <span class="error" id="error-user"></span>
                          </div>
                          <div class="form-group">
                              <label>Mật khẩu:</label>
                              <input type="password" class="form-control" id="txt-pass" placeholder="Không ít hơn 3 ký tự" name="password" required />
                              <span class="error" id="error-pass"></span>
                          </div>
                          <div class="checkbox">
                              <label><input type="checkbox" value="" style="position: relative" checked>Lưu mật khẩu</label>
                          </div>
                          <span class="error" id="error-login"></span>
                          <div class="div-btnLogin">
                              <button id="btnLogin" type="button" style="color:white"><span class="fa fa-sign-in"></span> ĐĂNG NHẬP</button>
                          </div>
                      </div>
                  </div>
                  <div class="modal-footer">
                      <p><a href="#" style="color:blue">Quên mật khẩu</a></p>
                  </div>
              </div>
          </div>
      </div>
	</body>
</html>