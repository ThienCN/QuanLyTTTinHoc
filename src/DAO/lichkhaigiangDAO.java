package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import model.LichKhaiGiangModel;

public class lichkhaigiangDAO {
	
	public static Statement stm = null;
	public static CallableStatement cstm = null;
	public static Connection cnn;
	public static ResultSet rs;
	
	public static List<LichKhaiGiangModel> LoadLichKhaiGiang() {

		String MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, NgayBatDau, SoPhong, HocPhi, MaKH, NgayKhaiGiang;
		int SoBuoi;
		
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spLichKhaiGiang()}");

			rs = cstm.executeQuery();

			List<LichKhaiGiangModel> LichKhaiGiang = new ArrayList<LichKhaiGiangModel>();
			while (rs.next()) {
				MaLop = rs.getString("MaLop");
				TenLop = rs.getString("TenLop");
				BuoiHoc = rs.getString("BuoiHoc");
				GioBatDau = rs.getString("GioBatDau");
				GioKetThuc = rs.getString("GioKetThuc");
				NgayBatDau = rs.getString("NgayBatDau");
				SoPhong = rs.getString("SoPhong");
				SoBuoi = rs.getInt("SoBuoi");
				HocPhi = rs.getString("HocPhi");
				MaKH = rs.getString("MaKH");
				NgayKhaiGiang = rs.getString("NgayKhaiGiang");
				LichKhaiGiang.add(new LichKhaiGiangModel(MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, NgayBatDau, SoPhong, SoBuoi, HocPhi, MaKH, NgayKhaiGiang));
				
			}
			
			rs.close();	
			return LichKhaiGiang; 

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
