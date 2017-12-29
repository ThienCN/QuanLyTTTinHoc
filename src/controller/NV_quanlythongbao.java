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

@WebServlet("/NV_quanlythongbao")
public class NV_quanlythongbao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_quanlythongbao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-quan-ly-thong-bao.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		//flag = 1: Lấy toàn bộ thông báo
		if(flag==1) {
			List<ThongBaoModel> dsThongBao = ThongBaoDAO.LayThongBao();
			
			if(!dsThongBao.isEmpty()) {
				if(dsThongBao.get(0).getError() == null) {
					Gson gson = new Gson();
				    String objectToReturn = gson.toJson(dsThongBao);
				    out.write(objectToReturn); 
				    out.flush();
				}
				else {
					out.write("{\"check\":\"" + dsThongBao.get(0).getError()  + "\"}");
					out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		//flag = 2: Đưa 1 TB lên đầu
		if(flag == 2) {
			String maTB = request.getParameter("maTB");
			
			int kq=ThongBaoDAO.DuaThongBaoLenDau(maTB);
			
			if(kq>0) {
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
			
		}
		
		//flag = 3: Update hiện/ẩn thông báo
		if(flag == 3) {
			String maTB = request.getParameter("maTB");
			int tinhTrang = Integer.parseInt(request.getParameter("tinhTrang"));
			
			int kq=ThongBaoDAO.AnHienMotThongBao(maTB,tinhTrang);
			
			if(kq>0) {
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		//flag = 5: lấy thông báo bỏ vào scope...chuẩn bị cho chuyển qua trang chỉnh sửa thông báo
		if(flag == 5) {
			String maTB = request.getParameter("maTB");
			
			List<ThongBaoModel> thongBaoEdit = ThongBaoDAO.LayMotThongBao(maTB);
			
			if(!thongBaoEdit.isEmpty()) {
				if(thongBaoEdit.get(0).getError() == null) {
					getServletContext().setAttribute("thongBaoEdit", thongBaoEdit);
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
		String maTB = request.getParameter("maTB");
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		int kq = ThongBaoDAO.XoaThongBao(maTB);
		
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
	    
	    List<ThongBaoModel> dsThongBao = ThongBaoDAO.TimKiemThongBao(thongTinTimKiem);
		
		if(!dsThongBao.isEmpty()) {
			if(dsThongBao.get(0).getError() == null) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsThongBao);
			    out.write(objectToReturn); 
			    out.flush();
			}
			else {
				out.write("{\"check\":\"" + dsThongBao.get(0).getError()  + "\"}");
				out.flush();
			}
		}
		else {
			out.write("{\"check\":\"fail\"}");
			out.flush();
		}
	
	}

}
