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

import DAO.HV_DAO;
import model.LichKhaiGiangModel;

@WebServlet("/dangkykhoahocthanhcong")
public class dangkykhoahocthanhcong extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dangkykhoahocthanhcong() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/dangkykhoahocthanhcong.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaDkyOnl = (String)getServletContext().getAttribute("MaDkyOnl");
		
		List<LichKhaiGiangModel> DangKyThanhCong;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			DangKyThanhCong = HV_DAO.DangKyThanhCong(MaDkyOnl);
			if(!DangKyThanhCong.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(DangKyThanhCong);
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
