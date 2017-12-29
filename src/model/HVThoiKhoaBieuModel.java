package model;

public class HVThoiKhoaBieuModel {

	String BuoiHoc, SoPhong, TenLop, GioBatDau, GioKetThuc, HoTenGV;
	
	public HVThoiKhoaBieuModel(String BuoiHoc, String SoPhong, String TenLop,
					String GioBatDau, String GioKetThuc, String HoTenGV) {
		this.BuoiHoc=BuoiHoc;
		this.SoPhong=SoPhong;
		this.TenLop=TenLop;
		this.GioBatDau=GioBatDau;
		this.GioKetThuc=GioKetThuc;
		this.HoTenGV=HoTenGV;
	}
	
	public HVThoiKhoaBieuModel() {}

	public String getBuoiHoc() {
		return BuoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		BuoiHoc = buoiHoc;
	}

	public String getSoPhong() {
		return SoPhong;
	}

	public void setSoPhong(String soPhong) {
		SoPhong = soPhong;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
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

	public String getHoTenGV() {
		return HoTenGV;
	}

	public void setHoTenGV(String hoTenGV) {
		HoTenGV = hoTenGV;
	}
	
}
