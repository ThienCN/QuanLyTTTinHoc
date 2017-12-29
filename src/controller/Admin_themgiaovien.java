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
import DAO.KhoaHocDAO;
import model.GioHocModel;
import model.TrinhDoHocVanModel;

@WebServlet("/Admin_themgiaovien")
public class Admin_themgiaovien extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_themgiaovien() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Admin_them-giao-vien.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Load mã giáo viên mới lên
	    if(flag == 1) {
	    	String maGVMoi = AdminDAO.MaGiaoVienMoi();
	    	out.write("{\"maGVMoi\":\"" + maGVMoi + "\"}");
		    out.flush();
		    return;
	    }
	    
	    //flag=2: Load ds Trình độ học vấn
	    if(flag == 2) {
	    	List<TrinhDoHocVanModel> dsTrinhDoHV = KhoaHocDAO.LayTrinhDoHocVan();
			
			if(!dsTrinhDoHV.isEmpty()) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsTrinhDoHV);
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
	    
	    //flag=3: Thêm 1 giáo viên mới
	    if(flag == 3) {
	    	String hoTen = request.getParameter("hoTen");
	    	String CMND = request.getParameter("CMND");
	    	String ngaySinh = request.getParameter("ngaySinh");
	    	String diaChi = request.getParameter("diaChi");
	    	String SDT = request.getParameter("SDT");
	    	boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
	    	String trinhDoHV = request.getParameter("trinhDoHV");
	    	String email = request.getParameter("email");
	    	
	    	String maGVMoi = AdminDAO.ThemGiaoVienMoi(hoTen, ngaySinh, diaChi, SDT, CMND, trinhDoHV, email, gioiTinh);
	    	
	    	if(maGVMoi != null) {
	    		out.write("{\"maGVMoi\":\"" + maGVMoi + "\"}");
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
