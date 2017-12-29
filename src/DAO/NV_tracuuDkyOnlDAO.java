package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import model.HVDKyOnlineModel;
import model.LopHocDKyOnlModel;

public class NV_tracuuDkyOnlDAO {

	public static HVDKyOnlineModel TraCuuThongTinHVDkyOnl(String maDkyOnl) {
		
		Connection conn=null;
		CallableStatement cstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null) {
			return null;
		}
		
		try {
			String sql="{call spTraCuuHVDkyOnl(?)}";
			cstmt=conn.prepareCall(sql,ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
			
			cstmt.setString(1, maDkyOnl);
			
			ResultSet kq = cstmt.executeQuery();
			HVDKyOnlineModel HVdkyOnl = null;
			
			
	        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        
			while(kq.next()) {
				Date date = parser.parse(kq.getString("NgaySinh"));
				
				HVdkyOnl = new HVDKyOnlineModel(kq.getString("MaDkyOnl"), kq.getString("HoTen"), formatter.format(date), 
						kq.getString("DiaChi"), kq.getString("SDT"), kq.getString("Email"), null);
			} 
			kq.close();
			return HVdkyOnl; 
			
		} catch (SQLException e) {
			//System.out.println(e.getMessage() + "\n(HVDKyOnlineModel - NV_tracuuDkyOnlDAO)"); 
			
			HVDKyOnlineModel HVdkyOnl = new HVDKyOnlineModel(null, null, null, null, null, null, e.getMessage());
			return HVdkyOnl; 
		}catch (ParseException e) {
			//System.out.println(e.getMessage() + "\n(HVDKyOnlineModel - NV_tracuuDkyOnlDAO)"); 
			
			HVDKyOnlineModel HVdkyOnl = new HVDKyOnlineModel(null, null, null, null, null, null, e.getMessage());
			return HVdkyOnl;
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

	
	public static List<LopHocDKyOnlModel> DSLopHocDangKyOnline(String maDkyOL){
		Connection conn = null;
		PreparedStatement pstmt=null;
		
		conn=connectDAO.ConnectDB();
		if(conn==null)
			return null;
		
		List<LopHocDKyOnlModel> dsLopHocDkyOnl = new ArrayList<LopHocDKyOnlModel>();
		
		try {
			String sql = "SELECT * FROM lophocdangkyonl_view WHERE MaDkyOnl = '" + maDkyOL + "'"; 
			pstmt=conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);
			
			ResultSet kq = pstmt.executeQuery();
			
			SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
	        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
	        Date date1, date2, date3;
			while (kq.next()) {
				
				date1 = parser.parse(kq.getString("NgayBatDau"));
				date2 = parser.parse(kq.getString("NgayKetThuc"));
				date3 = parser.parse(kq.getString("ngayDangKy"));
				
				dsLopHocDkyOnl.add(new LopHocDKyOnlModel(kq.getString("MaDkyOnl"), kq.getString("MaLop"), 
						kq.getString("TenLop"), kq.getString("MaKH"), 
						kq.getString("HoTenGV"), kq.getInt("SoBuoi"), 
						formatter.format(date1), formatter.format(date2), 
						kq.getString("SoPhong"), kq.getString("BuoiHoc"), 
						formatter.format(date3), kq.getInt("SoHV"), 
						kq.getString("GioBatDau")+'-'+kq.getString("GioKetThuc"), 
						kq.getString("HocPhi"), kq.getInt("tinhTrang"), null));
				
			}
			kq.close();
			return dsLopHocDkyOnl;
			
		} catch (SQLException e) {
			dsLopHocDkyOnl.add(new LopHocDKyOnlModel(null, null, null, null, null, 0, null, null, null, null, null, 0, null, null, 0, e.getMessage()));
			return dsLopHocDkyOnl;
		}catch (ParseException e) {
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
