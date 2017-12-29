package model;

public class LichKhaiGiangModel {
	
	private String MaLop, TenLop, BuoiHoc, GioBatDau, GioKetThuc, NgayBatDau, SoPhong, SoTien, MaKH, NgayKhaiGiang;
	private int SoBuoi;
	
	public LichKhaiGiangModel() {}
	
	public LichKhaiGiangModel(String MaLop, String TenLop, String BuoiHoc,String GioBatDau, String GioKetThuc,
					String NgayBatDau, String SoPhong, int SoBuoi, String SoTien, String MaKH, String NgayKhaiGiang) {
		this.MaLop = MaLop;
		this.TenLop = TenLop;
		this.BuoiHoc = BuoiHoc;
		this.GioBatDau = GioBatDau;
		this.GioKetThuc = GioKetThuc;
		this.NgayBatDau = NgayBatDau;
		this.SoPhong = SoPhong;
		this.SoBuoi = SoBuoi;
		this.SoTien = SoTien;
		this.MaKH = MaKH;
		this.NgayKhaiGiang = NgayKhaiGiang;
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

	public String getNgayBatDau() {
		return NgayBatDau;
	}

	public void setNgayBatDau(String ngayBatDau) {
		NgayBatDau = ngayBatDau;
	}

	public String getSoPhong() {
		return SoPhong;
	}

	public void setSoPhong(String soPhong) {
		SoPhong = soPhong;
	}

	public int getSoBuoi() {
		return SoBuoi;
	}

	public void setSoBuoi(int soBuoi) {
		SoBuoi = soBuoi;
	}

	public String getSoTien() {
		return SoTien;
	}

	public void setSoTien(String soTien) {
		SoTien = soTien;
	}

	public String getMaKH() {
		return MaKH;
	}

	public void setMaKH(String maKH) {
		MaKH = maKH;
	}

	public String getNgayKhaiGiang() {
		return NgayKhaiGiang;
	}

	public void setNgayKhaiGiang(String ngayKhaiGiang) {
		NgayKhaiGiang = ngayKhaiGiang;
	}
	
}
