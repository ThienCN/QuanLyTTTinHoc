package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.KhoaHocDAO;
import model.KhoaHocModel;
import model.LopHocModel;

@WebServlet("/Admin_chinhsuathongtinlophoc")
public class Admin_chinhsuathongtinlophoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public Admin_chinhsuathongtinlophoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Admin_chinh-sua-thong-tin-lop-hoc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		//flag=1: Lấy mã lớp học đi tìm kiếm thông tin lớp học
	    if(flag == 1) {
	    	String maLopHoc = request.getParameter("maLopHoc");
	    	List<LopHocModel> lopHoc = KhoaHocDAO.TraCuuLopHoc(maLopHoc);
	    	 
			if(!lopHoc.isEmpty()) {
				if(lopHoc.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(lopHoc);
				    out.write(objectToReturn); 
				    out.flush();
				    return;
				}
				else {
					out.write("{\"check\":\"" + lopHoc.get(0).getError()  + "\"}");
					out.flush();
					return;
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	    
	    if(flag == 2) {
	    	String maLopHocMoi = request.getParameter("maLopHocMoi");	    	
			String tenLopHocMoi = request.getParameter("tenLopHocMoi");
			int soHVMoi = Integer.parseInt(request.getParameter("soHVMoi"));
			int soBuoiHocMoi = Integer.parseInt(request.getParameter("soBuoiHocMoi"));
			String hocPhiMoi = request.getParameter("hocPhiMoi");
			String ngayBatDauMoi = request.getParameter("ngayBatDauMoi");
			String buoiHocMoi = request.getParameter("buoiHocMoi");
			String gioHocMoi = request.getParameter("gioHocMoi");
			String ngayKetThucMoi = request.getParameter("ngayKetThucMoi");
			String phongHocMoi = request.getParameter("phongHocMoi");
			String giaoVienMoi = request.getParameter("giaoVienMoi");
			int tinhTrangMoi = Integer.parseInt(request.getParameter("tinhTrangMoi"));
			String maLopHocCu = request.getParameter("maLopHocCu");
			
			
			int kq = KhoaHocDAO.CapNhatLopHoc(maLopHocCu, maLopHocMoi, tenLopHocMoi, giaoVienMoi, soBuoiHocMoi, 
							ngayBatDauMoi, ngayKetThucMoi, phongHocMoi, buoiHocMoi, soHVMoi, gioHocMoi, hocPhiMoi, tinhTrangMoi);
			
			if(kq>0) {
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	}

}
