package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.GiaoVienModel;
import model.HVDKyOnlineModel;
import model.HocVienModel;
import model.LopHocModel;

public class NV_thongkeDAO {

	public static List<LopHocModel> LayDSLopHocCuaMotKhoaHoc(String maKhoaHoc) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<LopHocModel> dsLopHoc = new ArrayList<LopHocModel>();
		
		try {
			String sql = "{call spLayDSLopHocCuaMotKhoaHoc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKhoaHoc);
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				
	        	dsLopHoc.add(new LopHocModel(kq.getString("MaLop"), kq.getString("TenLop"), 
											kq.getString("MaKH"), kq.getString("HoTenGV"), 
											kq.getInt("SoBuoi"), kq.getString("NgayBatDau"), 
											kq.getString("NgayKetThuc"), kq.getString("SoPhong"), 
											kq.getString("BuoiHoc"), kq.getInt("SoHV"), 
											kq.getString("GioBatDau")+'-'+kq.getString("GioKetThuc"), 
											kq.getString("HocPhi"), kq.getInt("tinhTrang"), null));
	        }
			kq.close();
			return dsLopHoc;
		} catch (SQLException e) {
			dsLopHoc.add(new LopHocModel(null, null, null, null, 0, null, null, null, null, 0, null, null, 0, e.getMessage()));
			return dsLopHoc;
		}
	}
	
	
	public static List<HVDKyOnlineModel> LayDSHVDKyOnlCuaMotLopHoc(String maLopHoc){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<HVDKyOnlineModel> dsHVDKyOnl = new ArrayList<HVDKyOnlineModel>();
		try {
			String sql="{call spLayDSHVDKyOnlCuaMotLopHoc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maLopHoc);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsHVDKyOnl.add(new HVDKyOnlineModel(kq.getString("MaDkyOnl"), kq.getString("HoTen"), 
													format.format(date), kq.getString("DiaChi"), 
													kq.getString("SDT"), kq.getString("Email"), null));
			}
			kq.close();
			return dsHVDKyOnl;
			
		} catch (SQLException e) {
			dsHVDKyOnl.add(new HVDKyOnlineModel(null, null, null, null, null, null, e.getMessage()));
			return dsHVDKyOnl;
		}catch (ParseException e) {
			dsHVDKyOnl.add(new HVDKyOnlineModel(null, null, null, null, null, null, e.getMessage()));
			return dsHVDKyOnl;
		} 
	}

	public static List<HocVienModel> LayDSHVCuaMotLopHoc(String maLopHoc){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<HocVienModel> dsHocVien = new ArrayList<HocVienModel>();
		try {
			String sql="{call spLayDSHVCuaMotLopHoc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maLopHoc);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsHocVien.add(new HocVienModel(kq.getString("MaHV"), kq.getString("HoTenHV"),
								kq.getString("NgaySinh"), kq.getBoolean("GioiTinh"), 
								kq.getString("DiaChi"), kq.getString("SDT"), 
								kq.getString("CMND"), kq.getString("EmailHV"), 
								kq.getString("PassHV"), kq.getInt("tinhTrang"), kq.getInt("role"), null));
			}
			kq.close();
			return dsHocVien;
			
		} catch (SQLException e) {
			dsHocVien.add(new HocVienModel(null, null, null, true, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsHocVien;
		}catch (ParseException e) {
			dsHocVien.add(new HocVienModel(null, null, null, true, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsHocVien;
		} 
	}

	public static List<GiaoVienModel> LayDanhSachGiaoVien(){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<GiaoVienModel> dsGiaoVien = new ArrayList<GiaoVienModel>();
		try {
			String sql="{call spLayDanhSachGiaoVien}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsGiaoVien.add(new GiaoVienModel(kq.getString("MaGV"), kq.getString("HoTenGV"), 
												format.format(date), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailGV"), 
												kq.getString("PassGV"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null));
			}
			kq.close();
			return dsGiaoVien;
			
		} catch (SQLException e) {
			dsGiaoVien.add(new GiaoVienModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsGiaoVien;
		}catch (ParseException e) {
			dsGiaoVien.add(new GiaoVienModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsGiaoVien;
		} 
	}

	public static List<GiaoVienModel> LayDanhSachGiaoVienTheoKhoaHoc(String maKH){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<GiaoVienModel> dsGiaoVien = new ArrayList<GiaoVienModel>();
		try {
			String sql="{call spLayDanhSachGiaoVienTheoKhoaHoc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			cstmt.setString(1, maKH);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsGiaoVien.add(new GiaoVienModel(kq.getString("MaGV"), kq.getString("HoTenGV"), 
												format.format(date), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailGV"), 
												kq.getString("PassGV"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null));
			}
			kq.close();
			return dsGiaoVien;
			
		} catch (SQLException e) {
			dsGiaoVien.add(new GiaoVienModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsGiaoVien;
		}catch (ParseException e) {
			dsGiaoVien.add(new GiaoVienModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsGiaoVien;
		} 
	}

}
