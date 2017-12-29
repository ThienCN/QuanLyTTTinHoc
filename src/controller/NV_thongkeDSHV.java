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
import model.HVDKyOnlineModel;
import model.HocVienModel;
import model.LopHocModel;

@WebServlet("/NV_thongkeDSHV")
public class NV_thongkeDSHV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_thongkeDSHV() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-thong-ke-DSHV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	  //flag = 1: lấy ds lớp học của 1 khóa học
  		if(flag == 1) {
  			String maKhoaHoc = request.getParameter("maKH");
  			
  			List<LopHocModel> dsLopHoc = new ArrayList<LopHocModel>();
  			
  			dsLopHoc = NV_thongkeDAO.LayDSLopHocCuaMotKhoaHoc(maKhoaHoc);
  			
  			if(!dsLopHoc.isEmpty()) {
  				if(dsLopHoc.get(0).getError() == null) {
  					Gson gson = new Gson();
  	  			    String objectToReturn = gson.toJson(dsLopHoc); 
  	  			    out.write(objectToReturn); 
  	  			    out.flush();
  				}
  				else {
  					out.write("{\"check\":\""+ dsLopHoc.get(0).getError() +"\"}");
  					out.flush();
  				}
  			}
  			else {
				out.write("{\"check\":\"fail\"}");
  			    out.flush();
  			}
  		}
		
		//flag = 2: lấy ds học viên của một lớp học
		if(flag == 2) {
			String maLopHoc = request.getParameter("maLopHoc");
			
			List<HocVienModel> dsHocVien = NV_thongkeDAO.LayDSHVCuaMotLopHoc(maLopHoc);
			
			
			if(!dsHocVien.isEmpty()) {
				if(dsHocVien.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsHocVien); 
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\""+ dsHocVien.get(0).getError() +"\"}");
				    out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
	}

}
