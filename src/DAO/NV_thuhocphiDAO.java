package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;


public class NV_thuhocphiDAO {

	public static String ThemHocVienMoi(String hoTenHV,String ngaySinh,boolean gioiTinh,
			String diachi,String SDT,String CMND,String email) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spThemHocVien(?,?,?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, hoTenHV);
			cstmt.setString(2, ngaySinh);
			cstmt.setString(3, diachi);
			cstmt.setBoolean(4, gioiTinh);
			cstmt.setString(5, SDT);
			cstmt.setString(6, CMND);
			cstmt.setString(7, email);
			cstmt.registerOutParameter(8, java.sql.Types.CHAR);
			
			cstmt.executeUpdate();
			
			if(cstmt.getString(8) != null)
				return cstmt.getString(8);
			return null;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(ThemHocVienMoi - NV_thuhocphiDAO)");
			return null; 
		}
	}

	public static int ThemBienLai(String maHV, String maLopHoc, String maNVThuNgan, String ngayDong) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		
		if(conn == null)
			return 0;
		
		try {
			String sql="{call spThemBienLai(?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maHV);
			cstmt.setString(2, maLopHoc);
			cstmt.setString(3, maNVThuNgan);
			cstmt.setString(4, ngayDong);
			
			int kq= cstmt.executeUpdate();
			
			if(kq>0)
				return 1;
			return 0;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(ThemBienLai - NV_thuhocphiDAO)");
			return 0;
		}
	}
	
	public static void HuyDangKyKhoaHoc(String maHV, String maLopHoc) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		
		if(conn == null)
			return;
		
		try {
			String sql="{call spHuyDangKyKhoaHoc(?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maHV);
			cstmt.setString(2, maLopHoc);
			
			cstmt.executeUpdate();
			return;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(HuyDangKyKhoaHoc - NV_thuhocphiDAO)");
			return;
		}
	}

	public static void HVDKyOnlNhanLop(String maDkyOnl, String maLopHoc) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		
		if(conn == null)
			return;
		
		try {
			String sql="{call spHocVienDKyOnlNhanLop(?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maDkyOnl);
			cstmt.setString(2, maLopHoc);
			
			cstmt.executeUpdate();
			return;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(HVDKyOnlNhanLop - NV_thuhocphiDAO)"); 
			return;
		}
	}
	
}
