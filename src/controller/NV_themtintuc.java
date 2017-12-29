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
import DAO.TinTucDAO;

@WebServlet("/NV_themtintuc")
public class NV_themtintuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_themtintuc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-them-tin-tuc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		String tieuDeTinTuc = request.getParameter("tieuDeTinTuc");
		String tomTatTinTuc = request.getParameter("tomTatTinTuc");
		String ngayDangTinTuc = request.getParameter("ngayDangTinTuc");
		String imageVideo;
		if(request.getParameter("hinhAnh").lastIndexOf("mp4") > 0)
			imageVideo = "Video/" + request.getParameter("hinhAnh");
		else
			imageVideo = "Pic/" + request.getParameter("hinhAnh");
		
		
		String root = getServletContext().getRealPath("/");
		
		if(KiemTraFileTonTai.KiemTraFileDaTonTaiChua(root+imageVideo)) {
			out.write("{\"imageVideo\":\"fail\"}");
		    out.flush();
		    return;
		}
		
		String maTTMoi = TinTucDAO.ThemTinTucMoi(tieuDeTinTuc, tomTatTinTuc, ngayDangTinTuc, imageVideo);
		
		
	    
		if(maTTMoi != null) {
			out.write("{\"maTTMoi\":\""+ maTTMoi +"\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
	}

	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maTTMoi = request.getParameter("maTTMoi");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(TinTucDAO.XoaTinTuc(maTTMoi) > 0) {
			out.write("{\"maTBMoi\":\"ok\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
	}
	
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String maTTMoi = TinTucDAO.MaTinTucMoi();
		
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
		if(maTTMoi != null) {
			out.write("{\"maTTMoi\":\""+ maTTMoi +"\"}");
		    out.flush();
		}
		else {
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
	}
}
