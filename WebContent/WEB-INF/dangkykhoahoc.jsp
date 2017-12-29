<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Đăng ký khóa học</title>

    <link rel="stylesheet" href="./CSS/bootstrap.min.css">
    <script src="./JS/jquery-3.2.1.min.js"></script>
    <script src="./JS/bootstrap.min.js"></script>
    <script src="JS/bootstrap-datepicker.js"></script>
    <!-- Glyphicons -->
    <link rel="stylesheet" href="./CSS/font-awesome.min.css">
    <link rel="stylesheet" href="CSS/bootstrap-datepicker.css">
    <!-- My CSS -->
    <link rel="stylesheet" href="CSS/w3.css">
    <link rel="stylesheet" href="./CSS/dangkykhoahoc.css" />
    <link rel="stylesheet" href="CSS/header-menu-fooder.css" />
    <!--My JS-->
    <script src="JS/dangkykhoahoc.js"></script>
    <script src="JS/include-html.js"></script>
</head>

<body>
	<%String MaLop = (String)getServletContext().getAttribute("MaLop"); %>
    <!-- Logo and menu bar -->
    <header id="header-menu"></header>
    <!-- Image -->
    <section>
        <div class="container" style="padding-top: 10px">
            <img src="./Pic/office.png" alt="logo" width="100%">
        </div>
    </section>
    <!-- Thông tin đăng ký khóa học -->
    <div class="container thong-tin-dang-ky" style="padding: 0px">
        <div class="col-sm-12 col-xs-12" style="padding: 0 45px">
            <form id="formdk" name="myform" onsubmit=return Validate()>
                <h2 class="muc-ca-nhan">THÔNG TIN CÁ NHÂN</h2>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-3 control-label">
                            <label class="">Họ và tên:</label>
                        </div>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" placeholder="Nguyễn Văn A" id="form_username" name="usertext">
                        </div>
                        <div class="col-sm-4">
                            <span class="error_form" id="username_error_message"  style="line-height: 40px;color: red"></span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-3 control-label">
                            <label class="">Ngày sinh:</label>
                        </div>
                        <div class="col-sm-3">
                            <div class="input-group date">
                                <input type="date" class="form-control" name="date" id="form_date">
                            </div>
                        </div>
                        <div class="col-sm-4">
                            <span class="error_form" id="date_error_message" style="line-height: 40px;color: red"></span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-3 control-label">
                            <label class="">SĐT:</label>
                        </div>
                        <div class="col-sm-3">
                            <input type="text" class="form-control" placeholder="0123456789" id="form_telephone" name="telephonetext">
                        </div>
                        <div class="col-sm-4">
                            <span class="error_form" id="telephone_error_message" style="line-height: 40px;color: red"></span>
                        </div>
                    </div>
                </div>
                
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-3 control-label">
                            <label class="">Địa chỉ:</label>
                        </div>
                        <div class="col-sm-4">
                            <input type="text" class="form-control" placeholder="1 Võ Văn Ngân" id="form_address" name="addresstext">
                        </div>
                        <div class="col-sm-4">
                            <span class="error_form" id="address_error_message" style="line-height: 40px;color: red"></span>
                        </div>
                    </div>
                </div>

                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-3 control-label">
                            <label class="">Email:</label>
                        </div>
                        <div class="col-sm-5">
                            <input type="text" class="form-control" placeholder="example@gmail.com" id="form_email" name="emailtext">
                        </div>
                        <div class="col-sm-4">
                            <span class="error_form" id="email_error_message" style="line-height: 40px; color: red"></span>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <hr>
                <h2 class="muc-dang-ky"
                <%if(MaLop != null || MaLop != ""){ %>
                	id=<%=MaLop %>
                <%} %>>THÔNG TIN ĐĂNG KÝ</h2>
                <div class="form-group">
                    <div class="row">
                        <div class="col-sm-3 control-label">
                            <label class="">Lớp học:</label>
                        </div>
                        <div class="col-sm-5 col-xs-10">
                            <select class="form-control" id="mySelect">
                                <option value="0" disabled selected value>Chọn lớp học</option>
                            </select>
                        </div>
                    </div>
                </div>
                <div id="dkthem"></div>
                <label class="fa fa-plus-square" id="addMH" style="cursor: pointer"> Đăng ký thêm</label><br>
                <div class="clearfix"></div>
                <div class="form-group">
                    <input data-togle="modal" data-target="modallogin" type="submit" id="register_button" class="w3-border w3-round-large w3-hover-blue" value="Hoàn tất đăng ký">
                </div>
                <div class="clearfix"></div>
            </form>
        </div>
        <br>
    </div>
    <br><br>

    <!-- Footer: Thông tin, địa chỉ -->
    <footer id="footer"></footer>

</body>

</html>