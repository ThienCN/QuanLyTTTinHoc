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
import model.NguoiDungModel;

@WebServlet("/Admin_chinhsuachitietthongtinnguoidung")
public class Admin_chinhsuachitietthongtinnguoidung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_chinhsuachitietthongtinnguoidung() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Admin_chinh-sua-chi-tiet-thong-tin-ND.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Load thông tin người dùng cần chỉnh sửa lên trang
	    if(flag == 1) {
	    	NguoiDungModel nguoiDungChinhSuaThongTin = (NguoiDungModel)getServletContext().getAttribute("nguoiDungChinhSuaThongTin");
    		if(nguoiDungChinhSuaThongTin != null) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(nguoiDungChinhSuaThongTin); 
			    out.write(objectToReturn); 
			    out.flush();
		    }
    		else {
		    	out.write("{\"check\":\"fail\"}");
				out.flush();
		    } 
	    }
	    
	   //flag=2: Cập nhật người dùng
	   if(flag == 2) {
		    String maND = request.getParameter("maND");
		   	String hoTen = request.getParameter("hoTen");
			String CMND = request.getParameter("CMND");
			String ngaySinh = request.getParameter("ngaySinh");
			String diaChi = request.getParameter("diaChi");
			String SDT = request.getParameter("SDT");
			boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
			String trinhDoHV = request.getParameter("trinhDoHV");
			String email = request.getParameter("email");
			String matKhau = request.getParameter("matKhau");
			int chucDanh = Integer.parseInt(request.getParameter("chucDanh")); 
			
			//3: Nhân viên
    		//4: Quản trị viên
			
			if(chucDanh == 3) {
				int kq = AdminDAO.CapNhatNhanVien(maND, hoTen, ngaySinh, diaChi, SDT, CMND, trinhDoHV, email, gioiTinh, matKhau);
				if(kq>0) {
					out.write("{\"check\":\"ok\"}");
					out.flush();
				}
				else {
					out.write("{\"check\":\"fail\"}");
					out.flush();
				}
			}
			
			if(chucDanh == 4) {
				int kq = AdminDAO.CapNhatQuanTriVien(maND, hoTen, ngaySinh, diaChi, SDT, CMND, trinhDoHV, email, gioiTinh, matKhau);
				if(kq>0) {
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

}
