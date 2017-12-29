$(document).ready(function () {
    $("#btn-xac-nhan").click(function (e) {
        e.preventDefault();
        var STT = "<td>" + 4 + "</td>";
        var tentailieu = "<td>CSS</td>";
        var loaitailieu = "<td>.docx</td>"
        var kichthuoc = "<td>9.66MB</td>"
        var xoa = '<td><a onclick="deleteRow(this)">Xóa</a></td>';



        var fsize = $("#file_kichthuoc")[0].files[0].size;
        if (fsize > 26214400) {
            alert("Kích thước tệp không quá 25MB!")
        } else {
            $("#table-DS-tai-lieu").append("<tr>" + STT + tentailieu + loaitailieu + kichthuoc + xoa + "</tr>");
            alert("Thêm thành công!");
        }

        $("#table-dky-khoahoc #sua-lop-hoc").click(function (e) {
            e.preventDefault();
            var maLopEdit = $(this).closest('tr').find('td:first').text();
            //console.log(maLopEdit);
        });

        $("#table-dky-khoahoc #xoa-lop-hoc").click(function (e) {
            e.preventDefault();
            var maLopDel = $(this).closest('tr').find('td:first').text();
            //console.log(maLopDel);
        });
    });
});