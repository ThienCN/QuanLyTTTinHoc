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

@WebServlet("/noidungthongbao")
public class noidungthongbao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public noidungthongbao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/noidungthongbao.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		//flag=1: Lưu lại tên file
		if(flag == 1) {
			String fileTBEdit = request.getParameter("fileTBEdit");
			
			getServletContext().setAttribute("fileTB", fileTBEdit);
			
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		    return;
		}
		
		//flag=2: Hiển thị file
		if(flag == 2) {
			String fileTB = (String)getServletContext().getAttribute("fileTB");
			
			out.write("{\"fileTB\":\""+ fileTB +"\"}");
		    out.flush();
		    return;
		}
		
		//flag = 3: lấy maThongBao trả về tên file Thông báo
		if(flag == 3) {
			String maTB = request.getParameter("maTB");
			String tepDinhKem = ThongBaoDAO.TraCuuTepDinhKemThongBao(maTB);
			
			if(tepDinhKem != null) {
				getServletContext().setAttribute("fileTB", tepDinhKem);
				out.write("{\"check\":\"ok\"}");
			    out.flush();
			    return;
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
		}
	}

}
