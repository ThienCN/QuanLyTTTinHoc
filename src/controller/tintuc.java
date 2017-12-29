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

import DAO.ThongBaoDAO;
import DAO.TinTucDAO;
import model.ThongBaoModel;
import model.TinTucModel;


@WebServlet("/tintuc")
public class tintuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public tintuc() {
        super();
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/tintuc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag = 1: Đếm số lượng Thông báo
  		if(flag == 1) {
  			int kq = TinTucDAO.SoLuongTinTuc();
  			
  			out.write("{\"soLuong\":\""+ kq +"\"}");
  		    out.flush();
  		}
    
	    //flag = 2: Load tin tức đầu lên trang tin tức
  		if(flag == 2) {
  			List<TinTucModel> dsTinTuc = TinTucDAO.LayTinTucDau();
  			
  			if(!dsTinTuc.isEmpty()) {
  				if(dsTinTuc.get(0).getError() == null) {
  					Gson gson = new Gson();
  	  			    String objectToReturn = gson.toJson(dsTinTuc); 
  	  			    out.write(objectToReturn); 
  	  			    out.flush();
  				}
  				else {
  					out.write("{\"check\":\""+ dsTinTuc.get(0).getError() +"\"}");
  	  			    out.flush();
  				}
  			}
  			else {
				out.write("{\"check\":\"fail\"}");
  			    out.flush();
  			}
  			
  		}
  		
  	    //flag=3: Load 3 tin tức phụ lên trang tin tức theo stt từ [start,end]
		if(flag == 3) {
			int start = Integer.parseInt(request.getParameter("start"));
			int end = Integer.parseInt(request.getParameter("end"));
			
			List<TinTucModel> dsTinTuc = TinTucDAO.LayTinTucPhu(start, end);
			
			if(!dsTinTuc.isEmpty()) {
				if(dsTinTuc.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsTinTuc); 
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\""+ dsTinTuc.get(0).getError() +"\"}");
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
