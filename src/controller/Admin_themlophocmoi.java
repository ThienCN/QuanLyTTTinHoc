package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhoaHocDAO;

@WebServlet("/Admin_themlophocmoi")
public class Admin_themlophocmoi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_themlophocmoi() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/Admin_them-lop-hoc-moi.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    String MaLop = request.getParameter("MaLop");
	    String TenLop = request.getParameter("TenLop");
    	int SoHV = Integer.parseInt(request.getParameter("SoHV"));
    	int SoBuoi = Integer.parseInt(request.getParameter("SoBuoi"));
    	String HocPhi = request.getParameter("HocPhi");
    	String NgayBatDau = request.getParameter("NgayBatDau");
    	String NgayKetThuc = request.getParameter("NgayKetThuc");
    	String BuoiHoc = request.getParameter("BuoiHoc");
    	String GioHoc = request.getParameter("GioHoc");
    	String PhongHoc = request.getParameter("PhongHoc");
    	String GiaoVien = request.getParameter("GiaoVien");
    	String KhoaHoc = request.getParameter("KhoaHoc");
	    
	    
	    int kq = KhoaHocDAO.ThemLopHocMoi(MaLop, TenLop, KhoaHoc, GiaoVien, SoBuoi, NgayBatDau, NgayKetThuc, PhongHoc, BuoiHoc, SoHV, GioHoc, HocPhi);
	    
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
