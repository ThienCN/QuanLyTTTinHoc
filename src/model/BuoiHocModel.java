package model;

public class BuoiHocModel {

	String MaBuoiHoc, BuoiHoc;
	
	public BuoiHocModel(String MaBuoiHoc,String BuoiHoc) {
		this.MaBuoiHoc=MaBuoiHoc;
		this.BuoiHoc=BuoiHoc;
	}

	public String getMaBuoiHoc() {
		return MaBuoiHoc;
	}

	public void setMaBuoiHoc(String maBuoiHoc) {
		MaBuoiHoc = maBuoiHoc;
	}

	public String getBuoiHoc() {
		return BuoiHoc;
	}

	public void setBuoiHoc(String buoiHoc) {
		BuoiHoc = buoiHoc;
	}
	

}
