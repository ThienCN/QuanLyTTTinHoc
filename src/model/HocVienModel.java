package model;

public class HocVienModel {

	String MaHV, HoTenHV, NgaySinh, DiaChi, SDT, CMND, EmailHV, PassHV, error;
	boolean GioiTinh;
	int tinhTrang, role;
	
	public HocVienModel(String MaHV,String HoTenHV,String NgaySinh,boolean GioiTinh,
			String DiaChi,String SDT,String CMND,String EmailHV, String PassHV, int tinhTrang, int role, String error) {
		this.MaHV=MaHV;
		this.HoTenHV=HoTenHV;
		this.NgaySinh=NgaySinh;
		this.GioiTinh=GioiTinh;
		this.DiaChi=DiaChi;
		this.SDT=SDT;
		this.CMND=CMND;
		this.EmailHV=EmailHV;
		this.PassHV=PassHV;
		this.role=role;
		this.error=error;
		this.tinhTrang=tinhTrang;
	}
	
	
	public String getPassHV() {
		return PassHV;
	}


	public void setPassHV(String passHV) {
		PassHV = passHV;
	}


	public int getRole() {
		return role;
	}


	public void setRole(int role) {
		this.role = role;
	}


	public int getTinhTrang() {
		return tinhTrang;
	}


	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}


	public String getError() {
		return error;
	}


	public void setError(String error) {
		this.error = error;
	}


	public String getMaHV() {
		return MaHV;
	}

	public void setMaHV(String MaHV) {
		this.MaHV = MaHV;
	}

	public String getHoTenHV() {
		return HoTenHV;
	}

	public void setHoTenHV(String HoTenHV) {
		this.HoTenHV = HoTenHV;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String NgaySinh) {
		this.NgaySinh = NgaySinh;
	}

	public boolean getGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(boolean GioiTinh) {
		this.GioiTinh = GioiTinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String DiaChi) {
		this.DiaChi = DiaChi;
	}

	public String getSDT() {
		return SDT;
	}

	public void setSDT(String SDT) {
		this.SDT = SDT;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String CMND) {
		this.CMND = CMND;
	}

	public String getEmailHV() {
		return EmailHV;
	}

	public void setEmail(String EmailHV) {
		this.EmailHV = EmailHV;
	}

}
