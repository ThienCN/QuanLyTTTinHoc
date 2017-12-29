package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.NV_tracuuDkyOnlDAO;
import model.HVDKyOnlineModel;
import model.LopHocDKyOnlModel;

@WebServlet("/NV_tracuuDKOnl")
public class NV_tracuuDKOnl extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_tracuuDKOnl() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.getRequestDispatcher("/WEB-INF/NV-tra-cuu-DKOnl.jsp").forward(request, response);
	
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		//flag = 1: lấy thông tin cá nhân của người đăng ký
		if(flag == 1) {
			String MaDkyOnl = request.getParameter("MaDkyOnl");
			
			HVDKyOnlineModel hvDkyOnl = NV_tracuuDkyOnlDAO.TraCuuThongTinHVDkyOnl(MaDkyOnl);
			
			if(hvDkyOnl == null || hvDkyOnl.getError() != null) {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			else {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(hvDkyOnl); 
			    out.write(objectToReturn); 
			    out.flush();
			}
		}
		
		//flag = 2: lấy thông tin đăng ký lớp học
		if(flag == 2) {
			String maDKOnline = request.getParameter("maDKOnline");
			
			List<LopHocDKyOnlModel> dsLopHocDkyOnl = NV_tracuuDkyOnlDAO.DSLopHocDangKyOnline(maDKOnline);
			
			if(!dsLopHocDkyOnl.isEmpty()) {
				if(dsLopHocDkyOnl.get(0).getError() != null) {
					out.write("{\"check\":\"" + dsLopHocDkyOnl.get(0).getError() + "\"}");
				    out.flush();
				}
				else {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsLopHocDkyOnl); 
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
	
}
