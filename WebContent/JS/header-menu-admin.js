$(document).ready(function (e) {

    //Menu
    $.get('menu-Admin.html', function (res) {
        $('#menu').html(res);

        //Sự kiện khi click vào các sub-menu
        $("li#submenu2").click(function () {
            $("ul#sub-menu2").toggle();
        });
        $("li#submenu3").click(function () {
            $("ul#sub-menu3").toggle();
        });
        $("li#submenu4").click(function () {
            $("ul#sub-menu4").toggle();
        });
        $("li#submenu5").click(function () {
            $("ul#sub-menu5").toggle();
        });

        //Sự kiện active menu
        var path = document.location.pathname;
        var namepage = '';
        var namefile = '';
        if (path.lastIndexOf('admin') >= 0) {
            namepage = 'TRANG CỦA BẠN';
            namefile = 'admin';
            $("li#submenu1").css("background-color", "#197485");
            $("li#submenu1 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_themnguoidung') >= 0) {
            namepage = 'THÊM NGƯỜI DÙNG MỚI';
            namefile = 'Admin_themnguoidung';
            $("li#submenu3").css("background-color", "#197485");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_chinhsuathongtinnguoidung') >= 0) {
            namepage = 'CHỈNH SỬA THÔNG TIN NGƯỜI DÙNG';
            namefile = 'Admin_chinhsuathongtinnguoidung';
            $("li#submenu3").css("background-color", "#197485");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_chinhsuachitietthongtinnguoidung') >= 0) {
            namepage = 'CHỈNH SỬA CHI TIẾT THÔNG TIN NGƯỜI DÙNG';
            namefile = 'Admin_chinhsuachitietthongtinnguoidung';
            $("li#submenu3").css("background-color", "#197485");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_thongkeDSND') >= 0) {
            namepage = 'THỐNG KÊ DANH SÁCH NGƯỜI DÙNG';
            namefile = 'Admin_thongkeDSND';
            $("li#submenu3").css("background-color", "#197485");
            $("li#submenu3 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_themlophocmoi') >= 0) {
            namepage = 'THÊM LỚP HỌC MỚI';
            namefile = 'Admin_themlophocmoi';
            $("li#submenu4").css("background-color", "#197485");
            $("li#submenu4 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_chinhsuathongtinlophoc') >= 0) {
            namepage = 'CHỈNH SỬA THÔNG TIN LỚP HỌC';
            namefile = 'Admin_chinhsuathongtinlophoc';
            $("li#submenu4").css("background-color", "#197485");
            $("li#submenu4 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_thongkeDSLH') >= 0) {
            namepage = 'THỐNG KÊ DANH SÁCH LỚP HỌC';
            namefile = 'Admin_thongkeDSLH';
            $("li#submenu4").css("background-color", "#197485");
            $("li#submenu4 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_themkhoahocmoi') >= 0) {
            namepage = 'THÊM KHÓA HỌC MỚI';
            namefile = 'Admin_themkhoahocmoi';
            $("li#submenu5").css("background-color", "#197485");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_chinhsuathongtinkhoahoc') >= 0) {
            namepage = 'CHỈNH SỬA THÔNG TIN KHÓA HỌC';
            namefile = 'Admin_chinhsuathongtinkhoahoc';
            $("li#submenu5").css("background-color", "#197485");
            $("li#submenu5 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_themgiaovien') >= 0) {
            namepage = 'THÊM GIÁO VIÊN MỚI';
            namefile = 'Admin_themgiaovien';
            $("li#submenu2").css("background-color", "#197485");
            $("li#submenu2 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_thongkeDSGV') >= 0) {
            namepage = 'THỐNG KÊ DANH SÁCH GIÁO VIÊN';
            namefile = 'Admin_thongkeDSGV';
            $("li#submenu2").css("background-color", "#197485");
            $("li#submenu2 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_chinhsuathongtingiaovien') >= 0) {
            namepage = 'CHỈNH SỬA THÔNG TIN GIÁO VIÊN';
            namefile = 'Admin_chinhsuathongtingiaovien';
            $("li#submenu2").css("background-color", "#197485");
            $("li#submenu2 a:first").attr("style", "color: white !important");
        }
        else if (path.lastIndexOf('Admin_chinhsuachitietthongtinGV') >= 0) {
            namepage = 'CHỈNH SỬA CHI TIẾT THÔNG TIN GIÁO VIÊN';
            namefile = 'Admin_chinhsuachitietthongtinGV';
            $("li#submenu2").css("background-color", "#197485");
            $("li#submenu2 a:first").attr("style", "color: white !important");
        }
        
        
        
        $('#page-trich-dan').attr("href", namefile);
        $('#page-trich-dan').text(namepage);
    });
});