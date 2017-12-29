package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import DAO.KiemTraFileTonTai;
import DAO.ThongBaoDAO;

@WebServlet("/NV_themthongbao")
public class NV_themthongbao extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public NV_themthongbao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-them-thong-bao.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    
		String tieuDeThongBao = request.getParameter("tieuDeThongBao");
		String tomTatThongBao = request.getParameter("tomTatThongBao");
		String ngayThongBao = request.getParameter("ngayThongBao");
		String hinhAnh = "Pic/" + request.getParameter("hinhAnh");
		String tepDinhKem = "File/" + request.getParameter("tepDinhKem");
		
		String root = getServletContext().getRealPath("/");
		
		if(KiemTraFileTonTai.KiemTraFileDaTonTaiChua(root+hinhAnh)) {
			out.write("{\"hinhAnh\":\"fail\"}");
		    out.flush();
		    return;
		}
		if(KiemTraFileTonTai.KiemTraFileDaTonTaiChua(root+tepDinhKem)) {
			out.write("{\"file\":\"fail\"}");
		    out.flush();
		    return;
		}
		
		String maTBMoi = ThongBaoDAO.ThemThongBaoMoi(tieuDeThongBao, tomTatThongBao, ngayThongBao, hinhAnh, tepDinhKem);
		
		
	    
		if(maTBMoi != null) {
			out.write("{\"maTBMoi\":\""+ maTBMoi +"\"}");
		    out.flush();
		    return;
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		    return;
		}
		
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maTBMoi = ThongBaoDAO.MaThongBaoMoi();
		
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(maTBMoi != null) {
			out.write("{\"maTBMoi\":\""+ maTBMoi +"\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maTBMoi = request.getParameter("maTBMoi");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(ThongBaoDAO.XoaThongBao(maTBMoi) > 0) {
			out.write("{\"maTBMoi\":\"ok\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
	}


}
