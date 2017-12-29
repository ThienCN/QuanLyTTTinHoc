package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/themchitietdangkykhoahoconl")
public class themchitietdangkykhoahoconl extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public themchitietdangkykhoahoconl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String HoTen = (String)request.getParameter("HoTen");
		String NgaySinh = (String)request.getParameter("NgaySinh");
		String SDT = (String)request.getParameter("SDT");
		String DiaChi = (String)request.getParameter("DiaChi");
		String Email = (String)request.getParameter("Email");
		
		String MaDkyOnl = DAO.dangkykhoahocDAO.ThemDangKyOnl(HoTen, NgaySinh, SDT, DiaChi, Email);
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		if (("".equals(MaDkyOnl))) {
			out.write("{\"check\":\"fail\"}");
			out.flush();
		} else {
			getServletContext().setAttribute("MaDkyOnl", MaDkyOnl);
			out.write("{\"check\":\"" + MaDkyOnl + "\"}");
			out.flush();
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDangKyOnl = (String)request.getParameter("MaDangKyOnl");
		String MaLop = (String)request.getParameter("MaLop");
		
		int kq = DAO.dangkykhoahocDAO.ThemChiTietDangKyOnl(MaDangKyOnl, MaLop);
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		if(kq > 0) {
			out.write("{\"check\":\"yes\"}");
			out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
			out.flush();
		}
	}

}
