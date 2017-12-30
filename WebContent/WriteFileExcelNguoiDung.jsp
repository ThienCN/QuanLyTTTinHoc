<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.NguoiDungModel" %>
<%@ page import="DAO.AdminDAO" %>
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
                <th>Mã người dùng</th>
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
       			int flag = Integer.parseInt(request.getParameter("flag"));
        		List<NguoiDungModel> dsNguoiDung = null;
		       	if (flag == 1) //Nhân viên
		       		dsNguoiDung = AdminDAO.LayDanhSachNhanVien();
		       	if(flag == 2)
		       		dsNguoiDung = AdminDAO.LayDanhSachAdmin();
		        if (dsNguoiDung != null) {
		             response.setContentType("application/vnd.ms-excel");
		             response.setHeader("Content-Disposition", "inline; filename=danhsachNguoiDung.xls");
		        }
			    for(NguoiDungModel gv: dsNguoiDung){
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
      				<td><%=gv.getMaND() %></td>
      				<td><%=gv.getHoTenND() %></td>
      				<td><%=gv.getNgaySinh() %></td>
      				<td><%=gv.getCMND() %></td>
      				<td><%=gv.getDiaChi() %></td>
      				<td><%=gioiTinh %></td>
      				<td><%=gv.getDienThoai() %></td>
      				<td><%=gv.getTenTrinhDoHV()%></td>
      				<td><%=gv.getEmailND() %></td>
			   </tr>
			  <% 
			   }
	 		%>
        </tbody>
    </table>
</body>
</html>