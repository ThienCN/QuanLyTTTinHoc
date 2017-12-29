package model;

public class TrinhDoHocVanModel {

	String MaTrinhDoHV, TenTrinhDoHV;
	
	public TrinhDoHocVanModel(String MaTrinhDoHV,String TenTrinhDoHV) {
		this.MaTrinhDoHV=MaTrinhDoHV;
		this.TenTrinhDoHV=TenTrinhDoHV;
	}

	public String getMaTrinhDoHV() {
		return MaTrinhDoHV;
	}

	public void setMaTrinhDoHV(String maTrinhDoHV) {
		MaTrinhDoHV = maTrinhDoHV;
	}

	public String getTenTrinhDoHV() {
		return TenTrinhDoHV;
	}

	public void setTenTrinhDoHV(String tenTrinhDoHV) {
		TenTrinhDoHV = tenTrinhDoHV;
	}
	
	

}
