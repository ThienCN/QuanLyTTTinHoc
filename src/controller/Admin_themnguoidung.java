package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.AdminDAO;

@WebServlet("/Admin_themnguoidung")
public class Admin_themnguoidung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_themnguoidung() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Admin_them-nguoi-dung.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Load mã Nhân viên mới lên
	    if(flag == 1) {
	    	String maNVMoi = AdminDAO.MaNhanVienMoi();
	    	out.write("{\"maNVMoi\":\"" + maNVMoi + "\"}");
		    out.flush();
		    return;
	    }
	    
	    //flag=2: Load mã Quản trị viên mới lên
	    if(flag == 2) {
	    	String maAdminMoi = AdminDAO.MaQuanTriVienMoi();
	    	out.write("{\"maAdminMoi\":\"" + maAdminMoi + "\"}");
		    out.flush();
		    return;
	    }
	    
	    //flag=3: Thêm người dùng
	    if(flag == 3) {
	    	String hoTen = request.getParameter("hoTen");
			String CMND = request.getParameter("CMND");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChi = request.getParameter("diaChi");
			String SDT = request.getParameter("SDT");
			boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
			String trinhDoHV = request.getParameter("trinhDoHV");
			String email = request.getParameter("email");
			int chucDanh = Integer.parseInt(request.getParameter("chucDanh")); 
			
			//3: Nhân viên
    		//4: Quản trị viên
			
			if(chucDanh == 3) {
				String maNDMoi = AdminDAO.ThemNhanVienMoi(hoTen, ngaySinh, diaChi, SDT, CMND, trinhDoHV, email, gioiTinh);
		    	
		    	if(maNDMoi != null) {
		    		out.write("{\"maNDMoi\":\"" + maNDMoi + "\"}");
				    out.flush();
				    return;
		    	}
		    	else {
		    		out.write("{\"check\":\"fail\"}");
				    out.flush();
				    return;
		    	}
			}
			
			if(chucDanh == 4) {
				String maNDMoi = AdminDAO.ThemQuanTriVienMoi(hoTen, ngaySinh, diaChi, SDT, CMND, trinhDoHV, email, gioiTinh);
		    	
		    	if(maNDMoi != null) {
		    		out.write("{\"maNDMoi\":\"" + maNDMoi + "\"}");
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

}
