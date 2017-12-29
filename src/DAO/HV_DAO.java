package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.GVBangDiemHocVienModel;
import model.HVThoiKhoaBieuModel;
import model.HocVienModel;
import model.LichKhaiGiangModel;

public class HV_DAO {

	public static Statement stm = null;
	public static CallableStatement cstm = null;
	public static Connection cnn;
	public static ResultSet rs;
	
	public static HocVienModel LayThongTinMotHocVien(String maHV){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		HocVienModel ThongTinCaNhan = null;
		try {
			String sql="{call spLayThongTinMotHocVien(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maHV);
			
			ResultSet kq = cstmt.executeQuery();
			
			
			if(kq.first()) {
				
				ThongTinCaNhan = new HocVienModel(kq.getString("MaHV"), kq.getString("HoTenHV"), 
												kq.getString("NgaySinh"),kq.getBoolean("GioiTinh"),
												kq.getString("DiaChi"), kq.getString("SDT"),
												kq.getString("CMND"), kq.getString("EmailHV"),
												kq.getString("PassHV"), kq.getInt("tinhTrang"),
												kq.getInt("role"), null);
			}
			kq.close();
			return ThongTinCaNhan;
			
		} catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	
	public static List<HVThoiKhoaBieuModel> LoadThoiKhoaBieu(String TuNgay, String DenNgay, String MaHV) {

		String BuoiHoc, SoPhong, TenLop, GioBatDau, GioKetThuc, HoTenGV;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spHVThoiKhoaBieu(?,?,?)}");

			cstm.setString(1, TuNgay);
			cstm.setString(2, DenNgay);
			cstm.setString(3, MaHV);

			rs = cstm.executeQuery();

			List<HVThoiKhoaBieuModel> ThoiKhoaBieu = new ArrayList<HVThoiKhoaBieuModel>();
			while (rs.next()) {
				BuoiHoc = rs.getString("BuoiHoc");
				SoPhong = rs.getString("SoPhong");
				TenLop = rs.getString("TenLop");
				GioBatDau = rs.getString("GioBatDau");
				GioKetThuc = rs.getString("GioKetThuc");
				HoTenGV = rs.getString("HoTenGV");
				ThoiKhoaBieu.add(new HVThoiKhoaBieuModel(BuoiHoc, SoPhong, TenLop, GioBatDau, GioKetThuc, HoTenGV));
				
			}
			
			rs.close();	
			return ThoiKhoaBieu; 

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public static List<GVBangDiemHocVienModel> XemDiem(String MaHV) {

		String MaLop, TenLop, ChungChi;
		float DiemLT, DiemTH;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spHVXemDiem(?)}");

			cstm.setString(1, MaHV);

			rs = cstm.executeQuery();

			List<GVBangDiemHocVienModel> XemDiem = new ArrayList<GVBangDiemHocVienModel>();
			while (rs.next()) {
				MaLop = rs.getString("MaLop");
				TenLop = rs.getString("TenLop");
				DiemLT = rs.getFloat("DiemLT");
				DiemTH = rs.getFloat("DiemTH");
				ChungChi = rs.getString("ChungChi");
				XemDiem.add(new GVBangDiemHocVienModel(null, null, MaLop, TenLop, DiemLT, DiemTH, ChungChi));
				
			}
			
			rs.close();	
			return XemDiem; 

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
	
	public static List<LichKhaiGiangModel> DangKyThanhCong(String MaDKyOnl) {

		String MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, NgayBatDau, SoPhong, SoTien;
		int SoBuoi;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spDangKyOnlThanhCong(?)}");

			cstm.setString(1, MaDKyOnl);

			rs = cstm.executeQuery();

			List<LichKhaiGiangModel> DangKyThanhCong = new ArrayList<LichKhaiGiangModel>();
			while (rs.next()) {
				MaLop = rs.getString("MaLop");
				TenLop = rs.getString("TenLop");
				BuoiHoc = rs.getString("BuoiHoc");
				GioBatDau = rs.getString("GioBatDau");
				GioKetThuc = rs.getString("GioKetThuc");
				NgayBatDau = rs.getString("NgayBatDau");
				SoPhong = rs.getString("SoPhong");
				SoBuoi = rs.getInt("SoBuoi");
				SoTien = rs.getString("HocPhi");
				DangKyThanhCong.add(new LichKhaiGiangModel(MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, NgayBatDau, SoPhong, SoBuoi, SoTien,null,null));
				
			}
			
			rs.close();	
			return DangKyThanhCong; 

		} catch (SQLException ex) {
			ex.printStackTrace();
		} finally {
			try {
				if (cnn != null) {
					cnn.close();
				}
				if (cstm != null) {
					cstm.close();
				}
			} catch (SQLException ex) {
				ex.printStackTrace();
			}
		}
		return null;
	}
}
