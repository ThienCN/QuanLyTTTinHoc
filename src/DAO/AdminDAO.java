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

import model.NguoiDungModel;
import model.GiaoVienModel;

public class AdminDAO {

	public static String MaGiaoVienMoi() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TaoMaGiaoVien()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String ThemGiaoVienMoi(String HoTenGV,String NgaySinh,String DiaChi,String DienThoai,String CMND,
			String TenTrinhDoHV,String EmailGV, boolean GioiTinh) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spThemGiaoVien(?,?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, HoTenGV);
			cstmt.setString(2, NgaySinh);
			cstmt.setString(3, DiaChi);
			cstmt.setString(4, DienThoai);
			cstmt.setBoolean(5, GioiTinh);
			cstmt.setString(6, CMND);
			cstmt.setString(7, TenTrinhDoHV);
			cstmt.setString(8, EmailGV);
			cstmt.registerOutParameter(9, java.sql.Types.CHAR);
			
			cstmt.executeUpdate();
			
			if(cstmt.getString(9) != null)
				return cstmt.getString(9);
			return null;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(ThemHocVienMoi - NV_thuhocphiDAO)");
			return null; 
		}
	}
	
	public static GiaoVienModel LayThongTinMotGiaoVien(String maGV){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		GiaoVienModel giaoVienChinhSuaThongTin = null;
		try {
			String sql="{call spLayThongTinMotGiaoVien(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maGV);
			
			ResultSet kq = cstmt.executeQuery();
			
			
			if(kq.first()) {
				
				giaoVienChinhSuaThongTin = new GiaoVienModel(kq.getString("MaGV"), kq.getString("HoTenGV"), 
												kq.getString("NgaySinh"), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailGV"), 
												kq.getString("PassGV"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null);
			}
			kq.close();
			return giaoVienChinhSuaThongTin;
			
		} catch (SQLException e) {
			giaoVienChinhSuaThongTin = new GiaoVienModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage());
			return giaoVienChinhSuaThongTin;
		} 
	}
	
	public static List<GiaoVienModel> TimKiemGiaoVien(String thongTinTimKiem){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<GiaoVienModel> dsGiaoVien = new ArrayList<GiaoVienModel>();
		try {
			String sql="{call spTimKiemGiaoVien(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, thongTinTimKiem);
			
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
	
	
	public static int CapNhatGiaoVien(String MaGiaoVien, String HoTenGiaoVien,String NgaySinhGV,String DiaChi,String DienThoai,String CMND,
			String TrinhDoHV,String EmailGV, boolean GioiTinh, String matKhau) {

			Connection conn=null;
			CallableStatement cstmt=null;
			
			conn=connectDAO.ConnectDB();
			if(conn==null) {
				return 0;
			}
			
			try {
			String sql="{call spCapNhatGiaoVien(?,?,?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, MaGiaoVien);
			cstmt.setString(2, HoTenGiaoVien);
			cstmt.setString(3, NgaySinhGV);
			cstmt.setString(4, DiaChi);
			cstmt.setString(5, DienThoai);
			cstmt.setBoolean(6, GioiTinh);
			cstmt.setString(7, CMND);
			cstmt.setString(8, TrinhDoHV);
			cstmt.setString(9, EmailGV);
			cstmt.setString(10, matKhau);
			
			int kq = cstmt.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			return 0; 
		}
	}
	
	
	public static String MaNhanVienMoi() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TaoMaNhanVien()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String MaQuanTriVienMoi() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TaoMaAdmin()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	public static String ThemNhanVienMoi(String HoTenNV,String NgaySinh,String DiaChi,String DienThoai,String CMND,
			String TenTrinhDoHV,String EmailNV, boolean GioiTinh) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spThemNhanVien(?,?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, HoTenNV);
			cstmt.setString(2, NgaySinh);
			cstmt.setString(3, DiaChi);
			cstmt.setString(4, DienThoai);
			cstmt.setBoolean(5, GioiTinh);
			cstmt.setString(6, CMND);
			cstmt.setString(7, TenTrinhDoHV);
			cstmt.setString(8, EmailNV);
			cstmt.registerOutParameter(9, java.sql.Types.CHAR);
			
			cstmt.executeUpdate();
			
			if(cstmt.getString(9) != null)
				return cstmt.getString(9);
			return null;
			
		} catch (SQLException e) {
			return null; 
		}
	}
	
	public static String ThemQuanTriVienMoi(String HoTenAD,String NgaySinh,String DiaChi,String DienThoai,String CMND,
			String TenTrinhDoHV,String EmailAD, boolean GioiTinh) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spThemAdmin(?,?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, HoTenAD);
			cstmt.setString(2, NgaySinh);
			cstmt.setString(3, DiaChi);
			cstmt.setString(4, DienThoai);
			cstmt.setBoolean(5, GioiTinh);
			cstmt.setString(6, CMND);
			cstmt.setString(7, TenTrinhDoHV);
			cstmt.setString(8, EmailAD);
			cstmt.registerOutParameter(9, java.sql.Types.CHAR);
			
			cstmt.executeUpdate();
			
			if(cstmt.getString(9) != null)
				return cstmt.getString(9);
			return null;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(ThemHocVienMoi - NV_thuhocphiDAO)");
			return null; 
		}
	}
	
	public static List<NguoiDungModel> LayDanhSachNhanVien(){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<NguoiDungModel> dsNhanVien = new ArrayList<NguoiDungModel>();
		try {
			String sql="{call spLayDanhSachNhanVien()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsNhanVien.add(new NguoiDungModel(kq.getString("MaNV"), kq.getString("HoTenNV"), 
												format.format(date), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailNV"), 
												kq.getString("PassNV"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null));
			}
			kq.close();
			return dsNhanVien;
			
		} catch (SQLException e) {
			dsNhanVien.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsNhanVien;
		}catch (ParseException e) {
			dsNhanVien.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsNhanVien;
		} 
	}
	
	public static List<NguoiDungModel> LayDanhSachAdmin(){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<NguoiDungModel> dsAdmin = new ArrayList<NguoiDungModel>();
		try {
			String sql="{call spLayDanhSachAdmin()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsAdmin.add(new NguoiDungModel(kq.getString("MaAdmin"), kq.getString("HoTenAdmin"), 
												format.format(date), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailAdmin"), 
												kq.getString("PassAdmin"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null));
			}
			kq.close();
			return dsAdmin;
			
		} catch (SQLException e) {
			dsAdmin.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsAdmin;
		}catch (ParseException e) {
			dsAdmin.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsAdmin;
		} 
	}
	
	public static List<NguoiDungModel> TimKiemNhanVien(String thongTinTimKiem){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<NguoiDungModel> dsNguoiDung = new ArrayList<NguoiDungModel>();
		try {
			String sql="{call spTimKiemNhanVien(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, thongTinTimKiem);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsNguoiDung.add(new NguoiDungModel(kq.getString("MaNV"), kq.getString("HoTenNV"), 
												format.format(date), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailNV"), 
												kq.getString("PassNV"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null));
			}
			kq.close();
			return dsNguoiDung;
			
		} catch (SQLException e) {
			dsNguoiDung.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsNguoiDung;
		}catch (ParseException e) {
			dsNguoiDung.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsNguoiDung;
		} 
	}
	
	
	public static List<NguoiDungModel> TimKiemAdmin(String thongTinTimKiem){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		List<NguoiDungModel> dsNguoiDung = new ArrayList<NguoiDungModel>();
		try {
			String sql="{call spTimKiemAdmin(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, thongTinTimKiem);
			
			ResultSet kq = cstmt.executeQuery();
			
			SimpleDateFormat parse = new SimpleDateFormat("yyyy-MM-dd");
			SimpleDateFormat format = new SimpleDateFormat("dd-MM-yyyy");
			
			while(kq.next()) {
				Date date;
				date = parse.parse(kq.getString("NgaySinh"));
				
				dsNguoiDung.add(new NguoiDungModel(kq.getString("MaAdmin"), kq.getString("HoTenAdmin"), 
												format.format(date), kq.getString("DiaChi"), 
												kq.getString("DienThoai"), kq.getString("CMND"), 
												kq.getString("TenTrinhDoHV"), kq.getString("EmailAdmin"), 
												kq.getString("PassAdmin"), kq.getInt("role"), 
												kq.getBoolean("GioiTinh"), null));
			}
			
			kq.close();
			return dsNguoiDung;
			
		} catch (SQLException e) {
			dsNguoiDung.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsNguoiDung;
		}catch (ParseException e) {
			dsNguoiDung.add(new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage()));
			return dsNguoiDung;
		} 
	}
	
	
	public static NguoiDungModel LayThongTinMotNhanVien(String maNhanVien){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		NguoiDungModel nhanVienChinhSuaThongTin = null;
		try {
			String sql="{call spLayThongTinMotNhanVien(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maNhanVien);
			
			ResultSet kq = cstmt.executeQuery();
			
			
			if(kq.first()) {
				
				nhanVienChinhSuaThongTin = new NguoiDungModel(kq.getString("MaNV"), kq.getString("HoTenNV"), 
						kq.getString("NgaySinh"), kq.getString("DiaChi"), 
											kq.getString("DienThoai"), kq.getString("CMND"), 
											kq.getString("TenTrinhDoHV"), kq.getString("EmailNV"), 
											kq.getString("PassNV"), kq.getInt("role"), 
											kq.getBoolean("GioiTinh"), null);
			}
			kq.close();
			return nhanVienChinhSuaThongTin;
			
		} catch (SQLException e) {
			nhanVienChinhSuaThongTin = new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage());
			return nhanVienChinhSuaThongTin;
		} 
	}
	
	
	public static NguoiDungModel LayThongTinMotAdmin(String maAdmin){
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		NguoiDungModel adminChinhSuaThongTin = null;
		try {
			String sql="{call spLayThongTinMotAdmin(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maAdmin);
			
			ResultSet kq = cstmt.executeQuery();
			
			
			if(kq.first()) {
				adminChinhSuaThongTin = new NguoiDungModel(kq.getString("MaAdmin"), kq.getString("HoTenAdmin"), 
											kq.getString("NgaySinh"), kq.getString("DiaChi"), 
											kq.getString("DienThoai"), kq.getString("CMND"), 
											kq.getString("TenTrinhDoHV"), kq.getString("EmailAdmin"), 
											kq.getString("PassAdmin"), kq.getInt("role"), 
											kq.getBoolean("GioiTinh"), null);
			}
			kq.close();
			return adminChinhSuaThongTin;
			
		} catch (SQLException e) {
			adminChinhSuaThongTin = new NguoiDungModel(null, null, null, null, null, null, null, null, null, 0, true, e.getMessage());
			return adminChinhSuaThongTin;
		} 
	}
	
	public static int CapNhatQuanTriVien(String maAdmin, String HoTenAD,String NgaySinh,String DiaChi,String DienThoai,String CMND,
			String TenTrinhDoHV,String EmailAD, boolean GioiTinh, String PassAdmin) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return 0;
		}
		
		try {
			String sql="{call spCapNhatAdmin(?,?,?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			
			cstmt.setString(1, maAdmin);
			cstmt.setString(2, HoTenAD);
			cstmt.setString(3, NgaySinh);
			cstmt.setString(4, DiaChi);
			cstmt.setString(5, DienThoai);
			cstmt.setBoolean(6, GioiTinh);
			cstmt.setString(7, CMND);
			cstmt.setString(8, TenTrinhDoHV);
			cstmt.setString(9, EmailAD);
			cstmt.setString(10, PassAdmin);
			
			int kq = cstmt.executeUpdate();
			
			return kq;
			
		} catch (SQLException e) {
			return 0; 
		}
	}
	
	public static int CapNhatNhanVien(String maNV, String HoTenNV,String NgaySinh,String DiaChi,String DienThoai,String CMND,
			String TenTrinhDoHV,String EmailNV, boolean GioiTinh, String PassNV) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return 0;
		}
		
		try {
			String sql="{call spCapNhatNhanVien(?,?,?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maNV);
			cstmt.setString(2, HoTenNV);
			cstmt.setString(3, NgaySinh);
			cstmt.setString(4, DiaChi);
			cstmt.setString(5, DienThoai);
			cstmt.setBoolean(6, GioiTinh);
			cstmt.setString(7, CMND);
			cstmt.setString(8, TenTrinhDoHV);
			cstmt.setString(9, EmailNV);
			cstmt.setString(10, PassNV);
			
			int kq = cstmt.executeUpdate();
			
			return kq;
			
		} catch (SQLException e) {
			return 0; 
		}
	}
}
