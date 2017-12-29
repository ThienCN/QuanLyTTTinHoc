package model;

public class NguoiDungModel {
	String MaND, HoTenND, NgaySinh, DiaChi, DienThoai, CMND, TenTrinhDoHV, EmailND, PassND, error;
	int role;
	boolean GioiTinh;
	
	public NguoiDungModel(String MaND, String HoTenND, String NgaySinh, String DiaChi, String DienThoai,
	   String CMND, String TenTrinhDoHV, String EmailND, String PassND, int role, boolean GioiTinh, String error) {
		this.MaND=MaND;
		this.HoTenND=HoTenND;
		this.NgaySinh=NgaySinh;
		this.DiaChi=DiaChi;
		this.DienThoai=DienThoai;
		this.GioiTinh=GioiTinh;
		this.CMND=CMND;
		this.TenTrinhDoHV=TenTrinhDoHV;
		this.EmailND=EmailND;
		this.PassND=PassND;
		this.role=role;
		this.error=error;
	}

	public String getMaND() {
		return MaND;
	}

	public void setMaND(String maND) {
		MaND = maND;
	}

	public String getHoTenND() {
		return HoTenND;
	}

	public void setHoTenND(String hoTenND) {
		HoTenND = hoTenND;
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

	public String getEmailND() {
		return EmailND;
	}

	public void setEmailND(String emailND) {
		EmailND = emailND;
	}

	public String getPassND() {
		return PassND;
	}

	public void setPassND(String passND) {
		PassND = passND;
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
