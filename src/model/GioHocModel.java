package model;

public class GioHocModel {

	String MaGioHoc, GioBatDau, GioKetThuc;
	
	public GioHocModel(String MaGioHoc,String GioBatDau,String GioKetThuc) {
		this.MaGioHoc=MaGioHoc;
		this.GioBatDau=GioBatDau;
		this.GioKetThuc=GioKetThuc;
	}

	public String getMaGioHoc() {
		return MaGioHoc;
	}

	public void setMaGioHoc(String maGioHoc) {
		MaGioHoc = maGioHoc;
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
	

}
