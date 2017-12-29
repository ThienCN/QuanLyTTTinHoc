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

import DAO.AdminDAO;
import model.NguoiDungModel;
import model.GiaoVienModel;

@WebServlet("/Admin_chinhsuathongtinnguoidung")
public class Admin_chinhsuathongtinnguoidung extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public Admin_chinhsuathongtinnguoidung() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Admin_chinh-sua-thong-tin-nguoi-dung.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		String thongTinTimKiem = (String)request.getParameter("thongTinTimKiem");

		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();
		
		//Nhân viên
		if(flag == 1) {
			List<NguoiDungModel> dsNhanVien = AdminDAO.TimKiemNhanVien(thongTinTimKiem);
			if (!dsNhanVien.isEmpty()) {
				if (dsNhanVien.get(0).getError() == null) {
					Gson gson = new Gson();
					String objectToReturn = gson.toJson(dsNhanVien);
					out.write(objectToReturn);
					out.flush();
				} else {
					out.write("{\"check\":\"" + dsNhanVien.get(0).getError() + "\"}");
					out.flush();
				}
			} else {
				out.write("{\"check\":\"fail\"}");
				out.flush();
			}
		}
		
		//Quản trị viên
		if(flag == 2) {
			List<NguoiDungModel> dsAdmin = AdminDAO.TimKiemAdmin(thongTinTimKiem);
			if (!dsAdmin.isEmpty()) {
				if (dsAdmin.get(0).getError() == null) {
					Gson gson = new Gson();
					String objectToReturn = gson.toJson(dsAdmin);
					out.write(objectToReturn);
					out.flush();
				} else {
					out.write("{\"check\":\"" + dsAdmin.get(0).getError() + "\"}");
					out.flush();
				}
			} else {
				out.write("{\"check\":\"fail\"}");
				out.flush();
			}
		}
		
		//flag=3: Lấy mã Admin đi lấy thông tin của Admin đó
		//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
		if(flag == 3) {
			String maAdmin = request.getParameter("maAdmin");
			
			NguoiDungModel nguoiDungChinhSuaThongTin = AdminDAO.LayThongTinMotAdmin(maAdmin);
			
			if(nguoiDungChinhSuaThongTin != null) {
				
				
				getServletContext().setAttribute("nguoiDungChinhSuaThongTin", nguoiDungChinhSuaThongTin);
				out.write("{\"check\":\"ok\"}");
				out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		
		//flag=4: Lấy mã NV đi lấy thông tin của Nhân viên đó
		//lưu vào scope để chuyển sang trang chỉnh sửa chi tiết thông tin
		if(flag == 4) {
			String maNV = request.getParameter("maNV");
			
			NguoiDungModel nguoiDungChinhSuaThongTin = AdminDAO.LayThongTinMotNhanVien(maNV);
			if(nguoiDungChinhSuaThongTin != null) {
				getServletContext().setAttribute("nguoiDungChinhSuaThongTin", nguoiDungChinhSuaThongTin);
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
