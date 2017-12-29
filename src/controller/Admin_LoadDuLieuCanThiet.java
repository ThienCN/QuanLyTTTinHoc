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
import DAO.NV_thongkeDAO;
import model.BuoiHocModel;
import model.GiaoVienModel;
import model.GioHocModel;
import model.HocPhiModel;
import model.KhoaHocModel;
import model.PhongHocModel;

@WebServlet("/Admin_LoadDuLieuCanThiet")
public class Admin_LoadDuLieuCanThiet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_LoadDuLieuCanThiet() {
        super();
    }

    //Load danh sách học phí, buổi học, giờ học, phòng, giáo viên, khóa học lên các combobox
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: load ds học phí
	    if(flag == 1) {
	    	List<HocPhiModel> dsHocPhi = KhoaHocDAO.LayHocPhi();
			
			if(!dsHocPhi.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsHocPhi);
			    out.write(objectToReturn); 
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	    
	    //flag=2: load ds BUỔI HỌC
	    if(flag == 2) {
	    	List<BuoiHocModel> dsBuoiHoc = KhoaHocDAO.LayBuoiHoc();
			
			if(!dsBuoiHoc.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsBuoiHoc);
			    out.write(objectToReturn); 
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	    
	    //flag=3: load ds GIỜ HỌC
	    if(flag == 3) {
	    	List<GioHocModel> dsGioHoc = KhoaHocDAO.LayGioHoc();
			
			if(!dsGioHoc.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsGioHoc);
			    out.write(objectToReturn); 
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	    //flag=4: load ds PHÒNG HỌC
	    if(flag == 4) {
	    	List<PhongHocModel> dsPhongHoc = KhoaHocDAO.LayPhongHoc();
			
			if(!dsPhongHoc.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsPhongHoc);
			    out.write(objectToReturn); 
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	    //flag=5: load ds PHÒNG HỌC
	    if(flag == 5) {
	    	List<GiaoVienModel> dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVien();
			
			if(!dsGiaoVien.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsGiaoVien);
			    out.write(objectToReturn); 
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
	    }
	    
	    //flag=6: load ds TRÌNH ĐỘ HỌC VẤN
	    if(flag == 3) {
	    	List<GioHocModel> dsGioHoc = KhoaHocDAO.LayGioHoc();
			
			if(!dsGioHoc.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsGioHoc);
			    out.write(objectToReturn); 
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
