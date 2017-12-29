package model;

public class HVDKyOnlineModel {

	String maDkyOnl, hoTen, ngaySinh, diaChi, SDT, email, error;
	
	
	public HVDKyOnlineModel(String maDkyOnl,String hoTen,String ngaySinh,String diaChi,String SDT,String email, String error) {
		this.maDkyOnl=maDkyOnl;
		this.hoTen=hoTen;
		this.ngaySinh=ngaySinh;
		this.diaChi=diaChi;
		this.SDT=SDT;
		this.email=email;	
		this.error=error;
	}
 
	

	public String getError() {
		return error;
	}



	public void setError(String error) {
		this.error = error;
	}



	public String getMaDkyOnl() {
		return maDkyOnl;
	}


	public void setMaDkyOnl(String maDkyOnl) {
		this.maDkyOnl = maDkyOnl;
	}


	public String getHoTen() {
		return hoTen;
	}


	public void setHoTen(String hoTen) {
		this.hoTen = hoTen;
	}


	public String getNgaySinh() {
		return ngaySinh;
	}


	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}


	public String getDiaChi() {
		return diaChi;
	}


	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}


	public String getSDT() {
		return SDT;
	}


	public void setSDT(String sDT) {
		SDT = sDT;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}
	

}
