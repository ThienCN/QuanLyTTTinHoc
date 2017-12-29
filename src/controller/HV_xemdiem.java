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

import model.GVBangDiemHocVienModel;;

@WebServlet("/HV_xemdiem")
public class HV_xemdiem extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public HV_xemdiem() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/HV-xem-diem.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaHV = (String)request.getSession().getAttribute("username");
		
		List<GVBangDiemHocVienModel> XemDiem;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
			XemDiem = DAO.HV_DAO.XemDiem(MaHV);
			if(!XemDiem.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(XemDiem);
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
