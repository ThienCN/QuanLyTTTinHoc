package model;

public class HocPhiModel {
	String MaHocPhi;
	float HocPhi;
	
	public HocPhiModel(String MaHocPhi, float HocPhi) {
		this.MaHocPhi=MaHocPhi;
		this.HocPhi=HocPhi;
	}

	public String getMaHocPhi() {
		return MaHocPhi;
	}

	public void setMaHocPhi(String MaHocPhi) {
		this.MaHocPhi = MaHocPhi;
	}

	public float getHocPhi() {
		return HocPhi;
	}

	public void setHocPhi(float HocPhi) {
		this.HocPhi = HocPhi;
	}
	
}
