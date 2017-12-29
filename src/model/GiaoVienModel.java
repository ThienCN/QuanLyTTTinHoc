package model;

public class GiaoVienModel {

	String MaGV, HoTenGV, NgaySinh, DiaChi, DienThoai, CMND, TenTrinhDoHV, EmailGV, PassGV, error;
	int role;
	boolean GioiTinh;
	
	public GiaoVienModel(String MaGV,String HoTenGV,String NgaySinh,String DiaChi,String DienThoai,String CMND,
			String TenTrinhDoHV,String EmailGV,String PassGV, int role, boolean GioiTinh,String error) {
		
		this.MaGV=MaGV;
		this.HoTenGV=HoTenGV;
		this.NgaySinh=NgaySinh;
		this.DiaChi=DiaChi;
		this.DienThoai=DienThoai;
		this.CMND=CMND;
		this.TenTrinhDoHV=TenTrinhDoHV;
		this.EmailGV=EmailGV;
		this.PassGV=PassGV;
		this.role=role;
		this.GioiTinh=GioiTinh;		
		this.error=error;
	}

	public String getMaGV() {
		return MaGV;
	}

	public void setMaGV(String maGV) {
		MaGV = maGV;
	}

	public String getHoTenGV() {
		return HoTenGV;
	}

	public void setHoTenGV(String hoTenGV) {
		HoTenGV = hoTenGV;
	}

	public String getNgaySinh() {
		return NgaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		NgaySinh = ngaySinh;
	}

	public String getDiaChi() {
		return DiaChi;
	}

	public void setDiaChi(String diaChi) {
		DiaChi = diaChi;
	}

	public String getDienThoai() {
		return DienThoai;
	}

	public void setDienThoai(String dienThoai) {
		DienThoai = dienThoai;
	}

	public String getCMND() {
		return CMND;
	}

	public void setCMND(String cMND) {
		CMND = cMND;
	}

	public String getTenTrinhDoHV() {
		return TenTrinhDoHV;
	}

	public void setTenTrinhDoHV(String tenTrinhDoHV) {
		TenTrinhDoHV = tenTrinhDoHV;
	}

	public String getEmailGV() {
		return EmailGV;
	}

	public void setEmailGV(String emailGV) {
		EmailGV = emailGV;
	}

	public String getPassGV() {
		return PassGV;
	}

	public void setPassGV(String passGV) {
		PassGV = passGV;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public int getRole() {
		return role;
	}

	public void setRole(int role) {
		this.role = role;
	}

	public boolean isGioiTinh() {
		return GioiTinh;
	}

	public void setGioiTinh(boolean gioiTinh) {
		GioiTinh = gioiTinh;
	}
	
	
} 
