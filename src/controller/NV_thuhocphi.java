package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import DAO.NV_dangkykhoahocDAO;
import DAO.NV_thuhocphiDAO;
import model.HVDKyOnlineModel;
import model.HocVienModel;
import model.LopHocDKyOnlModel;
import model.LopHocModel;

@WebServlet("/NV_thuhocphi")
public class NV_thuhocphi extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public NV_thuhocphi() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("/WEB-INF/NV-thu-hoc-phi.jsp").forward(request, response); 
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int flag = Integer.parseInt(request.getParameter("flag"));
		HocVienModel hocVienMoi;
		response.setContentType("application/json;charset=UTF-8");
	    request.setCharacterEncoding("utf-8");
	    PrintWriter out = response.getWriter();
		
		//flag = 1: lưu thông tin cá nhân và học phí cần đóng của học viên mới (sự kiện click Thanh toán học phí: trang đăng ký khóa học)
		if(flag == 1) {
			String maHV = request.getParameter("maHV");
			String hoTenHV = request.getParameter("hoTenHV");
			String ngaySinh = request.getParameter("ngaySinh");
			boolean gioiTinh;
			if(request.getParameter("gioiTinh") == "0")
				gioiTinh = false;
			else
				gioiTinh = true;
			
			String diachi = request.getParameter("diachi");
			String SDT = request.getParameter("SDT");
			String CMND = request.getParameter("CMND");
			String email = request.getParameter("email");
			String hocPhiPhaiThanhToan = request.getParameter("hocPhiPhaiThanhToan");
			
			//Kiểm tra học viên cũ hay mới (thông qua CMND) -> trả về mã học viên cũ
			if(NV_dangkykhoahocDAO.KiemTraHocVien(CMND) != null)
				maHV=NV_dangkykhoahocDAO.KiemTraHocVien(CMND);
			
			hocVienMoi = new HocVienModel(maHV, hoTenHV, ngaySinh, gioiTinh, diachi, SDT, CMND, email, null, 1, 1, null);
			getServletContext().setAttribute("hocVienMoi", hocVienMoi);
			getServletContext().setAttribute("hocPhiPhaiThanhToan", hocPhiPhaiThanhToan); 
			
			List<LopHocModel> dsLopHocDangKy = (List<LopHocModel>)getServletContext().getAttribute("dsLopHocDangKy");
			List<LopHocDKyOnlModel> dsLopHocDkyOnl = (List<LopHocDKyOnlModel>)getServletContext().getAttribute("dsLopHocDkyOnl");
			
			boolean onlyOnline=false;
			if(dsLopHocDangKy == null) {
				onlyOnline=true;
				dsLopHocDangKy = new ArrayList<LopHocModel>();
			}
				
			
			//Kiểm tra ds lớp học đăng ký có phải từ tra cứu đăng ký online hay ko? 
			//nếu phải thì bỏ vào dsLopHocDangKy để hiển thị trong trang thu học phí
			if(dsLopHocDkyOnl != null) {
				LopHocDKyOnlModel temp;
				for(int i=0; i<dsLopHocDkyOnl.size(); i++) { 
					temp = dsLopHocDkyOnl.get(i);
					
					if(dsLopHocDkyOnl.get(i).gettinhTrang() == 0) {
						dsLopHocDangKy.add(new LopHocModel(temp.getMaLop(), temp.getTenLop(), 
								temp.getKhoaHoc(),temp.getGiaoVienGiangDay(), 
								temp.getSoBuoi(), temp.getNgayBatDau(), 
								temp.getNgayKetThuc(), temp.getSoPhong(), 
								temp.getBuoiHoc(),temp.getSoHV(), 
								temp.getGioHoc(), 
								temp.getHocPhi(), temp.gettinhTrang(), null));
					}
				}
				if(onlyOnline)
					getServletContext().setAttribute("dsLopHocDangKy", dsLopHocDangKy);
			}
			
			out.write("{\"check\":\"ok\"}");
		    out.flush();
		    
		    return;
		}
		
		//flag=2: lấy thông tin học viên mới (sự kiện load trang thu học phí)
		if(flag == 2) {
			Gson gson = new Gson();
		    String objectToReturn = gson.toJson((HocVienModel)getServletContext().getAttribute("hocVienMoi"));
		    out.write(objectToReturn); 
		    out.flush();
		    
		    return;
		}
		
		//flag=3: lấy thông tin học phí phải thanh toán (sự kiện load trang thu học phí)
		if(flag == 3) {
		    String hocPhiPhaiThanhToan = (String)getServletContext().getAttribute("hocPhiPhaiThanhToan");
		    
		    out.write("{\"check\":\"" + hocPhiPhaiThanhToan  + "\"}");
		    out.flush();
		    
		    return;
		}
		
		
		//flag=4: thêm học viên mới và biên lai thanh toán học phí cho học viên này (sự kiện click Xuất biên lai)
		if(flag == 4) {
			//Thêm học viên mới
			hocVienMoi = (HocVienModel)getServletContext().getAttribute("hocVienMoi");
			
			String maHVMoi = NV_thuhocphiDAO.ThemHocVienMoi(
								hocVienMoi.getHoTenHV(), hocVienMoi.getNgaySinh(), 
								hocVienMoi.getGioiTinh(), hocVienMoi.getDiaChi(), 
								hocVienMoi.getSDT(), hocVienMoi.getCMND(), hocVienMoi.getEmailHV()); 
			
			if(maHVMoi == null) {
				out.write("{\"check\":\"fail\"}");
			    out.flush();
			    return;
			}
			
			List<LopHocModel> dsLopHocDangKy = (List<LopHocModel>)getServletContext().getAttribute("dsLopHocDangKy");
			
			String maNV = (String)request.getSession().getAttribute("username");
			Date today = new Date();
			SimpleDateFormat simpleDate=new SimpleDateFormat("yyyy-MM-dd");
			int kq;
			for(int i=0; i<dsLopHocDangKy.size(); i++) {
				kq = NV_thuhocphiDAO.ThemBienLai(maHVMoi.trim(), dsLopHocDangKy.get(i).getMaLop().trim(), 
												maNV.trim(), simpleDate.format(today));
				
				if(kq==0) {
					for(int k=0; k<i; k++) {
						NV_thuhocphiDAO.HuyDangKyKhoaHoc(maHVMoi.trim(), dsLopHocDangKy.get(k).getMaLop().trim());
					}
					out.write("{\"check\":\"fail\"}");
				    out.flush();
				    return;
				}
			}
			
			HVDKyOnlineModel hvDkyOnl = (HVDKyOnlineModel)getServletContext().getAttribute("hvDkyOnl");
			
			//Nếu hóa đơn được xuất cho học viên đăng ký online thì cập nhật tình trang cho bảng CHITIETDANGKYONLINE là 1: đã nhận lớp
			if(getServletContext().getAttribute("hvDkyOnl") != null && getServletContext().getAttribute("dsLopHocDkyOnl") != null) {
				
				for(int i=0; i<dsLopHocDangKy.size(); i++) {
					NV_thuhocphiDAO.HVDKyOnlNhanLop(hvDkyOnl.getMaDkyOnl(), dsLopHocDangKy.get(i).getMaLop());
				}
			}
			
			
			//Xóa objects lưu trong application scope
			getServletContext().removeAttribute("dsLopHocDangKy");
			getServletContext().removeAttribute("hocVienMoi"); 
			getServletContext().removeAttribute("hocPhiPhaiThanhToan"); 
			getServletContext().removeAttribute("hvDkyOnl");
			getServletContext().removeAttribute("dsLopHocDkyOnl");
			
			out.write("{\"check\":\"" + maHVMoi + "\"}");
		    out.flush();
		    return;
		}
	}

}
