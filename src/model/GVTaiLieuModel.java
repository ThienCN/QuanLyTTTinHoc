package model;

public class GVTaiLieuModel {
	String MaTaiLieu, TenTaiLieu, NoiDungTaiLieu, MaLop, TenLop, LinkTaiLieu;
	
	public GVTaiLieuModel(String MaTaiLieu, String TenTaiLieu, String NoiDungTaiLieu,
							String MaLop, String TenLop, String LinkTaiLieu) {
		this.MaTaiLieu = MaTaiLieu;
		this.TenTaiLieu = TenTaiLieu;
		this.NoiDungTaiLieu = NoiDungTaiLieu;
		this.MaLop = MaLop;
		this.TenLop = TenLop;
		this.LinkTaiLieu = LinkTaiLieu;
	}
	
	public GVTaiLieuModel() {}

	public String getMaTaiLieu() {
		return MaTaiLieu;
	}

	public void setMaTaiLieu(String maTaiLieu) {
		MaTaiLieu = maTaiLieu;
	}

	public String getTenTaiLieu() {
		return TenTaiLieu;
	}

	public void setTenTaiLieu(String tenTaiLieu) {
		TenTaiLieu = tenTaiLieu;
	}

	public String getNoiDungTaiLieu() {
		return NoiDungTaiLieu;
	}

	public void setNoiDungTaiLieu(String noiDungTaiLieu) {
		NoiDungTaiLieu = noiDungTaiLieu;
	}

	public String getMaLop() {
		return MaLop;
	}

	public void setMaLop(String maLop) {
		MaLop = maLop;
	}

	public String getTenLop() {
		return TenLop;
	}

	public void setTenLop(String tenLop) {
		TenLop = tenLop;
	}

	public String getLinkTaiLieu() {
		return LinkTaiLieu;
	}

	public void setLinkTaiLieu(String linkTaiLieu) {
		LinkTaiLieu = linkTaiLieu;
	}
	
}
