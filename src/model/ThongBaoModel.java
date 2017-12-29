package model;

public class ThongBaoModel {

	String maThongBao, tieuDeThongBao, tomTatThongBao, ngayThongBao, hinhAnh, tepDinhKem, error;
	int tinhTrang, STT;
	
	public ThongBaoModel(String maThongBao,String tieuDeThongBao,String tomTatThongBao,
			String ngayThongBao,String hinhAnh,String tepDinhKem,int tinhTrang,int STT, String error) {
		this.maThongBao=maThongBao;
		this.tieuDeThongBao=tieuDeThongBao;
		this.tomTatThongBao=tomTatThongBao;
		this.ngayThongBao=ngayThongBao;
		this.hinhAnh=hinhAnh;
		this.tepDinhKem=tepDinhKem;
		this.tinhTrang=tinhTrang;
		this.STT=STT;
		this.error=error;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

	public String getMaThongBao() {
		return maThongBao;
	}

	public void setMaThongBao(String maThongBao) {
		this.maThongBao = maThongBao;
	}

	public String getTieuDeThongBao() {
		return tieuDeThongBao;
	}

	public void setTieuDeThongBao(String tieuDeThongBao) {
		this.tieuDeThongBao = tieuDeThongBao;
	}

	public String getTomTatThongBao() {
		return tomTatThongBao;
	}

	public void setTomTatThongBao(String tomTatThongBao) {
		this.tomTatThongBao = tomTatThongBao;
	}

	public String getNgayThongBao() {
		return ngayThongBao;
	}

	public void setNgayThongBao(String ngayThongBao) {
		this.ngayThongBao = ngayThongBao;
	}

	public String getHinhAnh() {
		return hinhAnh;
	}

	public void setHinhAnh(String hinhAnh) {
		this.hinhAnh = hinhAnh;
	}

	public String getTepDinhKem() {
		return tepDinhKem;
	}

	public void setTepDinhKem(String tepDinhKem) {
		this.tepDinhKem = tepDinhKem;
	}

	public int getTinhTrang() {
		return tinhTrang;
	}

	public void setTinhTrang(int tinhTrang) {
		this.tinhTrang = tinhTrang;
	}

	public int getSTT() {
		return STT;
	}

	public void setSTT(int sTT) {
		STT = sTT;
	}
	
	

}
