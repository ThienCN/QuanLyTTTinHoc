package model;

public class GVLichGiangDayModel {
	String BuoiHoc, SoPhong, TenLop, GioBatDau, GioKetThuc, NgayBatDau, NgayKetThuc;
	
	public GVLichGiangDayModel(String BuoiHoc, String SoPhong, String TenLop,
					String GioBatDau, String GioKetThuc, String NgayBatDau, String NgayKetThuc) {
		this.BuoiHoc=BuoiHoc;
		this.SoPhong=SoPhong;
		this.TenLop=TenLop;
		this.GioBatDau=GioBatDau;
		this.GioKetThuc=GioKetThuc;
		this.NgayBatDau=NgayBatDau;
		this.NgayKetThuc=NgayKetThuc;
	}
	
	public GVLichGiangDayModel() {}

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

	public String getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public String getNgayKetThuc() {
		return NgayKetThuc;
	}

	public void setNgayKetThuc(String ngayKetThuc) {
		NgayKetThuc = ngayKetThuc;
	}
	
}
