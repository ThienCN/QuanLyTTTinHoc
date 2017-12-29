package model;

public class GVDanhSachGiangDayModel {
	String MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, SoPhong;
	int SoHV;
	
	public GVDanhSachGiangDayModel(String MaLop, String TenLop, String BuoiHoc,
						String GioBatDau, String GioKetThuc, int SoHV, String SoPhong) {
		this.MaLop = MaLop;
		this.TenLop = TenLop;
		this.BuoiHoc = BuoiHoc;
		this.GioBatDau = GioBatDau;
		this.GioKetThuc = GioKetThuc;
		this.SoHV = SoHV;
		this.SoPhong = SoPhong;
	}
	
	public GVDanhSachGiangDayModel() {}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public String getBuoiHoc() {
		return BuoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		BuoiHoc = buoiHoc;
	}

	public String getGioBatDau() {
		return GioBatDau;
	}

	public void setGioBatDau(String gioBatDau) {
		GioBatDau = gioBatDau;
	}

	public String getGioKetThuc() {
		return GioKetThuc;
	}

	public void setGioKetThuc(String gioKetThuc) {
		GioKetThuc = gioKetThuc;
	}

	public int getSoHV() {
		return SoHV;
	}

	public void setSoHV(int soHV) {
		SoHV = soHV;
	}

	public String getSoPhong() {
		return SoPhong;
	}

	public void setSoPhong(String soPhong) {
		SoPhong = soPhong;
	}
	
}
