package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

@WebServlet("/GV_nhapdiem")
public class GV_nhapdiem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GV_nhapdiem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/GV-nhap-diem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHV = (String)request.getParameter("MaHV");
		String MaLop = (String)request.getParameter("MaLop");
		Float DiemLT, DiemTH, DiemTB;
		if("".equals(request.getParameter("DiemLT"))){
			DiemLT = null;
		}
		else {
			DiemLT = Float.parseFloat(request.getParameter("DiemLT"));
		}
		if("".equals(request.getParameter("DiemTH"))){
			DiemTH = null;
		}
		else {
			DiemTH = Float.parseFloat(request.getParameter("DiemTH"));
		}
		if("".equals(request.getParameter("DiemTB"))){
			DiemTB = null;
		}
		else {
			DiemTB = Float.parseFloat(request.getParameter("DiemTB"));
		}
//		float DiemLT = Float.parseFloat(request.getParameter("DiemLT"));
//		float DiemTH = Float.parseFloat(request.getParameter("DiemTH"));
//		float DiemTB = Float.parseFloat(request.getParameter("DiemTB"));
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			int kq = DAO.GV_DAO.CapNhatDiem(MaHV, MaLop, DiemLT, DiemTH, DiemTB);
			if(kq > 0) {
				out.write("{\"check\":\"yes\"}");
			    out.flush();
			}
			else
			{
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
