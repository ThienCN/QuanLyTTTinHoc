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

import DAO.KiemTraFileTonTai;
import DAO.ThongBaoDAO;
import model.ThongBaoModel;

@WebServlet("/NV_chinhsuathongbao")
public class NV_chinhsuathongbao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_chinhsuathongbao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-chinh-sua-thong-bao.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		//flag = 1: load thông báo muốn chỉnh sửa lên
		if(flag == 1) {
			List<ThongBaoModel> thongBaoEdit = (List<ThongBaoModel>)getServletContext().getAttribute("thongBaoEdit");
			
			if(thongBaoEdit!=null) {
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(thongBaoEdit);
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
    		String maThongBao = request.getParameter("maThongBao");
			String tieuDeThongBao = request.getParameter("tieuDeThongBao");
			String tomTatThongBao = request.getParameter("tomTatThongBao");
			String ngayThongBao = request.getParameter("ngayThongBao");
			String hinhAnh = "Pic/" + request.getParameter("hinhAnh");
			String tepDinhKem = "File/" + request.getParameter("tepDinhKem");
			
			int kq = ThongBaoDAO.CapNhatThongBao(maThongBao, tieuDeThongBao, tomTatThongBao, ngayThongBao, hinhAnh, tepDinhKem);
			
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
