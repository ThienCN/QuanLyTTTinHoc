package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.DangKyKhoaHocModel;

import com.google.gson.Gson;

@WebServlet("/dangkykhoahoc")
public class dangkykhoahoc extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public dangkykhoahoc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String MaLop = (String)request.getParameter("MaLop");
		if(MaLop != null || !("".equals(MaLop))) {
			getServletContext().setAttribute("MaLop", MaLop);
		}
		request.getRequestDispatcher("/WEB-INF/dangkykhoahoc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<DangKyKhoaHocModel> LopHoc;
		
		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");

		PrintWriter out = response.getWriter();
		
		try {
//			if(MaLop != null || !("".equals(MaLop))) {
//				System.out.println("yes");
//				out.write("{\"check\":\"yes\"}");
//			}
			
			LopHoc = DAO.dangkykhoahocDAO.LoadLopHoc();
			if(!LopHoc.isEmpty()) {
				Gson gson=new Gson();
				String objectToReturn=gson.toJson(LopHoc);
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
