<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.HVDKyOnlineModel" %>
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
                <th>Mã ĐKONL </th>
                <th>Họ tên</th>
                <th>Ngày sinh</th>
                <th>Địa chỉ</th>
                <th>Số điện thoại</th>
                <th>Email</th>
            </tr>
        </thead>
        <tbody>
        	<%
	    		 String maLopHoc = request.getParameter("maLopHoc");
       			 List<HVDKyOnlineModel> dsHVDKyOnl = NV_thongkeDAO.LayDSHVDKyOnlCuaMotLopHoc(maLopHoc);
	    		 
		         if (dsHVDKyOnl != null) {
		             response.setContentType("application/vnd.ms-excel");
		             response.setHeader("Content-Disposition", "inline; filename=danhsachHVDKOnline.xls");
		         }
			    for(HVDKyOnlineModel hv: dsHVDKyOnl){
			    	int i=0;
			    	i++;
			  %>
			   <tr>
				    <td><%=i %></td>
      				<td><%=hv.getMaDkyOnl() %></td>
      				<td><%=hv.getHoTen() %></td>
      				<td><%=hv.getNgaySinh() %></td>
      				<td><%=hv.getDiaChi() %></td>
      				<td><%=hv.getSDT() %></td>
      				<td><%=hv.getEmail() %></td>
			   </tr>
			  <% 
			   }
	 		%>
        </tbody>
    </table>
</body>
</html>