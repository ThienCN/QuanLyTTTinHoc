package model;

public class HVKhoaHocModel {

	String MaKH, NgayKhaiGiang, Nam, Thang;
	
	public HVKhoaHocModel(String MaKH, String NgayKhaiGiang, String Nam, String Thang) {
		this.MaKH=MaKH;
		this.NgayKhaiGiang=NgayKhaiGiang;
		this.Nam=Nam;
		this.Thang=Thang;
	}
	
	public HVKhoaHocModel() {}

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

	public String getNam() {
		return Nam;
	}

	public void setNam(String nam) {
		Nam = nam;
	}

	public String getThang() {
		return Thang;
	}

	public void setThang(String thang) {
		Thang = thang;
	}
	
}
