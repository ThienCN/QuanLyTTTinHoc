package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.HocVienModel;
import model.LopHocModel;

public class NV_dangkykhoahocDAO {

	public static String LayMaHocVienMoi() {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_TaoMaHocVien()}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		return null;
	}
	
	public static String KiemTraHocVien(String CMND) {
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return null;
		
		try {
			cstmt=conn.prepareCall("{?=call fn_KiemTraHocVien(?)}");
			
			cstmt.registerOutParameter(1, java.sql.Types.CHAR);
			cstmt.setString(2, CMND);
			
			cstmt.execute();
			
			String kq=cstmt.getString(1);
			
			return kq;
			
		} catch (SQLException e) {
			e.printStackTrace();
		}finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
		return null;
	}
	
	public static List<LopHocModel> DSLopHocHienTai(){
		Connection conn = null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return null;
		
		List<LopHocModel> dsLopHoc = new ArrayList<LopHocModel>();
		
		try {
			String sql="{call spLayDSLopHocHienTai()}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = cstmt.executeQuery();
			
			while (kq.next()) {
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
		}finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cstmt != null) {
                	cstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}

	public static HocVienModel TraCuuHocVien(String maTimKiem) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spTraCuuHocVien(?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maTimKiem);
			
			ResultSet kq = cstmt.executeQuery();
			HocVienModel hocVien = null;
			
			while(kq.next()) {
				hocVien=new HocVienModel(kq.getString("MaHV"), kq.getString("HoTenHV"),
										kq.getString("NgaySinh"), kq.getBoolean("GioiTinh"), 
										kq.getString("DiaChi"), kq.getString("SDT"), 
										kq.getString("CMND"), kq.getString("EmailHV"), 
										kq.getString("PassHV"), kq.getInt("tinhTrang"), kq.getInt("role"), null);
			}
			kq.close();
			return hocVien;
			
		} catch (SQLException e) {
			HocVienModel hocvien = new HocVienModel(null, null, null, true, null, null, null, null, null, 0, 0, e.getMessage());
			return hocvien; 
		}finally {
            try {
                if (conn != null) {
                    conn.close();
                }
                if (cstmt != null) {
                    cstmt.close();
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
	}
}
