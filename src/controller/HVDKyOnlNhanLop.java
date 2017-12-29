package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
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
import model.LopHocModel;

@WebServlet("/HVDKyOnlNhanLop")
public class HVDKyOnlNhanLop extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public HVDKyOnlNhanLop() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maDKOnline = request.getParameter("maDKOnline");
		
		HVDKyOnlineModel hvDkyOnl = NV_tracuuDkyOnlDAO.TraCuuThongTinHVDkyOnl(maDKOnline);
		List<LopHocDKyOnlModel> dsLopHocDkyOnl = NV_tracuuDkyOnlDAO.DSLopHocDangKyOnline(maDKOnline);
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    if(hvDkyOnl == null || hvDkyOnl.getError() != null) {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	    else if(dsLopHocDkyOnl.isEmpty() || dsLopHocDkyOnl.get(0).getError() != null) {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	    else {
	    	SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat parser = new SimpleDateFormat("dd-MM-yyyy");
	        
	        try {
				Date date = parser.parse(hvDkyOnl.getNgaySinh());
				
				hvDkyOnl.setNgaySinh(formatter.format(date));
				
				getServletContext().setAttribute("hvDkyOnl", hvDkyOnl);
				getServletContext().setAttribute("dsLopHocDkyOnl", dsLopHocDkyOnl); 
				
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			} catch (ParseException e) {
				e.printStackTrace();
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		//flag = 1: Lấy thông tin cá nhân học viên đăng ký online
		if(flag == 1) {
			if(getServletContext().getAttribute("hvDkyOnl") == null) {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			else {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(getServletContext().getAttribute("hvDkyOnl"));
			    out.write(objectToReturn); 
			    out.flush();
			}
		}
		
		//flag = 2: Lấy thông tin đăng ký lớp học online của học viên đăng ký online
		if(flag == 2) { 
			if(getServletContext().getAttribute("dsLopHocDkyOnl") == null) {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			else {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(getServletContext().getAttribute("dsLopHocDkyOnl")); 
			    out.write(objectToReturn); 
			    out.flush();
			}
		}
		
	}

}
