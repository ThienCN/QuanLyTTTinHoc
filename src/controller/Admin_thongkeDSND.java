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

@WebServlet("/Admin_thongkeDSND")
public class Admin_thongkeDSND extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Admin_thongkeDSND() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.getRequestDispatcher("./WEB-INF/Amin_thong-ke-nguoi-dung.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));

		response.setContentType("application/json;charset=UTF-8");
		request.setCharacterEncoding("utf-8");
		PrintWriter out = response.getWriter();

		//flag = 1: Thống kê nhân viên
		if (flag == 1) {
			List<NguoiDungModel> dsNhanVien = AdminDAO.LayDanhSachNhanVien();
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
		
		if (flag == 2) {
			List<NguoiDungModel> dsAdmin = AdminDAO.LayDanhSachAdmin();
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
	}

}
