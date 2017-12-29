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

@WebServlet("/NV_chinhsuatintuc")
public class NV_chinhsuatintuc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_chinhsuatintuc() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV_chinhsuatintuc.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		//flag = 1: load tin tức muốn chỉnh sửa lên
		if(flag == 1) {
			List<TinTucModel> tintucEdit = (List<TinTucModel>)getServletContext().getAttribute("tintucEdit");
			
			if(tintucEdit!=null) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(tintucEdit);
			    out.write(objectToReturn); 
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		//flag=2: cập nhật thông tin mới
		if(flag == 2) {
    		
    		String maTinTuc = request.getParameter("maTinTuc");
			String tieuDeTinTuc = request.getParameter("tieuDeTinTuc");
			String tomTatTinTuc = request.getParameter("tomTatTinTuc");
			String ngayDangTinTuc = request.getParameter("ngayDangTinTuc");
			String imageVideo;
			if(request.getParameter("hinhAnh").lastIndexOf("mp4") > 0)
				imageVideo = "Video/" + request.getParameter("hinhAnh");
			else
				imageVideo = "Pic/" + request.getParameter("hinhAnh");
			
			int kq = TinTucDAO.CapNhatTinTuc(maTinTuc, tieuDeTinTuc, tomTatTinTuc, ngayDangTinTuc, imageVideo);
			
			if(kq > 0) {
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
	}

}
