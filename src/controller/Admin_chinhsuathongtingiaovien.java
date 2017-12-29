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

import DAO.AdminDAO;
import DAO.NV_thongkeDAO;
import model.GiaoVienModel;

@WebServlet("/Admin_chinhsuathongtingiaovien")
public class Admin_chinhsuathongtingiaovien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_chinhsuathongtingiaovien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Admin_chinh-sua-thong-tin-GV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Load toàn bộ danh sách giáo viên
	    if(flag == 1) {
	    	List<GiaoVienModel> dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVien();
			if(!dsGiaoVien.isEmpty()) {
				if(dsGiaoVien.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsGiaoVien); 
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\""+ dsGiaoVien.get(0).getError() +"\"}");
					 out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	    
	    //flag=2: Tìm kiếm thông tin giáo viên
	    if(flag == 2) {
	    	String thongTinTimKiem = request.getParameter("thongTinTimKiem");
	    	
	    	List<GiaoVienModel> dsGiaoVien = AdminDAO.TimKiemGiaoVien(thongTinTimKiem);
			if(!dsGiaoVien.isEmpty()) {
				if(dsGiaoVien.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsGiaoVien); 
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\""+ dsGiaoVien.get(0).getError() +"\"}");
					 out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	    
	    //flag=3: Lấy mã GV đi lấy thông tin của GV đó
		//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
	    if(flag == 3) {
	    	String maGV = request.getParameter("maGV");
	    	
	    	GiaoVienModel giaoVienChinhSuaThongTin = AdminDAO.LayThongTinMotGiaoVien(maGV);
			if(giaoVienChinhSuaThongTin != null) {
				getServletContext().setAttribute("giaoVienChinhSuaThongTin", giaoVienChinhSuaThongTin);
				out.write("{\"check\":\"ok\"}");
				out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	}

}
