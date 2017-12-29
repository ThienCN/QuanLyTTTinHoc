package DAO;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.GVDanhSachGiangDayModel;
import model.GVTaiLieuModel;
import model.GiaoVienModel;
import model.GVBangDiemHocVienModel;
import model.GVLichGiangDayModel;

public class GV_DAO {

	public static Statement stm = null;
	public static CallableStatement cstm = null;
	public static Connection cnn;
	public static ResultSet rs;

	public static List<GVDanhSachGiangDayModel> DanhSachGiangDay(String MaGV) {

		String MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, SoPhong;
		int SoHV;

		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spGVDanhSachGiangDay(?)}");

			cstm.setString(1, MaGV);

			rs = cstm.executeQuery();

			List<GVDanhSachGiangDayModel> DanhSachGiangDay = new ArrayList<GVDanhSachGiangDayModel>();
			while (rs.next()) {
				MaLop = rs.getString("MaLop");
				TenLop = rs.getString("TenLop");
				BuoiHoc = rs.getString("BuoiHoc");
				GioBatDau = rs.getString("GioBatDau");
				GioKetThuc = rs.getString("GioKetThuc");
				SoHV = rs.getInt("SoHV");
				SoPhong = rs.getString("SoPhong");
				DanhSachGiangDay
						.add(new GVDanhSachGiangDayModel(MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, SoHV, SoPhong));
			}

			rs.close();
			return DanhSachGiangDay;

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

	public static List<GVBangDiemHocVienModel> BangDiemHocVien(String MaLop) {
		String MaHV, HoTenHV, TenLop, ChungChi;
		Float DiemLT, DiemTH;
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spLayBangDiemTungLopHoc(?)}");

			cstm.setString(1, MaLop);

			rs = cstm.executeQuery();

			List<GVBangDiemHocVienModel> BangDiemLopHoc = new ArrayList<GVBangDiemHocVienModel>();
			while (rs.next()) {
				MaHV = rs.getString("MaHV");
				HoTenHV = rs.getString("HoTenHV");
				TenLop = rs.getString("TenLop");
				DiemLT = rs.getFloat("DiemLT");
				DiemTH = rs.getFloat("DiemTH");
				ChungChi = rs.getString("ChungChi");
				BangDiemLopHoc.add(new GVBangDiemHocVienModel(MaHV, HoTenHV, MaLop, TenLop, DiemLT, DiemTH, ChungChi));
			}

			rs.close();
			return BangDiemLopHoc;

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

	public static int CapNhatDiem(String MaHV, String MaLop, Float DiemLT, Float DiemTH, Float DiemTB) {
		try {
			CallableStatement cstm = null;
			Connection cnn;

			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return 0;

			//
			if (DiemLT == null || DiemTH == null) {
				if (DiemLT == null && DiemTH == null) {
					cstm = cnn.prepareCall("{call spGVCapNhatDiem(?,?,?,?,?)}");

					cstm.setString(1, MaHV);
					cstm.setString(2, MaLop);
					cstm.setNull(3, java.sql.Types.FLOAT);
					cstm.setNull(4, java.sql.Types.FLOAT);
					cstm.setNull(5, java.sql.Types.FLOAT);
				} else if (DiemLT == null) {
					cstm = cnn.prepareCall("{call spGVCapNhatDiem(?,?,?,?,?)}");

					cstm.setString(1, MaHV);
					cstm.setString(2, MaLop);
					cstm.setNull(3, java.sql.Types.FLOAT);
					cstm.setFloat(4, DiemTH);
					cstm.setNull(5, java.sql.Types.FLOAT);
				} else if (DiemTH == null) {
					cstm = cnn.prepareCall("{call spGVCapNhatDiem(?,?,?,?,?)}");

					cstm.setString(1, MaHV);
					cstm.setString(2, MaLop);
					cstm.setFloat(3, DiemLT);
					cstm.setNull(4, java.sql.Types.FLOAT);
					cstm.setNull(5, java.sql.Types.FLOAT);
				}
			} else {
				cstm = cnn.prepareCall("{call spGVCapNhatDiem(?,?,?,?,?)}");

				cstm.setString(1, MaHV);
				cstm.setString(2, MaLop);
				cstm.setFloat(3, DiemLT);
				cstm.setFloat(4, DiemTH);
				cstm.setFloat(5, DiemTB);
			}

			int row = cstm.executeUpdate();

			if (row > 0) {
				return 1;
			}
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

	public static List<GVLichGiangDayModel> LoadLichGiangDay(String TuNgay, String DenNgay, String MaGV) {

		String BuoiHoc, SoPhong, TenLop, GioBatDau, GioKetThuc, NgayBatDau, NgayKetThuc;

		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spGVLichGiangDay(?,?,?)}");

			cstm.setString(1, TuNgay);
			cstm.setString(2, DenNgay);
			cstm.setString(3, MaGV);

			rs = cstm.executeQuery();

			List<GVLichGiangDayModel> LichGiangDay = new ArrayList<GVLichGiangDayModel>();
			while (rs.next()) {
				BuoiHoc = rs.getString("BuoiHoc");
				SoPhong = rs.getString("SoPhong");
				TenLop = rs.getString("TenLop");
				GioBatDau = rs.getString("GioBatDau");
				GioKetThuc = rs.getString("GioKetThuc");
				NgayBatDau = rs.getString("NgayBatDau");
				NgayKetThuc = rs.getString("NgayKetThuc");
				LichGiangDay.add(new GVLichGiangDayModel(BuoiHoc, SoPhong, TenLop, GioBatDau, GioKetThuc, NgayBatDau,
						NgayKetThuc));

			}

			rs.close();
			return LichGiangDay;

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

	public static List<GVTaiLieuModel> LoadTaiLieu(String MaLop) {
		String MaTaiLieu, TenTaiLieu, NoiDungTaiLieu, TenLop, LinkTaiLieu;
		try {
			cnn = connectDAO.ConnectDB();
			if (cnn == null)
				return null;
			//
			cstm = cnn.prepareCall("{call spGVLoadTaiLieu(?)}");

			cstm.setString(1, MaLop);

			rs = cstm.executeQuery();

			List<GVTaiLieuModel> TaiLieu = new ArrayList<GVTaiLieuModel>();
			while (rs.next()) {
				MaTaiLieu = rs.getString("MaTaiLieu");
				TenTaiLieu = rs.getString("TenTaiLieu");
				NoiDungTaiLieu = rs.getString("NoiDungTaiLieu");
				TenLop = rs.getString("TenLop");
				LinkTaiLieu = rs.getString("LinkTaiLieu");
				TaiLieu.add(new GVTaiLieuModel(MaTaiLieu, TenTaiLieu, NoiDungTaiLieu, MaLop, TenLop, LinkTaiLieu));
			}

			rs.close();
			return TaiLieu;

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

	public static String ThemTaiLieuMoi(String TenTaiLieu, String NoiDungTaiLieu, String MaLop, String LinkTaiLieu) {

		Connection conn = null;
		CallableStatement cstmt = null;

		conn = connectDAO.ConnectDB();
		if (conn == null) {
			return null;
		}

		try {
			String sql = "{call spGVThemTaiLieu(?,?,?,?,?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			cstmt.setString(1, TenTaiLieu);
			cstmt.setString(2, NoiDungTaiLieu);
			cstmt.setString(3, MaLop);
			cstmt.setString(4, LinkTaiLieu);
			cstmt.registerOutParameter(5, java.sql.Types.CHAR);

			cstmt.executeUpdate();

			if (cstmt.getString(5) != null)
				return cstmt.getString(5);
			return null;

		} catch (SQLException e) {
			// System.out.println(e.getMessage() + "\n(ThemThongBaoMoi - ThongBaoDAO)");
			return null;
		}
	}

	public static int XoaTaiLieu(String MaTaiLieu) {

		Connection conn = null;
		CallableStatement cstmt = null;

		conn = connectDAO.ConnectDB();
		if (conn == null) {
			return 0;
		}

		try {
			String sql = "{call spXoaTaiLieu(?)}";
			cstmt = conn.prepareCall(sql, ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_READ_ONLY);

			cstmt.setString(1, MaTaiLieu);

			int kq = cstmt.executeUpdate();

			if (kq > 0)
				return 1;
			return 0;

		} catch (SQLException e) {
			// System.out.println(e.getMessage() + "\n(XoaThongBao - ThongBaoDAO)");
			return 0;
		}
	}
}
