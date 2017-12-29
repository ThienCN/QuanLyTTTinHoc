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

import model.GVLichGiangDayModel;

@WebServlet("/GV_lichgiangday")
public class GV_lichgiangday extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GV_lichgiangday() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/GV-lich-giang-day.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaGV = (String)request.getSession().getAttribute("username");
		String TuNgay = (String)request.getParameter("TuNgay");
		String DenNgay = (String)request.getParameter("DenNgay");
		
		List<GVLichGiangDayModel> LichGiangDay;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			LichGiangDay = DAO.GV_DAO.LoadLichGiangDay(TuNgay, DenNgay, MaGV);
			if(!LichGiangDay.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(LichGiangDay);
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
