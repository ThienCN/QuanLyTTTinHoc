package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.NV_thongkeDAO;
import model.GiaoVienModel;

@WebServlet("/NV_thongkeDSGV")
public class NV_thongkeDSGV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_thongkeDSGV() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-thong-ke-DSGV.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH = request.getParameter("maKH");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter(); 
	    
    	List<GiaoVienModel> dsGiaoVien;
    	
    	//maKH = Tất cả: load lên toàn bộ ds Giáo viên ở trung tâm
		if("Tất cả".equals(maKH)) 
			dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVien();
		else //maKH != Tất cả:Load ds Giáo viên giảng dạy của từng khóa
			dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVienTheoKhoaHoc(maKH);
		
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

}
