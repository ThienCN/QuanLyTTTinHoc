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

import DAO.NV_thongkeDAO;
import DAO.WriteFileExcel;
import DAO.WriteFileExcelGiaoVien;
import DAO.WriteFileExcelHVDangKyOnl;
import DAO.WriteFileExcelHocVien;
import DAO.WriteFileExcelLopHoc;
import model.GiaoVienModel;
import model.HVDKyOnlineModel;
import model.HocVienModel;
import model.LopHocModel;

@WebServlet("/ExportFileExcel")
public class ExportFileExcel extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ExportFileExcel() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		String nameFile = request.getParameter("nameFile");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	    //flag=1: Xuất dữ liệu HV đăng ký onl của 1 lớp học
	    if(flag == 1) {
	    	String maLopHoc = request.getParameter("maLopHoc");
			
			List<HVDKyOnlineModel> dsHVDKyOnl = NV_thongkeDAO.LayDSHVDKyOnlCuaMotLopHoc(maLopHoc);
			
			if(!dsHVDKyOnl.isEmpty())  {
				if(dsHVDKyOnl.get(0).getError() == null) {
					
					String outputFileName = "D:\\" + nameFile + ".xls";
					
					boolean isWrited = WriteFileExcelHVDangKyOnl.WriteFile(dsHVDKyOnl, outputFileName);
					
					if(isWrited) {
						out.write("{\"check\":\"ok\"}");
					    out.flush();
					}
					else {
						out.write("{\"check\":\"fail\"}");
					    out.flush();
					}
				}
				else {
					out.write("{\"check\":\""+ dsHVDKyOnl.get(0).getError() +"\"}");
					out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	    
	    //flag = 2: Xuất dữ liệu ds Giáo viên của 1 Khóa học
	    if(flag == 2) {
	    	String maKH = request.getParameter("maKH");
	    	List<GiaoVienModel> dsGiaoVien;
	    	
	    	//maKH = Tất cả: load lên toàn bộ ds Giáo viên ở trung tâm
			if("Tất cả".equals(maKH)) 
				dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVien();
			else //maKH != Tất cả:Load ds Giáo viên giảng dạy của từng khóa
				dsGiaoVien = NV_thongkeDAO.LayDanhSachGiaoVienTheoKhoaHoc(maKH);
			
			if(!dsGiaoVien.isEmpty()) {
				if(dsGiaoVien.get(0).getError() == null) {
					String outputFileName = "D:\\" + nameFile + ".xls";
					
					boolean isWrited = WriteFileExcelGiaoVien.WriteFile(dsGiaoVien, outputFileName);
					
					if(isWrited) {
						out.write("{\"check\":\"ok\"}");
					    out.flush();
					}
					else {
						out.write("{\"check\":\"fail\"}");
					    out.flush();
					}
				}
				else {
					out.write("{\"check\":\""+ dsGiaoVien.get(0).getError() +"\"}");
					out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag=Integer.parseInt(request.getParameter("flag"));
		String nameFile = request.getParameter("nameFile");
		
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
	    
	  //flag = 1: Xuất dữ liệu ds Học viên của 1 Lớp học
	    if(flag == 1) {
	    	String maLopHoc = request.getParameter("maLopHoc");
			List<HocVienModel> dsHocVien = NV_thongkeDAO.LayDSHVCuaMotLopHoc(maLopHoc);
			
			if(!dsHocVien.isEmpty()) {
				if(dsHocVien.get(0).getError() == null) {
					String outputFileName = "D:\\" + nameFile + ".xls";
					
					boolean isWrited = WriteFileExcelHocVien.WriteFile(dsHocVien, outputFileName);
					
					if(isWrited) {
						out.write("{\"check\":\"ok\"}");
					    out.flush();
					}
					else {
						out.write("{\"check\":\"fail\"}");
					    out.flush();
					}
				}
				else {
					out.write("{\"check\":\""+ dsHocVien.get(0).getError() +"\"}");
				    out.flush();
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			}
	    }
	    
	    //flag = 2: Xuất dữ liệu ds Lớp học của 1 Khóa học
	    if(flag == 2) {
	    	String maKH = request.getParameter("maKH");
	    	List<LopHocModel> dsLopHoc = NV_thongkeDAO.LayDSLopHocCuaMotKhoaHoc(maKH);
			
			if(!dsLopHoc.isEmpty()) {
				if(dsLopHoc.get(0).getError() != null) {
					out.write("{\"check\":\""+ dsLopHoc.get(0).getError() +"\"}");
				    out.flush();
				}
				else {
					String outputFileName = "D:\\" + nameFile + ".xls";
					
					boolean isWrited = WriteFileExcelLopHoc.WriteFile(dsLopHoc, outputFileName);
					
					if(isWrited) {
						out.write("{\"check\":\"ok\"}");
					    out.flush();
					}
					else {
						out.write("{\"check\":\"fail\"}");
					    out.flush();
					}
				}
			}
			else {
				out.write("{\"check\":\"fail\"}");
				out.flush();
			}
	    }
	}

}
