$(document).ready(function () {
	
	
    $.get('header-menu.html', function (res) {
        $('#header-menu').html(res);
        activeMenuId = '#index';
        
        //Sự kiện active menu
        var path = document.location.pathname;
        var activeMenuId = '';
        if (path.lastIndexOf("index") >= 0) {
            activeMenuId = '#index';
        }
        else if (path.lastIndexOf("lichkhaigiang") >= 0)
        {
            activeMenuId = "#lich-khai-giang";
        }   
        else if (path.lastIndexOf("tintuc") >= 0) {
            activeMenuId = '#tin-tuc';
        }
        else if (path.lastIndexOf("thongbao") >= 0) {
            activeMenuId = "#thong-bao";
        }   
        else if (path.lastIndexOf("lienhe") >= 0)
        {
            activeMenuId = "#lien-he";
        }    
        else if (path.lastIndexOf("dangkykhoahoc") >= 0)
        {
            activeMenuId = "#dang-ky-khoa-hoc";
        }
        else if (path.lastIndexOf("QuanLyTTTinHoc") >= 0) {
        	activeMenuId = '#index'; 
        }
        

        $(activeMenuId).css('background-color', '#56A1B0');
    });

    $.get('footer.html', function (res) {
        $('#footer').html(res); 
    });
});
