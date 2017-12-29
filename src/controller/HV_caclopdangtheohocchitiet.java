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

import model.GVTaiLieuModel;

@WebServlet("/HV_caclopdangtheohocchitiet")
public class HV_caclopdangtheohocchitiet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HV_caclopdangtheohocchitiet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaLop = (String)request.getParameter("MaLop");
		getServletContext().setAttribute("MaLop", MaLop);
		request.getRequestDispatcher("/WEB-INF/HV-cac-lop-dang-theo-hoc-chi-tiet.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaLop = (String)request.getServletContext().getAttribute("MaLop");
		List<GVTaiLieuModel> TaiLieu;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			TaiLieu = DAO.GV_DAO.LoadTaiLieu(MaLop);
			if(!TaiLieu.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(TaiLieu);
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
