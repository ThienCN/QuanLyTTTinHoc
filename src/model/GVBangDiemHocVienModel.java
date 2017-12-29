package model;

public class GVBangDiemHocVienModel {
	
	String MaHV, HoTenHV, MaLop, TenLop, ChungChi;
	Float DiemLT, DiemTH;
	
	public GVBangDiemHocVienModel(String MaHV, String HoTenHV, String MaLop, String TenLop,
											Float DiemLT, Float DiemTH, String ChungChi) {
		this.MaHV=MaHV;
		this.HoTenHV=HoTenHV;
		this.MaLop=MaLop;
		this.TenLop=TenLop;
		this.DiemLT=DiemLT;
		this.DiemTH=DiemTH;
		this.ChungChi=ChungChi;
	}
	
	public GVBangDiemHocVienModel() {}

	public String getMaHV() {
		return MaHV;
	}

	public void setMaHV(String maHV) {
		MaHV = maHV;
	}

	public String getHoTenHV() {
		return HoTenHV;
	}

	public void setHoTenHV(String hoTenHV) {
		HoTenHV = hoTenHV;
	}

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

	public Float getDiemLT() {
		return DiemLT;
	}

	public void setDiemLT(Float diemLT) {
		DiemLT = diemLT;
	}

	public Float getDiemTH() {
		return DiemTH;
	}

	public void setDiemTH(Float diemTH) {
		DiemTH = diemTH;
	}

	public String getChungChi() {
		return ChungChi;
	}

	public void setChungChi(String chungChi) {
		ChungChi = chungChi;
	}
	
}
