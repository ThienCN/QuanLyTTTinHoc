package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThongBaoModel;
import model.TinTucModel;


public class TinTucDAO {
	
	public static int SoLuongTinTuc() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return 0;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_SoLuongTinTuc()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			int kq=cstmt.getInt(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
	public static List<TinTucModel> LayTinTucDau() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<TinTucModel> dsTinTuc = new ArrayList<TinTucModel>();
		
		try {
			String sql = "{call spLayTinTucDau()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsTinTuc.add(new TinTucModel(kq.getString("maTinTuc"), kq.getString("tieuDeTinTuc"), 
								kq.getString("tomTatTinTuc"), kq.getString("ngayDangTinTuc"), 
								kq.getString("imageVideo"), kq.getInt("tinhTrang"), 
								kq.getInt("stt"), null));
	        }
			kq.close();
			return dsTinTuc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			dsTinTuc.add(new TinTucModel(null, null, null, null, null, 0, 0, e.getMessage()));
			return dsTinTuc;
		}
	}
	
	
	public static List<TinTucModel> LayTinTucPhu(int start, int end) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<TinTucModel> dsTinTuc = new ArrayList<TinTucModel>();
		
		try {
			String sql = "{call spLayTinTucPhu(?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setInt(1, start);
			cstmt.setInt(2, end);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
	        	dsTinTuc.add(new TinTucModel(kq.getString("maTinTuc"), kq.getString("tieuDeTinTuc"), 
									kq.getString("tomTatTinTuc"), kq.getString("ngayDangTinTuc"), 
									kq.getString("imageVideo"), kq.getInt("tinhTrang"), 
									kq.getInt("stt"), null));
	        }
			kq.close();
			return dsTinTuc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(Lay3TinTucPhu - TinTucDAO)");
			dsTinTuc.add(new TinTucModel(null, null, null, null, null, 0, 0, e.getMessage()));
			return dsTinTuc;
		}
	}
	
	public static List<TinTucModel> LayTinTuc() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<TinTucModel> dsTinTuc = new ArrayList<TinTucModel>();
		
		try {
			String sql = "{call spLayTinTuc()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
	        	dsTinTuc.add(new TinTucModel(kq.getString("maTinTuc"), kq.getString("tieuDeTinTuc"), 
						kq.getString("tomTatTinTuc"), kq.getString("ngayDangTinTuc"), 
						kq.getString("imageVideo"), kq.getInt("tinhTrang"), 
						kq.getInt("stt"), null));
	        }
			kq.close();
			return dsTinTuc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(LayTinTuc + TinTucDAO)"); 
			dsTinTuc.add(new TinTucModel(null, null, null, null, null, 0, 0, e.getMessage()));
			return dsTinTuc;
		}
	}
	
	public static int DuaTinTucLenDau(String maTinTuc) {

		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return 0;
		}
		
		try {
			String sql="{call spDuaTinTucLenDau(?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTinTuc);
			
			int kq = cstmt.executeUpdate();
			
			if(kq > 0)
				return 1;
			return 0;

		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(DuaTinTucLenDau - TinTucDAO)");
			return 0; 
		}
	}

	public static int AnHienMotTinTuc(String maTinTuc, int tinhTrang) {

		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
		return 0;
		}
		
		try {
		String sql="{call spAnHienMotTinTuc(?,?)}";
		cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		cstmt.setString(1, maTinTuc);
		cstmt.setInt(2, tinhTrang);
		
		int kq = cstmt.executeUpdate();
		
		if(kq > 0)
			return 1;
		return 0;

		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(AnHienMotTinTuc - TinTucDAO)");
			return 0; 
		}
	}
	
	public static int XoaTinTuc(String maTinTuc) {

			Connection conn=null;
			CallableStatement cstmt=null;
			
			conn=connectDAO.ConnectDB();
			if(conn==null) {
				return 0;
			}
			
			try {
				String sql="{call spXoaTinTuc(?)}";
				cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
				
				cstmt.setString(1, maTinTuc);
				
				int kq = cstmt.executeUpdate();
				
				if(kq > 0)
					return 1;
				return 0;
	
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(XoaTinTuc - TinTucDAO)");
			return 0; 
		}
	}
	
	public static String ThemTinTucMoi(String tieuDeTinTuc,String tomTatTinTuc,
			String ngayDangTinTuc,String imageVideo) {

		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spThemTinTuc(?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, tieuDeTinTuc);
			cstmt.setString(2, tomTatTinTuc);
			cstmt.setString(3, ngayDangTinTuc);
			cstmt.setString(4, imageVideo);
			cstmt.registerOutParameter(5, java.sql.Types.CHAR);
			
			cstmt.executeUpdate();
			
			if(cstmt.getString(5) != null)
				return cstmt.getString(5);
			return null;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(ThemTinTucMoi - TinTucDAO)");
			return null; 
		}
	}
	
	
	public static List<TinTucModel> LayMotTinTuc(String maTT) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<TinTucModel> dsTinTuc = new ArrayList<TinTucModel>();
		
		try {
			String sql = "{call spLayMotTinTuc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTT);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
	        	dsTinTuc.add(new TinTucModel(kq.getString("maTinTuc"), kq.getString("tieuDeTinTuc"), 
									kq.getString("tomTatTinTuc"), kq.getString("ngayDangTinTuc"), 
									kq.getString("imageVideo"), kq.getInt("tinhTrang"), 
									kq.getInt("stt"), null));
	        }
			kq.close();
			return dsTinTuc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(LayMotTinTuc + TinTucDAO)"); 
			dsTinTuc.add(new TinTucModel(null, null, null, null, null, 0, 0, e.getMessage()));
			return dsTinTuc;
		}
	}
	
	public static int CapNhatTinTuc(String maTinTuc, String tieuDeTinTuc,String tomTatTinTuc,
					String ngayDangTinTuc,String imageVideo) {

			Connection conn=null;
			CallableStatement cstmt=null;
			
			conn=connectDAO.ConnectDB();
			if(conn==null) {
				return 0;
			}
			
			try {
			String sql="{call spCapNhatTinTuc(?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTinTuc);
			cstmt.setString(2, tieuDeTinTuc);
			cstmt.setString(3, tomTatTinTuc);
			cstmt.setString(4, ngayDangTinTuc);
			cstmt.setString(5, imageVideo);
			
			int kq = cstmt.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(CapNhatTinTuc - TinTucDAO)");
			
			e.printStackTrace();
			
			return 0; 
		}
	}

	
	public static String MaTinTucMoi() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TaoMaTinTuc()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<TinTucModel> TimKiemTinTuc(String thongTinTimKiem) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<TinTucModel> dsTinTuc = new ArrayList<TinTucModel>();
		
		try {
			String sql = "{call spTimKiemTinTuc(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, thongTinTimKiem);
	
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
	        	dsTinTuc.add(new TinTucModel(kq.getString("maTinTuc"), kq.getString("tieuDeTinTuc"), 
						kq.getString("tomTatTinTuc"), kq.getString("ngayDangTinTuc"), 
						kq.getString("imageVideo"), kq.getInt("tinhTrang"), 
						kq.getInt("stt"), null));
	        }
			kq.close();
			return dsTinTuc;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(TimKiemTinTuc + TinTucDAO)"); 
			dsTinTuc.add(new TinTucModel(null, null, null, null, null, 0, 0, e.getMessage()));
			return dsTinTuc;
		}
	}
}
