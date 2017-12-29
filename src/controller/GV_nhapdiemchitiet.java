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

import model.GVBangDiemHocVienModel;
import model.HVThoiKhoaBieuModel;;

@WebServlet("/GV_nhapdiemchitiet")
public class GV_nhapdiemchitiet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GV_nhapdiemchitiet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaLop = (String)request.getParameter("MaLop");
		getServletContext().setAttribute("MaLop", MaLop);
		request.getRequestDispatcher("/WEB-INF/GV-nhap-diem-chi-tiet.jsp?MaLop="+MaLop).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaLop = (String)request.getServletContext().getAttribute("MaLop");
		List<GVBangDiemHocVienModel> BangDiemHocVien;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			BangDiemHocVien = DAO.GV_DAO.BangDiemHocVien(MaLop);
			if(!BangDiemHocVien.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(BangDiemHocVien);
				out.write(objectToReturn);
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
