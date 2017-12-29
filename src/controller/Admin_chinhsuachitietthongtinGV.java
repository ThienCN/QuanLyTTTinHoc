package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.AdminDAO;
import model.GiaoVienModel;

@WebServlet("/Admin_chinhsuachitietthongtinGV")
public class Admin_chinhsuachitietthongtinGV extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_chinhsuachitietthongtinGV() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Admin_chinh-sua-chi-tiet-thong-tin-GV.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Load thông tin giáo viên cần chỉnh sửa lên trang
	    if(flag == 1) {
	    	GiaoVienModel giaoVienChinhSuaThongTin = (GiaoVienModel)getServletContext().getAttribute("giaoVienChinhSuaThongTin");
	    	if(giaoVienChinhSuaThongTin != null) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(giaoVienChinhSuaThongTin); 
			    out.write(objectToReturn); 
			    out.flush();
		    }
		    else {
		    	out.write("{\"check\":\"fail\"}");
				out.flush();
		    }
	    }
	    
	    //flag=2: Cập nhật thông tin Giáo viên
	    if(flag == 2) {
	    	String maGiaoVien = request.getParameter("maGiaoVien");
	    	String hoTen = request.getParameter("hoTen");
	    	String CMND = request.getParameter("CMND");
	    	String ngaySinh = request.getParameter("ngaySinh");
	    	String diaChi = request.getParameter("diaChi");
	    	String SDT = request.getParameter("SDT");
	    	boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
	    	String trinhDoHV = request.getParameter("trinhDoHV");
	    	String email = request.getParameter("email");
	    	String matKhau = request.getParameter("matKhau");
	    	
	    	
	    	int k = AdminDAO.CapNhatGiaoVien(maGiaoVien, hoTen, ngaySinh, diaChi, SDT, CMND, trinhDoHV, email, gioiTinh, matKhau);
	    	if(k>0) {
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
