
    $(document).ready(function () {
        $("#collapse1").on("hide.bs.collapse", function () {
            $(".pnl1").html('<strong>LẬP TRÌNH TRÊN MOBILE</strong><span class="glyphicon glyphicon-menu-down" style="float:right"></span>');
        });
    $("#collapse1").on("show.bs.collapse", function () {
        $(".pnl1").html('<strong>LẬP TRÌNH TRÊN MOBILE</strong><span class="glyphicon glyphicon-menu-up" style="float:right"></span>');
    });

            $("#collapse2").on("hide.bs.collapse", function () {
        $(".pnl2").html('<strong>ỨNG DỤNG CNTT NÂNG CAO (TIN HỌC VĂN PHÒNG)</strong><span class="glyphicon glyphicon-menu-down" style="float:right"></span>');
    });
            $("#collapse2").on("show.bs.collapse", function () {
        $(".pnl2").html('<strong>ỨNG DỤNG CNTT NÂNG CAO (TIN HỌC VĂN PHÒNG)</strong><span class="glyphicon glyphicon-menu-up" style="float:right"></span>');
    });

            $("#collapse3").on("hide.bs.collapse", function () {
        $(".pnl3").html('<strong>CÁC LỚP CHUYÊN ĐỀ</strong><span class="glyphicon glyphicon-menu-down" style="float:right"></span>');
    });
            $("#collapse3").on("show.bs.collapse", function () {
        $(".pnl3").html('<strong>CÁC LỚP CHUYÊN ĐỀ</strong><span class="glyphicon glyphicon-menu-up" style="float:right"></span>');
    });
        });
