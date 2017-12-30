<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.GiaoVienModel" %>
<%@ page import="DAO.NV_thongkeDAO" %>
<%@ page import="java.util.*" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
</head>
<body>
	<table class="table" cellpadding="1"  cellspacing="1" border="1" bordercolor="gray">
        <thead>
            <tr>
            	<th>STT</th>
                <th>Mã Giáo viên </th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>CMND</th>
                <th>Địa chỉ</th>
                <th>Giới tính</th>
                <th>Số điện thoại</th>
                <th>Trình độ học vấn</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        	<%
       			 String maKH = request.getParameter("maKH");
				 List<GiaoVienModel> dsGiaoVien;
	    	
		    	 //maKH = Tất cả: load lên toàn bộ ds Giáo viên ở trung tâm
				 if("Tất cả".equals(maKH)) 
					dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVien();
				 else //maKH != Tất cả:Load ds Giáo viên giảng dạy của từng khóa
					dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVienTheoKhoaHoc(maKH);
	    		 
		         if (dsGiaoVien != null) {
		             response.setContentType("application/vnd.ms-excel");
		             response.setHeader("Content-Disposition", "inline; filename=danhsachGiaoVien.xls");
		         }
			    for(GiaoVienModel gv: dsGiaoVien){
			    	int i=0;
        			String gioiTinh;
			    	i++;
    				if(gv.isGioiTinh())
    					gioiTinh="Nữ";
    				else
    					gioiTinh="Nam";
			  %>
			   <tr>
				    <td><%=i %></td>
      				<td><%=gv.getMaGV() %></td>
      				<td><%=gv.getHoTenGV() %></td>
      				<td><%=gv.getNgaySinh() %></td>
      				<td><%=gv.getCMND() %></td>
      				<td><%=gv.getDiaChi() %></td>
      				<td><%=gioiTinh %></td>
      				<td><%=gv.getDienThoai() %></td>
      				<td><%=gv.getTenTrinhDoHV()%></td>
      				<td><%=gv.getEmailGV() %></td>
			   </tr>
			  <% 
			   }
	 		%>
        </tbody>
    </table>
</body>
</html>