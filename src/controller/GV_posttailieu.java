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

import DAO.GV_DAO;
import model.GVDanhSachGiangDayModel;;

@WebServlet("/GV_posttailieu")
public class GV_posttailieu extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public GV_posttailieu() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/GV-post-tai-lieu.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaGV = (String)request.getSession().getAttribute("username");
		
		List<GVDanhSachGiangDayModel> DanhSachGiangDay;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			DanhSachGiangDay = DAO.GV_DAO.DanhSachGiangDay(MaGV);
			if(!DanhSachGiangDay.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(DanhSachGiangDay);
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

	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaTLMoi = request.getParameter("MaTLMoi");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(GV_DAO.XoaTaiLieu(MaTLMoi) > 0) {
			out.write("{\"MaTLMoi\":\"yes\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	}
}
