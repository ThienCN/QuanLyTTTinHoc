package model;

public class LopHocModel {

	String MaLop, TenLop, KhoaHoc, GiaoVienGiangDay, NgayBatDau, NgayKetThuc, SoPhong, BuoiHoc, GioHoc, error;
	String HocPhi;
	int SoHV, SoBuoi, TinhTrang;
	
	
	public LopHocModel(String MaLop,String TenLop,String KhoaHoc,String GiaoVienGiangDay,int SoBuoi,
			String NgayBatDau, String NgayKetThuc,String SoPhong,String BuoiHoc,
			int SoHV,String GioHoc,String HocPhi, int TinhTrang, String error) {
		this.MaLop=MaLop;
		this.TenLop=TenLop;
		this.KhoaHoc=KhoaHoc;
		this.GiaoVienGiangDay=GiaoVienGiangDay;
		this.SoBuoi=SoBuoi;
		this.NgayBatDau=NgayBatDau;
		this.NgayKetThuc=NgayKetThuc;
		this.SoPhong=SoPhong;
		this.BuoiHoc=BuoiHoc;
		this.SoHV=SoHV;
		this.GioHoc=GioHoc;
		this.HocPhi=HocPhi;
		this.TinhTrang=TinhTrang;
		this.error=error;
	}
	
	
	public String getKhoaHoc() {
		return KhoaHoc;
	}


	public void setKhoaHoc(String khoaHoc) {
		KhoaHoc = khoaHoc;
	}


	public String getGiaoVienGiangDay() {
		return GiaoVienGiangDay;
	}


	public void setGiaoVienGiangDay(String giaoVienGiangDay) {
		GiaoVienGiangDay = giaoVienGiangDay;
	}


	public int getSoHV() {
		return SoHV;
	}


	public void setSoHV(int soHV) {
		SoHV = soHV;
	}


	public int getTinhTrang() {
		return TinhTrang;
	}


	public void setTinhTrang(int tinhTrang) {
		TinhTrang = tinhTrang;
	}

	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
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

	public void setSoBuoi(int soBuoi) {
		SoBuoi = soBuoi;
	}

	public int getSoBuoi() {
		return SoBuoi;
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

	public String getSoPhong() {
		return SoPhong;
	}

	public void setSoPhong(String soPhong) {
		SoPhong = soPhong;
	}

	public String getBuoiHoc() {
		return BuoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		BuoiHoc = buoiHoc;
	}

	public String getGioHoc() {
		return GioHoc;
	}

	public void setGioHoc(String gioHoc) {
		GioHoc = gioHoc;
	}

	public String getHocPhi() {
		return HocPhi;
	}

	public void setHocPhi(String hocPhi) {
		HocPhi = hocPhi;
	}
	
	
}
