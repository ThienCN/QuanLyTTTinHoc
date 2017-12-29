package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.NV_dangkykhoahocDAO;
import model.LopHocDKyOnlModel;
import model.LopHocModel;

@WebServlet("/NV_dangkykhoahoc")
public class NV_dangkykhoahoc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_dangkykhoahoc() {
        super();
    }
    
    public void init(ServletConfig config) throws ServletException {
		super.init(config); 
	}


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-dang-ky-khoa-hoc.jsp").forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
	    //flag = 1: lấy mã học viên tiếp theo
		if(flag == 1) {
			String maHVMoi = NV_dangkykhoahocDAO.LayMaHocVienMoi();
			
			if(maHVMoi != null) {
				out.write("{\"maHVMoi\":\"" + maHVMoi + "\"}");
			    out.flush();
			}
			else {
				out.write("{\"maHVMoi\":\"" + null + "\"}");
			    out.flush();
			}
		}
		
		//flag = 2: Lấy thông tin lớp học vừa chọn
		//Đồng thời lưu thông tin lại để sử dụng cho việc thanh toán học phí
		if(flag == 2) {
			String MaLop = request.getParameter("MaLop");
			
			LopHocModel lopHocDaChon = null;
			List<LopHocModel> dsLopHocHienTai = (List<LopHocModel>)getServletContext().getAttribute("dsLopHocHienTai");
			
			for(int i=0; i<dsLopHocHienTai.size(); i++) {
				if(dsLopHocHienTai.get(i).getMaLop().equals(MaLop)) {
					lopHocDaChon = new LopHocModel(dsLopHocHienTai.get(i).getMaLop(), dsLopHocHienTai.get(i).getTenLop(), 
									dsLopHocHienTai.get(i).getKhoaHoc(), dsLopHocHienTai.get(i).getGiaoVienGiangDay(), 
									dsLopHocHienTai.get(i).getSoBuoi(), dsLopHocHienTai.get(i).getNgayBatDau(), 
									dsLopHocHienTai.get(i).getNgayKetThuc(), dsLopHocHienTai.get(i).getSoPhong(), 
									dsLopHocHienTai.get(i).getBuoiHoc(), dsLopHocHienTai.get(i).getSoHV(), 
									dsLopHocHienTai.get(i).getGioHoc(), 
									dsLopHocHienTai.get(i).getHocPhi(), dsLopHocHienTai.get(i).getTinhTrang(), null);
					
					break;
				}
			}
			
			List<LopHocModel> dsLopHocDangKy;
			dsLopHocDangKy = (List<LopHocModel>)getServletContext().getAttribute("dsLopHocDangKy");
			
			if(dsLopHocDangKy == null) {
				dsLopHocDangKy = new ArrayList<LopHocModel>();
				dsLopHocDangKy.add(lopHocDaChon);
				getServletContext().setAttribute("dsLopHocDangKy", dsLopHocDangKy);
			}
			else {
				dsLopHocDangKy.add(lopHocDaChon);
			}
			
			Gson gson = new Gson();
		    String objectToReturn = gson.toJson(lopHocDaChon); 
		    out.write(objectToReturn); 
		    out.flush();
		}
	}
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		
		
		//flag=1: Xóa danh sách lớp học đăng ký trước đó (nếu có)
		if(flag == 1) {
			if(getServletContext().getAttribute("dsLopHocDangKy") != null)
				getServletContext().removeAttribute("dsLopHocDangKy"); 
		}
				
		//flag=2: Xóa 1 lớp học mà đã đăng ký (trực tiếp) nhưng muốn hủy đi
		if(flag == 2) {
			
			List<LopHocModel> dsLopHocDangKy = (List<LopHocModel>)getServletContext().getAttribute("dsLopHocDangKy");
			String MaLop = request.getParameter("MaLop").trim();
			
			for(int i=0; i<dsLopHocDangKy.size(); i++) {
				if(dsLopHocDangKy.get(i).getMaLop().trim().equals(MaLop)) {
					dsLopHocDangKy.remove(i);
					break;
				}
			}
		}
		
		//flag=3: Xóa danh sách lớp học đăng ký trước đó (nếu có), 
	    //xóa thông tin học viên đăng ký online tới nhận lớp trước đó (nếu có)
	    //xóa ds đăng ký lớp học online trước đó (nếu có)
		if(flag == 3) {
			if(getServletContext().getAttribute("dsLopHocDangKy") != null)
				getServletContext().removeAttribute("dsLopHocDangKy"); 
			
			if(getServletContext().getAttribute("hvDkyOnl") != null)
				getServletContext().removeAttribute("hvDkyOnl");
			
			if(getServletContext().getAttribute("dsLopHocDkyOnl") != null)
				getServletContext().removeAttribute("dsLopHocDkyOnl"); 
		}
		
		//flag=4: Xóa 1 lớp học mà đã đăng ký (online) nhưng muốn hủy đi
		if(flag == 4) {
			
			List<LopHocDKyOnlModel> dsLopHocDkyOnl = (List<LopHocDKyOnlModel>)getServletContext().getAttribute("dsLopHocDkyOnl");
			String MaLop = request.getParameter("MaLop").trim();
			
			for(int i=0; i<dsLopHocDkyOnl.size(); i++) {
				if(dsLopHocDkyOnl.get(i).getMaLop().trim().equals(MaLop)) {
					dsLopHocDkyOnl.remove(i);
					break;
				}
			}
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();

		//Lấy ds Lớp học hiện tại --> Nếu không có lớp nào để đăng ký khóa học
		//thì trong js sẽ gọi method PUT để thông báo không nằm trong thời gian đăng ký khóa học
		List<LopHocModel> dsLopHocHienTai = new ArrayList<LopHocModel>();
		dsLopHocHienTai=NV_dangkykhoahocDAO.DSLopHocHienTai();
		
		if(!dsLopHocHienTai.isEmpty()) {
			if(dsLopHocHienTai.get(0).getError() == null) {
				
				getServletContext().setAttribute("dsLopHocHienTai", dsLopHocHienTai);
				
				Gson gson = new Gson();
			    String objectToReturn = gson.toJson(dsLopHocHienTai);
			    out.write(objectToReturn); 
			    out.flush();
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
		}
		else{
			out.write("{\"check\":\"fail\"}");
		    out.flush();
		}
		
	}


}
