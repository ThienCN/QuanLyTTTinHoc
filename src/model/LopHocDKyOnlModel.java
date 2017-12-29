package model;

public class LopHocDKyOnlModel {

	String MaDkyOnl, MaLop, TenLop, KhoaHoc, GiaoVienGiangDay, NgayBatDau, NgayKetThuc, SoPhong, BuoiHoc, GioHoc,ngayDangKy, error;
	String HocPhi;
	int SoHV, SoBuoi, tinhTrang;
	
	public LopHocDKyOnlModel(String MaDkyOnl, String MaLop,String TenLop,String KhoaHoc,String GiaoVienGiangDay,int SoBuoi,
			String NgayBatDau, String NgayKetThuc,String SoPhong,String BuoiHoc, String ngayDangKy,
			int SoHV,String GioHoc,String HocPhi, int tinhTrang, String error) {
		this.MaDkyOnl=MaDkyOnl;
		this.MaLop=MaLop;
		this.TenLop=TenLop;
		this.SoBuoi=SoBuoi;
		this.KhoaHoc=KhoaHoc;
		this.GiaoVienGiangDay=GiaoVienGiangDay;
		this.SoHV=SoHV;
		this.NgayBatDau=NgayBatDau;
		this.NgayKetThuc=NgayKetThuc;
		this.SoPhong=SoPhong;
		this.BuoiHoc=BuoiHoc;
		this.GioHoc=GioHoc;
		this.ngayDangKy=ngayDangKy;
		this.HocPhi=HocPhi;
		this.tinhTrang=tinhTrang;
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



	public String getMaDkyOnl() {
		return MaDkyOnl;
	}

	public void setMaDkyOnl(String maDkyOnl) {
		MaDkyOnl = maDkyOnl;
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

	public int getSoBuoi() {
		return SoBuoi;
	}

	public void setSoBuoi(int soBuoi) {
		SoBuoi = soBuoi;
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

	public String getNgayDangKy() {
		return ngayDangKy;
	}

	public void setNgayDangKy(String ngayDangKy) {
		this.ngayDangKy = ngayDangKy;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getHocPhi() {
		return HocPhi;
	}

	public void setHocPhi(String hocPhi) {
		HocPhi = hocPhi;
	}

	public int gettinhTrang() {
		return tinhTrang;
	}

	public void settinhTrang(int TinhTrang) {
		this.tinhTrang = TinhTrang;
	}
	

}
