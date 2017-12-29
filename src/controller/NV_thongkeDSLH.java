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

import DAO.NV_thongkeDAO;
import model.LopHocModel;

@WebServlet("/NV_thongkeDSLH")
public class NV_thongkeDSLH extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_thongkeDSLH() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-thong-ke-DSLH.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maKH = request.getParameter("maKH");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		List<LopHocModel> dsLopHoc = NV_thongkeDAO.LayDSLopHocCuaMotKhoaHoc(maKH);
		
		if(!dsLopHoc.isEmpty()) {
			if(dsLopHoc.get(0).getError() != null) {
				out.write("{\"check\":\""+ dsLopHoc.get(0).getError() +"\"}");
			    out.flush();
			}
			else {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsLopHoc); 
			    out.write(objectToReturn); 
			    out.flush();
			}
		}
		else {
			out.write("{\"check\":\"fail\"}");
			out.flush();
		}
	}

}
