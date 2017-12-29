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

@WebServlet("/index")
public class index extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public index() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/index.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag = 1: Load 4 thông báo nổi bật lên  
	    if(flag == 1) {
	    	List<ThongBaoModel> dsThongBao = ThongBaoDAO.LayThongBaoPhu(1, 4);
	    	
	    	if(!dsThongBao.isEmpty()) {
	    		if(dsThongBao.get(0).getError() == null) {
	    			Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsThongBao);
				    out.write(objectToReturn); 
				    out.flush();
				    return;
	    		}
	    		else {
	    			out.write("{\"check\":\"" + dsThongBao.get(0).getError()  + "\"}");
    			 	out.flush();
    			 	return;
	    		}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	    
	    //flag=2: Load 4 tin tức nổi bật lên
		if(flag == 2) {
			List<TinTucModel> dsTinTuc = TinTucDAO.LayTinTucPhu(1, 4);
			
			if(!dsTinTuc.isEmpty()) {
				if(dsTinTuc.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsTinTuc); 
				    out.write(objectToReturn); 
				    out.flush();
				    return;
				}
				else {
					out.write("{\"check\":\""+ dsTinTuc.get(0).getError() +"\"}");
					out.flush();
					return;
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			
		}
	}

}
