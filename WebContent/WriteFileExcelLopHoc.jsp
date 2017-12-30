<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="model.LopHocModel" %>
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
                <th>Mã lớp </th>
                <th>Tên lớp</th>
                <th>Số HV dự kiến</th>
                <th>Số buổi</th>
                <th>Ngày bắt đầu</th>
                <th>Ngày kết thúc</th>
                <th>Giáo viên giảng dạy</th>
                <th>Phòng học</th>
                <th>Buổi học</th>
                <th>Giờ học</th>
                <th>Học phí</th>
                <th>Tình trạng</th>
            </tr>
        </thead>
        <tbody>
        	<%
		       	 String maKH = request.getParameter("maKH");
		    	 List<LopHocModel> dsLopHoc = NV_thongkeDAO.LayDSLopHocCuaMotKhoaHoc(maKH);
	    		 
		         if (dsLopHoc != null) {
		             response.setContentType("application/vnd.ms-excel");
		             response.setHeader("Content-Disposition", "inline; filename=danhsachLopHoc.xls");
		         }
			    for(LopHocModel hv: dsLopHoc){
			    	int i=0;
        			String tinhTrang = null;
			    	i++;
    				if(hv.getTinhTrang() == 1)
    					tinhTrang="Mở";
    				if(hv.getTinhTrang() == 0)
    					tinhTrang="Đóng";
    				if(hv.getTinhTrang() == 2)
    					tinhTrang="Khóa";
			  %>
			   <tr>
				    <td><%=i %></td>
      				<td><%=hv.getMaLop() %></td>
      				<td><%=hv.getTenLop() %></td>
      				<td><%=hv.getSoHV() %></td>
      				<td><%=hv.getSoBuoi() %></td>
      				<td><%=hv.getNgayBatDau() %></td>
      				<td><%=hv.getNgayKetThuc() %></td>
      				<td><%=hv.getGiaoVienGiangDay() %></td>
      				<td><%=hv.getSoPhong() %></td>
      				<td><%=hv.getBuoiHoc()%></td>
      				<td><%=hv.getGioHoc() %></td>
      				<td><%=hv.getHocPhi() %></td>
      				<td><%=tinhTrang %></td>
			   </tr>
			  <% 
			   }
	 		%>
        </tbody>
    </table>
</body>
</html>