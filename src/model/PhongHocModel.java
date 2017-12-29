package model;

public class PhongHocModel {

	String MaPhong, SoPhong;
	public PhongHocModel(String MaPhong,String SoPhong) {
		this.MaPhong=MaPhong;
		this.SoPhong=SoPhong;
	}
	public String getMaPhong() {
		return MaPhong;
	}
	public void setMaPhong(String maPhong) {
		MaPhong = maPhong;
	}
	public String getSoPhong() {
		return SoPhong;
	}
	public void setSoPhong(String soPhong) {
		SoPhong = soPhong;
	}
	

}
