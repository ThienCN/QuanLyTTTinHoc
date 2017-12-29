package model;

public class DangKyKhoaHocModel {
	String MaLop, TenLop;
	
	public DangKyKhoaHocModel(String MaLop, String TenLop) {
		this.MaLop = MaLop;
		this.TenLop = TenLop;
	}
	
	public DangKyKhoaHocModel() {}

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
	
}
