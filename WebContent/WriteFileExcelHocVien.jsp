<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.HocVienModel" %>
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
                <th>Mã học viên </th>
                <th>Họ tên</th>
                <th>Giới tính</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>CMND</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        	<%
	    		 String maLopHoc = request.getParameter("maLopHoc");
	    		 List<HocVienModel> dsHocVien = NV_thongkeDAO.LayDSHVCuaMotLopHoc(maLopHoc);
	    		 
		         if (dsHocVien != null) {
		             response.setContentType("application/vnd.ms-excel");
		             response.setHeader("Content-Disposition", "inline; filename=danhsachHocVien.xls");
		         }
			    for(HocVienModel hv: dsHocVien){
			    	int i=0;
        			String gioiTinh;
			    	i++;
    				if(hv.getGioiTinh())
    					gioiTinh="Nữ";
    				else
    					gioiTinh="Nam";
			  %>
			   <tr>
				    <td><%=i %></td>
      				<td><%=hv.getMaHV() %></td>
      				<td><%=hv.getHoTenHV() %></td>
      				<td><%=gioiTinh %></td>
      				<td><%=hv.getNgaySinh() %></td>
      				<td><%=hv.getDiaChi() %></td>
      				<td><%=hv.getSDT() %></td>
      				<td><%=hv.getCMND() %></td>
      				<td><%=hv.getEmailHV() %></td>
			   </tr>
			  <% 
			   }
	 		%>
        </tbody>
    </table>
</body>
</html>