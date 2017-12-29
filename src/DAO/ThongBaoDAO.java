package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.ThongBaoModel;


public class ThongBaoDAO {

	
	public static int SoLuongThongBao() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return 0;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_SoLuongThongBao()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.INTEGER);
			
			cstmt.execute();
			
			int kq=cstmt.getInt(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	
	public static List<ThongBaoModel> LayThongBaoDau() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<ThongBaoModel> dsThongBao = new ArrayList<ThongBaoModel>();
		
		try {
			String sql = "{call spLayThongBaoDau()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsThongBao.add(new ThongBaoModel(kq.getString("maThongBao"), kq.getString("tieuDeThongBao"), 
												kq.getString("tomTatThongBao"), kq.getString("ngayThongBao"), 
												kq.getString("hinhAnh"), kq.getString("tepDinhKem"), 
												kq.getInt("tinhTrang"), kq.getInt("stt"),null));
	        }
			kq.close();
			return dsThongBao;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			dsThongBao.add(new ThongBaoModel(null, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsThongBao;
		}
	}
	
	public static List<ThongBaoModel> LayThongBaoPhu(int start, int end) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<ThongBaoModel> dsThongBao = new ArrayList<ThongBaoModel>();
		
		try {
			String sql = "{call spLayThongBaoPhu(?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setInt(1, start);
			cstmt.setInt(2, end);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsThongBao.add(new ThongBaoModel(kq.getString("maThongBao"), kq.getString("tieuDeThongBao"), 
												kq.getString("tomTatThongBao"), kq.getString("ngayThongBao"), 
												kq.getString("hinhAnh"), kq.getString("tepDinhKem"), 
												kq.getInt("tinhTrang"), kq.getInt("stt"),null));
	        }
			kq.close();
			return dsThongBao;
		} catch (SQLException e) {
			//System.out.println(e.getMessage());
			dsThongBao.add(new ThongBaoModel(null, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsThongBao;
		}
	}

	public static String ThemThongBaoMoi(String tieuDeThongBao,String tomTatThongBao,
							String ngayThongBao,String hinhAnh,String tepDinhKem) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spThemThongBao(?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, tieuDeThongBao);
			cstmt.setString(2, tomTatThongBao);
			cstmt.setString(3, ngayThongBao);
			cstmt.setString(4, hinhAnh);
			cstmt.setString(5, tepDinhKem);
			cstmt.registerOutParameter(6, java.sql.Types.CHAR);
			
			cstmt.executeUpdate();
			
			if(cstmt.getString(6) != null)
				return cstmt.getString(6);
			return null;
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(ThemThongBaoMoi - ThongBaoDAO)");
			return null; 
		}
	}
	
	public static int CapNhatThongBao(String maThongBao, String tieuDeThongBao,String tomTatThongBao,
			String ngayThongBao,String hinhAnh,String tepDinhKem) {

			Connection conn=null;
			CallableStatement cstmt=null;
			
			conn=connectDAO.ConnectDB();
			if(conn==null) {
				return 0;
			}
			
			try {
			String sql="{call spCapNhatThongBao(?,?,?,?,?,?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maThongBao);
			cstmt.setString(2, tieuDeThongBao);
			cstmt.setString(3, tomTatThongBao);
			cstmt.setString(4, ngayThongBao);
			cstmt.setString(5, hinhAnh);
			cstmt.setString(6, tepDinhKem);
			
			int kq = cstmt.executeUpdate();
			
			return kq;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(CapNhatThongBao - ThongBaoDAO)");
			return 0; 
		}
	}

	
	public static int XoaThongBao(String maThongBao) {

			Connection conn=null;
			CallableStatement cstmt=null;
			
			conn=connectDAO.ConnectDB();
			if(conn==null) {
			return 0;
			}
			
			try {
			String sql="{call spXoaThongBao(?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maThongBao);
			
			int kq = cstmt.executeUpdate();
			
			if(kq > 0)
				return 1;
			return 0;

		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(XoaThongBao - ThongBaoDAO)");
			return 0; 
		}
	}
	
	public static String MaThongBaoMoi() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TaoMaThongBao()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static List<ThongBaoModel> LayThongBao() {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<ThongBaoModel> dsThongBao = new ArrayList<ThongBaoModel>();
		
		try {
			String sql = "{call spLayThongBao()}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsThongBao.add(new ThongBaoModel(kq.getString("maThongBao"), kq.getString("tieuDeThongBao"), 
												kq.getString("tomTatThongBao"), kq.getString("ngayThongBao"), 
												kq.getString("hinhAnh"), kq.getString("tepDinhKem"), 
												kq.getInt("tinhTrang"), kq.getInt("stt"),null));
	        }
			kq.close();
			return dsThongBao;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(LayThongBao + ThongBaoDAO)"); 
			dsThongBao.add(new ThongBaoModel(null, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsThongBao;
		}
	}

	public static int DuaThongBaoLenDau(String maThongBao) {

		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
		return 0;
		}
		
		try {
		String sql="{call spDuaThongBaoLenDau(?)}";
		cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		cstmt.setString(1, maThongBao);
		
		int kq = cstmt.executeUpdate();
		
		if(kq > 0)
			return 1;
		return 0;

		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(DuaThongBaoLenDau - ThongBaoDAO)");
			return 0; 
		}
	}
	
	public static int AnHienMotThongBao(String maThongBao, int tinhTrang) {

		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
		return 0;
		}
		
		try {
		String sql="{call spAnHienMotThongBao(?,?)}";
		cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
		
		cstmt.setString(1, maThongBao);
		cstmt.setInt(2, tinhTrang);
		
		int kq = cstmt.executeUpdate();
		
		if(kq > 0)
			return 1;
		return 0;

		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(AnHienMotThongBao - ThongBaoDAO)");
			return 0; 
		}
	}

	
	public static List<ThongBaoModel> LayMotThongBao(String maTB) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<ThongBaoModel> dsThongBao = new ArrayList<ThongBaoModel>();
		
		try {
			String sql = "{call spLayMotThongBao(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTB);
			
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsThongBao.add(new ThongBaoModel(kq.getString("maThongBao"), kq.getString("tieuDeThongBao"), 
												kq.getString("tomTatThongBao"), kq.getString("ngayThongBao"), 
												kq.getString("hinhAnh"), kq.getString("tepDinhKem"), 
												kq.getInt("tinhTrang"), kq.getInt("stt"),null));
	        }
			kq.close();
			return dsThongBao;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(LayMotThongBao + ThongBaoDAO)"); 
			dsThongBao.add(new ThongBaoModel(null, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsThongBao;
		}
	}
	
	public static List<ThongBaoModel> TimKiemThongBao(String thongTinTimKiem) {
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn = connectDAO.ConnectDB();
		
		if(conn == null) 
			return null;
		
		List<ThongBaoModel> dsThongBao = new ArrayList<ThongBaoModel>();
		
		try {
			String sql = "{call spTimKiemThongBao(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			cstmt.setString(1, thongTinTimKiem);
	
			ResultSet kq = cstmt.executeQuery();
	        
	        while(kq.next()) {
				dsThongBao.add(new ThongBaoModel(kq.getString("maThongBao"), kq.getString("tieuDeThongBao"), 
												kq.getString("tomTatThongBao"), kq.getString("ngayThongBao"), 
												kq.getString("hinhAnh"), kq.getString("tepDinhKem"), 
												kq.getInt("tinhTrang"), kq.getInt("stt"),null));
	        }
			kq.close();
			return dsThongBao;
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "(TimKiemThongBao + ThongBaoDAO)"); 
			dsThongBao.add(new ThongBaoModel(null, null, null, null, null, null, 0, 0, e.getMessage()));
			return dsThongBao;
		}
	}
	
	public static String TraCuuTepDinhKemThongBao(String maTB) {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn == null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TraCuuTepDinhKemThongBao(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.VARCHAR);
			cstmt.setString(2, maTB); 
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
