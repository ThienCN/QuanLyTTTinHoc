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
import model.ThongBaoModel;

@WebServlet("/thongbao")
public class thongbao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public thongbao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/thongbao.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		//flag = 1: Đếm số lượng Thông báo
		if(flag == 1) {
			int kq = ThongBaoDAO.SoLuongThongBao();
			
			out.write("{\"soLuong\":\""+ kq +"\"}");
		    out.flush();
		}
		//flag = 2: Load thông báo đầu lên trang thông báo
		if(flag == 2) {
			List<ThongBaoModel> dsThongBao = ThongBaoDAO.LayThongBaoDau();
			
			if(!dsThongBao.isEmpty()) {
				if(dsThongBao.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsThongBao); 
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\""+ dsThongBao.get(0).getError() +"\"}");
				    out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			
		}
		//flag=3: Load 3 thông báo phụ lên trang thông báo theo stt từ [start,end]
		if(flag == 3) {
			int start = Integer.parseInt(request.getParameter("start"));
			int end = Integer.parseInt(request.getParameter("end"));
			
			List<ThongBaoModel> dsThongBao = ThongBaoDAO.LayThongBaoPhu(start, end);
			
			if(!dsThongBao.isEmpty()) {
				if(dsThongBao.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsThongBao); 
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\""+ dsThongBao.get(0).getError() +"\"}");
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
