package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import model.HocVienModel;

@WebServlet("/HV_thongtincanhan")
public class HV_thongtincanhan extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HV_thongtincanhan() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/HV-thong-tin-ca-nhan.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHV = (String)request.getSession().getAttribute("username");
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		HocVienModel ThongTinCaNhan;
		
		try {
			ThongTinCaNhan = DAO.HV_DAO.LayThongTinMotHocVien(MaHV);
			if(!"".equals(ThongTinCaNhan)) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(ThongTinCaNhan);
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
