package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KhoaHocDAO;

@WebServlet("/Admin_chinhsuathongtinkhoahoc")
public class Admin_chinhsuathongtinkhoahoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_chinhsuathongtinkhoahoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Admin_chinh-sua-thong-tin-khoa-hoc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKhoaHoc = request.getParameter("maKhoaHoc");
		String ngayKhaiGiang = request.getParameter("ngayKhaiGiang");
		int tinhTrang = Integer.parseInt(request.getParameter("tinhTrang"));
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		int kq=KhoaHocDAO.CapNhatKhoaHoc(maKhoaHoc, ngayKhaiGiang, tinhTrang);
		
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
