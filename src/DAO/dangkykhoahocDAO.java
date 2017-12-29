package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import model.DangKyKhoaHocModel;
import model.LopHocDKyOnlModel;

public class dangkykhoahocDAO {
	public static Statement stm = null;
	public static CallableStatement cstm = null;
	public static Connection cnn;
	public static ResultSet rs;
	
	public static List<DangKyKhoaHocModel> LoadLopHoc() {
		String MaLop = null, TenLop = null;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spLoadLopHoc()}");

			rs = cstm.executeQuery();
			
			List<DangKyKhoaHocModel> LopHoc = new ArrayList<DangKyKhoaHocModel>();
			while (rs.next()) {
				MaLop = rs.getString("MaLop");
				TenLop = rs.getString("TenLop");
				LopHoc.add(new DangKyKhoaHocModel(MaLop,TenLop));
			}
			
			rs.close();	
			return LopHoc; 

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
	
	public static String ThemDangKyOnl(String HoTen, String NgaySinh, String SDT, String DiaChi, String Email) {
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spThemDangKyOnl(?,?,?,?,?,?)}");
			cstm.setString(1, HoTen);
			cstm.setString(2, NgaySinh);
			cstm.setString(3, SDT);
			cstm.setString(4, DiaChi);
			cstm.setString(5, Email);
			cstm.registerOutParameter(6, java.sql.Types.CHAR);
			
			cstm.executeUpdate();
			if (cstm.getString(6)!=null)
	        	return cstm.getString(6);   
	        return null; 

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
	
	public static int ThemChiTietDangKyOnl(String MaDangKyOnl, String MaLop) {
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return 0;
			//
			cstm = cnn.prepareCall("{call spThemChiTietDangKyOnl(?,?)}");
			cstm.setString(1, MaDangKyOnl);
			cstm.setString(2, MaLop);
			
			int row = cstm.executeUpdate();
			if (row > 0)
	        	return 1;   
	        return 0; 

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
		return 0;
	}
	
	public static List<LopHocDKyOnlModel> DSLopHocDangKyOnline(String MaDkyOnl){
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return null;
		
		List<LopHocDKyOnlModel> dsLopHocDkyOnl = new ArrayList<LopHocDKyOnlModel>();
		
		try {
			String sql = "SELECT * FROM lophocdangkyonl_view WHERE MaDkyOnl = '" + MaDkyOnl + "'"; 
			pstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = pstmt.executeQuery();
			
			while (kq.next()) {
				dsLopHocDkyOnl.add(new LopHocDKyOnlModel(kq.getString("MaDkyOnl"), kq.getString("MaLop"), 
						kq.getString("TenLop"), kq.getString("MaKH"), 
						kq.getString("HoTenGV"), kq.getInt("SoBuoi"), 
						kq.getString("NgayBatDau"), kq.getString("NgayKetThuc"), 
						kq.getString("SoPhong"), kq.getString("BuoiHoc"), 
						kq.getString("ngayDangKy"), kq.getInt("SoHV"), 
						kq.getString("GioBatDau")+'-'+kq.getString("GioKetThuc"), 
						kq.getString("HocPhi"), kq.getInt("tinhTrang"), null));
				
			}
			kq.close();
			return dsLopHocDkyOnl;
			
		} catch (SQLException e) {
			dsLopHocDkyOnl.add(new LopHocDKyOnlModel(null, null, null, null, null, 0, null, null, null, null, null, 0, null, null, 0, e.getMessage()));
			return dsLopHocDkyOnl;
		}finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (pstmt != null) {
                    pstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}
}
