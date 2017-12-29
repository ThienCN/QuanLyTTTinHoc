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

@WebServlet("/NV_quanlytintuc")
public class NV_quanlytintuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_quanlytintuc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-quan-ly-tin-tuc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		//flag = 1: Lấy toàn bộ tin tuc
		if(flag==1) {
			List<TinTucModel> dsTinTuc = TinTucDAO.LayTinTuc();
			
			if(!dsTinTuc.isEmpty()) {
				if(dsTinTuc.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsTinTuc);
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\"" + dsTinTuc.get(0).getError()  + "\"}");
				    out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		//flag = 2: Đưa 1 TT lên đầu
		if(flag == 2) {
			String maTT = request.getParameter("maTT");
			
			int kq=TinTucDAO.DuaTinTucLenDau(maTT);
			
			if(kq>0) {
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		//flag = 3: Update hiện tin tức
		if(flag == 3) {
			String maTT = request.getParameter("maTT");
			int tinhTrang = Integer.parseInt(request.getParameter("tinhTrang"));
			
			int kq=TinTucDAO.AnHienMotTinTuc(maTT,tinhTrang);
			
			if(kq>0) {
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		
		//flag = 5: lấy tin tức bỏ vào scope...chuẩn bị cho chuyển qua trang chỉnh sửa tin tức
		if(flag == 5) {
			String maTT = request.getParameter("maTT");
			
			List<TinTucModel> tintucEdit = TinTucDAO.LayMotTinTuc(maTT);
			
			if(!tintucEdit.isEmpty()) {
				if(tintucEdit.get(0).getError() == null) {
					getServletContext().setAttribute("tintucEdit", tintucEdit);
					out.write("{\"check\":\"ok\"}");
				    out.flush();
				}
				else {
					out.write("{\"check\":\"fail\"}");
				    out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			
		}
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String maTT = request.getParameter("maTT");
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		int kq = TinTucDAO.XoaTinTuc(maTT);
		
		if(kq>0) {
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String thongTinTimKiem = request.getParameter("thongTinTimKiem");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    List<TinTucModel> dsTinTuc = TinTucDAO.TimKiemTinTuc(thongTinTimKiem);
		
		if(!dsTinTuc.isEmpty()) {
			if(dsTinTuc.get(0).getError() == null) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsTinTuc);
			    out.write(objectToReturn); 
			    out.flush();
			}
			else {
				out.write("{\"check\":\"" + dsTinTuc.get(0).getError()  + "\"}");
				out.flush();
			}
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	
	}
}
