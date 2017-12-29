package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.LichKhaiGiangModel;

import com.google.gson.Gson;

import java.util.*;


@WebServlet("/lichkhaigiang")
public class lichkhaigiang extends HttpServlet {
	private static final long serialVersionUID = 1L;
   
    public lichkhaigiang() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/lichkhaigiang.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		List<LichKhaiGiangModel> LichKhaiGiang;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			LichKhaiGiang = DAO.lichkhaigiangDAO.LoadLichKhaiGiang();
			if(!LichKhaiGiang.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(LichKhaiGiang);
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
