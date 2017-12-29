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

import model.HVKhoaHocModel;

@WebServlet("/khoahoc")
public class khoahoc extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public khoahoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHV = (String)request.getSession().getAttribute("username");
		List<HVKhoaHocModel> KhoaHoc;
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		try {
			KhoaHoc = DAO.KhoaHocDAO.LoadKhoaHoc(MaHV);
			if(!KhoaHoc.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(KhoaHoc);
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

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaGV = (String)request.getSession().getAttribute("username");
		
		List<HVKhoaHocModel> KhoaHoc;
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();

		try {
			KhoaHoc = DAO.KhoaHocDAO.LoadKhoaHocGV(MaGV);
			if(!KhoaHoc.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(KhoaHoc);
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
