package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.BuoiHocModel;
import model.GioHocModel;
import model.HVKhoaHocModel;
import model.HocPhiModel;
import model.KhoaHocModel;
import model.LopHocModel;
import model.PhongHocModel;
import model.TrinhDoHocVanModel;

public class KhoaHocDAO {
	
	public static Statement stm = null;
	public static CallableStatement cstm = null;
	public static Connection cnn;
	public static ResultSet rs;
	
	public static List<HVKhoaHocModel> LoadKhoaHoc(String MaHV) {
		String MaKH = null, NgayKhaiGiang = null, Nam = null, Thang = null;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spHVKhoaHoc(?)}");
			cstm.setString(1, MaHV);

			rs = cstm.executeQuery();
			
			List<HVKhoaHocModel> KhoaHoc = new ArrayList<HVKhoaHocModel>();
			while (rs.next()) {
				MaKH = rs.getString("MaKH");
				NgayKhaiGiang = rs.getString("NgayKhaiGiang");
				Nam = rs.getString("Nam");
				Thang = rs.getString("Thang");
				KhoaHoc.add(new HVKhoaHocModel(MaKH,NgayKhaiGiang,Nam,Thang));
			}
			
			rs.close();	
			return KhoaHoc; 

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
	
	public static List<HVKhoaHocModel> LoadKhoaHocGV(String MaGV) {
		String MaKH = null, NgayKhaiGiang = null, Nam = null, Thang = null;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spGVKhoaHoc(?)}");
			cstm.setString(1, MaGV);

			rs = cstm.executeQuery();
			
			List<HVKhoaHocModel> GVKhoaHoc = new ArrayList<HVKhoaHocModel>();
			while (rs.next()) {
				MaKH = rs.getString("MaKH");
				NgayKhaiGiang = rs.getString("NgayKhaiGiang");
				Nam = rs.getString("Nam");
				Thang = rs.getString("Thang");
				GVKhoaHoc.add(new HVKhoaHocModel(MaKH,NgayKhaiGiang,Nam,Thang));
			}
			
			rs.close();	
			return GVKhoaHoc; 

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
	
	public static List<KhoaHocModel> LayKhoaHoc() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<KhoaHocModel> dsKhoaHoc = new ArrayList<KhoaHocModel>();
		
		try {
			String sql = "{call spLayKhoaHoc()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsKhoaHoc.add(new KhoaHocModel(kq.getString("MaKH"), kq.getString("NgayKhaiGiang"), kq.getInt("soLopHoc"),kq.getInt("tinhTrang"), null));
	        }
			kq.close();
			return dsKhoaHoc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			dsKhoaHoc.add(new KhoaHocModel(null, null, 0,0, e.getMessage()));
			return dsKhoaHoc;
		}
	}
	
	public static List<LopHocModel> TraCuuLopHoc(String maLopHoc) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<LopHocModel> lopHoc = new ArrayList<LopHocModel>();
		
		try {
			String sql = "{call spTraCuuLopHoc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, maLopHoc); 
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
	        	lopHoc.add(new LopHocModel(kq.getString("MaLop"), kq.getString("TenLop"), 
						kq.getString("MaKH"), kq.getString("HoTenGV"), 
						kq.getInt("SoBuoi"), kq.getString("NgayBatDau"), 
						kq.getString("NgayKetThuc"), kq.getString("SoPhong"), 
						kq.getString("BuoiHoc"), kq.getInt("SoHV"), 
						kq.getString("GioBatDau")+'-'+kq.getString("GioKetThuc"), 
						kq.getString("HocPhi"), kq.getInt("tinhTrang"), null));
	        }
			kq.close();
			return lopHoc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			lopHoc.add(new LopHocModel(null, null, null, null, 0, null, null, null, null, 0, null, null, 0, e.getMessage()));
			return lopHoc;
		}
	}
	
	public static int ThemKhoaHoc(String maKhoaHoc, String ngayKhaiGiang) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return 0;
		
		try {
			String sql = "{call spThemKhoaHoc(?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKhoaHoc);
			cstmt.setString(2, ngayKhaiGiang);
			
			int kq = cstmt.executeUpdate();
	        	        
			return kq;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			return 0;
		}
	}
	
	
	public static int CapNhatKhoaHoc(String maKhoaHoc, String ngayKhaiGiang, int TinhTrang) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return 0;
		
		try {
			String sql = "{call spCapNhatKhoaHoc(?,?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maKhoaHoc);
			cstmt.setString(2, ngayKhaiGiang);
			cstmt.setInt(3, TinhTrang);
			
			int kq = cstmt.executeUpdate();
	        	        
			return kq;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			return 0;
		}
	}

	public static int ThemLopHocMoi(String MaLop,String TenLop,String KhoaHoc,String GiaoVienGiangDay,int SoBuoi,
								String NgayBatDau, String NgayKetThuc,String SoPhong,String BuoiHoc,
								int SoHV,String GioHoc,String HocPhi) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return 0;
		
		try {
			String sql = "{call spThemLopHocMoi(?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, MaLop);
			cstmt.setString(2, TenLop);
			cstmt.setInt(3, SoHV);
			cstmt.setInt(4, SoBuoi);
			cstmt.setString(5, HocPhi);
			cstmt.setString(6, NgayBatDau);
			cstmt.setString(7, NgayKetThuc);
			cstmt.setString(8, BuoiHoc);
			cstmt.setString(9, GioHoc);
			cstmt.setString(10, SoPhong);
			cstmt.setString(11, GiaoVienGiangDay);
			cstmt.setString(12, KhoaHoc);
			
			int kq = cstmt.executeUpdate();
	        	        
			return kq;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			return 0;
		}
	}

	public static int CapNhatLopHoc(String maLopCu,String MaLop,String TenLop,String GiaoVienGiangDay,int SoBuoi,
				String NgayBatDau, String NgayKetThuc,String SoPhong,String BuoiHoc,
				int SoHV,String GioHoc,String HocPhi, int tinhTrang) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return 0;
		
		try {
			String sql = "{call spCapNhatLopHoc(?,?,?,?,?,?,?,?,?,?,?,?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maLopCu);
			cstmt.setString(2, MaLop);
			cstmt.setString(3, TenLop);
			cstmt.setInt(4, SoHV);
			cstmt.setInt(5, SoBuoi);
			cstmt.setString(6, HocPhi);
			cstmt.setString(7, NgayBatDau);
			cstmt.setString(8, NgayKetThuc);
			cstmt.setString(9, BuoiHoc);
			cstmt.setString(10, GioHoc);
			cstmt.setString(11, SoPhong);
			cstmt.setString(12, GiaoVienGiangDay);
			cstmt.setInt(13, tinhTrang);
			
			
			int kq = cstmt.executeUpdate();
			    
			return kq;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			return 0;
		}
}
	
	public static List<HocPhiModel> LayHocPhi() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<HocPhiModel> dsHocPhi = new ArrayList<HocPhiModel>();
		
		try {
			String sql = "{call spLayHocPhi()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsHocPhi.add(new HocPhiModel(kq.getString("MaHocPhi"), kq.getFloat("HocPhi")));
	        }
			kq.close();
			return dsHocPhi;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static List<BuoiHocModel> LayBuoiHoc() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<BuoiHocModel> dsBuoiHoc = new ArrayList<BuoiHocModel>();
		
		try {
			String sql = "{call spLayBuoiHoc()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsBuoiHoc.add(new BuoiHocModel(kq.getString("MaBuoiHoc"), kq.getString("BuoiHoc")));
	        }
			kq.close();
			return dsBuoiHoc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static List<GioHocModel> LayGioHoc() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<GioHocModel> dsGioHoc = new ArrayList<GioHocModel>();
		
		try {
			String sql = "{call spLayGioHoc()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsGioHoc.add(new GioHocModel(kq.getString("MaGioHoc"), kq.getString("GioBatDau"), kq.getString("GioKetThuc")));
	        }
			kq.close();
			return dsGioHoc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return null;
	}
	
	public static List<PhongHocModel> LayPhongHoc() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<PhongHocModel> dsPhongHoc = new ArrayList<PhongHocModel>();
		
		try {
			String sql = "{call spLayPhongHoc()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsPhongHoc.add(new PhongHocModel(kq.getString("MaPhong"), kq.getString("SoPhong")));
	        }
			kq.close();
			return dsPhongHoc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return null;
	}
	
	
	public static List<TrinhDoHocVanModel> LayTrinhDoHocVan() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<TrinhDoHocVanModel> dsTrinhDoHocVan = new ArrayList<TrinhDoHocVanModel>();
		
		try {
			String sql = "{call spLayTrinhDoHocVan()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
	        	dsTrinhDoHocVan.add(new TrinhDoHocVanModel(kq.getString("MaTrinhDoHV"), kq.getString("TenTrinhDoHV")));
	        }
			kq.close();
			return dsTrinhDoHocVan;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
		}
		return null;
	}
}
