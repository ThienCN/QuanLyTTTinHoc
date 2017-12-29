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
import DAO.ThongBaoDAO;
import model.KhoaHocModel;
import model.LopHocModel;


@WebServlet("/Admin_themkhoahocmoi")
public class Admin_themkhoahocmoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_themkhoahocmoi() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Admin_them-khoa-hoc-moi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Lấy thông tin toàn bộ các khóa học
	    if(flag == 1) {
	    	List<KhoaHocModel> dsKhoaHoc = KhoaHocDAO.LayKhoaHoc();
			
			if(!dsKhoaHoc.isEmpty()) {
				if(dsKhoaHoc.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsKhoaHoc);
				    out.write(objectToReturn); 
				    out.flush();
				    return;
				}
				else {
					out.write("{\"check\":\"" + dsKhoaHoc.get(0).getError()  + "\"}");
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
		
	    //flag=2: Tạo mới 1 khóa học
	    if(flag == 2) {
	    	String maKhoaHoc = request.getParameter("maKhoaHoc");
	    	String ngayKhaiGiang = request.getParameter("ngayKhaiGiang");
	    	
	    	int kq = KhoaHocDAO.ThemKhoaHoc(maKhoaHoc, ngayKhaiGiang);
	    	
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
