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

import model.HVThoiKhoaBieuModel;;

@WebServlet("/HV_thoikhoabieu")
public class HV_thoikhoabieu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HV_thoikhoabieu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/HV-thoi-khoa-bieu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String MaHV = (String)request.getSession().getAttribute("username");
		String TuNgay = (String)request.getParameter("TuNgay");
		String DenNgay = (String)request.getParameter("DenNgay");
		
		List<HVThoiKhoaBieuModel> ThoiKhoaBieu;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			ThoiKhoaBieu = DAO.HV_DAO.LoadThoiKhoaBieu(TuNgay, DenNgay, MaHV);
			if(!ThoiKhoaBieu.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(ThoiKhoaBieu);
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
